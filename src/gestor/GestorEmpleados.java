package gestor;

import entidad.Empleado;
import entidad.HorariosDeTrabajo;
import entidad.ProductoElaborado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'empleados' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * los empleados.
 */
public class GestorEmpleados extends GestorGeneral
{
    /* Constructor */
    public GestorEmpleados(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el empleado que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del empleado a buscar
     * @return el objeto 'empleado' apropiado o 'null' si no es encontró el mismo
     */
    public Empleado buscarEmpleadoPorId(int id)
    {
        Empleado emp = (Empleado)
                sesion.createCriteria(Empleado.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return emp;
    }

    /**
     * Devuelve el horario de trabajo que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del horario de trabajo a buscar
     * @return el objeto 'horario de trabajo' apropiado o 'null' si no es encontró el mismo
     */    
    public HorariosDeTrabajo buscarHorariosDeTrabajoPorId(int id)
    {
        HorariosDeTrabajo HorDeTrab = (HorariosDeTrabajo)
                sesion.createCriteria(HorariosDeTrabajo.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return HorDeTrab;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'empleado'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'empleado' que se 
     * mostrarán
     * @return el modelo final a mostrar
     */    
    public Modelo configurarModeloGeneral(Modelo modelo, List<Empleado> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Apellido");
        col.add("Nombre");
        col.add("Fecha de nacimiento");
        col.add("Sexo");
        col.add("Teléfono fijo");
        col.add("Teléfono celular");
        col.add("DNI");
        col.add("Email");
        col.add("Domicilio");
        col.add("Sueldo bruto");
        col.add("Cargo");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (Empleado emp : lista)
            {    
                Object[] datosFila = new Object[12];
                datosFila[0] = emp.getId();
                datosFila[1] = emp.getApellido();
                datosFila[2] = emp.getNombre();
                datosFila[3] = emp.getFechaDeNacimiento().get(Calendar.DAY_OF_MONTH)
                        + "/" + (emp.getFechaDeNacimiento().get(Calendar.MONTH) + 1)
                        + "/" + emp.getFechaDeNacimiento().get(Calendar.YEAR);
                datosFila[4] = emp.getSexo();
                datosFila[5] = emp.getTelefonoFijo();
                datosFila[6] = emp.getTelefonoCelular();
                datosFila[7] = emp.getDni();
                datosFila[8] = emp.getEmail();
                datosFila[9] = emp.getCalle() + ", " + emp.getLocalidad()
                        + ", " + emp.getProvincia() + ", "
                        + emp.getPais();
                datosFila[10] = emp.getSueldoBruto();
                datosFila[11] = emp.getCargo().getNombreCargo();
                    
                modelo.addRow(datosFila);                               
            }
        }
        
        return modelo;
    }
    
    /**
     * Construye el modelo que se utilizará mostrar los horarios de trabajo de un
     * empleado dado.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los horarios de trabajo de un
     * empleado dado
     * @return el modelo final a mostrar
     */
    public Modelo configurarModeloHorariosDeTrabajo
            (Modelo modelo, List<HorariosDeTrabajo> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Lunes");
        col.add("Martes");
        col.add("Miércoles");
        col.add("Jueves");
        col.add("Viernes");
        col.add("Sábado");
        col.add("Domingo");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
        
        if(lista != null)
        {
            ArrayList<HorariosDeTrabajo> lunes = new ArrayList<>();
            int cantLunes = 0;
            ArrayList<HorariosDeTrabajo> martes = new ArrayList<>();
            int cantMartes = 0;
            ArrayList<HorariosDeTrabajo> miercoles = new ArrayList<>();
            int cantMiercoles = 0;
            ArrayList<HorariosDeTrabajo> jueves = new ArrayList<>();
            int cantJueves = 0;            
            ArrayList<HorariosDeTrabajo> viernes = new ArrayList<>();
            int cantViernes = 0;
            ArrayList<HorariosDeTrabajo> sabado = new ArrayList<>();
            int cantSabado = 0;
            ArrayList<HorariosDeTrabajo> domingo = new ArrayList<>();
            int cantDomingo = 0;
            for(HorariosDeTrabajo temp : lista)
            {
                if(temp.getDiaDeSemana().equals("Lunes"))
                {
                    cantLunes++;
                    lunes.add(temp);
                }
                else if(temp.getDiaDeSemana().equals("Martes"))
                {
                    cantMartes++;
                    martes.add(temp);
                }
                else if(temp.getDiaDeSemana().equals("Miércoles"))
                {
                    cantMiercoles++;
                    miercoles.add(temp);
                }
                else if(temp.getDiaDeSemana().equals("Jueves"))
                {
                    cantJueves++;
                    jueves.add(temp);
                }
                else if(temp.getDiaDeSemana().equals("Viernes"))
                {
                    cantViernes++;
                    viernes.add(temp);
                }
                else if(temp.getDiaDeSemana().equals("Sábado"))
                {
                    cantSabado++;
                    sabado.add(temp);
                }
                else if(temp.getDiaDeSemana().equals("Domingo"))
                {
                    cantDomingo++;
                    domingo.add(temp);
                }
            }
            
            for(int i = 0 ; i < 3 ; i++)
            {
                Object[] datosFila = new Object[7];
                
                if(i < cantLunes)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) lunes.get(i);
                    datosFila[0] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
                }
                else
                {
                    datosFila[0] = "";
                }
                
                if(i < cantMartes)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) martes.get(i);
                    datosFila[1] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
                }
                else
                {
                    datosFila[1] = "";
                }
                
                if(i < cantMiercoles)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) miercoles.get(i);
                    datosFila[2] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
                }
                else
                {
                    datosFila[2] = "";
                }
                
