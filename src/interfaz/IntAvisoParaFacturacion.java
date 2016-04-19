package interfaz;

import interfaz.cliente.IntAltaCliente;
import interfaz.empleado.IntAltaEmpleado;
import org.hibernate.classic.Session;


/**
 * Ventana que avisa sobre la necesidad de tener clientes y mozos en la base de
 * datos para poder facturar.
 */
public class IntAvisoParaFacturacion extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    
    
    /* Constructor */
    public IntAvisoParaFacturacion(java.awt.Frame parent, boolean modal,
            Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlError = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbAnadirCliente = new javax.swing.JButton();
        jbAnadirMozo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Error para facturar");

        jlError.setText("No puede facturar si no tiene ingresados clientes y mozos en la base de datos.");

        jlTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Error");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbAnadirCliente.setText("Añadir cliente");
        jbAnadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirClienteActionPerformed(evt);
            }
        });

        jbAnadirMozo.setText("Añadir mozo");
        jbAnadirMozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirMozoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlError, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jbAnadirCliente)
                .addGap(18, 18, 18)
                .addComponent(jbAnadirMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(13, 13, 13)
                .addComponent(jlError)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbAnadirCliente)
                    .addComponent(jbAnadirMozo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana sin guardar ningún cambio.
     * 
     * @param evt el evento de pulsación del botón 'Cancelar'
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Abre el formulario que permite dar de alta un cliente.
     * 
     * @param evt el evento de pulsación del botón 'Añadir cliente'
     */
    private void jbAnadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirClienteActionPerformed
        IntAltaCliente intAltCli = new IntAltaCliente(null, true, sesion);
        intAltCli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbAnadirClienteActionPerformed

    /**
     * Abre el formulario que permite dar de alta un empleado.
     * 
     * @param evt el evento de pulsación del botón 'Añadir empleado'
     */    
    private void jbAnadirMozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirMozoActionPerformed
        IntAltaEmpleado intAltEmp = new IntAltaEmpleado(null, true, sesion);
        intAltEmp.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_jbAnadirMozoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAnadirCliente;
    private javax.swing.JButton jbAnadirMozo;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlError;
    private javax.swing.JLabel jlTitulo;
    // End of variables declaration//GEN-END:variables
}
