package interfaz.preferencias;

import entidad.Cliente;
import entidad.Preferencia;
import gestor.GestorClientes;
import gestor.GestorPreferencias;
import java.util.ArrayList;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz que muestra las preferencias de un cliente en cuanto a comida y
 * bebida.
 */
public class IntPreferencias extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GestorClientes gesCli;
    private GestorPreferencias gesPref;
    private ArrayList<Preferencia> listaPreferencias;  
    private Modelo modeloPref;
    
    
    /* Constructor */
    public IntPreferencias(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesCli = new GestorClientes(sesion);
        gesPref = new GestorPreferencias(sesion);
        listaPreferencias = new ArrayList<>();
        
        // código para que la tabla aparezca inicialmente con los encabezados
        // de columna adecuados
        ArrayList<Preferencia> vacio = new ArrayList<>();
        modeloPref = gesPref.configurarModelo(modeloPref, vacio);
        jtResultados.setModel(modeloPref);
        jtResultados.getColumnModel().removeColumn(jtResultados.
               getColumnModel().getColumn(0));  
        
        cargarClientes();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlPreferenciasDeClientes = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jcbClientes = new javax.swing.JComboBox();
        jbListarPreferencias = new javax.swing.JButton();
        jsResultados = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTable();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Preferencias de clientes");

        jlPreferenciasDeClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlPreferenciasDeClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPreferenciasDeClientes.setText("Preferencias de clientes");

        jlCliente.setText("Cliente:");

        jbListarPreferencias.setText("Listar preferencias");
        jbListarPreferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarPreferenciasActionPerformed(evt);
            }
        });

        jsResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jtResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtResultados);

        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPreferenciasDeClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jsResultados)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbListarPreferencias)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCerrar)
                .addGap(275, 275, 275))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPreferenciasDeClientes)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCliente)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbListarPreferencias))
                .addGap(18, 18, 18)
                .addComponent(jsResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCerrar)
                .addContainerGap(14, Short.MAX_VALUE))
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
     * Llena el combo clientes con todos los clientes almacenados en la base de
     * datos.
     */
    public void cargarClientes()
    {
        ArrayList<Cliente> listaClientes = gesCli.getListaClientes();
        String cliente = "";
        
        for(Cliente cli : listaClientes)
        {
            cliente = cli.getId() + " - " + cli.getApellido() + " " + cli.getNombre();
                        jcbClientes.addItem(cliente);
        }
    }    
    
    /**
     * Cierra la ventana.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cerrar'
     */
    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    /**
     * Muestra las preferencias en cuanto a comida y bebida del cliente 
     * seleccionado.
     * 
     * @param evt el evento de pulsación sobre el botón 'Listar preferencias'
     */
    private void jbListarPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarPreferenciasActionPerformed
        String clienteSeleccionado = jcbClientes.getSelectedItem().toString();
        int indGuion = clienteSeleccionado.indexOf("-");
        String idCliente = String.valueOf(clienteSeleccionado.substring(0, indGuion-1));
        Cliente cli = gesCli.buscarPorId(Integer.parseInt(idCliente));    
        
        listaPreferencias = gesPref.getListaPreferenciasDeCliente(cli);
        modeloPref = gesPref.configurarModelo(modeloPref, listaPreferencias);
        jtResultados.setModel(modeloPref);
        jtResultados.getColumnModel().removeColumn(jtResultados.
               getColumnModel().getColumn(0));                  
    }//GEN-LAST:event_jbListarPreferenciasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbListarPreferencias;
    private javax.swing.JComboBox jcbClientes;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlPreferenciasDeClientes;
    private javax.swing.JSeparator jsResultados;
    private javax.swing.JTable jtResultados;
    // End of variables declaration//GEN-END:variables
}
