package gestor;

import entidad.DetalleFactura;
import entidad.Factura;
import java.util.ArrayList;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase encargada de gestionar pedidos de 'facturas' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * las facturas, entre otras cosas.
 */
public class GestorFacturacion extends GestorGeneral
{
    /* Constructor */
    public GestorFacturacion(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve la factura que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' de la factura a buscar
     * @return el objeto 'factura' apropiado o 'null' si no es encontró el mismo
     */    
    public Factura buscarFacturaPorId(int id)
    {
        Factura fac = (Factura)
                sesion.createCriteria(Factura.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return fac;
    }   
    
    /**
     * Devuelve el detalle de factura que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del detalle de factura a buscar
     * @return el objeto 'detalleFactura' apropiado o 'null' si no se encontró
     * el mismo
     */
    public DetalleFactura buscarDetalleFacturaPorId(int id)
    {
        DetalleFactura detFac = (DetalleFactura)
                sesion.createCriteria(DetalleFactura.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return detFac;
    }    
    
    /**
     * Construye el modelo que se utilizará en el momento de la creación de la
     * factura, es decir, antes de guardarla y cuando se la esté rellenando
     * con alimentos.
     * 
     * @param modelo un modelo general, que será modificado
     * @param listaDetFac un arreglo que contendrá todos los objetos 'detalleFactura'
     * que se mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModeloFacturando(Modelo modelo, 
            ArrayList<DetalleFactura> listaDetFac)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Cantidad");
        col.add("Alimento");
        col.add("Precio unitario");
        col.add("Importe");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (listaDetFac != null)
        {
            for (DetalleFactura detFac : listaDetFac)
            {
                Object[] datosFila = new Object[5];
                datosFila[0] = detFac.getId();
                datosFila[1] = detFac.getCantidad();
                datosFila[2] = detFac.getProductoElaborado().getNombre();
                datosFila[3] = detFac.getPrecioUnitario();
                datosFila[4] = detFac.getImporte();
                
                modelo.addRow(datosFila);
            }
        }
        
        return modelo;
    }    
    
    /**
     * Construye el modelo que se utilizará en la interfaz de búsqueda de 
     * facturas, que se utilizará en la tabla que muestra los resultados de
     * búsqueda.
     * 
     * @param modelo un modelo general, que será modificado
     * @param listaFac un arreglo que contendrá todos los objetos 'factura' que
     * se mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModeloBusqueda(Modelo modelo, 
            ArrayList<Factura> listaFac)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Número de factura");
        col.add("Mozo");
        col.add("Cliente");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (listaFac != null)
        {
            for (Factura fac : listaFac)
            {
                Object[] datosFila = new Object[4];
                datosFila[0] = fac.getId();
                datosFila[1] = fac.getNumero();
                datosFila[2] = fac.getEmpleado().getApellido() + " "
                        + fac.getEmpleado().getNombre();
                datosFila[3] = fac.getCliente().getApellido() + " "
                        + fac.getCliente().getNombre();
                                
                modelo.addRow(datosFila);
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para obtener todas las facturas que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'factura' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */
    public ArrayList<Factura> getListaFacturas()
    {
        Criteria crit = sesion.createCriteria(Factura.class);            
        
        if(crit.list() != null)
        {
            return (ArrayList<Factura>) crit.list();
        }
        else
        {
            return new ArrayList<Factura>();
        }
    }
    
    /**
     * Se utiliza para obtener todos los detalles de factura que se hallen en
     * la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'detalleFactura' que se
     * hallen en la base de datos, o uno vacío si no existe ninguno
     */
    public ArrayList<DetalleFactura> getListaDetallesFacturas()
    {
        Criteria crit = sesion.createCriteria(DetalleFactura.class);
        
        if(crit.list() != null)
        {
            return (ArrayList<DetalleFactura>) crit.list();
        }
        else
        {
            return new ArrayList<DetalleFactura>();
        }
    }
    
    /**
     * Se utiliza para obtener todos los detalles de factura que pertenezcan a
     * una factura en particular.
     * 
     * @param idFactura el 'id' de la factura a la cual pertenezcan los detalles
     * de factura
     * @return un arreglo que contiene todos los objetos 'detalleFactura' relacionados
     * con la factura, o uno vacío si no existe ninguno
     */
    public ArrayList<DetalleFactura> getListaDetallesFacturaRelacionadosConFactura
        (int idFactura)
    {
        Criteria crit = sesion.createCriteria(DetalleFactura.class)
                .add(Restrictions.eq("factura.id", idFactura));
        
        if(crit.list() != null)
        {
            return (ArrayList<DetalleFactura>) crit.list();
        }
        else
        {
            return new ArrayList<DetalleFactura>();
        }
    }    
}