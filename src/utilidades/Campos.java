package utilidades;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;


/**
 * Proporciona métodos que ayudan a que el usuario no ingrese datos
 * inválidos. 
 */
public class Campos
{
    /** 
     * Está diseñado con el objetivo de que sólo se puedan añadir una
     * serie de caracteres a un campo de texto y en una cierta cantidad:
     * <br>- si se le envía como formato "Cadena" sólo podrán colocarse letras, espacios
     * y el guión,
     * <br>- si se le envía como formato "NúmerosConPunto" sólo podrán colocarse números
     * y puntos,
     * <br>- si se le envía como formato "Números" sólo podrán colocarse números,
     * <br>- si se le envía como formato "Todo" se permitirá cualquier caracter. Esto
     * es útil cuando simplemente se quiere fijar un límite a la cantidad de caracteres.
     * 
     * El programa no nos dejará colocar otros caracteres diferentes a los especificados
     * en formato.
     * 
     * @param evt parámetro de evento relacionado con pulsación de teclas
     * @param limite cantidad máxima de caracteres que pueden ingresarse
     * @param formato que tipo de caracteres se pueden ingresar
     */     
    public static void configurarCampo(KeyEvent evt, int limite, String formato)
    {
        if(formato != null)
        {
            char caracter = evt.getKeyChar();

            if (formato.equalsIgnoreCase("Cadena")) // sólo se admiten letras, espacios y el guión
            {
                if ( !(Character.isLetter(caracter) || caracter == ' ' || caracter == '-') )
                {
                    evt.consume();
                }
            } 
            else if (formato.equalsIgnoreCase("NúmerosConPunto")) // sólo se admiten números y el punto
            { 
                if ( ( (caracter < '0') || (caracter > '9') ) && (caracter != '.') )
                {
                    evt.consume();
                }
            } 
            else if (formato.equalsIgnoreCase("Números"))  // sólo se admiten números
            {
                if ( (caracter < '0') || (caracter > '9') )
                {
                    evt.consume();
                }
            }
            else if (formato.equalsIgnoreCase("Todo")) 
            {
                // se permiten caracteres y números, nada se consume. Esto es útil
                // cuando sólamente se quiere fijar un límite a la cantidad de caracteres.
            }
        }       
        
        JTextField campo = (JTextField) evt.getSource();
        
        if (campo.getText().length() >= limite)
        {
            evt.consume();
        }
    }
}