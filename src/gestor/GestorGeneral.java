package gestor;

import entidad.EntityBean;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;


/**
 * Clase encargada de interactuar con la base de datos, recibiendo objetos y
 * guardando o actualizando la información relacionada con ellos que se encuentra
 * en la base de datos. 
 */
public class GestorGeneral
{
    /* Atributos */
    protected Session sesion;
    protected Transaction transaccion = null;

    
    /* Constructor */
    public GestorGeneral(Session sesion)
    {
        this.sesion = sesion;
    }
    
    
    /* Métodos */
    /**
     * Recibe un objeto, y lo guarda en la base de datos o lo actualiza según
     * corresponda.
     * 
     * @param e el objeto a guardar o actualizar
     * @return 'true' si el proceso fue exitoso, 'false' en caso contrario
     */
    public boolean guardarOActualizar(EntityBean e)
    {
        boolean realizado = true;
        
        try
        {
            transaccion = sesion.beginTransaction();
            sesion.saveOrUpdate(e);
            sesion.flush();
        }
        catch (Exception ex)
        {
            transaccion.rollback();
            realizado = false;
            ex.printStackTrace();
        }
        
        transaccion.commit();
        return realizado;
    }
    
    /**
     * Elimina el objeto de la base de datos.
     * 
     * @param e el objeto a eliminar
     * @return 'true' si pudo eliminarse, 'false' en caso contrario
     */
    public boolean eliminarEntidad(EntityBean e)
    {
        boolean realizado = true;
        
        try
        {
            transaccion = sesion.beginTransaction();
            sesion.delete(e);
            sesion.flush();
        }
        catch (Exception ex)
        {
            transaccion.rollback();
            realizado = false;
            ex.printStackTrace();
        }
        
        transaccion.commit();
        return realizado;
    }
}
