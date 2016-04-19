package entidad;

import java.io.*;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Mesa extends EntityBean implements Serializable
{
    /* Atributos */
    private boolean activo;
    private String nroMesa;
    private String cantPersonas;
    private String descripcion;
    
    
    /* Constructor */
    public Mesa()
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

    public String getNroMesa()
    {
        return nroMesa;
    }

    public void setNroMesa(String nroMesa)
    {
        this.nroMesa = nroMesa;
    }

    public String getCantPersonas()
    {
        return cantPersonas;
    }

    public void setCantPersonas(String cantPersonas)
    {
        this.cantPersonas = cantPersonas;
    }   

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }    
}
