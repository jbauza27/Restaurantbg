package gestor;

import entidad.PrimerUso;
import java.util.ArrayList;
import org.hibernate.classic.Session;
import org.hibernate.Criteria;



/**
 * Clase destinada a hacer una consulta a la base de datos al principio de la
 * ejecución del programa, de modo de saber si es la primera vez que este se ejecuta
 * o no.
 */
public class GestorPrimerUso extends GestorGeneral
{
    /* Constructor */
    public GestorPrimerUso(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve un conjunto de objetos que contienen todos los registros 'primer uso'
     * que hallen en la base de datos.
     * 
     * @return un arreglo de objetos que contiene objetos 'primer uso', o un
     * arreglo vacío si no hay ninguno
     */
    public ArrayList<PrimerUso> getPrimerUso()
    {
        Criteria crit = sesion.createCriteria(PrimerUso.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<PrimerUso>) crit.list();
        }
        else
        {
            return new ArrayList<PrimerUso>();
        }
    }
}