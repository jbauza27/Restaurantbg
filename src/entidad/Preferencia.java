package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Preferencia extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;    
    
    @OneToOne
    private Cliente cliente;
    
    @OneToOne
    private ProductoElaborado productoElaborado;

    private int cantidadConsumiciones;
    
    
    /* Constructor */
    public Preferencia()
    {
        
    }
    
    
    /* Métodos */ 


    /* Métodos 'set' y 'get' */
    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public ProductoElaborado getProductoElaborado()
    {
        return productoElaborado;
    }
    
    public void setProductoElaborado(ProductoElaborado productoElaborado)
    {
        this.productoElaborado = productoElaborado;
    }

    public int getCantidadConsumiciones()
    {
        return cantidadConsumiciones;
    }

    public void setCantidadConsumiciones(int cantidadConsumiciones)
    {
        this.cantidadConsumiciones = cantidadConsumiciones;
    } 
}