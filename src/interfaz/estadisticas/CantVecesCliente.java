package interfaz.estadisticas;

public class CantVecesCliente implements Comparable<CantVecesCliente>
{
    /* Atributos */
    private int idCliente;
    private int cantVecesAsistio;
    
    
    /* Constructor */
    public CantVecesCliente()
    {
        
    }
    
    
    /* Métodos */
    public int compareTo(CantVecesCliente otro)
    {
        if(cantVecesAsistio > otro.cantVecesAsistio)
        {
            return -1;
        }
        
        if(cantVecesAsistio < otro.cantVecesAsistio)
        {
            return 1;
        }
        
        return 0;
    }
    
    
    /* Métodos 'set' y 'get' */
    public int getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    public int getCantVecesAsistio()
    {
        return cantVecesAsistio;
    }

    public void setCantVecesAsistio(int cantVecesAsistio)
    {
        this.cantVecesAsistio = cantVecesAsistio;
    }    
}
