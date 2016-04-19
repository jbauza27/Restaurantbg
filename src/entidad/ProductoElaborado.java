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
public class ProductoElaborado extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private boolean activo;
    private String nombre;
    private double precio;
    private int cantidad;
    
    @ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="productoselaborados_materiasprimas",
            joinColumns=@JoinColumn(name="productoelaborado_id"),
            inverseJoinColumns=@JoinColumn(name="materiaprima_id")) 
    private List<MateriaPrima> materiasPrimas;
    
    
    /* Constructor */
    public ProductoElaborado()
    {
        
    }
    
    
    /* Métodos */      
    

    /* Métodos 'set' y 'get' */
    public boolean isActivo()
    {
        return activo;
    }
    
    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }

    public String getNombre() {
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

    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public List<MateriaPrima> getMateriasPrimas()
    {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrima> materiasPrimas)
    {
        this.materiasPrimas = materiasPrimas;
    }  
}