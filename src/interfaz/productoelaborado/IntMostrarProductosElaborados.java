package interfaz.productoelaborado;

import entidad.MateriaPrima;
import entidad.ProductoElaborado;
import gestor.GestorMateriasPrimas;
import gestor.GestorProductosElaborados;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar productos elaborados y dar algunas posibilidades como 
 * dar de alta, dar de baja y modificar.
 */
public class IntMostrarProductosElaborados extends javax.swing.JDialog
{
    /* Atributos */
    private GestorMateriasPrimas gesMatPrim;
    private GestorProductosElaborados gesProdElab;
    private Modelo modeloProductosElaborados;
    private Session sesion; 
    private int idProductoElaborado;    
    
    
    /* Constructor */
    public IntMostrarProductosElaborados(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesMatPrim = new GestorMateriasPrimas(sesion);
        gesProdElab = new GestorProductosElaborados(sesion);
                
        actualizarTablaProductosElaborados();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeProductosElaborados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductosElaborados = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbDarDeBaja = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de productos elaborados");

        jlListadoDeProductosElaborados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeProductosElaborados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeProductosElaborados.setText("Listado de productos elaborados");

        jtProductosElaborados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtProductosElaborados);

        jbDarDeAlta.setText("Dar de alta");
        jbDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeAltaActionPerformed(evt);
            }
        });

        jbDarDeBaja.setText("Dar de baja");
        jbDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeBajaActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlListadoDeProductosElaborados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jbDarDeAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDarDeBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeProductosElaborados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbDarDeBaja)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana y vuelve al menú anterior.
     * 
     * @param evt el evento de clic sobre el botón 'Volver'
     */
    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    /**
     * Actualiza la tabla de productos elaborados.
     * 
     * @param evt el evento de clic sobre el botón 'Actualizar'
     */
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        actualizarTablaProductosElaborados();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Abre un formulario para dar de alta un producto elaborado.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE MATERIAS PRIMAS
        
           Para poder dar de alta productos elaborados, es necesario averiguar con
           anterioridad si hay o no materias primas en la base de datos. Si las hay,
           entonces se permite el alta de productos elaborados, caso contrario, no.
        */
        
        // primero, consulto si hay materias primas
        ArrayList<MateriaPrima> listaMatPrim =
                gesMatPrim.getListaMateriasPrimas();
        
        // si no las hay, muestro un mensaje de error
        if(listaMatPrim.isEmpty() == true)
        {    
            JOptionPane.showMessageDialog(null, "No puede dar de alta productos "
                    + "elaborados hasta que no haya materias primas ingresadas en la "
                    + "base de datos",
                    "Alta de productos elaborados",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen materias primas, permito el ingreso a la interfaz de alta de
        // productos elaborados
        else
        {
            IntAltaProductoElaborado intAltProdElab
                    = new IntAltaProductoElaborado(null, true, sesion);
            intAltProdElab.setVisible(true);
        } 
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Permite dar de baja al producto elaborado seleccionado, cambiando su
     * atributo 'activo' a 'false'.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de baja'
     */
    private void jbDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeBajaActionPerformed
        obtenerIdProductoElaboradoSeleccionado();        
        
        // si no se seleccionó ningún producto elaborado
        if(idProductoElaborado == -1)
        {
             JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un producto elaborado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int opcionSeleccionada = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro que desea dar de baja a este producto elaborado?",
                    "Baja de productos elaborados",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if(opcionSeleccionada == JOptionPane.YES_OPTION)
            {
                // obtengo el producto elaborado
                ProductoElaborado prodElab = gesProdElab.buscarPorId(idProductoElaborado);        
                
                // doy de baja al producto elaborado
                prodElab.setActivo(false);
                gesProdElab.guardarOActualizar(prodElab);
            }
            else
            {
                // nada                
            }
            
            actualizarTablaProductosElaborados();
        }
    }//GEN-LAST:event_jbDarDeBajaActionPerformed

    /**
     * Abre una ventana para modificar el producto elaborado seleccionado.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdProductoElaboradoSeleccionado();
        
        // si no se seleccionó ningún producto elaborado
        if(idProductoElaborado == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un producto elaborado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarProductoElaborado intModProdElab = new IntModificarProductoElaborado(
                    null, true, sesion, idProductoElaborado);
            intModProdElab.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Actualiza la tabla de productos elaborados.
     */
    public void actualizarTablaProductosElaborados()
    {
        ArrayList<ProductoElaborado> listaProductosElaborados
                = gesProdElab.getListaProductosElaborados();
        modeloProductosElaborados = 
                gesProdElab.configurarModelo(modeloProductosElaborados, listaProductosElaborados);
        jtProductosElaborados.setModel(modeloProductosElaborados);
        jtProductosElaborados.getColumnModel().removeColumn(
                jtProductosElaborados.getColumnModel().getColumn(0));
        
        jtProductosElaborados.getColumn("Materias primas").setPreferredWidth(250);
    }
    
    /**
     * Cuando se selecciona un producto elaborado en la tabla, cambia el valor de la
     * variable 'idProductoElaborado' por el valor del 'id' del producto elaborado
     * seleccionado.
     */    
    public void obtenerIdProductoElaboradoSeleccionado()
    {
        idProductoElaborado = -1;
        int fila = jtProductosElaborados.getSelectedRow();
        
        if(fila != -1)
        {
            idProductoElaborado = Integer.parseInt(
                    String.valueOf(modeloProductosElaborados.getValueAt(fila, 0)));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbDarDeBaja;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlListadoDeProductosElaborados;
    private javax.swing.JTable jtProductosElaborados;
    // End of variables declaration//GEN-END:variables
}