                if(i < cantJueves)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) jueves.get(i);
                    datosFila[3] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";                    
                }
                else
                {
                    datosFila[3] = "";
                }
                
                if(i < cantViernes)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) viernes.get(i);
                    datosFila[4] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
                }
                else
                {
                    datosFila[4] = "";
                }
                
                if(i < cantSabado)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) sabado.get(i);
                    datosFila[5] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
                }
                else
                {
                    datosFila[5] = "";
                }
                
                if(i < cantDomingo)
                {
                    HorariosDeTrabajo ht = (HorariosDeTrabajo) sabado.get(i);
                    datosFila[6] = "Turno " + ht.getParteDelDia()
                            + ", de " + ht.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                            + " hasta " + ht.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                            + ":" + ht.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
                }
                else
                {
                    datosFila[6] = "";
                }
                
                modelo.addRow(datosFila);
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para devolver todos los empleados que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'empleado' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */
    public ArrayList<Empleado> getListaEmpleados()
    {
        Criteria crit = sesion.createCriteria(Empleado.class)
                .addOrder(Order.asc("apellido"));                
        
        if(crit.list() != null)
        {
            return (ArrayList<Empleado>) crit.list();
        }
        else
        {
            return new ArrayList<Empleado>();
        }
    }

    /**
     * Se utiliza para devolver todos los empleados que tengan estado 'activo'
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'empleado' que tengan
     * estado 'activo' que se hallen en la base de datos, o un arreglo vacío
     * si no existe ninguno
     */    
    public ArrayList<Empleado> getListaEmpleadosActivos()
    {
        ArrayList<Empleado> empleadosActivos = new ArrayList<>();
        String hql = "FROM Empleado E WHERE E.activo = true";
        Query query = sesion.createQuery(hql);
        empleadosActivos = (ArrayList<Empleado>) query.list();
        
        if(empleadosActivos.isEmpty() == true)
        {
            return new ArrayList<Empleado>();
        }
        else
        {
            return empleadosActivos;
        }
    }     
    
    /**
     * Se utiliza para devolver todos los horarios de trabajo que se hallen en
     * la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'horarioDeTrabajo' que
     * se hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */
    public ArrayList<HorariosDeTrabajo> getListaHorariosDeTrabajo()
    {
        Criteria crit = sesion.createCriteria(HorariosDeTrabajo.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<HorariosDeTrabajo>) crit.list();
        }
        else
        {
            return new ArrayList<HorariosDeTrabajo>();
        }
    }
    
    /**
     * Se utiliza para devolver todos los empleados cuyo cargo sea el de mozo y
     * que al mismo tiempo tengan estado 'activo' que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'empleado' cuyo cargo
     * sea el de mozo y que al mismo tiempo tengan estado 'activo' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<Empleado> getListaMozosActivos()
    {
        ArrayList<Empleado> listaMozosActivos = new ArrayList<>();
        String hql = "FROM Empleado E WHERE E.activo = true"
                + " AND E.cargo.nombreCargo LIKE 'Mozo'";
        Query query = sesion.createQuery(hql);
        listaMozosActivos = (ArrayList<Empleado>) query.list();
        
        if(listaMozosActivos.isEmpty() == true)
        {
            return new ArrayList<Empleado>();
        }
        else
        {
            return listaMozosActivos;
        }
    }       
}