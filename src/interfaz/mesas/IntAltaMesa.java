package interfaz.mesas;

import entidad.*;
import gestor.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;


/**
 * Formulario para dar de alta una mesa.
 */
public class IntAltaMesa extends javax.swing.JDialog 
{
    /* Atributos */
    private Session sesion;
    private Mesa mes;
    private GestorMesas gesMes;
    
    
    /* Constructor */
    public IntAltaMesa(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        jlMensaje.setVisible(false);
        gesMes = new GestorMesas(sesion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlAltaMesa = new javax.swing.JLabel();
        jlDatosMesa = new javax.swing.JLabel();
        jlNroDeMesa = new javax.swing.JLabel();
        jtfNroMesa = new javax.swing.JTextField();
        jlCantPersonas = new javax.swing.JLabel();
        jtfCantPersonas = new javax.swing.JTextField();
        jlNota = new javax.swing.JLabel();
        jbDarDeAlta = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlMensaje = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Alta de mesa");

        jlAltaMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlAltaMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAltaMesa.setText("Alta de mesa");

        jlDatosMesa.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDatosMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatosMesa.setText("Datos de la mesa");

        jlNroDeMesa.setText("*Número de mesa:");

        jlCantPersonas.setText("*Cantidad de personas:");

        jtfCantPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantPersonasKeyTyped(evt);
            }
        });

        jlNota.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jlNota.setText("Nota: los campos marcados con asterisco son obligatorios");

        jbDarDeAlta.setText("Dar de alta");
        jbDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeAltaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMensaje.setText("Mensaje");

        jlDescripcion.setText("Descripción:");

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtaDescripcion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlAltaMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDatosMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCantPersonas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jlNroDeMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jbDarDeAlta)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlAltaMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlDatosMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNroDeMesa)
                    .addComponent(jtfNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCantPersonas)
                    .addComponent(jtfCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescripcion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbDarDeAlta))
                .addGap(18, 18, 18)
                .addComponent(jlNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlMensaje)
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Guarda la mesa o notifica al usuario que hay algún error.
     * 
     * @param evt el evento de pulsación sobre el botón 'Dar de alta'
     */    
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        /* VALIDACIONES */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;

        // cerciorándome de que no haya en la base de datos otra mesa con
        // el mismo número
        ArrayList<Mesa> repetidos = new ArrayList<>();
        String hql = "FROM Mesa M WHERE M.nroMesa = '"
            + jtfNroMesa.getText() + "'";
        Query query = sesion.createQuery(hql);
        repetidos = (ArrayList<Mesa>) query.list();

        // si se encontró algún registro con el mismo número de mesa que el que
        // quiero crear, creo un mensaje de error
        if(repetidos.isEmpty() == false)
        {
            mensajeDeError = mensajeDeError + "- No puede dar de alta esta mesa "
                    + "porque ya existe en la base de datos.\n";
            error = true;            
        }        
            
        /* Me cercioro que los campos obligatorios no están vacíos */
        if(jtfNroMesa.getText().equals("")
                || jtfCantPersonas.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar los campos marcados"
            + " con asterisco.\n";
            error = true;
        }
        

        /* Si existen errores, envío una notificación al usuario, caso contrario,
        * guardo los datos en la base de datos. */
        if(error == true)
        {
            JOptionPane.showMessageDialog(null,
                mensajeDeError,
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        /* ALTA */
        else
        {
            // armando objeto 'Mesa'
            mes = new Mesa();

            mes.setActivo(true);
            mes.setNroMesa(jtfNroMesa.getText());
            mes.setCantPersonas(jtfCantPersonas.getText()); 
            mes.setDescripcion(jtaDescripcion.getText());
            
            // guardando mesa en la base de datos
            gesMes.guardarOActualizar(mes);
            
            // impresión de mensaje confirmando éxito
            jlMensaje.setVisible(true);
            jlMensaje.setText("Mesa " + mes.getNroMesa() + " dada de alta en la "
                    + "base de datos.");              
        }
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Cierra la ventana sin efectuar ninguna operación.
     * 
     * @param evt el evento de clic sobre el botón 'Cancelar'
     */    
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfCantPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantPersonasKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfCantPersonasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlAltaMesa;
    private javax.swing.JLabel jlCantPersonas;
    private javax.swing.JLabel jlDatosMesa;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlNota;
    private javax.swing.JLabel jlNroDeMesa;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfCantPersonas;
    private javax.swing.JTextField jtfNroMesa;
    // End of variables declaration//GEN-END:variables
}
