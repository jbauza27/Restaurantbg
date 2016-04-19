package gestor;

import entidad.AcontecimientoImportante;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase encargada de gestionar pedidos de 'acontecimientosImportantes' a la
 * base de datos, así como también de armar el modelo que se usará para generar
 * la tabla que muestre los acontecimientosImportantes.
 */
public class GestorAcontecimientosImportantes extends GestorGeneral
{
    /* Constructor */
    public GestorAcontecimientosImportantes(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el acontecimientoImportante que se corresponde con el 'id'
     * recibido.
     * 
     * @param id el 'id' del acontecimientoImportante a buscar
     * @return el objeto 'acontecimientoImportante' apropiado o 'null' si no se
     * encontró el mismo
     */    
    public AcontecimientoImportante buscarPorId(int id)
    {
        AcontecimientoImportante acoImp = (AcontecimientoImportante)
                sesion.createCriteria(AcontecimientoImportante.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return acoImp;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'acontecimientoImportante'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos
     * 'acontecimientoImportante' que se mostrarán
     * @param cargo señala si los objetos acontecimiento se refieren a clientes, 
     * a empleados, o a ambos
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo,
            List<AcontecimientoImportante> lista, String cargo)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add(cargo);
        col.add("Fecha");
        col.add("Acontecimiento");       
        col.add("Tipo");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (AcontecimientoImportante acoImp : lista)
            {
                Object[] datosFila = new Object[5];
                datosFila[0] = acoImp.getId();
                if(cargo.equals("Cliente"))
                {
                    datosFila[1] = acoImp.getCliente().getApellido() + " "
                            + acoImp.getCliente().getNombre();
                }
                else if(cargo.equals("Empleado"))
                {
                    datosFila[1] = acoImp.getEmpleado().getApellido() + " "
                            + acoImp.getEmpleado().getNombre();
                }  
                else if(cargo.equals("Cliente o empleado"))
                {
                    if(acoImp.getCliente() != null)
                    {
                        datosFila[1] = "Cliente " 
                                + acoImp.getCliente().getApellido() + " "
                                + acoImp.getCliente().getNombre();                        
                    }
                    else if(acoImp.getEmpleado() != null)
                    {
                        datosFila[1] = "Empleado "
                                + acoImp.getEmpleado().getApellido() + " "
                                + acoImp.getEmpleado().getNombre();                        
                    }
                }
                datosFila[2] = acoImp.getFechaUnica().get(Calendar.DAY_OF_MONTH)
                        + "/" + (acoImp.getFechaUnica().get(Calendar.MONTH) + 1)
                        + "/" + acoImp.getFechaUnica().get(Calendar.YEAR);
                datosFila[3] = acoImp.getAcontecimiento();  
                datosFila[4] = acoImp.getTipo();
                    
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar un recordatorio acerca
     * de los acontecimientos importantes de clientes y empleados en las 
     * próximas dos semanas.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos
     * 'acontecimientoImportante' que se mostrarán
     * @return el modelo final a mostrar
     */    
    public Modelo configurarModeloRecordatorios(Modelo modelo,
            List<AcontecimientoImportante> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Persona");
        col.add("Fecha");
        col.add("Acontecimiento");       
        col.add("Tipo");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (AcontecimientoImportante acoImp : lista)
            {
                Object[] datosFila = new Object[5];
                datosFila[0] = acoImp.getId();
                    
                if(acoImp.getCliente() != null)
                {
                    datosFila[1] = "Cliente " 
                          + acoImp.getCliente().getApellido() + " "
                          + acoImp.getCliente().getNombre();                        
                }
                else if(acoImp.getEmpleado() != null)
                {
                    datosFila[1] = "Empleado "
                           + acoImp.getEmpleado().getApellido() + " "
                           + acoImp.getEmpleado().getNombre();                        
                }

                datosFila[2] = acoImp.getFechaUnica().get(Calendar.DAY_OF_MONTH)
                        + "/" + (acoImp.getFechaUnica().get(Calendar.MONTH) + 1)
                        + "/" + acoImp.getFechaUnica().get(Calendar.YEAR);
                datosFila[3] = acoImp.getAcontecimiento();  
                datosFila[4] = acoImp.getTipo();
                    
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }    
    
    /**
     * Se utiliza para devolver todos los acontecimientos importantes que se
     * hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'acontecimientoImportante'
     * que se hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */
    public ArrayList<AcontecimientoImportante> getListaAcontecimientosImportantes()
    {
        ArrayList<AcontecimientoImportante> listaAcoImp
                = new ArrayList<AcontecimientoImportante>();
        String hql = "FROM AcontecimientoImportante A ORDER BY A.fechaUnica ASC";
        Query query = sesion.createQuery(hql);
        listaAcoImp = (ArrayList<AcontecimientoImportante>) query.list(); 
        
        if(listaAcoImp.isEmpty() == false)
        {
            return listaAcoImp;
        }
        else
        {
            return new ArrayList<AcontecimientoImportante>();
        }        
    }
    
    /**
     * Se utiliza para devolver todos los acontecimientos importantes de clientes 
     * que se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'acontecimientoImportante'
     * de clientes que se hallen en la base de datos, o un arreglo vacío si no
     * existe ninguno
     */    
    public ArrayList<AcontecimientoImportante>
         getListaAcontecimientosImportantesDeClientes()
    {
        ArrayList<AcontecimientoImportante> listaAcoImp
                = new ArrayList<AcontecimientoImportante>();
        String hql = "FROM AcontecimientoImportante A WHERE A.cliente.id "
                + "IS NOT NULL ORDER BY A.fechaUnica ASC";
        Query query = sesion.createQuery(hql);
        listaAcoImp = (ArrayList<AcontecimientoImportante>) query.list();        
        
        if(listaAcoImp.isEmpty() == false)
        {
            return listaAcoImp;
        }
        else
        {
            return new ArrayList<AcontecimientoImportante>();
        }        
    }

    /**
     * Se utiliza para devolver todos los acontecimientos importantes de empleados 
     * que se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'acontecimientoImportante'
     * de empleados que se hallen en la base de datos, o un arreglo vacío si no
     * existe ninguno
     */             
    public ArrayList<AcontecimientoImportante>
         getListaAcontecimientosImportantesDeEmpleados()
    {
        ArrayList<AcontecimientoImportante> listaAcoImp
                = new ArrayList<AcontecimientoImportante>();
        String hql = "FROM AcontecimientoImportante A WHERE A.empleado.id "
                + "IS NOT NULL ORDER BY A.fechaUnica ASC";
        Query query = sesion.createQuery(hql);
        listaAcoImp = (ArrayList<AcontecimientoImportante>) query.list();        
        
        if(listaAcoImp.isEmpty() == false)
        {
            return listaAcoImp;
        }
        else
        {
            return new ArrayList<AcontecimientoImportante>();
        }        
    }         
}