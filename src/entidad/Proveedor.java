package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Proveedor extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private boolean activo;
    private String nombre;
    private String telefonoUno;
    private String telefonoDos;
    private String telefonoTres;
    private String tipo; // persona o empresa
    private String nombreDeContacto;
    private String email;
    private String calle;
    private String localidad;
    
    @OneToOne
    private Provincia provincia;
    
    @OneToOne
    private Pais pais;
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="proveedores") 
    private List<MateriaPrima> materiasPrimas;
    
    
    /* Constructor */
    public Proveedor()
    {
        
    }
    
    
    /* Métodos */   
    
    
    /* Métodos 'set' y 'get' */
    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefonoUno()
    {
        return telefonoUno;
    }

    public void setTelefonoUno(String telefonoUno)
    {
        this.telefonoUno = telefonoUno;
    }

    public String getTelefonoDos()
    {
        return telefonoDos;
    }

    public void setTelefonoDos(String telefonoDos)
    {
        this.telefonoDos = telefonoDos;
    }
    
    public String getTelefonoTres()
    {
        return telefonoTres;
    }

    public void setTelefonoTres(String telefonoTres)
    {
        this.telefonoTres = telefonoTres;
    }    
    
    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getNombreDeContacto()
    {
        return nombreDeContacto;
    }

    public void setNombreDeContacto(String nombreDeContacto)
    {
        this.nombreDeContacto = nombreDeContacto;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCalle()
    {
        return calle;
    }

    public void setCalle(String calle)
    {
        this.calle = calle;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    public Provincia getProvincia()
    {
        return provincia;
    }

    public void setProvincia(Provincia provincia)
    {
        this.provincia = provincia;
    }

    public Pais getPais()
    {
        return pais;
    }

    public void setPais(Pais pais)
    {
        this.pais = pais;
    }    

    public List<MateriaPrima> getMateriasPrimas()
    {
        return materiasPrimas;
    }

    public void setMateriasPrimas(List<MateriaPrima> materiasPrimas)
    {
        this.materiasPrimas = materiasPrimas;
    }
}