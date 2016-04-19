package gestor;

import entidad.*;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'reservas' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * las reservas.
 */
public class GestorReservas extends GestorGeneral
{
    /* Constructor */
    public GestorReservas(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve la reserva que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' de la reserva a buscar
     * @return el objeto 'reserva' apropiado o 'null' si no es encontró la misma
     */    
    public Reserva buscarPorId(int id)
    {
        Reserva res = (Reserva)
                sesion.createCriteria(Reserva.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return res;
    }

    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'reserva'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'reserva' 
     * que se mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo, List<Reserva> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Fecha");
        col.add("Hora");
        col.add("Mesa");
        col.add("Cliente");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (Reserva res : lista)
            {
                Object[] datosFila = new Object[10];
                datosFila[0] = res.getId();
                datosFila[1] = res.getFechayHora().get(Calendar.DAY_OF_MONTH)
                        + "/" + (res.getFechayHora().get(Calendar.MONTH) + 1)
                        + "/" + res.getFechayHora().get(Calendar.YEAR);
                Integer horaInt = res.getFechayHora().get(Calendar.HOUR_OF_DAY);
                String horaString;
                if(horaInt < 10)
                {
                    horaString = "0" + horaInt.toString();
                }
                else
                {
                    horaString = horaInt.toString();
                }
                Integer minutosInt = res.getFechayHora().get(Calendar.MINUTE);
                String minutosString;
                if(minutosInt < 10)
                {
                    minutosString = "0" + minutosInt.toString();
                }
                else
                {
                    minutosString = minutosInt.toString();
                }
                datosFila[2] = horaString + ":" + minutosString;                 
                datosFila[3] = res.getMesa().getNroMesa();
                datosFila[4] = res.getCliente().getApellido()
                        + " " + res.getCliente().getNombre();
                
                modelo.addRow(datosFila);                             
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para devolver todas las reservas que se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'reserva' que se
     * hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */        
    public ArrayList<Reserva> getListaReservas()
    {
        Criteria crit = sesion.createCriteria(Reserva.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<Reserva>) crit.list();
        }
        else
        {
            return new ArrayList<Reserva>();
        }
    }
    
    /**
     * Se utiliza para devolver todas las reservas que tengan estado 'activo'
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'reserva' que tengan
     * estado 'activo' que se hallen en la base de datos, o un arreglo vacío
     * si no existe ninguno
     */    
    public ArrayList<Reserva> getListaReservasActivas()
    {
        ArrayList<Reserva> reservasActivas = new ArrayList<>();
        String hql = "FROM Reserva R WHERE R.activo = true";
        Query query = sesion.createQuery(hql);
        reservasActivas = (ArrayList<Reserva>) query.list();
        
        if(reservasActivas.isEmpty() == true)
        {
            return new ArrayList<Reserva>();
        }
        else
        {
            return reservasActivas;
        }
    }       
    
    /**
     * Se utiliza para devolver todas las reservas que estén dadas de baja
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'reserva' que estén dados
     * de baja en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<Reserva> getListaReservasDadasDeBaja()
    {
        ArrayList<Reserva> reservasDadasDeBaja = new ArrayList<>();
        String hql = "FROM Reserva R WHERE R.activo = false";
        Query query = sesion.createQuery(hql);
        reservasDadasDeBaja = (ArrayList<Reserva>) query.list();
        
        if(reservasDadasDeBaja.isEmpty() == true)
        {
            return new ArrayList<Reserva>();
        }
        else
        {
            return reservasDadasDeBaja;
        }
    }         
}