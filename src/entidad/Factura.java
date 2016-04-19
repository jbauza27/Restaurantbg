package entidad;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Factura extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private boolean estado;
    private GregorianCalendar fecha;
    private int numero;
    private double IVA;
    private String condicionesDeVenta;
    private String tipo;
    private double totalGeneral;
    
    @OneToOne
    private Cliente cliente;
    
    @OneToOne
    private Empleado empleado;
    
    @OneToMany(mappedBy="factura", targetEntity=DetalleFactura.class)
    private List<DetalleFactura> listaDetalleFactura;
    
    
    /* Constructor */
    public Factura()
    {
        
    }
    
    
    /* Métodos */    
    
    
    /* Métodos 'set' y 'get' */
    public boolean getEstado()
    {
        return estado;
    }

    public void setEstado(boolean estado)
    {
        this.estado = estado;
    }

    public GregorianCalendar getFecha()
    {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha)
    {
        this.fecha = fecha;
    }

    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }

    public double getIVA()
    {
        return IVA;
    }

    public void setIVA(double IVA)
    {
        this.IVA = IVA;
    }

    public String getCondicionesDeVenta()
    {
        return condicionesDeVenta;
    }

    public void setCondicionesDeVenta(String condicionesDeVenta)
    {
        this.condicionesDeVenta = condicionesDeVenta;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public double getTotalGeneral()
    {
        return totalGeneral;
    }

    public void setTotalGeneral(double totalGeneral)
    {
        this.totalGeneral = totalGeneral;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
    }

    public List<DetalleFactura> getListaDetalleFactura()
    {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(List<DetalleFactura> listaDetalleFactura)
    {
        this.listaDetalleFactura = listaDetalleFactura;
    }    
}
