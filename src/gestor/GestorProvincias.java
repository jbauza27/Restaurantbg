package gestor;

import entidad.Provincia;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


/**
 * Clase encargada de gestionar pedidos de 'provincias' a la base de datos.
 */
public class GestorProvincias extends GestorGeneral
{
    /* Constructor */
    public GestorProvincias(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve la provincia que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' de la provincia a buscar
     * @return el objeto 'provincia' apropiado o 'null' si no es encontró el mismo
     */    
    public Provincia buscarPorId(int id)
    {
        Provincia pro = (Provincia)
                sesion.createCriteria(Provincia.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return pro;
    }

    /**
     * Se utiliza para devolver todas las provincias que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'provincias' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */          
    public ArrayList<Provincia> getListaProvincias()
    {
        Criteria crit = sesion.createCriteria(Provincia.class)
                .addOrder(Order.asc("nombreProvincia"));                
        
        if(crit.list() != null)
        {
            return (ArrayList<Provincia>) crit.list();
        }
        else
        {
            return new ArrayList<Provincia>();
        }
    }
}