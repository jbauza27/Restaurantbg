package interfaz.materiaprima;

import entidad.MateriaPrima;
import entidad.Proveedor;
import gestor.GestorMateriasPrimas;
import gestor.GestorProveedores;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar materias primas y dar algunas posibilidades como 
 * dar de alta, dar de baja y modificar.
 */
public class IntMostrarMateriasPrimas extends javax.swing.JDialog
{
    /* Atributos */
    private GestorMateriasPrimas gesMatPrim;
    private GestorProveedores gesProv;
    private Modelo modeloMateriasPrimas;
    private Session sesion; 
    private int idMateriaPrima;    
    
    
    /* Constructor */
    public IntMostrarMateriasPrimas(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesMatPrim = new GestorMateriasPrimas(sesion);
        gesProv = new GestorProveedores(sesion);
                
        actualizarTablaMateriasPrimas();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeMateriasPrimas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMateriasPrimas = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de materia primas");

        jlListadoDeMateriasPrimas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeMateriasPrimas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeMateriasPrimas.setText("Listado de materias primas");

        jtMateriasPrimas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMateriasPrimas);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlListadoDeMateriasPrimas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jbDarDeAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeMateriasPrimas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver))
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
     * Actualiza la tabla de materias primas.
     * 
     * @param evt el evento de clic sobre el botón 'Actualizar'
     */
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        actualizarTablaMateriasPrimas();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Abre un formulario para dar de alta una materia prima.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE PROVEEDORES
        
           Para poder dar de alta materias primas, es necesario averiguar con
           anterioridad si hay o no proveedores en la base de datos. Si los hay,
           entonces se permite el alta de materias primas, caso contrario, no.
        */
        
        // primero, consulto si hay proveedores
        ArrayList<Proveedor> listaProv =
                gesProv.getListaProveedores();
        
        // si no los hay, muestro un mensaje de error
        if(listaProv.isEmpty() == true)
        {    
            JOptionPane.showMessageDialog(null, "No puede dar de alta materias "
                    + "primas hasta que no haya proveedores ingresados en la "
                    + "base de datos",
                    "Alta de materias primas",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen proveedores, permito el ingreso a la interfaz de alta de
        // materias primas
        else
        {
            IntAltaMateriaPrima intAltMatPrim = new IntAltaMateriaPrima(null, true, sesion);
            intAltMatPrim.setVisible(true);
        } 
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Abre una ventana para modificar la materia prima seleccionada.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdMateriaPrimaSeleccionada();
        
        // si no se seleccionó ninguna materia prima
        if(idMateriaPrima == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar una materia prima",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarMateriaPrima intModMatPrim = new IntModificarMateriaPrima(
                    null, true, sesion, idMateriaPrima);
            intModMatPrim.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Actualiza la tabla de materias primas.
     */
    public void actualizarTablaMateriasPrimas()
    {
        ArrayList<MateriaPrima> listaMateriasPrimas = gesMatPrim.getListaMateriasPrimas();
        modeloMateriasPrimas = 
                gesMatPrim.configurarModelo(modeloMateriasPrimas, listaMateriasPrimas);
        jtMateriasPrimas.setModel(modeloMateriasPrimas);
        jtMateriasPrimas.getColumnModel().removeColumn(
                jtMateriasPrimas.getColumnModel().getColumn(0));
        
        jtMateriasPrimas.getColumn("Proveedores").setPreferredWidth(250);
    }
    
    /**
     * Cuando se selecciona una materia prima en la tabla, cambia el valor de la
     * variable 'idMateriaPrima' por el valor del 'id' de la materia prima
     * seleccionada.
     */    
    public void obtenerIdMateriaPrimaSeleccionada()
    {
        idMateriaPrima = -1;
        int fila = jtMateriasPrimas.getSelectedRow();
        
        if(fila != -1)
        {
            idMateriaPrima = Integer.parseInt(
                    String.valueOf(modeloMateriasPrimas.getValueAt(fila, 0)));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlListadoDeMateriasPrimas;
    private javax.swing.JTable jtMateriasPrimas;
    // End of variables declaration//GEN-END:variables
}
