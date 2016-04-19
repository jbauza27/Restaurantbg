package interfaz.facturacion;

import entidad.*;
import gestor.*;
import interfaz.cliente.IntAltaCliente;
import interfaz.empleado.IntAltaEmpleado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.*;


/**
 * Formulario destinado a guardar facturas en la base de datos.
 */
public class IntFacturacion extends javax.swing.JDialog
{
    /* Atributos */
    // - sesión -
    private Session sesion;
    
    // - gestores - 
    private GestorFacturacion gesFac;
    private GestorEmpleados gesEmp;
    private GestorClientes gesCli;
    private GestorProductosElaborados gesProdElab;
    private GestorPreferencias gesPref;
    
    // - modelos -
    private Modelo modeloDetFac;
    private DefaultComboBoxModel cbmAlimentos;
    
    // - factura -
    // un ArrayList para guardar todos los renglones de la factura que voy a 
    // colocar en la tabla
    private ArrayList<DetalleFactura> detalleFactura;
    private ArrayList<ProductoElaborado> listaProdElab;
    private int idRenglon;
    private int idRenglonSel;
    private double importeTotal;
    
    // - renglón -
    // información relativa a los renglones que se ingresan y quitan de la tabla
    private int cantidadRenglon;
    private String alimentoSeleccionado;
    private Double precioUnitario;
    private Double importeRenglon;
    private ArrayList<String> alimentosRenglones;
    
    // notifica a diversos métodos si se presionó el botón calcular o añadir
    // renglón, pues se deberán hacer diferentes cosas en cada caso
    private String botonPresionado;
    
    // la fecha y hora actual
    private GregorianCalendar fechaActual;
    private int diaActual;
    private int mesActual;
    private int anioActual;    
    private int horaActual;
    private int minutoActual;
    
    
    /* Constructor */
    public IntFacturacion(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesFac = new GestorFacturacion(sesion);
        gesEmp = new GestorEmpleados(sesion);
        gesCli = new GestorClientes(sesion);
        gesPref = new GestorPreferencias(sesion);
        gesProdElab = new GestorProductosElaborados(sesion);
        detalleFactura = new ArrayList<>();
        listaProdElab = new ArrayList<>();
        alimentosRenglones = new ArrayList<>();
        cbmAlimentos = new DefaultComboBoxModel();
        idRenglon = 1;
        
        jlPrecioUnitarioRes.setVisible(false);
        jlImporteRes.setVisible(false);
        jlImporteTotalRes.setVisible(false);
        jlMensaje.setVisible(false);
        
        Integer numFac = cargarUltimoNumeroFactura();
        numFac++;
        String n = numFac.toString();
        jlNumFac.setText(n);
        
        cargarMozos();
        cargarClientes();
        cargarProductosElaborados();
        actualizarTablaFacturando();
        
        jcbAlimentos.setModel(cbmAlimentos); 
        
        fechaActual = new GregorianCalendar();
        diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
        mesActual = fechaActual.get(Calendar.MONTH);
        anioActual = fechaActual.get(Calendar.YEAR);
        horaActual = fechaActual.get(Calendar.HOUR_OF_DAY);
        minutoActual = fechaActual.get(Calendar.MINUTE);
    }

    
    /* Métodos */
    public int cargarUltimoNumeroFactura()
    {
        ArrayList<Factura> listaFacturas = new ArrayList<>();
        String hql = "FROM Factura F";
        Query query = sesion.createQuery(hql);
        listaFacturas = (ArrayList<Factura>) query.list();        
        
        int numero = 0;
        
        for(Factura fac : listaFacturas)
        {
            numero = fac.getNumero();            
        }
        
        return numero;
    }
    
