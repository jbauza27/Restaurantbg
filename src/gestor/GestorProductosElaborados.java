package gestor;

import entidad.MateriaPrima;
import entidad.ProductoElaborado;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.collection.PersistentBag;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'productos elaborados' a la base de
 * datos, así como también de armar el modelo que se usará para generar la
 * tabla que muestre los productos elaborados.
 */
public class GestorProductosElaborados extends GestorGeneral
{
    /* Constructor */
    public GestorProductosElaborados(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve el producto elaborado que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' del producto elaborado a buscar
     * @return el objeto 'producto elaborado' apropiado o 'null' si no se
     * encontró el mismo
     */  
    public ProductoElaborado buscarPorId(int id)
    {
        ProductoElaborado prodElab = (ProductoElaborado)
                sesion.createCriteria(ProductoElaborado.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return prodElab;
    }
    
    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'producto elaborado'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'producto elaborado'
     * que se mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo, List<ProductoElaborado> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Nombre");
        col.add("Precio");
        col.add("Cantidad");
        col.add("Materias primas");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {            
            for (ProductoElaborado prodElab : lista)
            {
                if(prodElab.isActivo() == true)
                {
                    Object[] datosFila = new Object[5];
                    datosFila[0] = prodElab.getId();
                    datosFila[1] = prodElab.getNombre();
                    datosFila[2] = prodElab.getPrecio();
                    datosFila[3] = prodElab.getCantidad();
                    String cadenaMateriasPrimas = "";

                    PersistentBag temp = (PersistentBag) prodElab.getMateriasPrimas();
                    ArrayList<MateriaPrima> listaMateriasPrimas = new ArrayList<>();
                    listaMateriasPrimas.addAll(temp);

                    for(MateriaPrima matPrim : listaMateriasPrimas)
                    {
                        cadenaMateriasPrimas = cadenaMateriasPrimas + matPrim.getNombre() + " - ";
                    }
                    datosFila[4] = cadenaMateriasPrimas;

                    modelo.addRow(datosFila); 
                }
                else
                {
                    // si no está dada de alta, no la agrego a la lista
                }
            }
        }
        
        return modelo;    
    }
    
    /**
     * Se utiliza para devolver todos los productos elaborados que se hallen
     * en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'producto elaborado'
     * que se hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */    
    public ArrayList<ProductoElaborado> getListaProductosElaborados()
    {
        Criteria crit = sesion.createCriteria(ProductoElaborado.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<ProductoElaborado>) crit.list();
        }
        else
        {
            return new ArrayList<ProductoElaborado>();
        }
    }

    /**
     * Se utiliza para devolver todos los productos elaborados con estado 'activo'
     * que se hallen en la base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'producto elaborado'
     * que se hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */       
    public ArrayList<ProductoElaborado> getListaProductosElaboradosActivos()
    {
        ArrayList<ProductoElaborado> listaProdElab = new ArrayList<>();
        String hql = "FROM ProductoElaborado P WHERE P.activo = true";
        Query query = sesion.createQuery(hql);
        listaProdElab = (ArrayList<ProductoElaborado>) query.list();
        
        if(listaProdElab.isEmpty() == true)
        {
            return new ArrayList<ProductoElaborado>();
        }
        else
        {
            return listaProdElab;
        }
    }    
}