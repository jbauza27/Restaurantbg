package interfaz.cliente;

import entidad.Cliente;
import gestor.GestorClientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar clientes y dar algunas posibilidades como 
 * buscar, dar de alta, dar de baja y modificar.
 */
public class IntMostrarClientes extends javax.swing.JDialog
{
    /* Atributos */
    private GestorClientes gesCli;
    private ArrayList<Cliente> listaClientes;
    private Modelo modeloClientes;
    private Session sesion; 
    private int idCliente;    
    
    
    /* Constructor */
    public IntMostrarClientes(java.awt.Frame parent, boolean modal,
                    Session sesion, ArrayList<Cliente> muchosClientes)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesCli = new GestorClientes(sesion);
        listaClientes = muchosClientes;
        
        actualizarTablaClientes();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeClientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de clientes");

        jlListadoDeClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeClientes.setText("Listado de clientes");

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtClientes);

        jbDarDeAlta.setText("Dar de alta");
        jbDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeAltaActionPerformed(evt);
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
            .addComponent(jlListadoDeClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jbBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbDarDeAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeClientes)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver)
                    .addComponent(jbBuscar))
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
     * Actualiza la tabla de clientes.
     * 
     * @param evt el evento de clic sobre el botón 'Actualizar'
     */
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        listaClientes = gesCli.getListaClientes();
        actualizarTablaClientes();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Abre un formulario para dar de alta a un cliente.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        IntAltaCliente intAltCli = new IntAltaCliente(null, true, sesion);
        intAltCli.setVisible(true);
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Abre una ventana para modificar al cliente seleccionado.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdClienteSeleccionado();
        
        // si no se seleccionó ningún cliente
        if(idCliente == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarCliente intModCli = new IntModificarCliente(
                    null, true, sesion, idCliente);
            intModCli.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Abre un formulario para buscar clientes que coincidan con determinados
     * criterios.
     * 
     * @param evt el evento de clic sobre el botón 'Buscar'
     */
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        this.dispose();
        IntBusquedaClientes intBusCli = new IntBusquedaClientes(null, true, sesion);
        intBusCli.setVisible(true);
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * Actualiza la tabla de clientes.
     */
    public void actualizarTablaClientes()
    {
        modeloClientes = gesCli.configurarModelo(modeloClientes, listaClientes);
        jtClientes.setModel(modeloClientes);
        jtClientes.getColumnModel().removeColumn(
                jtClientes.getColumnModel().getColumn(0));
        
        jtClientes.getColumn("Fecha de nacimiento").setPreferredWidth(75);
        jtClientes.getColumn("Teléfono fijo").setPreferredWidth(125);
        jtClientes.getColumn("Teléfono celular").setPreferredWidth(125);
        jtClientes.getColumn("Email").setPreferredWidth(125);
        jtClientes.getColumn("Domicilio").setPreferredWidth(250);
    }
    
    /**
     * Cuando se selecciona un cliente en la tabla, cambia el valor de la
     * variable 'idCliente' por el valor del 'id' del cliente seleccionado.
     */    
    public void obtenerIdClienteSeleccionado()
    {
        idCliente = -1;
        int fila = jtClientes.getSelectedRow();
        
        if(fila != -1)
        {
            idCliente = Integer.parseInt(
                    String.valueOf(modeloClientes.getValueAt(fila, 0)));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlListadoDeClientes;
    private javax.swing.JTable jtClientes;
    // End of variables declaration//GEN-END:variables
}
