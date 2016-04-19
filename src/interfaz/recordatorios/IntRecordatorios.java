package interfaz.recordatorios;

import entidad.AcontecimientoImportante;
import entidad.Cliente;
import entidad.Preferencia;
import gestor.GestorAcontecimientosImportantes;
import gestor.GestorClientes;
import gestor.GestorPreferencias;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Formulario que muestra los acontecimientos importantes de clientes y empleados
 * desde el inicio de semana hasta el final de la siguiente semana.
 */
public class IntRecordatorios extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GregorianCalendar fechaActual;
    private int diaActual;
    private int mesActual;
    private int anioActual;
    private GregorianCalendar fechaPosterior;
    private int diaPosterior;
    private int mesPosterior;
    private int anioPosterior;
    private ArrayList<AcontecimientoImportante> listaRecordatorios;
    private AcontecimientoImportante recordatorio;
    private GestorAcontecimientosImportantes gesRecordatorios;
    private ArrayList<Preferencia> listaPreferencias;
    private GestorPreferencias gesPref;
    private Cliente cli;
    private GestorClientes gesCli;
    private Modelo modeloRecordatorios;
    private int idRecordatorio;
    
    
    /* Constructor */
    public IntRecordatorios(java.awt.Frame parent, boolean modal, Session sesion,
        GregorianCalendar fechaActual, GregorianCalendar fechaPosterior,
        ArrayList<AcontecimientoImportante> muchosRecordatorios)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        this.fechaActual = fechaActual;
        this.fechaPosterior = fechaPosterior;
        this.listaRecordatorios = muchosRecordatorios;
        
        anioActual = fechaActual.get(Calendar.YEAR);        
        mesActual = fechaActual.get(Calendar.MONTH) + 1;
        diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
        
        anioPosterior = fechaPosterior.get(Calendar.YEAR);
        mesPosterior = fechaPosterior.get(Calendar.MONTH) + 1;
        diaPosterior = fechaPosterior.get(Calendar.DAY_OF_MONTH);        
        
        jlFechas.setText("Acontecimientos desde "
                + diaActual + "/" + mesActual + "/" + anioActual
                + " hasta "
                + diaPosterior + "/" + mesPosterior + "/" + anioPosterior);
        
        modeloRecordatorios = new Modelo();
        gesRecordatorios = new GestorAcontecimientosImportantes(sesion);
        recordatorio = new AcontecimientoImportante();
        listaPreferencias = new ArrayList<>();
        gesPref = new GestorPreferencias(sesion);
        cli = new Cliente();
        gesCli = new GestorClientes(sesion);
        
        actualizarTablaRecordatorios();       
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlRecordatorios = new javax.swing.JLabel();
        jlFechas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRecordatorios = new javax.swing.JTable();
        jbVerPreferencias = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Recordatorios");

        jlRecordatorios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlRecordatorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRecordatorios.setText("Recordatorios");

        jlFechas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechas.setText("Fechas");

        jtRecordatorios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtRecordatorios);

        jbVerPreferencias.setText("Ver preferencias");
        jbVerPreferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerPreferenciasActionPerformed(evt);
            }
        });

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
                    .addComponent(jlRecordatorios, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(jlFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jbVerPreferencias)
                .addGap(18, 18, 18)
                .addComponent(jbCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlRecordatorios)
                .addGap(18, 18, 18)
                .addComponent(jlFechas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVerPreferencias)
                    .addComponent(jbCerrar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * Cierrra la ventana.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cerrar'
     */
    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    /**
     * Muestra las preferencias en cuanto a comidas y bebidas del cliente
     * seleccionado en la tabla.
     * 
     * @param evt el evento de pulsación sobre el botón 'Ver preferencias'
     */
    private void jbVerPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerPreferenciasActionPerformed
        obtenerIdRecordatorioSeleccionado();
        
        // si no se seleccionó ningún recordatorio
        if(idRecordatorio == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un recordatorio",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            recordatorio = gesRecordatorios.buscarPorId(idRecordatorio);
            
            if(recordatorio.getCliente() != null)
            {
                String prefCli = "";
                cli = gesCli.buscarPorId(recordatorio.getCliente().getId());    
                prefCli = "Cliente " + cli.getApellido() + " "
                        + cli.getNombre() + "\n\n";
                listaPreferencias = gesPref.getListaPreferenciasDeCliente(cli);
                
                for(Preferencia p : listaPreferencias)
                {
                    prefCli = prefCli
                            + "- " + p.getProductoElaborado().getNombre()
                            + ": " + p.getCantidadConsumiciones() + "\n";
                }
                
                JOptionPane.showMessageDialog(
                    null,
                    prefCli,
                    "Preferencias del cliente",
                    JOptionPane.INFORMATION_MESSAGE);    
            }
            else
            {
                JOptionPane.showMessageDialog(
                        null,
                        "Sólo puede ver preferencias de clientes",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);                
            }
        }
    }//GEN-LAST:event_jbVerPreferenciasActionPerformed

    /**
     * Actualiza la tabla de recordatorios.
     */
    public void actualizarTablaRecordatorios()
    {
        modeloRecordatorios = gesRecordatorios.configurarModeloRecordatorios
            (modeloRecordatorios, listaRecordatorios);
        jtRecordatorios.setModel(modeloRecordatorios);
        jtRecordatorios.getColumnModel().removeColumn(
                jtRecordatorios.getColumnModel().getColumn(0));
    }
    
    /**
     * Cuando se selecciona un recordatorio en la tabla, cambia el valor de la
     * variable 'idRecordatorio' por el valor del 'id' del recordatorio 
     * seleccionado.
     */    
    public void obtenerIdRecordatorioSeleccionado()
    {
        idRecordatorio = -1;
        int fila = jtRecordatorios.getSelectedRow();
        
        if(fila != -1)
        {
            idRecordatorio = Integer.parseInt(
                    String.valueOf(modeloRecordatorios.getValueAt(fila, 0)));
        }
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbVerPreferencias;
    private javax.swing.JLabel jlFechas;
    private javax.swing.JLabel jlRecordatorios;
    private javax.swing.JTable jtRecordatorios;
    // End of variables declaration//GEN-END:variables
}
