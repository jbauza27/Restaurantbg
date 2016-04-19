package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Provincia extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private String nombreProvincia;
    
    @ManyToOne
    @JoinColumn(name="idPais")
    private Pais pais;
    
    
    /* Constructor */
    public Provincia()
    {
        
    }
    

    /* Métodos */     
    
    
    /* Métodos 'set' y 'get' */
    public String getNombreProvincia()
    {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) 
    {
        this.nombreProvincia = nombreProvincia;
    }

    public Pais getPais()
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }    
}