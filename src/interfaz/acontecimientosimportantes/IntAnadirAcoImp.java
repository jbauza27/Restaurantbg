package interfaz.acontecimientosimportantes;

import entidad.AcontecimientoImportante;
import entidad.Cliente;
import entidad.Empleado;
import gestor.GestorAcontecimientosImportantes;
import gestor.GestorClientes;
import gestor.GestorEmpleados;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Fecha;


/**
 * Abre un formulario que permite añadir un acontecimiento importante a un cliente
 * o a un empleado.
 */
public class IntAnadirAcoImp extends javax.swing.JDialog
{
    // una constante
    public static final int ANIOANUAL = AcontecimientoImportante.A_ANUAL;
    
    /* Atributos */
    private Session sesion;
    private GestorAcontecimientosImportantes gesAcoImp;
    private GestorClientes gesCli;
    private GestorEmpleados gesEmp;    
    private AcontecimientoImportante acoImp;
    private Cliente cli;
    private ArrayList<Cliente> listaClientes;    
    private Empleado emp;
    private ArrayList<Empleado> listaEmpleados;
        
    
    /* Constructor */
    public IntAnadirAcoImp(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesAcoImp = new GestorAcontecimientosImportantes(sesion);
        gesCli = new GestorClientes(sesion);
        gesEmp = new GestorEmpleados(sesion);
        
        acoImp = new AcontecimientoImportante();
        cli = new Cliente();
        listaClientes = new ArrayList<>();
        emp = new Empleado();
        listaEmpleados = new ArrayList<>();
        
        jlMensaje.setVisible(false);
        
        cargarClientes();
        cargarEmpleados();        
    }
    
    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlAcontecimientosImportantes = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jtfDia = new javax.swing.JTextField();
        jlBarra1 = new javax.swing.JLabel();
        jtfMes = new javax.swing.JTextField();
        jlBarra2 = new javax.swing.JLabel();
        jtfAnio = new javax.swing.JTextField();
        jlAcontecimiento = new javax.swing.JLabel();
        jtfAcontecimiento = new javax.swing.JTextField();
        jbSalir = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jCheckBoxCliente = new javax.swing.JCheckBox();
        jcbClientes = new javax.swing.JComboBox();
        jCheckBoxEmpleado = new javax.swing.JCheckBox();
        jcbEmpleados = new javax.swing.JComboBox();
        jlMensaje = new javax.swing.JLabel();
        jlTipo = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Añadir acontecimiento importante");

        jlAcontecimientosImportantes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlAcontecimientosImportantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAcontecimientosImportantes.setText("Acontecimientos importantes");

        jlFecha.setText("Fecha:");

