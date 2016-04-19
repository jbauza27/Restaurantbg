package interfaz.empleado;

import entidad.Empleado;
import gestor.GestorEmpleados;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar empleados y dar algunas posibilidades como 
 * buscar, dar de alta, dar de baja y modificar.
 */
public class IntMostrarEmpleados extends javax.swing.JDialog
{
    /* Atributos */
    private GestorEmpleados gesEmp;
    private ArrayList<Empleado> listaEmpleados;
    private Modelo modeloEmpleados;
    private Session sesion; 
    private int idEmpleado;    
    
    
    /* Constructor */
    public IntMostrarEmpleados(java.awt.Frame parent, boolean modal,
            Session sesion, ArrayList<Empleado> muchosEmpleados)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesEmp = new GestorEmpleados(sesion);
        listaEmpleados = muchosEmpleados;
        
        actualizarTablaEmpleados();     
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlListadoDeEmpleados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpleados = new javax.swing.JTable();
        jbDarDeAlta = new javax.swing.JButton();
        jbDarDeBaja = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbVerHorarioDeTrabajo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Listado de empleados");

        jlListadoDeEmpleados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlListadoDeEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlListadoDeEmpleados.setText("Listado de empleados");

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtEmpleados);

        jbDarDeAlta.setText("Dar de alta");
        jbDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeAltaActionPerformed(evt);
            }
        });

        jbDarDeBaja.setText("Dar de baja");
        jbDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeBajaActionPerformed(evt);
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

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbVerHorarioDeTrabajo.setText("Ver horario de trabajo");
        jbVerHorarioDeTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerHorarioDeTrabajoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlListadoDeEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jbBuscar)
                .addGap(18, 18, 18)
                .addComponent(jbDarDeAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbDarDeBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificar))
                    .addComponent(jbVerHorarioDeTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlListadoDeEmpleados)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVerHorarioDeTrabajo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbDarDeBaja)
                    .addComponent(jbModificar)
                    .addComponent(jbActualizar)
                    .addComponent(jbVolver)
                    .addComponent(jbBuscar))
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
     * Actualiza la tabla de empleados.
     * 
     * @param evt el evento de clic sobre el botón 'Actualizar'
     */    
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        listaEmpleados = gesEmp.getListaEmpleadosActivos();
        actualizarTablaEmpleados();
    }//GEN-LAST:event_jbActualizarActionPerformed

    /**
     * Abre un formulario para dar de alta a un empleado.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de alta'
     */    
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        IntAltaEmpleado intAltEmp = new IntAltaEmpleado(null, true, sesion);
        intAltEmp.setVisible(true);
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Permite dar de baja al empleado seleccionado, cambiando su atributo 'activo'
     * a 'false'.
     * 
     * @param evt el evento de clic sobre el botón 'Dar de baja'
     */    
    private void jbDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeBajaActionPerformed
        obtenerIdEmpleadoSeleccionado();        
        
        // si no se seleccionó ningún empleado
        if(idEmpleado == -1)
        {
             JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un empleado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int opcionSeleccionada = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro que desea dar de baja a este empleado?",
                    "Baja de empleados",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if(opcionSeleccionada == JOptionPane.YES_OPTION)
            {
                // obtengo el empleado
                Empleado emp = gesEmp.buscarEmpleadoPorId(idEmpleado);        
                
                // doy de baja al empleado
                emp.setActivo(false);
                gesEmp.guardarOActualizar(emp);
            }
            else
            {
                // nada                
            }
            
            actualizarTablaEmpleados();
        }
    }//GEN-LAST:event_jbDarDeBajaActionPerformed

    /**
     * Abre una ventana para modificar al empleado seleccionado.
     * 
     * @param evt el evento de clic sobre el botón 'Modificar'
     */    
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        obtenerIdEmpleadoSeleccionado();
        
        // si no se seleccionó ningún empleado
        if(idEmpleado == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un empleado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntModificarEmpleado intModEmp = new IntModificarEmpleado(
                    null, true, sesion, idEmpleado);
            intModEmp.setVisible(true);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Abre un formulario para buscar empleados según determinados criterios.
     * 
     * @param evt el evento de clic sobre el botón 'Buscar'
     */    
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        this.dispose();
        IntBusquedaEmpleados intBusEmp = new IntBusquedaEmpleados(null, true, sesion);
        intBusEmp.setVisible(true);
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * Permite ver los horarios de trabajo asignados al empleado seleccionado.
     * 
     * @param evt el evento de clic sobre el botón "Ver horario de trabajo"
     */
    private void jbVerHorarioDeTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerHorarioDeTrabajoActionPerformed
        obtenerIdEmpleadoSeleccionado();
        
        // si no se seleccionó ningún empleado
        if(idEmpleado == -1)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un empleado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntMostrarHorariosEmpleado intMostHorEmp
                    = new IntMostrarHorariosEmpleado(null, true, sesion, idEmpleado);
            intMostHorEmp.setVisible(true);
        }        
    }//GEN-LAST:event_jbVerHorarioDeTrabajoActionPerformed

    /**
     * Actualiza la tabla de empleados.
     */    
    public void actualizarTablaEmpleados()
    {
        modeloEmpleados = gesEmp.configurarModeloGeneral(modeloEmpleados, listaEmpleados);
        jtEmpleados.setModel(modeloEmpleados);
        jtEmpleados.getColumnModel().removeColumn(
                jtEmpleados.getColumnModel().getColumn(0));
        
        jtEmpleados.getColumn("Fecha de nacimiento").setPreferredWidth(75);
        jtEmpleados.getColumn("Teléfono fijo").setPreferredWidth(125);
        jtEmpleados.getColumn("Teléfono celular").setPreferredWidth(125);
        jtEmpleados.getColumn("Email").setPreferredWidth(125);
        jtEmpleados.getColumn("Domicilio").setPreferredWidth(250);
    }
    
    /**
     * Cuando se selecciona un empleado en la tabla, cambia el valor de la
     * variable 'idEmpleado' por el valor del 'id' del empleado seleccionado.
     */    
    public void obtenerIdEmpleadoSeleccionado()
    {
        idEmpleado = -1;
        int fila = jtEmpleados.getSelectedRow();
        
        if(fila != -1)
        {
            idEmpleado = Integer.parseInt(
                    String.valueOf(modeloEmpleados.getValueAt(fila, 0)));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbDarDeBaja;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbVerHorarioDeTrabajo;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlListadoDeEmpleados;
    private javax.swing.JTable jtEmpleados;
    // End of variables declaration//GEN-END:variables
}
