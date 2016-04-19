package entidad;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class EntityBean
{    
    /* Atributos */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

    
    /* Métodos */
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }    
    
    public static String getIdentityPropery()
    {
        return "id";
    }
}
