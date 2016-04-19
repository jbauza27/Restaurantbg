package gestor;

import entidad.*;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'mesas' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * las mesas.
 */
public class GestorMesas extends GestorGeneral
{
    /* Constructor */
    public GestorMesas(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve la mesa que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' de la mesa a buscar
     * @return el objeto 'mesa' apropiado o 'null' si no es encontró la misma
     */    
    public Mesa buscarPorId(int id)
    {
        Mesa mes = (Mesa)
                sesion.createCriteria(Mesa.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return mes;
    }

    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'mesa'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'mesa' 
     * que se mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo, List<Mesa> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Número");
        col.add("Cantidad de personas");
        col.add("Descripción");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (Mesa mes : lista)
            {
                Object[] datosFila = new Object[10];
                datosFila[0] = mes.getId();
                datosFila[1] = mes.getNroMesa();
                datosFila[2] = mes.getCantPersonas();
                datosFila[3] = mes.getDescripcion();
                
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para devolver todas las mesas que se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'mesa' que se
     * hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */        
    public ArrayList<Mesa> getListaMesas()
    {
        Criteria crit = sesion.createCriteria(Mesa.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<Mesa>) crit.list();
        }
        else
        {
            return new ArrayList<Mesa>();
        }
    }
    
    /**
     * Se utiliza para devolver todas las mesas que tengan estado 'activo'
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'mesa' que tengan
     * estado 'activo' que se hallen en la base de datos, o un arreglo vacío
     * si no existe ninguno
     */    
    public ArrayList<Mesa> getListaMesasActivas()
    {
        ArrayList<Mesa> mesasActivas = new ArrayList<>();
        String hql = "FROM Mesa M WHERE M.activo = true";
        Query query = sesion.createQuery(hql);
        mesasActivas = (ArrayList<Mesa>) query.list();
        
        if(mesasActivas.isEmpty() == true)
        {
            return new ArrayList<Mesa>();
        }
        else
        {
            return mesasActivas;
        }
    }       
    
    /**
     * Se utiliza para devolver todas las mesas que estén dadas de baja
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'mesa' que estén dados
     * de baja en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<Mesa> getListaMesasDadasDeBaja()
    {
        ArrayList<Mesa> mesasDadasDeBaja = new ArrayList<>();
        String hql = "FROM Mesa M WHERE M.activo = false";
        Query query = sesion.createQuery(hql);
        mesasDadasDeBaja = (ArrayList<Mesa>) query.list();
        
        if(mesasDadasDeBaja.isEmpty() == true)
        {
            return new ArrayList<Mesa>();
        }
        else
        {
            return mesasDadasDeBaja;
        }
    }         
}