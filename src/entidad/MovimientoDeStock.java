package entidad;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class MovimientoDeStock extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private GregorianCalendar fecha;
    private double cantidad;
    private String estado; // entrada o salida    
    private String motivo;
    
    @OneToOne
    private MateriaPrima materiaPrima;
    
    @OneToOne
    private ProductoElaborado productoElaborado;
    
    
    /* Constructor */
    public MovimientoDeStock()
    {
        
    }
    
    
    /* Métodos */      
    
    
    /* Métodos 'set' y 'get' */
    public GregorianCalendar getFecha()
    {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha)
    {
        this.fecha = fecha;
    }

    public double getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(double cantidad)
    {
        this.cantidad = cantidad;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getMotivo()
    {
        return motivo;
    }

    public void setMotivo(String motivo)
    {
        this.motivo = motivo;
    }

    public MateriaPrima getMateriaPrima()
    {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima)
    {
        this.materiaPrima = materiaPrima;
    }

    public ProductoElaborado getProductoElaborado()
    {
        return productoElaborado;
    }

    public void setProductoElaborado(ProductoElaborado productoElaborado)
    {
        this.productoElaborado = productoElaborado;
    }    
}
