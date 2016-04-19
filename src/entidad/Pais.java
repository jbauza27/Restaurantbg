package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pais extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private String nombrePais;
    
    @OneToMany(mappedBy="pais", targetEntity=Provincia.class)
    private List<Provincia> listaProvincias;
    
    
    /* Constructor */
    public Pais()
    {
        
    }
    

    /* Métodos */      
    
    
    /* Métodos 'set' y 'get' */
    public String getNombrePais()
    {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais)
    {
        this.nombrePais = nombrePais;
    }

    public List<Provincia> getListaProvincias()
    {
        return listaProvincias;
    }

    public void setListaProvincias(List<Provincia> listaProvincias)
    {
        this.listaProvincias = listaProvincias;
    }    
}