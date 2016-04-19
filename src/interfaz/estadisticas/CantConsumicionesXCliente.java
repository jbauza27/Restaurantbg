package interfaz.estadisticas;

public class CantConsumicionesXCliente implements Comparable<CantConsumicionesXCliente>
{
    /* Atributos */
    private int idCliente;
    private int cantConsumiciones;
    
    
    /* Constructor */
    public CantConsumicionesXCliente()
    {
        
    }
    
    
    /* Métodos */
    public int compareTo(CantConsumicionesXCliente otro)
    {
        if(cantConsumiciones > otro.cantConsumiciones)
        {
            return -1;
        }
        
        if(cantConsumiciones < otro.cantConsumiciones)
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

    public int getCantConsumiciones()
    {
        return cantConsumiciones;
    }

    public void setCantConsumiciones(int cantConsumiciones)
    {
        this.cantConsumiciones = cantConsumiciones;
    }    
}
