package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class MateriaPrima extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private String nombre;
    private double precio;
    private double cantidad;
    
    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="materiasprimas_proveedores",
            joinColumns=@JoinColumn(name="materiaprima_id"),
            inverseJoinColumns=@JoinColumn(name="proveedores_id"))  
    private List<Proveedor> proveedores;
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="materiasPrimas") 
    private List<ProductoElaborado> productosElaborados;
    
    
    /* Constructor */
    public MateriaPrima()
    {
        
    }
    
    
    /* Métodos */


    /* Métodos 'set' y 'get' */
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public double getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(double cantidad)
    {
        this.cantidad = cantidad;
    }

    public List<Proveedor> getProveedores() 
    {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores)
    {
        this.proveedores = proveedores;
    }   

    public List<ProductoElaborado> getProductosElaborados()
    {
        return productosElaborados;
    }

    public void setProductosElaborados(List<ProductoElaborado> productosElaborados)
    {
        this.productosElaborados = productosElaborados;
    }    
}