package gestor;

import entidad.Cliente;
import entidad.Preferencia;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.hibernate.classic.Session;
import org.hibernate.Query;
import utilidades.Modelo;


/**
 * Clase encargada de gestionar pedidos de 'preferencias' a la base de datos,
 * así como también de armar el modelo que se usará para generar la tabla que
 * muestre las preferencias de un cliente.
 */
public class GestorPreferencias extends GestorGeneral
{
    /* Constructor */
    public GestorPreferencias(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'preferencia'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'preferencia' que se 
     * mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo, List<Preferencia> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Cliente");
        col.add("Alimento");
        col.add("Cantidad de consumiciones");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (Preferencia pref : lista)
            {
                Object[] datosFila = new Object[4];
                datosFila[0] = pref.getId();
                datosFila[1] = pref.getCliente().getApellido()
                        + " " + pref.getCliente().getNombre();
                datosFila[2] = pref.getProductoElaborado().getNombre();
                datosFila[3] = pref.getCantidadConsumiciones();
                    
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para devolver todas las preferencias que se correspondan con un
     * cliente 'x' y que se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'preferencia' que se 
     * correspondan con un cliente 'x' y que se hallen en la base de datos;
     * o un arreglo vacío si no existe ninguno
     * 
     * @param cli el cliente específico del cual queremos obtener las preferencias
     */       
    public ArrayList<Preferencia> getListaPreferenciasDeCliente(Cliente cli)
    {
        ArrayList<Preferencia> listaPreferencias = new ArrayList<Preferencia>();
        String hql = "FROM Preferencia P WHERE P.cliente.id = " 
                + cli.getId() + " ORDER BY P.cantidadConsumiciones DESC";
        Query query = sesion.createQuery(hql);
        listaPreferencias = (ArrayList<Preferencia>) query.list();        
        
        if(listaPreferencias.isEmpty() == false)
        {
            return listaPreferencias;
        }
        else
        {
            return new ArrayList<Preferencia>();
        }
    }
}    
