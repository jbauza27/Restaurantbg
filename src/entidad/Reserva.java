package entidad;

import java.io.*;
import java.util.*;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Reserva extends EntityBean implements Serializable
{
    /* Atributos */
    private boolean activo;
    private GregorianCalendar fechayHora;
        
    @OneToOne
    private Cliente cliente;
    
    @OneToOne
    private Mesa mesa;
    
    
    /* Constructor */
    public Reserva()
    {
        
    }
    
    
    /* Métodos 'set' y 'get' */
    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }

    public GregorianCalendar getFechayHora()
    {
        return fechayHora;
    }

    public void setFechayHora(GregorianCalendar fechayHora)
    {
        this.fechayHora = fechayHora;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Mesa getMesa()
    {
        return mesa;
    }

    public void setMesa(Mesa mesa)
    {
        this.mesa = mesa;
    }    
}
