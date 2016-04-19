package interfaz.reservas;

import entidad.*;
import gestor.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar reservas y dar algunas posibilidades como 
 * dar de alta, dar de baja y modificar.
 */
public class IntMostrarReservas extends javax.swing.JDialog
{
    /* Atributos */
    private GestorReservas gesRes;
    private ArrayList<Reserva> listaReservas;
    private Modelo modeloReservas;
    private Session sesion; 
    private int idReserva;    
    
    
    /* Constructor */
    public IntMostrarReservas(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesRes = new GestorReservas(sesion);
                
        listaReservas = gesRes.getListaReservasActivas();
        actualizarTablaReservas();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeReservas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReservas = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jlVerReservas = new javax.swing.JLabel();
        jcbVerReservas = new javax.swing.JComboBox();
        jbDarDeBaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de reservas");

        jlListadoDeReservas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeReservas.setText("Listado de reservas");

        jtReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtReservas);

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

        jlVerReservas.setText("Ver reservas:");

        jcbVerReservas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activas", "Dadas de baja", "Todas" }));
        jcbVerReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVerReservasActionPerformed(evt);
            }
        });

        jbDarDeBaja.setText("Dar de baja");
        jbDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlListadoDeReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jbDarDeAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbDarDeBaja)
                        .addGap(3, 3, 3)
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlVerReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbVerReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(372, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeReservas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVerReservas)
                    .addComponent(jcbVerReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver)
                    .addComponent(jbDarDeBaja))
                .addGap(444, 444, 444))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
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
     * Llama al método 'buscarReservas' para que actualice la tabla de reservas.
     * 
     * @param evt el evento de clic sobre el botón 'Actualizar'
     */
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        buscarReservas();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Abre un formulario para dar de alta una reserva.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        IntAltaReserva intAltRes = new IntAltaReserva(null, true, sesion);
        intAltRes.setVisible(true);
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Abre una ventana para modificar a la reserva seleccionada.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdReservaSeleccionada();
        
        // si no se seleccionó ninguna reserva
        if(idReserva == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar una reserva",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarReserva intModRes = new IntModificarReserva(
                    null, true, sesion, idReserva);
            intModRes.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Llama al método 'buscarReservas' para que actualice la tabla de reservas.
     * 
     * @param evt el evento de cambio de cambio de opción del combobox
     */
    private void jcbVerReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVerReservasActionPerformed
        buscarReservas();
    }//GEN-LAST:event_jcbVerReservasActionPerformed

    /**
     * Permite dar de baja a la reserva seleccionada, cambiando su atributo 'activo'
     * a 'false'.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de baja'
     */         
    private void jbDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeBajaActionPerformed
        obtenerIdReservaSeleccionada();

        // si no se seleccionó ninguna reserva
        if(idReserva == -1)
        {
            JOptionPane.showMessageDialog(
                null,
                "Debe seleccionar una reserva",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int opcionSeleccionada = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea dar de baja a esta reserva?",
                "Baja de reservas",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if(opcionSeleccionada == JOptionPane.YES_OPTION)
            {
                // obtengo la reserva
                Reserva res = gesRes.buscarPorId(idReserva);

                // doy de baja la reserva
                res.setActivo(false);
                gesRes.guardarOActualizar(res);
            }
            else
            {
                // nada
            }

            buscarReservas();
        }
    }//GEN-LAST:event_jbDarDeBajaActionPerformed

    /**
     * Actualiza la tabla de reservas.
     */
    public void actualizarTablaReservas()
    {
        modeloReservas = gesRes.configurarModelo(modeloReservas, listaReservas);
        jtReservas.setModel(modeloReservas);
        jtReservas.getColumnModel().removeColumn(
                jtReservas.getColumnModel().getColumn(0));
        
        jtReservas.getColumn("Fecha").setPreferredWidth(75);
        jtReservas.getColumn("Hora").setPreferredWidth(75);
        jtReservas.getColumn("Mesa").setPreferredWidth(75);
        jtReservas.getColumn("Cliente").setPreferredWidth(250);
    }
    
    /**
     * Cuando se selecciona una reserva en la tabla, cambia el valor de la
     * variable 'idReserva' por el valor del 'id' de la reserva seleccionada.
     */    
    public void obtenerIdReservaSeleccionada()
    {
        idReserva = -1;
        int fila = jtReservas.getSelectedRow();
        
        if(fila != -1)
        {
            idReserva = Integer.parseInt(
                    String.valueOf(modeloReservas.getValueAt(fila, 0)));
        }
    }
    
    /**
     * Actualiza la tabla de reservas según el criterio escogido en el combobox
     * 'Ver reservas'
     */    
    public void buscarReservas()
    {
        if(jcbVerReservas.getSelectedItem().toString().equals("Activas"))
        {
            listaReservas = gesRes.getListaReservasActivas();
        }
        else if(jcbVerReservas.getSelectedItem().toString().equals("Dadas de baja"))
        {
            listaReservas = gesRes.getListaReservasDadasDeBaja();
        }
        else if(jcbVerReservas.getSelectedItem().toString().equals("Todas"))
        {
            listaReservas = gesRes.getListaReservas();
        }    
        
        actualizarTablaReservas();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbDarDeBaja;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox jcbVerReservas;
    private javax.swing.JLabel jlListadoDeReservas;
    private javax.swing.JLabel jlVerReservas;
    private javax.swing.JTable jtReservas;
    // End of variables declaration//GEN-END:variables
}
