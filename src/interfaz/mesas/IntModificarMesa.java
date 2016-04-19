package interfaz.mesas;

import entidad.*;
import gestor.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;


/**
 * Formulario para modificar una mesa.
 */
public class IntModificarMesa extends javax.swing.JDialog 
{
    /* Atributos */
    private Session sesion;
    private Mesa mes;
    private GestorMesas gesMes;
    private int id;
    private String nroMesaActual;
    
    
    /* Constructor */
    public IntModificarMesa(java.awt.Frame parent, boolean modal, Session sesion, 
            int idMesa)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;        
        gesMes = new GestorMesas(sesion);
        id = idMesa;
        
        mes = gesMes.buscarPorId(id);
        
        if(mes.isActivo() == true)
        {
            jcbActivo.setSelected(true);
        }
        else
        {
            jcbActivo.setSelected(false);
        }     
        
        jtfNroMesa.setText(mes.getNroMesa());
        jtfCantPersonas.setText(mes.getCantPersonas());
        jtaDescripcion.setText(mes.getDescripcion());
        
        nroMesaActual = mes.getNroMesa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlModificacionMesa = new javax.swing.JLabel();
        jlDatosMesa = new javax.swing.JLabel();
        jlNroDeMesa = new javax.swing.JLabel();
        jtfNroMesa = new javax.swing.JTextField();
        jlCantPersonas = new javax.swing.JLabel();
        jtfCantPersonas = new javax.swing.JTextField();
        jlNota = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jlDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jlActivo = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Modificación de mesa");

        jlModificacionMesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlModificacionMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlModificacionMesa.setText("Modificación de mesa");

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

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jlDescripcion.setText("Descripción:");

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtaDescripcion);

        jlActivo.setText("Activo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlModificacionMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(jlDatosMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCantPersonas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNroDeMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jbModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jbCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jcbActivo)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlModificacionMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlActivo)
                    .addComponent(jcbActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jbCancelar)
                    .addComponent(jbModificar))
                .addGap(18, 18, 18)
                .addComponent(jlNota)
                .addGap(51, 51, 51))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Guarda la mesa o notifica al usuario que hay algún error.
     * 
     * @param evt el evento de pulsación sobre el botón 'Dar de alta'
     */    
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        /* VALIDACIONES */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;

        /* Comprobación de registros duplicados */
        // cerciorándome de que no haya en la base de datos otra mesa con
        // el mismo número
        ArrayList<Mesa> repetidos = new ArrayList<>();
        // si el usuario no cambió el número de mesa, entonces no se
        // realiza la comprobación por registros duplicados
        if(jtfNroMesa.getText().equals(nroMesaActual))
        {
                
        }
        // cerciorándome de que no haya en la base de datos otra mesa con ese
        // número
        else
        {           
            String hql = "FROM Mesa M WHERE M.nroMesa = '"
                + jtfNroMesa.getText() + "'";
            Query query = sesion.createQuery(hql);
            repetidos = (ArrayList<Mesa>) query.list();
            
            // si se encontró algún registro con el mismo número de mesa que el que
            // quiero crear, creo un mensaje de error
            if(repetidos.isEmpty() == false)
            {
                mensajeDeError = mensajeDeError + "- No realizar esta modificación "
                        + "porque el número de mesa asignado ya pertenece a otra "
                        + "mesa.\n";
                error = true;            
            }                
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
        /* MODIFICACIÓN */
        else
        {
            // obteniendo la mesa
            gesMes = new GestorMesas(sesion);
            mes = gesMes.buscarPorId(id);

            // armando la mesa
            if(jcbActivo.isSelected() == true)
            {
                mes.setActivo(true);
            }
            else
            {
                mes.setActivo(false);
            }      
            
            mes.setNroMesa(jtfNroMesa.getText());
            mes.setCantPersonas(jtfCantPersonas.getText()); 
            mes.setDescripcion(jtaDescripcion.getText());
            
            // guardando mesa en la base de datos
            gesMes.guardarOActualizar(mes);
            
            this.dispose();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Cierra la ventana sin efectuar ninguna operación.
     * 
     * @param evt el evento de clic sobre el botón 'Cancelar'
     */    
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

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
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JLabel jlActivo;
    private javax.swing.JLabel jlCantPersonas;
    private javax.swing.JLabel jlDatosMesa;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlModificacionMesa;
    private javax.swing.JLabel jlNota;
    private javax.swing.JLabel jlNroDeMesa;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfCantPersonas;
    private javax.swing.JTextField jtfNroMesa;
    // End of variables declaration//GEN-END:variables
}
