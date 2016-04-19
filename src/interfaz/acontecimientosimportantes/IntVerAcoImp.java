package interfaz.acontecimientosimportantes;

import entidad.AcontecimientoImportante;
import gestor.GestorAcontecimientosImportantes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Muestra todos los acontecimientos importantes de clientes, empleados o ambos.
 */
public class IntVerAcoImp extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private ArrayList<AcontecimientoImportante> listaAcoImp;
    private GestorAcontecimientosImportantes gesAcoImp;
    private Modelo modeloAcoImp;
    private int idAco;
    
    
    /* Constructor */    
    public IntVerAcoImp(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        listaAcoImp = new ArrayList<>();
        gesAcoImp = new GestorAcontecimientosImportantes(sesion);
        
        vaciarTablaAcoImp();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCargo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jlVerAcoImp = new javax.swing.JLabel();
        jlListar = new javax.swing.JLabel();
        jrbClientes = new javax.swing.JRadioButton();
        jrbEmpleados = new javax.swing.JRadioButton();
        jrbAmbos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTable();
        jbAnadir = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de acontecimientos importantes");

        jlVerAcoImp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlVerAcoImp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlVerAcoImp.setText("Listado de acontecimientos importantes");

        jlListar.setText("Listar:");

        bgCargo.add(jrbClientes);
        jrbClientes.setText("Clientes");
        jrbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbClientesActionPerformed(evt);
            }
        });

        bgCargo.add(jrbEmpleados);
        jrbEmpleados.setText("Empleados");
        jrbEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEmpleadosActionPerformed(evt);
            }
        });

        bgCargo.add(jrbAmbos);
        jrbAmbos.setText("Ambos");
        jrbAmbos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAmbosActionPerformed(evt);
            }
        });

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

        jbAnadir.setText("Añadir");
        jbAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlVerAcoImp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlListar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbClientes)
                        .addGap(18, 18, 18)
                        .addComponent(jrbEmpleados)
                        .addGap(18, 18, 18)
                        .addComponent(jrbAmbos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jbAnadir)
                .addGap(10, 10, 10)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlVerAcoImp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlListar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbClientes)
                        .addComponent(jrbEmpleados)
                        .addComponent(jrbAmbos)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnadir)
                    .addComponent(jbModificar)
                    .addComponent(jbCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana.
     * 
     * @param evt el evento de pulsación osbre el botón 'Cancelar'
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Lista todos los acontecimientos importantes relacionados con clientes.
     * 
     * @param evt el evento de pulsación sobre el botón de radio 'Clientes'
     */
    private void jrbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbClientesActionPerformed
        listaAcoImp = gesAcoImp.getListaAcontecimientosImportantesDeClientes();
        
        actualizarTablaAcoImp("Cliente");
    }//GEN-LAST:event_jrbClientesActionPerformed

    /**
     * Lista todos los acontecimientos importantes relacionados con empleados.
     * 
     * @param evt el evento de pulsación sobre el botón de radio 'Empleados'
     */
    private void jrbEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEmpleadosActionPerformed
        listaAcoImp = gesAcoImp.getListaAcontecimientosImportantesDeEmpleados();
        
        actualizarTablaAcoImp("Empleado");
    }//GEN-LAST:event_jrbEmpleadosActionPerformed

    /**
     * Lista todos los acontecimientos importantes.
     * 
     * @param evt el evento de pulsación sobre el botón de radio 'Ambos'
     */
    private void jrbAmbosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAmbosActionPerformed
        listaAcoImp = gesAcoImp.getListaAcontecimientosImportantes();
        
        actualizarTablaAcoImp("Cliente o empleado");
    }//GEN-LAST:event_jrbAmbosActionPerformed

    /**
     * Abre un formulario que permite añadir un acontecimiento importante.
     * 
     * @param evt el evento de pulsación sobre el botón 'Añadir'
     */
    private void jbAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirActionPerformed
        IntAnadirAcoImp intaai = new IntAnadirAcoImp(null, true, sesion);
        intaai.setVisible(true);
    }//GEN-LAST:event_jbAnadirActionPerformed

    /**
     * Abre un formulario que permite modificar un acontecimiento importante.
     * 
     * @param evt el evento de pulsación sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdAcontecimientoSeleccionado();
        
        // si no se seleccionó ningún acontecimiento
        if(idAco == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un acontecimiento",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarAcoImp intModCli = new IntModificarAcoImp(
                    null, true, sesion, idAco);
            intModCli.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Actualiza la tabla de acontecimientos importantes.
     * 
     * @param cargo variable que hace saber al método si debe actualizarse con
     * clientes, empleados, o ambos.
     */
    public void actualizarTablaAcoImp(String cargo)
    {
        modeloAcoImp = gesAcoImp.configurarModelo(modeloAcoImp, listaAcoImp,
                cargo);
        jtResultados.setModel(modeloAcoImp);
        jtResultados.getColumnModel().removeColumn(
                jtResultados.getColumnModel().getColumn(0));
    }    
    
    /**
     * Crea una tabla de acontecimientos importantes vacía (contiene únicamente
     * los encabezados).
     */
    public void vaciarTablaAcoImp()
    {
        ArrayList<AcontecimientoImportante> vacio = new ArrayList<>();
        modeloAcoImp = gesAcoImp.configurarModelo(modeloAcoImp, vacio,
                "Clientes o empleados");
        jtResultados.setModel(modeloAcoImp);
        jtResultados.getColumnModel().removeColumn(
                jtResultados.getColumnModel().getColumn(0));
    }        
    
    /**
     * Cuando se selecciona un acontecimiento en la tabla, cambia el valor de la
     * variable 'idAco' por el valor del 'id' del acontecimiento seleccionado.
     */    
    public void obtenerIdAcontecimientoSeleccionado()
    {
        idAco = -1;
        int fila = jtResultados.getSelectedRow();
        
        if(fila != -1)
        {
            idAco = Integer.parseInt(
                    String.valueOf(modeloAcoImp.getValueAt(fila, 0)));
        }
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCargo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnadir;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JLabel jlListar;
    private javax.swing.JLabel jlVerAcoImp;
    private javax.swing.JRadioButton jrbAmbos;
    private javax.swing.JRadioButton jrbClientes;
    private javax.swing.JRadioButton jrbEmpleados;
    private javax.swing.JTable jtResultados;
    // End of variables declaration//GEN-END:variables
}