    /**
     * Llena el combo mozos con todos los mozos almacenados en la base de datos.
     */
    public void cargarMozos()
    {
        ArrayList<Empleado> listaMozos = new ArrayList<>();
        String hql = "FROM Empleado E WHERE E.cargo.nombreCargo LIKE 'Mozo'";
        Query query = sesion.createQuery(hql);
        listaMozos = (ArrayList<Empleado>) query.list();        
        
        String mozo = "";
        
        for(Empleado moz : listaMozos)
        {
            mozo = moz.getId() + " - " + moz.getApellido() + " " + moz.getNombre();
            jcbMozos.addItem(mozo);
        }
    }
    
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
     * Llena el combo productos elaborados con todos los productos elaborados
     * almacenados en la base de datos.
     */
    public void cargarProductosElaborados()
    {
        listaProdElab = gesProdElab.getListaProductosElaborados();
        String prodElab = "";
        
        for(ProductoElaborado pe : listaProdElab)
        {
            prodElab = pe.getId() + " - " + pe.getNombre();
            cbmAlimentos.addElement(prodElab);
            alimentosRenglones.add(prodElab);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jpPrincipal = new javax.swing.JPanel();
        jlFacturacion = new javax.swing.JLabel();
        jlTipo = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox();
        jlCliente = new javax.swing.JLabel();
        jcbClientes = new javax.swing.JComboBox();
        jlCondicionesDeVenta = new javax.swing.JLabel();
        jcbCondicionesDeVenta = new javax.swing.JComboBox();
        jlNumeroDeFactura = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlCantidad = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jlAlimento = new javax.swing.JLabel();
        jcbAlimentos = new javax.swing.JComboBox();
        jlPrecioUnitario = new javax.swing.JLabel();
        jlImporte = new javax.swing.JLabel();
        jbAgregarRenglon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProductosElaborados = new javax.swing.JTable();
        jbGuardarFactura = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlImporteTotal = new javax.swing.JLabel();
        jbBorrarRenglon = new javax.swing.JButton();
        jlPrecioUnitarioRes = new javax.swing.JLabel();
        jlImporteRes = new javax.swing.JLabel();
        jlImporteTotalRes = new javax.swing.JLabel();
        jlMozo = new javax.swing.JLabel();
        jcbMozos = new javax.swing.JComboBox();
        jlMensaje = new javax.swing.JLabel();
        jbAnadirMozo = new javax.swing.JButton();
        jbAnadirCliente = new javax.swing.JButton();
        jbCalcular = new javax.swing.JButton();
        jlNumFac = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Generación de factura");

        jlFacturacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlFacturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFacturacion.setText("Facturación");

        jlTipo.setText("Tipo:");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C" }));

        jlCliente.setText("Cliente:");

        jlCondicionesDeVenta.setText("Condiciones de venta:");

        jcbCondicionesDeVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Cuenta corriente" }));

        jlNumeroDeFactura.setText("Número de factura:");

        jlCantidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCantidad.setText("Cantidad");

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jlAlimento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlAlimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAlimento.setText("Alimento");

        jlPrecioUnitario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlPrecioUnitario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecioUnitario.setText("Precio unitario");

        jlImporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlImporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImporte.setText("Importe");

        jbAgregarRenglon.setText("Agregar renglón");
        jbAgregarRenglon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarRenglonActionPerformed(evt);
            }
        });

        jtProductosElaborados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtProductosElaborados);

        jbGuardarFactura.setText("Guardar factura");
        jbGuardarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarFacturaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlImporteTotal.setText("Importe total:");

        jbBorrarRenglon.setText("Borrar renglón");
        jbBorrarRenglon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarRenglonActionPerformed(evt);
            }
        });

        jlPrecioUnitarioRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecioUnitarioRes.setText("PrecioUnitario");

        jlImporteRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImporteRes.setText("Importe");

        jlImporteTotalRes.setText("ImporteTotal");

        jlMozo.setText("Mozo:");

        jlMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMensaje.setText("Mensaje");

        jbAnadirMozo.setText("Añadir mozo");
        jbAnadirMozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirMozoActionPerformed(evt);
            }
        });

        jbAnadirCliente.setText("Añadir cliente");
        jbAnadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirClienteActionPerformed(evt);
            }
        });

        jbCalcular.setText("Calcular");
        jbCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularActionPerformed(evt);
            }
        });

        jlNumFac.setText("numfac");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(jbGuardarFactura))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlImporteTotalRes)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbBorrarRenglon)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(jlMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbMozos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(jlTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(108, 108, 108)
                                        .addComponent(jbAnadirMozo)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfCantidad)
                                    .addComponent(jlCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbAlimentos, 0, 202, Short.MAX_VALUE)
                                    .addComponent(jlAlimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlPrecioUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(jlPrecioUnitarioRes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlImporte, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                    .addComponent(jlImporteRes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbCalcular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbAgregarRenglon)))))
                .addContainerGap())
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlNumeroDeFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlCondicionesDeVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCondicionesDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jbAnadirCliente))
                    .addComponent(jlNumFac))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFacturacion)
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMozo)
                    .addComponent(jcbMozos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAnadirMozo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipo)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCliente)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAnadirCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCondicionesDeVenta)
                    .addComponent(jcbCondicionesDeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumeroDeFactura)
                    .addComponent(jlNumFac))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCantidad)
                    .addComponent(jlAlimento)
                    .addComponent(jlPrecioUnitario)
                    .addComponent(jlImporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregarRenglon)
                    .addComponent(jlPrecioUnitarioRes)
                    .addComponent(jlImporteRes)
                    .addComponent(jbCalcular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBorrarRenglon)
                .addGap(11, 11, 11)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlImporteTotal)
                    .addComponent(jlImporteTotalRes))
                .addGap(28, 28, 28)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardarFactura)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18)
                .addComponent(jlMensaje)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Calcula el importe de este renglón de alimentos, multiplicando el precio
     * del mismo por la cantidad consumida.
     * 
     * @param evt el evento de pulsación del boton 'Calcular'
     */
    private void jbCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularActionPerformed
        botonPresionado = "Calcular";
        calcular();
    }//GEN-LAST:event_jbCalcularActionPerformed

    /**
     * Abre una ventana que permite añadir un nuevo cliente a la base de datos.
     * 
     * @param evt el evento de pulsación sobre el botón 'Añadir cliente'
     */
    private void jbAnadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirClienteActionPerformed
        IntAltaCliente intAltCli = new IntAltaCliente(null, true, sesion);
        intAltCli.setVisible(true);

        cargarClientes();
    }//GEN-LAST:event_jbAnadirClienteActionPerformed

    /**
     * Abre una ventana que permite añadir un nuevo empleado a la base de datos.
     * 
     * @param evt el evento de pulsación sobre el botón 'Añadir mozo'
     */
    private void jbAnadirMozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirMozoActionPerformed
        IntAltaEmpleado intAltEmp = new IntAltaEmpleado(null, true, sesion);
        intAltEmp.setVisible(true);

        cargarMozos();
    }//GEN-LAST:event_jbAnadirMozoActionPerformed

    /**
     * Borra del detalle de factura el renglón seleccionado por el cajero.
     * 
     * @param evt el evento de pulsación sobre el botón 'Borrar renglón'
     */
    private void jbBorrarRenglonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarRenglonActionPerformed
        obtenerRenglonSeleccionado();

        /* Validaciones */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        if(idRenglonSel == -1)
        {
            mensajeDeError = mensajeDeError + "- Seleccione un renglón.\n";
            error = true;
        }

        /* Si existen errores, envío una notificación al usuario */
        if(error == true)
        {
            JOptionPane.showMessageDialog(null,
                mensajeDeError,
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            DetalleFactura detFac = new DetalleFactura();
            String alimentoBorrado = "";
            for(int i = 0 ; i < detalleFactura.size() ; i++)
            {
                detFac = detalleFactura.get(i);

                if(detFac.getId() == idRenglonSel)
                {
                    detalleFactura.remove(i);
                    alimentoBorrado = detFac.getProductoElaborado().getId()
                    + " - "
                    + detFac.getProductoElaborado().getNombre();
                }
            }

            // el siguiente código ordena el modelo de combo ayudándose de un arreglo
            // de cadenas
            alimentosRenglones.add(alimentoBorrado);
            alimentosRenglones.sort(null);
            cbmAlimentos.removeAllElements();

            for(String a : alimentosRenglones)
            {
                cbmAlimentos.addElement(a);
            }

            jcbAlimentos.setModel(cbmAlimentos);

            // obtengo el importe total de la factura
            importeTotal = 0;
            for(DetalleFactura dt : detalleFactura)
            {
                importeTotal = importeTotal + dt.getImporte();
            }
            actualizarCampoImporteTotal();

            actualizarTablaFacturando();
        }
    }//GEN-LAST:event_jbBorrarRenglonActionPerformed

    /**
     * Cierra la ventana sin guardar ninguna factura.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cancelar'
     */
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    /**
     * Guarda la factura en la base de datos.
     * 
     * @param evt el eento de pulsación sobre el botón 'Guardar factura'
     */
    private void jbGuardarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarFacturaActionPerformed
        Factura fac = new Factura();
        DetalleFactura detFac = new DetalleFactura();
        Cliente cli = new Cliente();
        Empleado mozo = new Empleado();
        ProductoElaborado prodElab = new ProductoElaborado();
        ArrayList<DetalleFactura> detalleFacturaAGuardar = new ArrayList<>();

        /* VALIDACIONES */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;

        /* Me cercioro que el campo 'Número de factura' no está vacío */
