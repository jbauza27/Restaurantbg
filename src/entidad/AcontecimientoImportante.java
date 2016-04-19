package entidad;

import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class AcontecimientoImportante extends EntityBean implements Serializable
{
    // una constante
    public static final int A_ANUAL = 2200;
    
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private GregorianCalendar fechaUnica;
    private GregorianCalendar fechaAnual;
    private String acontecimiento;    
    private String tipo; // anual o único
    
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="idEmpleado")
    private Empleado empleado;
    
    
    /* Constructor */
    public AcontecimientoImportante()
    {
        
    }
    

    /* Métodos */
    
    
    /* Métodos 'set' y 'get' */
    public GregorianCalendar getFechaUnica()
    {
        return fechaUnica;
    }

    public void setFechaUnica(GregorianCalendar fechaUnica)
    {
        this.fechaUnica = fechaUnica;
    }

    public GregorianCalendar getFechaAnual()
    {
        return fechaAnual;
    }

    public void setFechaAnual(GregorianCalendar fechaAnual)
    {
        this.fechaAnual = fechaAnual;
    }    
    
    public String getAcontecimiento()
    {
        return acontecimiento;
    }

    public void setAcontecimiento(String acontecimiento)
    {
        this.acontecimiento = acontecimiento;
    }
    
    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
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
}