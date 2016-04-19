package gestor;

import entidad.Pais;
import java.util.ArrayList;
import org.hibernate.classic.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


/**
 * Clase encargada de gestionar pedidos de 'paises' a la base de datos.
 */
public class GestorPaises extends GestorGeneral
{
    /* Constructor */
    public GestorPaises(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el pais que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del pais a buscar
     * @return el objeto 'pais' apropiado o 'null' si no es encontró el mismo
     */
    public Pais buscarPorId(int id)
    {
        Pais pais = (Pais)
                sesion.createCriteria(Pais.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return pais;
    }

    /**
     * Se utiliza para devolver todos los paises que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'paises' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */       
    public ArrayList<Pais> getListaPaises()
    {
        Criteria crit = sesion.createCriteria(Pais.class)
                .addOrder(Order.asc("nombrePais"));                
        
        if(crit.list() != null)
        {
            return (ArrayList<Pais>) crit.list();
        }
        else
        {
            return new ArrayList<Pais>();
        }
    }
}