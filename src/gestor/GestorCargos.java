package gestor;

import entidad.Cargo;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;


/**
 * Clase encargada de gestionar pedidos de 'cargos' a la base de datos.
 */
public class GestorCargos extends GestorGeneral
{
    /* Constructor */
    public GestorCargos(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el cargo que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del cargo a buscar
     * @return el objeto 'cargo' apropiado o 'null' si no es encontró el mismo
     */
    public Cargo buscarPorId(int id)
    {
        Cargo car = (Cargo)
                sesion.createCriteria(Cargo.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return car;
    }

    /**
     * Se utiliza para devolver todos los cargos que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'cargo' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<Cargo> getListaCargos()
    {
        Criteria crit = sesion.createCriteria(Cargo.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<Cargo>) crit.list();
        }
        else
        {
            return new ArrayList<Cargo>();
        }
    }
}