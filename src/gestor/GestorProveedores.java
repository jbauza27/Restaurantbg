package gestor;

import entidad.Proveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'proveedores' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * los proveedores.
 */
public class GestorProveedores extends GestorGeneral
{
    /* Constructor */
    public GestorProveedores(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el proveedor que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del proveedor a buscar
     * @return el objeto 'proveedor' apropiado o 'null' si no es encontró el mismo
     */
    public Proveedor buscarPorId(int id)
    {
        Proveedor prov = (Proveedor)
                sesion.createCriteria(Proveedor.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return prov;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'proveedor'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'proveedor' que se 
     * mostrarán
     * @return el modelo final a mostrar
     */    
    public Modelo configurarModelo(Modelo modelo, List<Proveedor> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Nombre");
        col.add("Teléfonos");
        col.add("Tipo");
        col.add("Nombre de contacto");
        col.add("Email");
        col.add("Domicilio");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (Proveedor prov : lista)
            {
                Object[] datosFila = new Object[7];
                datosFila[0] = prov.getId();
                datosFila[1] = prov.getNombre();
                    
                String telefonos = prov.getTelefonoUno();
                if(!prov.getTelefonoDos().equals(""))
                {
                    telefonos = telefonos + " - " + prov.getTelefonoDos();
                }
                if(!prov.getTelefonoTres().equals(""))
                {
                    telefonos = telefonos + " - " + prov.getTelefonoTres();
                }
                    
                datosFila[2] = telefonos;
                datosFila[3] = prov.getTipo();
                datosFila[4] = prov.getNombreDeContacto();
                datosFila[5] = prov.getEmail();
                datosFila[6] = prov.getCalle() + ", " + prov.getLocalidad()
                                + ", " + prov.getProvincia().getNombreProvincia() + ", "
                                + prov.getPais().getNombrePais();
                    
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }

    /**
     * Se utiliza para devolver todos los proveedores que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'proveedor' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<Proveedor> getListaProveedores()
    {
        Criteria crit = sesion.createCriteria(Proveedor.class)
                .addOrder(Order.asc("nombre"));                
        
        if(crit.list() != null)
        {
            return (ArrayList<Proveedor>) crit.list();
        }
        else
        {
            return new ArrayList<Proveedor>();
        }
    }

    /**
     * Se utiliza para devolver todos los proveedores con estado 'activo' que
     * se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'proveedor' con estado 
     * 'activo' que se hallen en la base de datos, o un arreglo vacío si no
     * existe ninguno
     */        
    public ArrayList<Proveedor> getListaProveedoresActivos()
    {
        ArrayList<Proveedor> listaProv = new ArrayList<>();
        String hql = "FROM Proveedor P WHERE P.activo = true";
        Query query = sesion.createQuery(hql);
        listaProv = (ArrayList<Proveedor>) query.list();
        
        if(listaProv.isEmpty() == true)
        {
            return new ArrayList<Proveedor>();
        }
        else
        {
            return listaProv;
        }
    }
}