        jtfDia.setText("dd");
        jtfDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaKeyTyped(evt);
            }
        });

        jlBarra1.setText("/");

        jtfMes.setText("mm");
        jtfMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesKeyTyped(evt);
            }
        });

        jlBarra2.setText("/");

        jtfAnio.setText("aaaa");
        jtfAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioKeyTyped(evt);
            }
        });

        jlAcontecimiento.setText("Acontecimiento:");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jCheckBoxCliente.setText("Cliente:");
        jCheckBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxClienteActionPerformed(evt);
            }
        });

        jCheckBoxEmpleado.setText("Empleado:");
        jCheckBoxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxEmpleadoActionPerformed(evt);
            }
        });

        jlMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMensaje.setText("Mensaje");

        jlTipo.setText("Tipo:");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anual", "Único" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlAcontecimientosImportantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBoxEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jCheckBoxCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlAcontecimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlBarra1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlBarra2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jtfAcontecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jbGuardar)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlAcontecimientosImportantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxCliente)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxEmpleado)
                    .addComponent(jcbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFecha)
                    .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra1)
                    .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra2)
                    .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAcontecimiento)
                    .addComponent(jtfAcontecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipo)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbGuardar))
                .addGap(18, 18, 18)
                .addComponent(jlMensaje)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
     * Llena el combo empleados con todos los empleados almacenados en la base
     * de datos.
     */
    public void cargarEmpleados()
    {
        listaEmpleados = gesEmp.getListaEmpleados();        
        String empleado = "";
        
        for(Empleado emp : listaEmpleados)
        {
            empleado = emp.getId() + " - " + emp.getApellido()
                    + " " + emp.getNombre();
            jcbEmpleados.addItem(empleado);
        }
    }
    
    /**
     * Llena el combo clientes con todos los clientes almacenados en la base de
     * datos.
     */
    public void cargarClientes()
    {
        listaClientes = gesCli.getListaClientes();
        String cliente = "";
        
        for(Cliente cli : listaClientes)
        {
            cliente = cli.getId() + " - " + cli.getApellido()
                    + " " + cli.getNombre();
            jcbClientes.addItem(cliente);
        }
    }    
    
    /**
     * Cierra la ventana sin guardar ningún cambio.
     * 
     * @param evt el evento de pulsación sobre el botón 'Salir'
     */
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    /**
     * Guarda el acontecimiento importante o notifica al usuario que existe
     * algún error en el llenado del formulario.
     * 
     * @param evt el evento de pulsación sobre el botón 'Guardar'
     */
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        /* VALIDACIONES */
        int dia = 0;
        int mes = 0;
        int anio = 0;
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        
        /* Me aseguro de que se haya seleccionado un cliente o empleado */
        if(jCheckBoxCliente.isSelected() == false
                && jCheckBoxEmpleado.isSelected() == false)
        {
            mensajeDeError = mensajeDeError + "- Debe seleccionar un cliente o"
                    + " un empleado.\n";
            error = true;
        }    
        
        
        /* Me cercioro que no hay campos vacíos */
        if(jtfAcontecimiento.getText().equals("")
                || jtfDia.getText().equals("dd") || jtfDia.getText().equals("d")
                || jtfDia.getText().equals("")
                || jtfMes.getText().equals("mm") || jtfMes.getText().equals("m")
                || jtfMes.getText().equals("")
                || jtfAnio.getText().equals("aaaa") || jtfAnio.getText().equals("aaa")
                || jtfAnio.getText().equals("aa") || jtfAnio.getText().equals("a")
                || jtfAnio.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar todos los campos.\n";
            error = true;
        }
        
        /* Valido que la fecha ingresada pueda existir */
        if( !(jtfDia.getText().equals("dd")) &&
            !(jtfDia.getText().equals("d"))  &&
            !(jtfDia.getText().equals("")) &&    
            !(jtfMes.getText().equals("mm")) &&
            !(jtfMes.getText().equals("m")) &&    
            !(jtfMes.getText().equals("")) &&    
            !(jtfAnio.getText().equals("aaaa")) && 
            !(jtfAnio.getText().equals("aaa")) &&
            !(jtfAnio.getText().equals("aa")) &&
            !(jtfAnio.getText().equals("a")) &&
            !(jtfAnio.getText().equals("")))
        {
            Fecha fec = new Fecha();
            dia = Integer.parseInt(jtfDia.getText());
            mes = Integer.parseInt(jtfMes.getText());
            anio = Integer.parseInt(jtfAnio.getText());
        
            boolean fechaValida = fec.validarFecha(anio, mes, dia);
        
            if(fechaValida == false)
            {
                mensajeDeError = mensajeDeError + "- La fecha ingresada no es"
                        + " correcta.\n"; 
                error = true;
            }        
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
        /* ALTA */
        else
        {
            AcontecimientoImportante acoImp = new AcontecimientoImportante();
            if(jCheckBoxCliente.isSelected() == true)
            {
                // obtengo el cliente seleccionado
                String clienteSeleccionado = jcbClientes.getSelectedItem().toString();
                int indGuion = clienteSeleccionado.indexOf("-");
                String idCliente = String.valueOf(clienteSeleccionado.substring(0, indGuion-1));
                cli = gesCli.buscarPorId(Integer.parseInt(idCliente));                 
                
                // lo asigno al acontecimiento
                acoImp.setCliente(cli);
            }
            else if(jCheckBoxEmpleado.isSelected() == true)
            {
                // obtengo el empleado seleccionado
                String empleadoSeleccionado = jcbEmpleados.getSelectedItem().toString();
                int indGuion = empleadoSeleccionado.indexOf("-");
                String idEmpleado = String.valueOf(empleadoSeleccionado.substring(0, indGuion-1));
                emp = gesEmp.buscarEmpleadoPorId(Integer.parseInt(idEmpleado));                 
                
                // lo asigno al acontecimiento                
                acoImp.setEmpleado(emp);
            }
            
            acoImp.setTipo(jcbTipo.getSelectedItem().toString());
            
            // si el acontecimiento es de tipo anual, primero guardo la fecha
            // tal como se ingresó en el campo 'fechaUnica', y luego la misma fecha
            // pero con el año 2200 en el campo 'fechaAnual'
            if(jcbTipo.getSelectedItem().toString().equals("Anual"))
            {
                mes = mes-1; // GregorianCalendar cuenta los meses de 0 a 11
                GregorianCalendar fec = new GregorianCalendar(anio, mes, dia);            
                acoImp.setFechaUnica(fec);
                GregorianCalendar fecAnual = new GregorianCalendar(ANIOANUAL, mes, dia);
                acoImp.setFechaAnual(fecAnual);
            }
            // si el acontecimiento es de tipo único, simplemente guardo la fecha
            // tal cual fue ingresada en el campo 'fechaUnica'
            else if(jcbTipo.getSelectedItem().toString().equals("Único"))
            {
                mes = mes-1; // GregorianCalendar cuenta los meses de 0 a 11
                GregorianCalendar fec = new GregorianCalendar(anio, mes, dia);            
                acoImp.setFechaUnica(fec); 
                acoImp.setFechaAnual(null);
            }            

            acoImp.setAcontecimiento(jtfAcontecimiento.getText());
            
            // guardo el objeto en la base de datos
            gesAcoImp.guardarOActualizar(acoImp);
            
            
            // muestro un mensaje
            jlMensaje.setVisible(true);
            jlMensaje.setText("Guardado exitoso");            
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    /**
     * Automáticamente desselecciona el checkbox Empleado si se selecciona el
     * checkbox Cliente.
     * 
     * @param evt el evento de selección del checkbox 'Cliente'
     */
    private void jCheckBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxClienteActionPerformed
        if(jCheckBoxCliente.isSelected() == true)
        {
            jCheckBoxEmpleado.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxClienteActionPerformed

    /**
     * Automáticamente desselecciona el checkbox Cliente si se selecciona el
     * checkbox Empleado.
     * 
     * @param evt el evento de selección del checkbox 'Empleado'
     */    
    private void jCheckBoxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxEmpleadoActionPerformed
        if(jCheckBoxEmpleado.isSelected() == true)
        {
            jCheckBoxCliente.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxEmpleadoActionPerformed

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */     
    private void jtfDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfDiaKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */      
    private void jtfMesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfMesKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 4.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnioKeyTyped
        Campos.configurarCampo(evt, 4, "Números");
    }//GEN-LAST:event_jtfAnioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxCliente;
    private javax.swing.JCheckBox jCheckBoxEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcbClientes;
    private javax.swing.JComboBox jcbEmpleados;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JLabel jlAcontecimiento;
    private javax.swing.JLabel jlAcontecimientosImportantes;
    private javax.swing.JLabel jlBarra1;
    private javax.swing.JLabel jlBarra2;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JTextField jtfAcontecimiento;
    private javax.swing.JTextField jtfAnio;
    private javax.swing.JTextField jtfDia;
    private javax.swing.JTextField jtfMes;
    // End of variables declaration//GEN-END:variables
}
