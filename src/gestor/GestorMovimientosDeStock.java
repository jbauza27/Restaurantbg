package gestor;

import entidad.MovimientoDeStock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'movimientos de stock' a la base de
 * datos, así como también de armar el modelo que se usará para generar la
 * tabla que muestre los movimientos de stock.
 */
public class GestorMovimientosDeStock extends GestorGeneral
{
    /* Constructor */
    public GestorMovimientosDeStock(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el movimiento de stock que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del movimiento de stock a buscar
     * @return el objeto 'movimiento de stock' apropiado o 'null' si no se
     * encontró el mismo
     */
    public MovimientoDeStock buscarPorId(int id)
    {
        MovimientoDeStock movStock = (MovimientoDeStock)
                sesion.createCriteria(MovimientoDeStock.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return movStock;
    }

    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'movimientos de stock'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'movimientos de stock'
     * que se mostrarán
     * @return el modelo final a mostrar
     */    
    public Modelo configurarModelo(Modelo modelo, List<MovimientoDeStock> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Fecha");
        col.add("Hora");
        col.add("Cantidad");
        col.add("Estado");
        col.add("Motivo");
        col.add("Ítem");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (MovimientoDeStock movSto : lista)
            {    
                Object[] datosFila = new Object[7];
                datosFila[0] = movSto.getId();
                datosFila[1] = movSto.getFecha().get(Calendar.DAY_OF_MONTH)
                        + "/" + (movSto.getFecha().get(Calendar.MONTH) + 1)
                        + "/" + movSto.getFecha().get(Calendar.YEAR);
                Integer horaInt = movSto.getFecha().get(Calendar.HOUR_OF_DAY);
                String horaString;
                if(horaInt < 10)
                {
                    horaString = "0" + horaInt.toString();
                }
                else
                {
                    horaString = horaInt.toString();
                }
                Integer minutosInt = movSto.getFecha().get(Calendar.MINUTE);
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
                datosFila[3] = movSto.getCantidad();
                datosFila[4] = movSto.getEstado();
                datosFila[5] = movSto.getMotivo();
                // si el ítem no es un producto elaborado, entonces es una materia prima
                if(movSto.getProductoElaborado() == null)
                {
                    datosFila[6] = "Materia prima '"
                            + movSto.getMateriaPrima().getNombre()
                            + "'";
                }
                else
                {
                    datosFila[6] = "Producto elaborado '"
                            + movSto.getProductoElaborado().getNombre()
                            + "'";
                }
                    
                modelo.addRow(datosFila);                               
            }
        }
        
        return modelo;
    }
    
    /**
     * Se utiliza para devolver todos los movimientos de stock que se hallen
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'movimientos de stock'
     * que se hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<MovimientoDeStock> getListaMovimientosDeStock()
    {
        Criteria crit = sesion.createCriteria(MovimientoDeStock.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<MovimientoDeStock>) crit.list();
        }
        else
        {
            return new ArrayList<MovimientoDeStock>();
        }
    }
}