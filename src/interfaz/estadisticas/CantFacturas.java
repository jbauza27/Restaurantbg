package interfaz.estadisticas;

public class CantFacturas
{
    /* Atributos */
    private String anioyMes;
    private int cantFacturas;
    
    
    /* Constructor */
    public CantFacturas()
    {
        
    }


    /* Métodos 'set' y 'get' */
    public String getAnioyMes()
    {
        return anioyMes;
    }

    
    public void setAnioyMes(String anioyMes)
    {
        this.anioyMes = anioyMes;
    }

    public int getCantFacturas()
    {
        return cantFacturas;
    }

    public void setCantFacturas(int cantFacturas)
    {
        this.cantFacturas = cantFacturas;
    }    
}
