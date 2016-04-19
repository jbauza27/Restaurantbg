package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class PrimerUso extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private String primerUso;
    
    
    /* Constructor */
    public PrimerUso()
    {
        
    }
    

    /* Métodos */  
    
    
    /* Métodos 'set' y 'get' */ 
    public String getPrimerUso()
    {
        return primerUso;
    }

    public void setPrimerUso(String primerUso)
    {
        this.primerUso = primerUso;
    }    
}