//        if(jtfNumeroDeFactura.getText().equals(""))
//        {
//            mensajeDeError = mensajeDeError + "- El campo 'Número de factura' no "
//                    + "puede dejarse vacío.\n";
//            error = true;
//        }

        /* Valido que se hayan ingresado renglones a la factura */
        if(detalleFactura.isEmpty() == true)
        {
            mensajeDeError = mensajeDeError + "- Debe seleccionar alimentos.\n";
            error = true;
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
        /* GUARDAR FACTURA */
        else
        {
            // la doy de alta
            fac.setEstado(true);

            // le añado el mozo
            String mozoSeleccionado = jcbMozos.getSelectedItem().toString();
            int indGuion = mozoSeleccionado.indexOf("-");
            String idMozo = String.valueOf(mozoSeleccionado.substring(0, indGuion-1));
            mozo = gesEmp.buscarEmpleadoPorId(Integer.parseInt(idMozo));

            fac.setEmpleado(mozo);

            // le añado el tipo
            fac.setTipo(jcbTipo.getSelectedItem().toString());

            // le añado la fecha y la hora
            GregorianCalendar fechaDeLaFactura = new GregorianCalendar
                    (anioActual, mesActual, diaActual, horaActual, minutoActual);            
            fac.setFecha(fechaDeLaFactura);

            // le añado el cliente
            String clienteSeleccionado = jcbClientes.getSelectedItem().toString();
            indGuion = clienteSeleccionado.indexOf("-");
            String idCliente = String.valueOf(clienteSeleccionado.substring(0, indGuion-1));
            cli = gesCli.buscarPorId(Integer.parseInt(idCliente));

            fac.setCliente(cli);

            // le añado las condiciones de venta
            fac.setCondicionesDeVenta(jcbCondicionesDeVenta.getSelectedItem().toString());

            // le añado el número de factura
            String num = jlNumFac.getText();
            int n = Integer.parseInt(num);
            fac.setNumero(n);

            // le añado los detalles de factura
            for(DetalleFactura df : detalleFactura)
            {
                df.setId(null);
                detalleFacturaAGuardar.add(df);
            }

            fac.setListaDetalleFactura(detalleFacturaAGuardar);

            // le añado el importe total
            fac.setTotalGeneral(importeTotal);

            // guardo la factura en la base de datos
            gesFac.guardarOActualizar(fac);

            // guardo todos los detalles de factura en la base de datos
            for(DetalleFactura df : detalleFacturaAGuardar)
            {
                df.setFactura(fac);
                gesFac.guardarOActualizar(df);
            }

            // actualizo la lista de preferencias del cliente
            actualizarPreferencias(cli, detalleFacturaAGuardar);

            // vacío la tabla para poder agregar nuevas facturas
            vaciarTablaFacturando();

            // vacío el arreglo de detalles de facturas en orden de no traer
            // viejos renglones a nueva factura
            detalleFactura.clear();

            // muestro un mensaje
            jlMensaje.setVisible(true);
            jlMensaje.setText("La factura se ha guardado con éxito");

            // vuelvo a cargar todos los productos elaborados en el combo
            cbmAlimentos.removeAllElements();
            alimentosRenglones.clear();
            cargarProductosElaborados();
        }
    }//GEN-LAST:event_jbGuardarFacturaActionPerformed

    /**
     * Agrega un renglón al detalle de factura con el producto que deseemos.
     * 
     * @param evt el evento de pulsación sobre el botón 'Agregar renglón'
     */
    private void jbAgregarRenglonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarRenglonActionPerformed
        botonPresionado = "Agregar renglón";

        /* VALIDACIONES */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;

        if(jtfCantidad.equals(""))
        {
            error = true;
            mensajeDeError = mensajeDeError + "- Debe ingresar una cantidad de "
            + "alimentos.\n";
        }

        if(cbmAlimentos.getSize() == 0)
        {
            error = true;
            mensajeDeError = mensajeDeError + "- No hay alimentos por ingresar.";
        }

        /* Si existen errores, envío una notificación al usuario, caso contrario,
        * realizo la consulta solicitada */
        if(error == true)
        {
            JOptionPane.showMessageDialog(null,
                mensajeDeError,
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            /* AÑADIR RENGLÓN */
            calcular();

            importeTotal = 0;

            // obtengo el objeto 'producto elaborado'
            int indGuion = alimentoSeleccionado.indexOf("-");
            String idAlimento = String.valueOf(alimentoSeleccionado.substring(0, indGuion-1));
            ProductoElaborado ali = gesProdElab.buscarPorId(Integer.parseInt(idAlimento));

            // armo un renglón de la factura
            DetalleFactura renglon = new DetalleFactura();
            renglon.setId(idRenglon);
            renglon.setCantidad(cantidadRenglon);
            renglon.setProductoElaborado(ali);
            renglon.setPrecioUnitario(precioUnitario);
            renglon.setImporte(importeRenglon);

            // voy armando la factura
            detalleFactura.add(renglon);

            // obtengo el importe total de la factura
            for(DetalleFactura dt : detalleFactura)
            {
                importeTotal = importeTotal + dt.getImporte();
            }

            idRenglon++;

            // actualizo el campo informativo "Importe total"
            actualizarCampoImporteTotal();

            // actualizo la tabla que me muestra los ítems
            actualizarTablaFacturando();
        }
    }//GEN-LAST:event_jbAgregarRenglonActionPerformed

    /**
     * Permite que solamente se ingresen números y en un máximo de 10.
     * 
     * @param evt el evento de tipeo
     */          
    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        Campos.configurarCampo(evt, 10, "Números");
    }//GEN-LAST:event_jtfCantidadKeyTyped

    /**
     * Actualiza la tabla preferencias de la base de datos, teniendo en cuenta
     * el detalle de factura de esta factura, incrementando las comidas de este
     * usuario si existen, creándolas en caso contrario.
     * 
     * @param cli el cliente al cual se le está facturando
     * @param todosDetalles todos los renglones del detalle de factura de la
     * factura actual
     */
    private void actualizarPreferencias(Cliente cli, ArrayList<DetalleFactura> todosDetalles)
    {
        /* existen dos alternativas:
            - esta es la primera vez que se le factura a este cliente, por lo que
                hay que crear unos nuevos registros de preferencias,
            - o no es la primera, en cuyo caso hay que sumar los detalles factura
                de la factura actual a las preferencias.
        */
        // busco preferencias anteriores
        ArrayList<Preferencia> preferenciasActuales = new ArrayList<>();
        String hql = "FROM Preferencia P WHERE P.cliente.id = " + cli.getId();
        Query query = sesion.createQuery(hql);
        preferenciasActuales = (ArrayList<Preferencia>) query.list();
        
        // si esta es la primera vez que le facturamos al cliente
        if(preferenciasActuales.isEmpty() == true)
        {
            for(DetalleFactura d : todosDetalles)
            {
                Preferencia p = new Preferencia();
                
                p.setCliente(cli);
                p.setProductoElaborado(d.getProductoElaborado());
                p.setCantidadConsumiciones(1);
                
                gesPref.guardarOActualizar(p);
            }
        }
        // si ya le hemos facturado anteriormente, debo hacer lo siguiente:
        //      * mirar cada producto de la lista de detalles,
        //          - si ya está en la lista de preferencias, hay que añadirle
        //              una consumición más,
        //          - caso contrario, hay que agregarlo como preferencia nueva.
        else
        {
            for(DetalleFactura d : todosDetalles)
            {
                // el alimento del detalle factura es nuevo, no existe en la 
                // lista de preferencias
                boolean alimentoExistente = false; 
                String alimentoDet = d.getProductoElaborado().getNombre();
                
                // recorro toda la lista de preferencias para saber si el
                // alimento del detalle de factura existe entre las preferencias
                int i = 0; // para obtener posiciones del arreglo de preferencias
                int posArrPref = -1; // para guardar la posición del arreglo de preferencias en
                                     // en el que se encontró el alimento del detalle de factura
                for(Preferencia p : preferenciasActuales)
                {
                    String alimentoPref = p.getProductoElaborado().getNombre();
                    
                    if(alimentoDet.equals(alimentoPref))
                    {
                        alimentoExistente = true;
                        posArrPref = i;
                    }
                    i++;
                }
                
                // si el alimento que estamos mirando en el detalle de factura
                // existe entre las preferencias, incremento su cantidad de 
                // consumiciones en 1
                if(alimentoExistente == true)
                {
                    int cantCons = preferenciasActuales.get(posArrPref)
                                        .getCantidadConsumiciones();
                    cantCons++;
                    preferenciasActuales.get(posArrPref)
                                .setCantidadConsumiciones(cantCons);                        
                    
                    gesPref.guardarOActualizar(preferenciasActuales.get(posArrPref));                    
                }
                // si el alimento que estamos mirando en el detalle de factura
                // no existe entre las preferencias, guardo un nuevo registro
                // en la base de datos
                else
                {
                    Preferencia p = new Preferencia();

                    p.setCliente(cli);
                    p.setProductoElaborado(d.getProductoElaborado());
                    p.setCantidadConsumiciones(1);

                    gesPref.guardarOActualizar(p);                    
                }
            }
        }
    }
    
    
    /**
     * Calcula el importe de este renglón de alimentos, multiplicando el precio
     * del mismo por la cantidad consumida.
     */
    private void calcular()
    {        
        /* Validaciones */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        if(jtfCantidad.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe ingresar una cantidad.\n";
            error = true;
        }

        /* Si existen errores, envío una notificación al usuario */
        if(error == true)
        {
            JOptionPane.showMessageDialog(null,
                    mensajeDeError,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            obtenerCantidadyPrecioUnitario();            

            // coloco el precio unitario en la etiqueta correspondiente
            jlPrecioUnitarioRes.setText(precioUnitario.toString());
            jlPrecioUnitarioRes.setVisible(true);
            
            // calculo el importe
            importeRenglon = cantidadRenglon * precioUnitario;
            jlImporteRes.setText(importeRenglon.toString());
            jlImporteRes.setVisible(true);
        }        
    }
    
    /**
     * Obtiene la cantidad ingresada y el precio unitario del alimento.
     */
    private void obtenerCantidadyPrecioUnitario()
    {
        // obtengo la cantidad ingresada
        cantidadRenglon = Integer.parseInt(jtfCantidad.getText());

        // realizo diferentes cosas en función de si el usuario presionó el botón
        // "Calcular" o "Agregar renglón"
        if(botonPresionado.equals("Calcular"))
        {
            // obtengo el alimento seleccionado
            alimentoSeleccionado = String.valueOf(jcbAlimentos.getSelectedItem());
        }
        else if(botonPresionado.equals("Agregar renglón"))
        {
            // obtengo el alimento seleccionado
            alimentoSeleccionado = String.valueOf(jcbAlimentos.getSelectedItem());
            
            // lo elimino del modelo de combo. lo elimino del arreglo de alimentos,
            // y establezco el nuevo modelo al combo
            for(int i = 0 ; i < cbmAlimentos.getSize() ; i++)
            {
                if(alimentoSeleccionado.equals(cbmAlimentos.getElementAt(i)))
                {
                    cbmAlimentos.removeElementAt(i);
                    alimentosRenglones.remove(i);
                    
                    if(cbmAlimentos.getSize() > 0)
                    {
                        cbmAlimentos.setSelectedItem(cbmAlimentos.getElementAt(0));
                    }
                    
                    jcbAlimentos.setModel(cbmAlimentos);
                    break;
                }
            }
        }
        
        // obtengo el objeto 'producto elaborado' completo
        int indGuion = alimentoSeleccionado.indexOf("-");
        String idAlimento = String.valueOf(alimentoSeleccionado.substring(0, indGuion-1));
        ProductoElaborado ali = gesProdElab.buscarPorId(Integer.parseInt(idAlimento));

        // obtengo su precio
        precioUnitario = ali.getPrecio();    
    }    
    
    /**
     * Actualiza el campo 'Importe total' con la sumatoria de todos los importes
     * de todos los renglones.
     */
    public void actualizarCampoImporteTotal()
    {
        String impTot = Double.toString(importeTotal);
        jlImporteTotalRes.setVisible(true);
        jlImporteTotalRes.setText(impTot);
    }
    
    /**
     * Actualiza la tabla del detalle de factura.
     */
    public void actualizarTablaFacturando()
    {
        modeloDetFac = gesFac.configurarModeloFacturando(modeloDetFac,
                detalleFactura);
        jtProductosElaborados.setModel(modeloDetFac);
        jtProductosElaborados.getColumnModel().removeColumn(jtProductosElaborados.
                getColumnModel().getColumn(0));
    }  

    /**
     * Vacía la tabla del detalle de factura.
     */
    public void vaciarTablaFacturando()
    {
        ArrayList<DetalleFactura> vacio = new ArrayList<DetalleFactura>();
        modeloDetFac = gesFac.configurarModeloFacturando(modeloDetFac,
                                vacio);
        jtProductosElaborados.setModel(modeloDetFac);
        jtProductosElaborados.getColumnModel().removeColumn(jtProductosElaborados.
                getColumnModel().getColumn(0));
    }      
    
    /**
     * Proporciona el 'id' del renglón seleccionado.
     */
    public void obtenerRenglonSeleccionado()
    {
        idRenglonSel = -1;
        int fila = jtProductosElaborados.getSelectedRow();
        
        if(fila != -1) 
        {
            idRenglonSel = Integer.parseInt(String.valueOf(modeloDetFac.
                    getValueAt(fila, 0)));
        }        
    }       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAgregarRenglon;
    private javax.swing.JButton jbAnadirCliente;
    private javax.swing.JButton jbAnadirMozo;
    private javax.swing.JButton jbBorrarRenglon;
    private javax.swing.JButton jbCalcular;
    private javax.swing.JButton jbGuardarFactura;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcbAlimentos;
    private javax.swing.JComboBox jcbClientes;
    private javax.swing.JComboBox jcbCondicionesDeVenta;
    private javax.swing.JComboBox jcbMozos;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JLabel jlAlimento;
    private javax.swing.JLabel jlCantidad;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlCondicionesDeVenta;
    private javax.swing.JLabel jlFacturacion;
    private javax.swing.JLabel jlImporte;
    private javax.swing.JLabel jlImporteRes;
    private javax.swing.JLabel jlImporteTotal;
    private javax.swing.JLabel jlImporteTotalRes;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlMozo;
    private javax.swing.JLabel jlNumFac;
    private javax.swing.JLabel jlNumeroDeFactura;
    private javax.swing.JLabel jlPrecioUnitario;
    private javax.swing.JLabel jlPrecioUnitarioRes;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable jtProductosElaborados;
    private javax.swing.JTextField jtfCantidad;
    // End of variables declaration//GEN-END:variables
}
