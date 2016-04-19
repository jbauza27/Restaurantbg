package interfaz.mesas;

import entidad.*;
import gestor.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar mesas y dar algunas posibilidades como 
 * dar de alta, dar de baja y modificar.
 */
public class IntMostrarMesas extends javax.swing.JDialog
{
    /* Atributos */
    private GestorMesas gesMes;
    private ArrayList<Mesa> listaMesas;
    private Modelo modeloMesas;
    private Session sesion; 
    private int idMesa;    
    
    
    /* Constructor */
    public IntMostrarMesas(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesMes = new GestorMesas(sesion);
                
        listaMesas = gesMes.getListaMesasActivas();
        actualizarTablaMesas();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeMesas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMesas = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jlVerMesas = new javax.swing.JLabel();
        jcbVerMesas = new javax.swing.JComboBox();
        jbDarDeBaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de mesas");

        jlListadoDeMesas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeMesas.setText("Listado de mesas");

        jtMesas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMesas);

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

        jlVerMesas.setText("Ver mesas:");

        jcbVerMesas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activas", "Dadas de baja", "Todas" }));
        jcbVerMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVerMesasActionPerformed(evt);
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
            .addComponent(jlListadoDeMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jbDarDeAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDarDeBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlVerMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbVerMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeMesas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlVerMesas)
                    .addComponent(jcbVerMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver)
                    .addComponent(jbDarDeBaja))
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
                .addGap(0, 0, Short.MAX_VALUE))
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
     * Llama al método 'buscarMesas' para que actualice la tabla de mesas.
     * 
     * @param evt el evento de clic sobre el botón 'Actualizar'
     */
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        buscarMesas();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Abre un formulario para dar de alta a una mesa.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        IntAltaMesa intAltMes = new IntAltaMesa(null, true, sesion);
        intAltMes.setVisible(true);
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Abre una ventana para modificar a la mesa seleccionada.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdMesaSeleccionada();
        
        // si no se seleccionó ninguna mesa
        if(idMesa == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar una mesa",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarMesa intModMes = new IntModificarMesa(
                    null, true, sesion, idMesa);
            intModMes.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Llama al método 'buscarMesas' para que actualice la tabla de mesas.
     * 
     * @param evt el evento de cambio de cambio de opción del combobox
     */
    private void jcbVerMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVerMesasActionPerformed
        buscarMesas();    
    }//GEN-LAST:event_jcbVerMesasActionPerformed

    /**
     * Permite dar de baja a la mesa seleccionada, cambiando su atributo 'activo'
     * a 'false'.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de baja'
     */     
    private void jbDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeBajaActionPerformed
        obtenerIdMesaSeleccionada();

        // si no se seleccionó ninguna mesa
        if(idMesa == -1)
        {
            JOptionPane.showMessageDialog(
                null,
                "Debe seleccionar una mesa",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            int opcionSeleccionada = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea dar de baja a esta mesa?",
                "Baja de mesas",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            if(opcionSeleccionada == JOptionPane.YES_OPTION)
            {
                // obtengo la mesa
                Mesa mes = gesMes.buscarPorId(idMesa);
                
                // doy de baja a la mesa
                mes.setActivo(false);
                gesMes.guardarOActualizar(mes);
            }
            else
            {
                // nada
            }

            buscarMesas();
        }
    }//GEN-LAST:event_jbDarDeBajaActionPerformed

    /**
     * Actualiza la tabla de mesas.
     */
    public void actualizarTablaMesas()
    {
        modeloMesas = gesMes.configurarModelo(modeloMesas, listaMesas);
        jtMesas.setModel(modeloMesas);
        jtMesas.getColumnModel().removeColumn(
                jtMesas.getColumnModel().getColumn(0));
        
        jtMesas.getColumn("Número").setPreferredWidth(75);
        jtMesas.getColumn("Cantidad de personas").setPreferredWidth(75);
        jtMesas.getColumn("Descripción").setPreferredWidth(250);
    }
    
    /**
     * Cuando se selecciona una mesa en la tabla, cambia el valor de la
     * variable 'idMesa' por el valor del 'id' de la mesa seleccionada.
     */    
    public void obtenerIdMesaSeleccionada()
    {
        idMesa = -1;
        int fila = jtMesas.getSelectedRow();
        
        if(fila != -1)
        {
            idMesa = Integer.parseInt(
                    String.valueOf(modeloMesas.getValueAt(fila, 0)));
        }
    }

    /**
     * Actualiza la tabla de mesas según el criterio escogido en el combobox
     * 'Ver mesas'
     */
    public void buscarMesas()
    {
        if(jcbVerMesas.getSelectedItem().toString().equals("Activas"))
        {
            listaMesas = gesMes.getListaMesasActivas();
        }
        else if(jcbVerMesas.getSelectedItem().toString().equals("Dadas de baja"))
        {
            listaMesas = gesMes.getListaMesasDadasDeBaja();
        }
        else if(jcbVerMesas.getSelectedItem().toString().equals("Todas"))
        {
            listaMesas = gesMes.getListaMesas();
        }    
        
        actualizarTablaMesas();
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbDarDeBaja;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox jcbVerMesas;
    private javax.swing.JLabel jlListadoDeMesas;
    private javax.swing.JLabel jlVerMesas;
    private javax.swing.JTable jtMesas;
    // End of variables declaration//GEN-END:variables
}
