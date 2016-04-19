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
public class Cliente extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaDeNacimiento;
    private String sexo;
    private String telefonoFijo;
    private String telefonoCelular;
    private String dni;
    private String email;
    private String calle;
    private String localidad;
    
    @OneToOne
    private Provincia provincia;
    
    @OneToOne
    private Pais pais;
    
    @OneToMany(mappedBy="cliente", targetEntity=AcontecimientoImportante.class)
    private List<AcontecimientoImportante> listaAcontecimientosImportantes;

    
    /* Constructor */
    public Cliente()
    {
        
    }
    

    /* Métodos */
    
    
    /* Métodos 'set' y 'get' */
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public GregorianCalendar getFechaDeNacimiento()
    {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento)
    {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() 
    {
        return sexo;
    }

    public void setSexo(String sexo) 
    {
        this.sexo = sexo;
    }

    public String getTelefonoFijo()
    {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular()
    {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular)
    {
        this.telefonoCelular = telefonoCelular;
    }

    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
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

    public List<AcontecimientoImportante> getListaAcontecimientosImportantes()
    {
        return listaAcontecimientosImportantes;
    }

    public void setListaAcontecimientosImportantes
        (List<AcontecimientoImportante> listaAcontecimientosImportantes)
    {
        this.listaAcontecimientosImportantes = listaAcontecimientosImportantes;
    }   
}
