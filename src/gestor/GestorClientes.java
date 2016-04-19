package gestor;

import entidad.Cliente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase encargada de gestionar pedidos de 'clientes' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * los clientes.
 */
public class GestorClientes extends GestorGeneral
{
    /* Constructor */
    public GestorClientes(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el cliente que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del cliente a buscar
     * @return el objeto 'cliente' apropiado o 'null' si no es encontró el mismo
     */
    public Cliente buscarPorId(int id)
    {
        Cliente cli = (Cliente)
                sesion.createCriteria(Cliente.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return cli;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'cliente'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'cliente' que se 
     * mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo, List<Cliente> lista)
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
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (Cliente cli : lista)
            {
                Object[] datosFila = new Object[10];
                datosFila[0] = cli.getId();
                datosFila[1] = cli.getApellido();
                datosFila[2] = cli.getNombre();
                if(cli.getFechaDeNacimiento() == null)
                {
                    datosFila[3] = "";
                }
                else
                {
                    datosFila[3] = cli.getFechaDeNacimiento().get(Calendar.DAY_OF_MONTH)
                            + "/" + (cli.getFechaDeNacimiento().get(Calendar.MONTH) + 1)
                            + "/" + cli.getFechaDeNacimiento().get(Calendar.YEAR);
                }                
                datosFila[4] = cli.getSexo();
                datosFila[5] = cli.getTelefonoFijo();
                datosFila[6] = cli.getTelefonoCelular();
                datosFila[7] = cli.getDni();
                datosFila[8] = cli.getEmail();
                
                // si están presentes todos los datos del domicilio
                if(!cli.getCalle().equals("") && !cli.getLocalidad().equals(""))
                {
                    datosFila[9] = cli.getCalle() + ", " + cli.getLocalidad() + ", "
                            + cli.getProvincia().getNombreProvincia()
                            + ", " + cli.getPais().getNombrePais();
                }    
                // si falta la calle
                else if(cli.getCalle().equals(""))
                {
                    datosFila[9] = cli.getLocalidad() + ", "
                            + cli.getProvincia().getNombreProvincia()
                            + ", " + cli.getPais().getNombrePais();
                }
                // si falta la localidad
                else if(cli.getLocalidad().equals(""))
                {
                    datosFila[9] = cli.getCalle() + ", "
                            + cli.getProvincia().getNombreProvincia()
                            + ", " + cli.getPais().getNombrePais();
                }
                // si no están presentes ni la calle ni la localidad
                else if(cli.getCalle().equals("") && cli.getLocalidad().equals(""))
                {
                    datosFila[9] = cli.getProvincia().getNombreProvincia()
                            + ", " + cli.getPais().getNombrePais();
                }                        
                
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para devolver todos los clientes que se hallen en la base de
     * datos.
     * 
     * @return un arreglo que contiene todos los objetos 'cliente' que se hallen
     * en la base de datos, o un arreglo vacío si no existe ninguno
     */
    public ArrayList<Cliente> getListaClientes()
    {
        Criteria crit = sesion.createCriteria(Cliente.class)
                .addOrder(Order.asc("apellido"));                
        
        if(crit.list() != null)
        {
            return (ArrayList<Cliente>) crit.list();
        }
        else
        {
            return new ArrayList<Cliente>();
        }
    }    
}