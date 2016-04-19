package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cargo extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private String nombreCargo;
    private String descripcion;
    
    
    /* Constructor */
    public Cargo()
    {
        
    }
    

    /* Métodos */
    
    
    /* Métodos 'set' y 'get' */
    public String getNombreCargo()
    {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo)
    {
        this.nombreCargo = nombreCargo;
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