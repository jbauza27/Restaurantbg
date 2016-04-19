package interfaz.proveedor;

import entidad.Proveedor;
import gestor.GestorProveedores;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar proveedores y dar algunas posibilidades como 
 * buscar, dar de alta, dar de baja y modificar.
 */
public class IntMostrarProveedores extends javax.swing.JDialog
{
    /* Atributos */
    private GestorProveedores gesProv;
    private ArrayList<Proveedor> listaProveedores;
    private Modelo modeloProveedores;
    private Session sesion; 
    private int idProveedor;        
    
    
    /* Constructor */
    public IntMostrarProveedores(java.awt.Frame parent, boolean modal,
            Session sesion, ArrayList<Proveedor> muchosProveedores)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesProv = new GestorProveedores(sesion);
        listaProveedores = muchosProveedores;
        
        actualizarTablaProveedores();    
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeProveedores = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProveedores = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbDarDeBaja = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de proveedores");

        jlListadoDeProveedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeProveedores.setText("Listado de proveedores");

        jtProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProveedores);

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

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlListadoDeProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 118, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jbBuscar)
                .addGap(18, 18, 18)
                .addComponent(jbDarDeAlta)
                .addGap(18, 18, 18)
                .addComponent(jbDarDeBaja)
                .addGap(18, 18, 18)
                .addComponent(jbModificar)
                .addGap(18, 18, 18)
                .addComponent(jbActualizar)
                .addGap(18, 18, 18)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeProveedores)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbDarDeBaja)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver)
                    .addComponent(jbBuscar))
                .addContainerGap(21, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre un formulario para dar de alta a un proveedor.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */    
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        IntAltaProveedor intAltProv = new IntAltaProveedor(null, true, sesion);
        intAltProv.setVisible(true);
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Permite dar de baja al proveedor seleccionado, cambiando su atributo 'activo'
     * a 'false'.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de baja'
     */    
    private void jbDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeBajaActionPerformed
        obtenerIdProveedorSeleccionado();        
        
        // si no se seleccionó ningún proveedor
        if(idProveedor == -1)
        {
             JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un proveedor",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int opcionSeleccionada = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro que desea dar de baja a este proveedor?",
                    "Baja de proveedores",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if(opcionSeleccionada == JOptionPane.YES_OPTION)
            {
                // obtengo el proveedor
                Proveedor prov = gesProv.buscarPorId(idProveedor);        
                
                // doy de baja al proveedor
                prov.setActivo(false);
                gesProv.guardarOActualizar(prov);
            }
            else
            {
                // nada                
            }
            
            actualizarTablaProveedores();
        }
    }//GEN-LAST:event_jbDarDeBajaActionPerformed

    /**
     * Abre una ventana para modificar al proveedor seleccionado.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */    
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdProveedorSeleccionado();
        
        // si no se seleccionó ningún proveedor
        if(idProveedor == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un proveedor",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarProveedor intModProv = new IntModificarProveedor(
                    null, true, sesion, idProveedor);
            intModProv.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Actualiza la tabla de proveedores.
     * 
     * @param evt el evento de pulsación sobre el botón 'Actualizar'
     */
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        listaProveedores = gesProv.getListaProveedoresActivos();
        actualizarTablaProveedores();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Cierra la ventana.
     * 
     * @param evt el evento de pulsación sobre el botón 'Volver'
     */
    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    /**
     * Abre un formulario para buscar proveedores según determinados criterios.
     * 
     * @param evt el evento de clic sobre el botón 'Buscar'
     */    
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        this.dispose();
        IntBusquedaProveedores intBusProv = new IntBusquedaProveedores(null, true, sesion);
        intBusProv.setVisible(true);        
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * Actualiza la tabla de proveedores.
     */    
    public void actualizarTablaProveedores()
    {
        modeloProveedores = gesProv.configurarModelo(modeloProveedores, listaProveedores);
        jtProveedores.setModel(modeloProveedores);
        jtProveedores.getColumnModel().removeColumn(
                jtProveedores.getColumnModel().getColumn(0));
        
        jtProveedores.getColumn("Teléfonos").setPreferredWidth(125);
        jtProveedores.getColumn("Domicilio").setPreferredWidth(250);
    }

    /**
     * Cuando se selecciona un proveedor en la tabla, cambia el valor de la
     * variable 'idProveedor' por el valor del 'id' del proveedor seleccionado.
     */     
    public void obtenerIdProveedorSeleccionado()
    {
        idProveedor = -1;
        int fila = jtProveedores.getSelectedRow();
        
        if(fila != -1)
        {
            idProveedor = Integer.parseInt(
                    String.valueOf(modeloProveedores.getValueAt(fila, 0)));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbDarDeBaja;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlListadoDeProveedores;
    private javax.swing.JTable jtProveedores;
    // End of variables declaration//GEN-END:variables
}
