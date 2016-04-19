package interfaz;

import interfaz.materiaprima.IntAltaMateriaPrima;
import org.hibernate.classic.Session;


/**
 * Ventana que avisa sobre la necesidad de tener materias primas en la base de
 * datos para poder guardar productos elaborados.
 */
public class IntAvisoParaProductosElaborados extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    
    
    /* Constructor */
    public IntAvisoParaProductosElaborados(java.awt.Frame parent, boolean modal,
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
        jbAnadirMateriaPrima = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Error para dar de alta productos elaborados");

        jlError.setText("No puede dar de alta productos elaborados hasta que no haya materias primas ingresadas en la base de datos");

        jlTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Error");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbAnadirMateriaPrima.setText("Añadir materia prima");
        jbAnadirMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirMateriaPrimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlError, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAnadirMateriaPrima)
                .addGap(18, 18, 18)
                .addComponent(jbCancelar)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(13, 13, 13)
                .addComponent(jlError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbAnadirMateriaPrima))
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
     * Abre el formulario que permite dar de alta una materia prima.
     * 
     * @param evt el evento de pulsación del botón 'Añadir materia prima'
     */    
    private void jbAnadirMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirMateriaPrimaActionPerformed
        IntAltaMateriaPrima intAltMatPrim =
                new IntAltaMateriaPrima(null, true, sesion);
        intAltMatPrim.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbAnadirMateriaPrimaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAnadirMateriaPrima;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlError;
    private javax.swing.JLabel jlTitulo;
    // End of variables declaration//GEN-END:variables
}
