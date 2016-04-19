package entidad;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class HorariosDeTrabajo extends EntityBean implements Serializable
{
    /* Atributos */
    private static final long serialVersionUID = 1L;
    private boolean activo;
    private String parteDelDia; // mañana, tarde, noche
    private String diaDeSemana;
    private GregorianCalendar horaDeInicio;
    private GregorianCalendar horaDeFinalizacion;    
    
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="horariosDeTrabajo") 
    private List<Empleado> empleados;

        
    /* Constructor */
    public HorariosDeTrabajo()
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

    public String getParteDelDia()
    {
        return parteDelDia;
    }

    public void setParteDelDia(String parteDelDia)
    {
        this.parteDelDia = parteDelDia;
    }

    public String getDiaDeSemana()
    {
        return diaDeSemana;
    }

    public void setDiaDeSemana(String diaDeSemana)
    {
        this.diaDeSemana = diaDeSemana;
    }

    public GregorianCalendar getHoraDeInicio()
    {
        return horaDeInicio;
    }

    public void setHoraDeInicio(GregorianCalendar horaDeInicio)
    {
        this.horaDeInicio = horaDeInicio;
    }

    public GregorianCalendar getHoraDeFinalizacion()
    {
        return horaDeFinalizacion;
    }

    public void setHoraDeFinalizacion(GregorianCalendar horaDeFinalizacion)
    {
        this.horaDeFinalizacion = horaDeFinalizacion;
    }

    public List<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados)
    {
        this.empleados = empleados;
    }    
}