package interfaz.empleado;

import entidad.Empleado;
import gestor.GestorEmpleados;
import java.util.ArrayList;
import org.hibernate.classic.Session;
import org.hibernate.collection.PersistentBag;
import utilidades.Modelo;


/**
 * Muestra los horarios de trabajo de un determinado empleado.
 */
public class IntMostrarHorariosEmpleado extends javax.swing.JDialog 
{
    /* Atributos */
    private Session sesion;
    private GestorEmpleados gesEmp;
    private Empleado emp;
    private ArrayList<Empleado> listaEmpleados;
    private PersistentBag listaHorTrab;
    private Modelo modeloHorTrab;
    private int id;    
    
    
    /* Constructor */
    public IntMostrarHorariosEmpleado(java.awt.Frame parent, boolean modal,
            Session sesion, int idEmpleado) 
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesEmp = new GestorEmpleados(sesion);
        id = idEmpleado;
        emp = gesEmp.buscarEmpleadoPorId(id);
        listaHorTrab = new PersistentBag();
        
        String nombreEmpleado = emp.getApellido() + " " + emp.getNombre();
        jlEmpleadoNombre.setText(nombreEmpleado);
        
        generarTablaHorariosDeTrabajo();
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlHorariosDeTrabajo = new javax.swing.JLabel();
        jlEmpleadoNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHorariosDeEmpleado = new javax.swing.JTable();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Horarios de trabajo de un empleado");

        jlHorariosDeTrabajo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlHorariosDeTrabajo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlHorariosDeTrabajo.setText("Horarios de trabajo");

        jlEmpleadoNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEmpleadoNombre.setText("Empleado: nombre");

        jtHorariosDeEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtHorariosDeEmpleado);

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
            .addComponent(jlHorariosDeTrabajo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlEmpleadoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jbCerrar)
                .addContainerGap(536, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlHorariosDeTrabajo)
                .addGap(18, 18, 18)
                .addComponent(jlEmpleadoNombre)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCerrar)
                .addContainerGap(18, Short.MAX_VALUE))
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
     * Cierra esta ventana y vuelve a la anterior.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cerrar' 
     */
    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    /**
     * Llena la tabla de horarios de trabajo con la información que corresponda.
     */
    public void generarTablaHorariosDeTrabajo()
    {
        listaHorTrab = (PersistentBag) emp.getHorariosDeTrabajo();
       
        modeloHorTrab = gesEmp.configurarModeloHorariosDeTrabajo
                            (modeloHorTrab, listaHorTrab);
        jtHorariosDeEmpleado.setModel(modeloHorTrab);
        
        jtHorariosDeEmpleado.getColumn("Lunes").setPreferredWidth(157);
        jtHorariosDeEmpleado.getColumn("Martes").setPreferredWidth(157);
        jtHorariosDeEmpleado.getColumn("Miércoles").setPreferredWidth(157);
        jtHorariosDeEmpleado.getColumn("Jueves").setPreferredWidth(157);
        jtHorariosDeEmpleado.getColumn("Viernes").setPreferredWidth(157);
        jtHorariosDeEmpleado.getColumn("Sábado").setPreferredWidth(157);
        jtHorariosDeEmpleado.getColumn("Domingo").setPreferredWidth(157);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JLabel jlEmpleadoNombre;
    private javax.swing.JLabel jlHorariosDeTrabajo;
    private javax.swing.JTable jtHorariosDeEmpleado;
    // End of variables declaration//GEN-END:variables
}
