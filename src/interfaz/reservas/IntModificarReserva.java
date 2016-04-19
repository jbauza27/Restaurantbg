package interfaz.reservas;

import entidad.*;
import gestor.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Fecha;


/**
 * Formulario para modificar una reserva.
 */
public class IntModificarReserva extends javax.swing.JDialog 
{
    /* Atributos */
    private Session sesion;
    private Reserva res;
    private int id;
    private GestorReservas gesRes;
    private GestorMesas gesMes;
    private GestorClientes gesCli;
    private ArrayList<Mesa> listaMesas;
    private ArrayList<Cliente> listaClientes;
    private DefaultComboBoxModel cbmHora;
    private DefaultComboBoxModel cbmMinutos;    
    private DefaultComboBoxModel cbmMesas;
    private DefaultComboBoxModel cbmClientes;
    
    // fecha, hora y mesa de la reserva actual
    private String anioActual;
    private String mesActual;
    private String diaActual;
    private String horaActual;
    private String minutoActual;
    private String mesaActual;
    
    
    /* Constructor */
    public IntModificarReserva(java.awt.Frame parent, boolean modal,
            Session sesion, int idReserva)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;        
        gesRes = new GestorReservas(sesion);
        gesMes = new GestorMesas(sesion);
        gesCli = new GestorClientes(sesion);
        id = idReserva;
        cbmHora = new DefaultComboBoxModel();
        cbmMinutos = new DefaultComboBoxModel();
        cbmMesas = new DefaultComboBoxModel();
        cbmClientes = new DefaultComboBoxModel();
              
        res = gesRes.buscarPorId(id);
        
        if(res.isActivo() == true)
        {
            jCheckBoxActivo.setSelected(true);
        }
        else
        {
            jCheckBoxActivo.setSelected(false);
        }
        
        Integer a = res.getFechayHora().get(Calendar.YEAR);
        String anio = a.toString();
        jtfAnio.setText(anio);
        Integer m = res.getFechayHora().get(Calendar.MONTH+1);
        String mes = m.toString();
        jtfMes.setText(mes);
        Integer d = res.getFechayHora().get(Calendar.DAY_OF_MONTH);
        String dia = d.toString();
        jtfDia.setText(dia);        
        
        llenarModeloComboHora();
        Integer ho = res.getFechayHora().get(Calendar.HOUR_OF_DAY);
        String horaSeleccionada;
        if(ho < 10)
        {
            horaSeleccionada = "0" + ho.toString();
        }
        else
        {
            horaSeleccionada = ho.toString();
        }
        cbmHora.setSelectedItem(horaSeleccionada);
        jcbHora.setModel(cbmHora);        
        
        llenarModeloComboMinutos();
        Integer mi = res.getFechayHora().get(Calendar.MINUTE);
        String minutosSeleccionados;
        if(mi < 10)
        {
            minutosSeleccionados = "0" + mi.toString();
        }
        else
        {
            minutosSeleccionados = mi.toString();
        }
        cbmMinutos.setSelectedItem(minutosSeleccionados);
        jcbMinutos.setModel(cbmMinutos);  
        
        llenarModeloComboMesas();
        String mesaSeleccionadaConGuion = 
                res.getMesa().getId() + " - " + res.getMesa().getNroMesa();
        cbmMesas.setSelectedItem(mesaSeleccionadaConGuion);
        jcbMesas.setModel(cbmMesas);
        
        llenarModeloComboClientes();
        String clienteSeleccionadoConGuion = 
                res.getCliente().getId() + " - "
                + res.getCliente().getApellido() + " " + res.getCliente().getNombre();
        cbmClientes.setSelectedItem(clienteSeleccionadoConGuion);
        jcbClientes.setModel(cbmClientes);        
        
        anioActual = a.toString();
        mesActual = m.toString();
        diaActual = d.toString();
        horaActual = ho.toString();
        minutoActual = mi.toString();
        mesaActual = res.getMesa().getNroMesa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlModificacionReserva = new javax.swing.JLabel();
        jlDatosReserva = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlFecha = new javax.swing.JLabel();
        jtfDia = new javax.swing.JTextField();
        jlBarra1 = new javax.swing.JLabel();
        jtfMes = new javax.swing.JTextField();
        jtfAnio = new javax.swing.JTextField();
        jlBarra2 = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jcbHora = new javax.swing.JComboBox();
        jcbMinutos = new javax.swing.JComboBox();
        jlMesa = new javax.swing.JLabel();
        jcbMesas = new javax.swing.JComboBox();
        jcbClientes = new javax.swing.JComboBox();
        jlCliente = new javax.swing.JLabel();
        jlActivo = new javax.swing.JLabel();
        jCheckBoxActivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Modificación de reservas");

        jlModificacionReserva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlModificacionReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlModificacionReserva.setText("Modificación de reserva");

        jlDatosReserva.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDatosReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatosReserva.setText("Datos de la reserva");

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

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

