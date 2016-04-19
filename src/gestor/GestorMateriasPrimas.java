package gestor;

import entidad.MateriaPrima;
import entidad.Proveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.collection.PersistentBag;
import org.hibernate.criterion.Restrictions;
import utilidades.Modelo;


/**
 * Clase en cargada de gestionar pedidos de 'materias primas' a la base de datos, así
 * como también de armar el modelo que se usará para generar la tabla que muestre
 * las materias primas.
 */
public class GestorMateriasPrimas extends GestorGeneral
{
    /* Constructor */
    public GestorMateriasPrimas(Session sesion)
    {
        super(sesion);
    }
    
        
    /* Métodos */
    /**
     * Devuelve la materia prima que se corresponde con el 'id' recibido.
     * 
     * @param id el 'id' de la materia prima a buscar
     * @return el objeto 'materia prima' apropiado o 'null' si no es encontró
     * el mismo
     */    
    public MateriaPrima buscarPorId(int id)
    {
        MateriaPrima matPrim = (MateriaPrima)
                sesion.createCriteria(MateriaPrima.class)
                .add(Restrictions.eq("id", id))
                .list()
                .get(0);
        return matPrim;
    }

    /**
     * Construye el modelo que se utilizará para mostrar una lista con los objetos
     * 'materia prima'.
     * 
     * @param modelo un modelo general, que será modificado
     * @param lista un arreglo que contendrá todos los objetos 'materia prima' 
     * que se mostrarán
     * @return el modelo final a mostrar
     */
    public Modelo configurarModelo(Modelo modelo, List<MateriaPrima> lista)
    {        
        Vector<String> col = new Vector();
        col.add("Id");
        col.add("Nombre");
        col.add("Precio");
        col.add("Cantidad");
        col.add("Proveedores");
        modelo = new Modelo();
        modelo.setColumnIdentifiers(col);
                
        if (lista != null)
        {
            for (MateriaPrima matPrim : lista)
            { 
                    Object[] datosFila = new Object[5];
                    datosFila[0] = matPrim.getId();
                    datosFila[1] = matPrim.getNombre();
                    datosFila[2] = matPrim.getPrecio();
                    datosFila[3] = matPrim.getCantidad();
                    String cadenaProveedores = "";

                    PersistentBag temp = (PersistentBag) matPrim.getProveedores();
                    ArrayList<Proveedor> listaProveedores = new ArrayList<>();
                    listaProveedores.addAll(temp);

                    for(Proveedor prov : listaProveedores)
                    {
                        cadenaProveedores = cadenaProveedores + prov.getNombre() + " - ";
                    }
                    datosFila[4] = cadenaProveedores;

                    modelo.addRow(datosFila);
            }
        }
        
        return modelo;    
    }
    
    /**
     * Se utiliza para devolver todas las materias primas que se hallen en la
     * base de datos.
     * 
     * @return un arreglo que contiene todos los objetos 'materia prima' que se
     * hallen en la base de datos, o un arreglo vacío si no existe ninguno
     */        
    public ArrayList<MateriaPrima> getListaMateriasPrimas()
    {
        Criteria crit = sesion.createCriteria(MateriaPrima.class);                
        
        if(crit.list() != null)
        {
            return (ArrayList<MateriaPrima>) crit.list();
        }
        else
        {
            return new ArrayList<MateriaPrima>();
        }
    }
}