package gestor;

import entidad.*;
import interfaz.estadisticas.*;
import java.util.List;
import java.util.Vector;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Clase encargada de cuestiones estadísticas.
 */
public class GestorEstadisticas extends GestorGeneral
{
    /* Atributos */
    private Factura fac;
    private GestorClientes gesCli;
    
    
    /* Constructor */
    public GestorEstadisticas(Session sesion)
    {
        super(sesion);       
        
        gesCli = new GestorClientes(sesion);
    }
    
        
    /* Métodos */    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'cantFacturas'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'cantFacturas' que se 
     * mostrarán
     * @return el modelo final a mostrar
     */    
    public Modelo configurarModeloCantFacturas(Modelo modelo, List<CantFacturas> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Año y mes");
        col.add("Facturación total");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (CantFacturas cf : lista)
            {
                Object[] datosFila = new Object[2];
                datosFila[0] = cf.getAnioyMes();
                datosFila[1] = cf.getCantFacturas();                  
                
                modelo.addRow(datosFila);  
            }
        }
        
        return modelo;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'cantFacturas'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'cantFacturas' que se 
     * mostrarán
     * @return el modelo final a mostrar
     */    
    public Modelo configurarModeloCantVecesCliente(Modelo modelo, List<CantVecesCliente> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Cliente");
        col.add("Cantidad de veces que asistió");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (CantVecesCliente cvc : lista)
            {
                Object[] datosFila = new Object[2];
                Cliente cli = gesCli.buscarPorId(cvc.getIdCliente());
                              
                datosFila[0] = cli.getApellido() + " " + cli.getNombre();
                datosFila[1] = cvc.getCantVecesAsistio();                  
                
                modelo.addRow(datosFila);  
            }
        }
        
        return modelo;
    }    

    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'cantConsumicionesXCliente'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos
     * 'cantConsumicionesXCliente' que se mostrarán
     * @return el modelo final a mostrar
     */     
    public Modelo configurarModeloCantVecesPE(Modelo modelo,
            List<CantConsumicionesXCliente> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Cliente");
        col.add("Cantidad de veces que consumió el producto");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (CantConsumicionesXCliente cvc : lista)
            {
                Object[] datosFila = new Object[2];
                Cliente cli = gesCli.buscarPorId(cvc.getIdCliente());
                              
                datosFila[0] = cli.getApellido() + " " + cli.getNombre();
                datosFila[1] = cvc.getCantConsumiciones();
                
                modelo.addRow(datosFila);  
            }
        }
        
        return modelo;
    }        
}