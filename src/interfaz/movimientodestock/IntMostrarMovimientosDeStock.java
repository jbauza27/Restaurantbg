package interfaz.movimientodestock;

import entidad.MovimientoDeStock;
import gestor.GestorMovimientosDeStock;
import java.util.ArrayList;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar movimientos de stock.
 */
public class IntMostrarMovimientosDeStock extends javax.swing.JDialog
{
    /* Atributos */
    private GestorMovimientosDeStock gesMovSto;
    private Modelo modeloMovimientosDeStock;
    private Session sesion; 
    private int idMovimientoDeStock;    
    
    
    /* Constructor */
    public IntMostrarMovimientosDeStock(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesMovSto = new GestorMovimientosDeStock(sesion);
                
        actualizarTablaMovimientosDeStock();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeMovimientosDeStock = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMovimientosDeStock = new javax.swing.JTable();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de movimientos de stock");

        jlListadoDeMovimientosDeStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeMovimientosDeStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeMovimientosDeStock.setText("Listado de movimientos de stock");

        jtMovimientosDeStock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMovimientosDeStock);

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlListadoDeMovimientosDeStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(455, 455, 455)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeMovimientosDeStock)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbVolver)
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
     * Actualiza la tabla de movimientos de stock.
     */
    public void actualizarTablaMovimientosDeStock()
    {
        ArrayList<MovimientoDeStock> listaMovimientosDeStock
                = gesMovSto.getListaMovimientosDeStock();
        modeloMovimientosDeStock = 
                gesMovSto.configurarModelo(modeloMovimientosDeStock, listaMovimientosDeStock);
        jtMovimientosDeStock.setModel(modeloMovimientosDeStock);
        jtMovimientosDeStock.getColumnModel().removeColumn(
                jtMovimientosDeStock.getColumnModel().getColumn(0));
        
        jtMovimientosDeStock.getColumn("Fecha").setPreferredWidth(50);
        jtMovimientosDeStock.getColumn("Hora").setPreferredWidth(50);
        jtMovimientosDeStock.getColumn("Cantidad").setPreferredWidth(50);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlListadoDeMovimientosDeStock;
    private javax.swing.JTable jtMovimientosDeStock;
    // End of variables declaration//GEN-END:variables
}
