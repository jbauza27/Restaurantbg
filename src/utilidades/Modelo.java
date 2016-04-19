package utilidades;

import javax.swing.table.DefaultTableModel;


/**
 * Hereda de defaultTableModel pero sobreescribiendo el metodo isCellEditable,
 * indicando que no sean editables las celdas que se muestran por la pantalla.
 */
public class Modelo extends DefaultTableModel
{
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}