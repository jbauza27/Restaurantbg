package utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Esta clase contiene diversos métodos relacionados con fechas con propósitos
 * variados. 
 */
public class Fecha
{
    /**
     * Comprueba si el año ingresado es bisiesto.
     * 
     * @param anio el año que se comprobará si es bisiesto
     */
    private boolean siEsAnioBisiesto(int anio)
    {
        // Un año es bisiesto si es divisible entre 4, excepto si es divisible
        // entre 100 pero no entre 400.
        boolean bisiesto = false;
        boolean divisiblePorCuatro;
        boolean divisiblePorCien;
        boolean divisiblePorCuatrocientos;
        
        if(anio % 4 == 0)
        {
            divisiblePorCuatro = true;
        }
        else
        {
            divisiblePorCuatro = false;
        }
        
        if(anio % 100 == 0)
        {
            divisiblePorCien = true;
        }
        else
        {
            divisiblePorCien = false;
        }
        
        if(anio % 400 == 0)
        {
            divisiblePorCuatrocientos = true;
        }
        else
        {
            divisiblePorCuatrocientos = false;
        }
        
        if(divisiblePorCuatro == true)
        {
            if(divisiblePorCien == true && divisiblePorCuatrocientos == false)
            {
                bisiesto = false;                
            }
            else
            {
                bisiesto = true;                
            }
        }  
        
        return bisiesto;
    }
    
    /**
     * Valida si una fecha puede existir o no en el calendario gregoriano.
     * 
     * @param anio el año de la fecha
     * @param mes el mes de la fecha
     * @param dia el día de la fecha
     * @return 'true' si la fecha puede existir, 'false' en caso contrario
     */
    public boolean validarFecha(int anio, int mes, int dia)
    {
        boolean fechaValida = true;
    
        if(mes == 1)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 2)
        {
            boolean bisiesto = siEsAnioBisiesto(anio);
            
            if(bisiesto == false)
            {
                if(dia < 1 || dia > 28)
                {
                    fechaValida = false;
                }
            }
            else
            {
                if(dia < 1 || dia > 29)
                {
                    fechaValida = false;
                }
            }
        }
    
        if(mes == 3)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 4)
        {
            if(dia < 1 || dia > 30)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 5)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 6)
        {
            if(dia < 1 || dia > 30)
            {
                fechaValida = false;
            }        
        }
    
        if(mes == 7)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 8)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 9)
        {
            if(dia < 1 || dia > 30)
            {   
                fechaValida = false;
            }
        }
    
        if(mes == 10)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 11)
        {
            if(dia < 1 || dia > 30)
            {
                fechaValida = false;
            }
        }
    
        if(mes == 12)
        {
            if(dia < 1 || dia > 31)
            {
                fechaValida = false;
            }
        }
        
        if(mes < 1 || mes > 12)
        {
            fechaValida = false;
        }
    
        return fechaValida;
    }
    
    /**
     * Compara dos fechas y comunica cual es la mayor o si son iguales.
     * 
     * @param primeraFecha la primera fecha a comparar
     * @param segundaFecha la segunda fecha a comparar
     * @return '1' si la primera fecha es la mayor, <br>'2' si la segunda fecha es la
     * mayor, <br>'0' si ambas fechas son iguales
     */
    public int comparacionDeFechas(GregorianCalendar primeraFecha,
            GregorianCalendar segundaFecha)    
    {
        int resultado = 0;
        
        // primeraFecha
        int anio1 = primeraFecha.get(Calendar.YEAR);
        int mes1  = primeraFecha.get(Calendar.MONTH);
        int dia1  = primeraFecha.get(Calendar.DAY_OF_MONTH);
        
        // segundaFecha
        int anio2 = segundaFecha.get(Calendar.YEAR);
        int mes2  = segundaFecha.get(Calendar.MONTH);
        int dia2  = segundaFecha.get(Calendar.DAY_OF_MONTH);
        
        if(anio1 < anio2)
        {
            resultado = 2;
            return resultado;
        }
        else if(anio1 > anio2)
        {
            resultado = 1;
            return resultado;
        }
        else if(anio1 == anio2)
        {
            if(mes1 < mes2)
            {
                resultado = 2;
                return resultado;
            }
            else if(mes1 > mes2)
            {
                resultado = 1;
                return resultado;
            }
            else if(mes1 == mes2)
            {
                if(dia1 < dia2)
                {
                    resultado = 2;
                    return resultado;
                }
                else if(dia1 > dia2)
                {
                    resultado = 1;
                    return resultado;
                }
                else if(dia1 == dia2)
                {
                    resultado = 0;
                    return resultado;
                }
            }
        }
        
        return resultado;
    }
    
    /**
     * Recibe el número de un mes y devuelve ese mismo mes en texto.
     * 
     * @param nroMes un mes en número
     * @return el mes que se envió en texto
     */
    public String darNombreMes(int nroMes)
    {
        String nombreMes = "";
        
        if(nroMes == 1)
        {
            nombreMes = "Enero";
        }
        else if(nroMes == 2)
        {
            nombreMes = "Febrero";
        }
        else if(nroMes == 3)
        {
            nombreMes = "Marzo";
        }
        else if(nroMes == 4)
        {
            nombreMes = "Abril";
        }
        else if(nroMes == 5)
        {
            nombreMes = "Mayo";
        }
        else if(nroMes == 6)
        {
            nombreMes = "Junio";
        }
        else if(nroMes == 7)
        {
            nombreMes = "Julio";
        }
        else if(nroMes == 8)
        {
            nombreMes = "Agosto";
        }
        else if(nroMes == 9)
        {
            nombreMes = "Setiembre";
        }
        else if(nroMes == 10)
        {
            nombreMes = "Octubre";
        }
        else if(nroMes == 11)
        {
            nombreMes = "Noviembre";
        }
        else if(nroMes == 12)
        {
            nombreMes = "Diciembre";
        }
        
        return nombreMes;
    }    
}