        jtfAnio.setText("aaaa");
        jtfAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioKeyTyped(evt);
            }
        });

        jlBarra2.setText("/");

        jlHora.setText("Hora:");

        jlMesa.setText("Mesa:");

        jlCliente.setText("Cliente:");

        jlActivo.setText("Activo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jbModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir)
                        .addGap(138, 138, 138))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlModificacionReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlDatosReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jlMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jcbMinutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jlBarra1)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addComponent(jlBarra2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCheckBoxActivo)))
                            .addGap(0, 0, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlModificacionReserva)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlActivo)
                    .addComponent(jCheckBoxActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDatosReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFecha)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlBarra1)
                        .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlBarra2)
                        .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHora)
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlMesa)
                    .addComponent(jcbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbModificar))
                .addContainerGap(43, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Crea el modelo del combo 'Hora'. 
     */
    private void llenarModeloComboHora()
    {       
        for(int i = 8 ; i <= 23 ; i++)
        {
            if(i < 10)
            {
                Integer iInt = i;
                String j = "0" + iInt.toString();
                cbmHora.addElement(j);
            }
            else
            {
                cbmHora.addElement(i);
            }
        }
    }    
    
    /**
     * Crea el modelo del combo 'Minutos'. 
     */
    private void llenarModeloComboMinutos()
    {       
        for(int i = 0 ; i <= 45 ; i = i + 15)
        {
            if(i < 10)
            {
                Integer iInt = i;
                String j = "0" + iInt.toString();
                cbmMinutos.addElement(j);
            }
            else
            {
                cbmMinutos.addElement(i);
            }
        }
    }      
    
    /**
     * Crea el modelo del combo 'Mesas'.
     */
    private void llenarModeloComboMesas()
    {
        listaMesas = gesMes.getListaMesasActivas();
        String mesaConId = "";
        
        for(Mesa mes : listaMesas)
        {
            mesaConId = mes.getId() + " - " + mes.getNroMesa();
            cbmMesas.addElement(mesaConId);
        }
    } 
    
    /**
     * Crea el modelo del combo 'Clientes'.
     */
    private void llenarModeloComboClientes()
    {
        listaClientes = gesCli.getListaClientes();
        String clienteConId = "";
        
        for(Cliente cli : listaClientes)
        {
            clienteConId = cli.getId() + " - "
                    + cli.getApellido() + " " + cli.getNombre();
            cbmClientes.addElement(clienteConId);
        }
    }      
    
    /**
     * Guarda la reserva o notifica al usuario que hay algún error.
     * 
     * @param evt el evento de pulsación sobre el botón 'Dar de alta'
     */    
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        /* VALIDACIONES */
        int dia = 0;
        int mes = 0;
        int anio = 0;        
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;   
        boolean fechaCorrecta = true;
            
        /* Me cercioro que no hay campos vacíos */
        if(jtfDia.getText().equals("dd") || jtfDia.getText().equals("d")
             || jtfDia.getText().equals("")
             || jtfMes.getText().equals("mm") || jtfMes.getText().equals("m")
             || jtfMes.getText().equals("")
             || jtfAnio.getText().equals("aaaa") || jtfAnio.getText().equals("aaa")
             || jtfAnio.getText().equals("aa") || jtfAnio.getText().equals("a")
             || jtfAnio.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar todos los campos.\n";
            error = true;
            fechaCorrecta = false;
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
                fechaCorrecta = false;
            }        
        }              
        
        // sólo si se llenaron los campos relativos a la fecha y la misma es 
        // válida, hago la siguiente comprobación          
        if(fechaCorrecta == true)
        {
            // comparo fechas y horas solicitadas para la reserva con la fecha y
            // hora actual. Las fechas y horas solicitadas para la reserva no deben
            // ser menores a la actual
            
            // fecha y hora actual
            GregorianCalendar momentoActual = new GregorianCalendar();
            
            // fecha y hora solicitada para la reserva
            int a = Integer.parseInt(jtfAnio.getText());
            int m = Integer.parseInt(jtfMes.getText());
            m--; // necesario porque GregorianCalendar cuenta los meses desde 0 a 11
            int d = Integer.parseInt(jtfDia.getText());
            int hor = Integer.parseInt(jcbHora.getSelectedItem().toString());       
            GregorianCalendar momentoSolicitado = new GregorianCalendar(a, m, d, hor, 0, 0);
            
            // comparo fecha actual con fecha solicitada para reserva
            Fecha fec = new Fecha();
            int comp = fec.comparacionDeFechas(momentoActual, momentoSolicitado);
            
            // si la fecha solicitada es la de hoy, comparo horas
            if(comp == 0)
            {
                int horaActual = momentoActual.get(Calendar.HOUR_OF_DAY);
                                
                if(horaActual < hor)
                {
                    // si la hora actual es menor a la solicitada, permito la
                    // reserva
                }
                else
                {
                    mensajeDeError = mensajeDeError + "- La fechas y horas"
                        + " solicitadas son anteriores a las actuales.\n"; 
                    error = true;
                }
            }
            // si la fecha solicitada es anterior a la actual, entonces no permito
            // la reserva y envío un mensaje de error
            else if(comp == 1)
            {
                mensajeDeError = mensajeDeError + "- La fechas y horas"
                    + " solicitadas son anteriores a las actuales.\n"; 
                error = true;                
            }
            // si la fecha solicitada es posterior a la actual, se permite la
            // reserva
            else if(comp == 2)
            {

            }
        }
        
        /* Comprobación de registros duplicados */
        // sólo si todas las comprobaciones anteriores son correctas, hago la
        // siguiente comprobación        
        if(error == false)
        {
            // en primer lugar, necesito el número de mesa solo, sin el 'id' ni
            // el guión adelante
            Mesa mesa = new Mesa();
            String mesaSeleccionada = jcbMesas.getSelectedItem().toString();
            int indGuion = mesaSeleccionada.indexOf("-");
            String idMesa = String.valueOf(mesaSeleccionada.substring(0, indGuion-1));
            mesa = gesMes.buscarPorId(Integer.parseInt(idMesa));
            String mesaSinGuion = mesa.getNroMesa();
            
            // cerciorándome de que no haya en la base de datos otra reserva con
            // la misma fecha, hora y número de mesa
            ArrayList<Reserva> repetidos = new ArrayList<>();
            // si el usuario no cambió el número de mesa, la fecha y la hora 
            // entonces no se realiza la comprobación por registros duplicados
            if(jcbMesas.getSelectedItem().toString().equals(mesaActual)
                    && jtfAnio.getText().equals(anioActual)
                    && jtfMes.getText().equals(mesActual)
                    && jtfDia.getText().equals(diaActual)
                    && jcbHora.getSelectedItem().toString().equals(horaActual)
                    && jcbMinutos.getSelectedItem().toString().equals(minutoActual)
              )
            {
                
            }            
            else
            {
                String hql = "FROM Reserva R WHERE R.activo = true AND "
                        + "R.mesa.nroMesa = '"
                    + mesaSinGuion + "' "
                    + "AND R.fechayHora = '" + jtfAnio.getText()
                    + "-" + jtfMes.getText()
                    + "-" + jtfDia.getText()
                    + " " + jcbHora.getSelectedItem().toString()
                    + ":" + jcbMinutos.getSelectedItem().toString()
                    + ":" + "00'";
                Query query = sesion.createQuery(hql);
                repetidos = (ArrayList<Reserva>) query.list();            

                // si encuentro alguna reserva que tenga la misma fecha, hora y número
                // de mesa que las ingresadas en la ventana, muestro un mensaje de
                // error
                if(repetidos.isEmpty() == false)
                {
                    mensajeDeError = mensajeDeError + "- No puede dar de alta esta reserva "
                            + "porque ya existe otra en la base de datos con la misma "
                            + "fecha, hora y número de mesa.\n";
                    error = true;            
                }   
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
            // obteniendo la reserva
            res = gesRes.buscarPorId(id);
            
            if(jCheckBoxActivo.isSelected() == true)
            {
                res.setActivo(true);
            }
            else
            {
                res.setActivo(false);
            }            
            
            int a = Integer.parseInt(jtfAnio.getText());
            int m = Integer.parseInt(jtfMes.getText());
            m--; // necesario porque GregorianCalendar cuenta los meses desde 0 a 11
            int d = Integer.parseInt(jtfDia.getText());
            int hor = Integer.parseInt(jcbHora.getSelectedItem().toString());
            int min = Integer.parseInt(jcbMinutos.getSelectedItem().toString());
            int seg = 0;
            GregorianCalendar fh = new GregorianCalendar(a, m, d, hor, min, seg);            
            res.setFechayHora(fh);
            
            // le añado el cliente
            Cliente cliente = new Cliente();
            String clienteSeleccionado = jcbClientes.getSelectedItem().toString();
            int indGuion = clienteSeleccionado.indexOf("-");
            String idCliente = String.valueOf(clienteSeleccionado.substring(0, indGuion-1));
            cliente = gesCli.buscarPorId(Integer.parseInt(idCliente));
            res.setCliente(cliente);
            
            // le añado la mesa
            Mesa mesa = new Mesa();
            String mesaSeleccionada = jcbMesas.getSelectedItem().toString();
            indGuion = mesaSeleccionada.indexOf("-");
            String idMesa = String.valueOf(mesaSeleccionada.substring(0, indGuion-1));
            mesa = gesMes.buscarPorId(Integer.parseInt(idMesa));
            res.setMesa(mesa);
            
            // actualizando reserva en la base de datos
            gesRes.guardarOActualizar(res);
            
            this.dispose();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Cierra la ventana sin efectuar ninguna operación.
     * 
     * @param evt el evento de clic sobre el botón 'Cancelar'
     */    
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

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
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcbClientes;
    private javax.swing.JComboBox jcbHora;
    private javax.swing.JComboBox jcbMesas;
    private javax.swing.JComboBox jcbMinutos;
    private javax.swing.JLabel jlActivo;
    private javax.swing.JLabel jlBarra1;
    private javax.swing.JLabel jlBarra2;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlDatosReserva;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel jlMesa;
    private javax.swing.JLabel jlModificacionReserva;
    private javax.swing.JTextField jtfAnio;
    private javax.swing.JTextField jtfDia;
    private javax.swing.JTextField jtfMes;
    // End of variables declaration//GEN-END:variables
}
