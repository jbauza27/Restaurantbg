package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class DetalleFactura extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private int cantidad;
    private double precioUnitario;
    private double importe;
    
    @ManyToOne()
    @JoinColumn(name="idFactura")
    private Factura factura;
    
    @OneToOne
    private ProductoElaborado productoElaborado;
    
    
    /* Constructor */
    public DetalleFactura()
    {
        
    }
    
    
    /* Métodos */
    
    
    /* Métodos 'set' y 'get' */
    public int getCantidad()
    {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario()
    {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario)
    {
        this.precioUnitario = precioUnitario;
    }

    public double getImporte()
    {
        return importe;
    }

    public void setImporte(double importe)
    {
        this.importe = importe;
    }

    public Factura getFactura()
    {
        return factura;
    }

    public void setFactura(Factura factura)
    {
        this.factura = factura;
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
