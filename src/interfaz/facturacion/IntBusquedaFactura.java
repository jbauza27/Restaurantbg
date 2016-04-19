package interfaz.facturacion;

import entidad.Cliente;
import entidad.Empleado;
import entidad.Factura;
import gestor.GestorClientes;
import gestor.GestorEmpleados;
import gestor.GestorFacturacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Modelo;


/**
 * Permite buscar facturas que se correspondan con los criterios especificados.
 */
public class IntBusquedaFactura extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GestorFacturacion gesFac;
    private ArrayList<Factura> listaFacturas;
    private GestorClientes gesCli;
    private ArrayList<Cliente> listaClientes;
    private GestorEmpleados gesEmp;
    private ArrayList<Empleado> listaMozos;
    private int idFac;
    private Modelo modeloDetFac;
    
    // cadenas necesarias para realizar consultas hql
    private String estado;
    private String cliente;
    private String mozo;
    private String nroFactura;
    private String tipo;
    private String condVentas;
    private String diaExacto;
    private String mesExacto;
    private String anioExacto;
    private String diaDesde;
    private String mesDesde;
    private String anioDesde;
    private String diaHasta;
    private String mesHasta;
    private String anioHasta;
    
    
    /* Constructor */
    public IntBusquedaFactura(java.awt.Frame parent, boolean modal,
            Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesFac = new GestorFacturacion(sesion);
        listaFacturas = new ArrayList<>();
        gesCli = new GestorClientes(sesion);
        listaClientes = new ArrayList<>();
        gesEmp = new GestorEmpleados(sesion);
        listaMozos = new ArrayList<>();    
        
        jtfNroFactura.setEnabled(false);
        jtfDiaExacto.setEnabled(false);
        jtfMesExacto.setEnabled(false);
        jtfAnioExacto.setEnabled(false);
        jtfDiaDesde.setEnabled(false);
        jtfMesDesde.setEnabled(false);
        jtfAnioDesde.setEnabled(false);
        jtfDiaHasta.setEnabled(false);
        jtfMesHasta.setEnabled(false);
        jtfAnioHasta.setEnabled(false);
        
        // código para que la tabla aparezca inicialmente con los encabezados
        // de columna adecuados
        ArrayList<Factura> vacio = new ArrayList<>();
        modeloDetFac = gesFac.configurarModeloBusqueda(modeloDetFac,
                           vacio);
        jtResultados.setModel(modeloDetFac);
        jtResultados.getColumnModel().removeColumn(jtResultados.
               getColumnModel().getColumn(0));                    
        
        llenarComboClientes();
        llenarComboMozos();
    }    

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jlBusquedaDeFactura = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlResultados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtResultados = new javax.swing.JTable();
        jtfNroFactura = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbMostrarFactura = new javax.swing.JButton();
        jcbCondVentas = new javax.swing.JComboBox();
        jlEstado = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox();
        jcbTipo = new javax.swing.JComboBox();
        jCheckBoxCliente = new javax.swing.JCheckBox();
        jCheckBoxNroFactura = new javax.swing.JCheckBox();
        jCheckBoxCondVentas = new javax.swing.JCheckBox();
        jCheckBoxMozo = new javax.swing.JCheckBox();
        jCheckBoxTipo = new javax.swing.JCheckBox();
        jCheckBoxFechaExacta = new javax.swing.JCheckBox();
        jtfDiaExacto = new javax.swing.JTextField();
        jlBarra1 = new javax.swing.JLabel();
        jtfMesExacto = new javax.swing.JTextField();
        jlBarra2 = new javax.swing.JLabel();
        jtfAnioExacto = new javax.swing.JTextField();
        jCheckBoxPeriodo = new javax.swing.JCheckBox();
        jtfDiaDesde = new javax.swing.JTextField();
        jlBarra3 = new javax.swing.JLabel();
        jtfMesDesde = new javax.swing.JTextField();
        jlBarra4 = new javax.swing.JLabel();
        jtfAnioDesde = new javax.swing.JTextField();
        jtfDiaHasta = new javax.swing.JTextField();
        jlBarra5 = new javax.swing.JLabel();
        jtfMesHasta = new javax.swing.JTextField();
        jlBarra6 = new javax.swing.JLabel();
        jtfAnioHasta = new javax.swing.JTextField();
        jlFlecha = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jcbClientes = new javax.swing.JComboBox();
        jcbMozos = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Búsqueda de factura");

        jlBusquedaDeFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlBusquedaDeFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlBusquedaDeFactura.setText("Búsqueda de factura");

        jlResultados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlResultados.setText("Resultados");

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

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbMostrarFactura.setText("Mostrar factura");
        jbMostrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarFacturaActionPerformed(evt);
            }
        });

        jcbCondVentas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Cuenta corriente" }));

        jlEstado.setText("Estado:");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Baja", "Es indistinto" }));

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C" }));

        jCheckBoxCliente.setText("Cliente:");

        jCheckBoxNroFactura.setText("Número:");
        jCheckBoxNroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNroFacturaActionPerformed(evt);
            }
        });

        jCheckBoxCondVentas.setText("Condiciones de venta:");

        jCheckBoxMozo.setText("Mozo:");

        jCheckBoxTipo.setText("Tipo:");

        jCheckBoxFechaExacta.setText("Fecha exacta:");
        jCheckBoxFechaExacta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFechaExactaActionPerformed(evt);
            }
        });

        jtfDiaExacto.setText("dd");
        jtfDiaExacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaExactoKeyTyped(evt);
            }
        });

        jlBarra1.setText("/");

        jtfMesExacto.setText("mm");
        jtfMesExacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesExactoKeyTyped(evt);
            }
        });

        jlBarra2.setText("/");

        jtfAnioExacto.setText("aaaa");
        jtfAnioExacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioExactoKeyTyped(evt);
            }
        });

        jCheckBoxPeriodo.setText("Período:");
        jCheckBoxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPeriodoActionPerformed(evt);
            }
        });

        jtfDiaDesde.setText("dd");
        jtfDiaDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaDesdeKeyTyped(evt);
            }
        });

        jlBarra3.setText("/");

        jtfMesDesde.setText("mm");
        jtfMesDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesDesdeKeyTyped(evt);
            }
        });

        jlBarra4.setText("/");

        jtfAnioDesde.setText("aaaa");
        jtfAnioDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioDesdeKeyTyped(evt);
            }
        });

        jtfDiaHasta.setText("dd");
        jtfDiaHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaHastaKeyTyped(evt);
            }
        });

        jlBarra5.setText("/");

        jtfMesHasta.setText("mm");
        jtfMesHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesHastaKeyTyped(evt);
            }
        });

        jlBarra6.setText("/");

        jtfAnioHasta.setText("aaaa");
        jtfAnioHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioHastaKeyTyped(evt);
            }
        });

        jlFlecha.setText("->");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlBusquedaDeFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jlResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBoxNroFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBoxCondVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBoxFechaExacta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbCondVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(jtfDiaExacto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlBarra1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtfMesExacto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlBarra2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtfAnioExacto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtfNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jCheckBoxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jCheckBoxMozo, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(jlFlecha)
                                                .addGap(46, 46, 46)))
                                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                                .addComponent(jtfDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlBarra5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtfMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlBarra6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jtfAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jcbMozos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jCheckBoxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlBarra3)
                                .addGap(18, 18, 18)
                                .addComponent(jtfMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlBarra4)
                                .addGap(18, 18, 18)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                                        .addComponent(jbBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbCancelar)))))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbMostrarFactura)
                .addGap(325, 325, 325))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jlBusquedaDeFactura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jlEstado)
                                .addGap(13, 13, 13)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBoxCliente)
                                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jCheckBoxNroFactura))
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBoxMozo)
                                    .addComponent(jcbMozos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxTipo)
                                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbCondVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBoxCondVentas))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxFechaExacta))
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfDiaExacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlBarra1)
                        .addComponent(jtfMesExacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlBarra2)
                        .addComponent(jtfAnioExacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPeriodo)
                    .addComponent(jtfDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra3)
                    .addComponent(jtfMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra4)
                    .addComponent(jtfAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra5)
                    .addComponent(jtfMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra6)
                    .addComponent(jtfAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFlecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar)
                    .addComponent(jbCancelar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbMostrarFactura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Llena el combo 'Clientes' con todos los clientes que se hallen en la base
     * de datos.
     */
    private void llenarComboClientes()
    {
        listaClientes = gesCli.getListaClientes();
                
        for(Cliente cli : listaClientes)
        {
            jcbClientes.addItem(cli.getId() + " - " + cli.getApellido() 
                    + " " + cli.getNombre());            
        }        
    }
    
    /**
     * Llena el combo 'Mozos' con todos los empleados que se hallen en la base
     * de datos cuo cargo sea 'mozo'.
     */
    private void llenarComboMozos()
    {
        listaMozos = gesEmp.getListaMozosActivos();
        
        for(Empleado mozo : listaMozos)
        {
            jcbMozos.addItem(mozo.getId() + " - " + mozo.getApellido()
                    + " " + mozo.getNombre());
        }
    }
    /**
     * Busca las facturas que se correspondan con los criterios especificados.
     * 
     * @param evt el evento de pulsación sobre el botón 'Buscar'
     */
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        boolean error = false;
        String mensajeDeError = "Se han producido los siguientes errores: \n\n";
        
        /* Capturando lo ingresado por el usuario */
        estado = jcbEstado.getSelectedItem().toString();        
        cliente = jcbClientes.getSelectedItem().toString();
        mozo = jcbMozos.getSelectedItem().toString();
        nroFactura = "";
        if(jtfNroFactura.isEnabled() == true)
        {
            nroFactura = jtfNroFactura.getText();
        }
        tipo = jcbTipo.getSelectedItem().toString();
        condVentas = jcbCondVentas.getSelectedItem().toString();
        diaExacto = "";
        if(jtfDiaExacto.isEnabled() == true)
        {
            diaExacto = jtfDiaExacto.getText();
        }
        mesExacto = "";
        if(jtfMesExacto.isEnabled() == true)
        {
            mesExacto = jtfMesExacto.getText();
        }
        anioExacto = "";
        if(jtfDiaExacto.isEnabled() == true)
        {
            anioExacto = jtfAnioExacto.getText();
        }
        diaDesde = "";
        if(jtfDiaDesde.isEnabled() == true)
        {
            diaDesde = jtfDiaDesde.getText();
        }
        mesDesde = "";
        if(jtfMesDesde.isEnabled() == true)
        {
            mesDesde = jtfMesDesde.getText();
        }
        anioDesde = "";
        if(jtfAnioDesde.isEnabled() == true)
        {
            anioDesde = jtfAnioDesde.getText();
        }
        diaHasta = "";
        if(jtfDiaHasta.isEnabled() == true)
        {
            diaHasta = jtfDiaHasta.getText();
        }
        mesHasta = "";
        if(jtfMesHasta.isEnabled() == true)
        {
            mesHasta = jtfMesHasta.getText();
        }
        anioHasta = "";
        if(jtfAnioHasta.isEnabled() == true)
        {
            anioHasta = jtfAnioHasta.getText();
        }        


        /* Comprobación de posibles errores */
        if(jCheckBoxNroFactura.isSelected() == true && jtfNroFactura.getText().equals(""))
        {
            error = true;
            mensajeDeError = mensajeDeError
                    + "el campo 'Número de factura' ha sido seleccionado como criterio de "
                    + "búsqueda y sin embargo está vacío.\n";
        }
        if(jCheckBoxFechaExacta.isSelected() == true    && 
                (jtfDiaExacto.getText().equals("")      ||
                 jtfMesExacto.getText().equals("")      ||
                 jtfAnioExacto.getText().equals("")     ||
                 jtfDiaExacto.getText().equals("d")     ||
                 jtfMesExacto.getText().equals("m")     ||
                 jtfAnioExacto.getText().equals("a")    ||
                 jtfDiaExacto.getText().equals("dd")    ||
                 jtfMesExacto.getText().equals("mm")    ||
                 jtfAnioExacto.getText().equals("aa")   ||                
                 jtfAnioExacto.getText().equals("aaa")  ||                
                 jtfAnioExacto.getText().equals("aaaa")                
                )
          )
        {
            error = true;
            mensajeDeError = mensajeDeError
                    + "el campo 'Fecha exacta' ha sido seleccionado como criterio de "
                    + "búsqueda y sin embargo está vacío o contiene valores "
                    + "incorrectos.\n";
        }
        
        if(jCheckBoxPeriodo.isSelected() == true       && 
                (jtfDiaDesde.getText().equals("")      ||
                 jtfMesDesde.getText().equals("")      ||
                 jtfAnioDesde.getText().equals("")     ||
                 jtfDiaDesde.getText().equals("d")     ||
                 jtfMesDesde.getText().equals("m")     ||
                 jtfAnioDesde.getText().equals("a")    ||
                 jtfDiaDesde.getText().equals("dd")    ||
                 jtfMesDesde.getText().equals("mm")    ||
                 jtfAnioDesde.getText().equals("aa")   ||                
                 jtfAnioDesde.getText().equals("aaa")  ||                
                 jtfAnioDesde.getText().equals("aaaa") ||
                 jtfDiaHasta.getText().equals("")      ||
                 jtfMesHasta.getText().equals("")      ||
                 jtfAnioHasta.getText().equals("")     ||
                 jtfDiaHasta.getText().equals("d")     ||
                 jtfMesHasta.getText().equals("m")     ||
                 jtfAnioHasta.getText().equals("a")    ||
                 jtfDiaHasta.getText().equals("dd")    ||
                 jtfMesHasta.getText().equals("mm")    ||
                 jtfAnioHasta.getText().equals("aa")   ||                
                 jtfAnioHasta.getText().equals("aaa")  ||                
                 jtfAnioHasta.getText().equals("aaaa")                                
                )
          )
        {
            error = true;
            mensajeDeError = mensajeDeError
                    + "el campo 'Período' ha sido seleccionado como criterio de "
                    + "búsqueda y sin embargo está vacío o contiene valores "
                    + "incorrectos.\n";
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
            /* CONSULTA */
            String sentenciaHQL = "";            
            int cantOpSel = 0;
            ArrayList<String> opSel = new ArrayList<>();
            
            cantOpSel++;
            opSel.add("estado");
            
            if(jCheckBoxCliente.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("cliente");
            }
            if(jCheckBoxMozo.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("mozo");
            }    
            if(jCheckBoxNroFactura.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("nroFactura");
            }       
            if(jCheckBoxTipo.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("tipo");
            }            
            if(jCheckBoxCondVentas.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("condVentas");
            }            
            if(jCheckBoxFechaExacta.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("fechaExacta");
            }            
            if(jCheckBoxPeriodo.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("periodo");
            }     
            
            sentenciaHQL = prepararSentenciaHQL(opSel, cantOpSel);
            
            Query query = sesion.createQuery(sentenciaHQL);
            listaFacturas = (ArrayList<Factura>) query.list();
            
            // el listado de las facturas que coinciden con la búsqueda
            modeloDetFac = gesFac.configurarModeloBusqueda(modeloDetFac,
                                listaFacturas);
            jtResultados.setModel(modeloDetFac);
            jtResultados.getColumnModel().removeColumn(jtResultados.
                    getColumnModel().getColumn(0));            
        }    
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * Teniendo en cuenta los criterios seleccionados y sus correspondientes
     * valores, prepara la sentencia HQL que se utilizará para traer las facturas
     * deseadas.
     * 
     * @param opSel los criterios seleccionados
     * @param cantOpSel la cantidad de criterios seleccionados
     * @return la sentencia HQL lista para ser utilizada para efectuar la
     * consulta
     */
    private String prepararSentenciaHQL(ArrayList<String> opSel, int cantOpSel)
    {        
        String hql;        
        
        if(estado.equals("Es indistinto")
                && jCheckBoxCliente.isSelected()     == false
                && jCheckBoxMozo.isSelected()        == false
                && jCheckBoxNroFactura.isSelected()  == false 
                && jCheckBoxTipo.isSelected()        == false
                && jCheckBoxCondVentas.isSelected()  == false
                && jCheckBoxFechaExacta.isSelected() == false
                && jCheckBoxPeriodo.isSelected()     == false
          )
        {
            hql = "FROM Factura F";
        }
        else
        {
            hql = "FROM Factura F WHERE ";
            
            for(int i = 0 ; i < cantOpSel ; i++)
            {
                String opActual = opSel.get(i);

                if(opActual.equals("estado"))
                {
                    hql = hql + sentenciaEstado();
                }
                else if(opActual.equals("cliente"))
                {
                    hql = hql + sentenciaCliente();
                }
                else if(opActual.equals("mozo"))
                {
                    hql = hql + sentenciaMozo();
                }
                else if(opActual.equals("nroFactura"))
                {
                    hql = hql + sentenciaNroFactura();
                }
                else if(opActual.equals("tipo"))
                {
                    hql = hql + sentenciaTipo();
                }
                else if(opActual.equals("condVentas"))
                {
                    hql = hql + sentenciaCondVentas();
                }
                else if(opActual.equals("fechaExacta"))
                {
                    hql = hql + sentenciaFechaExacta();
                }
                else if(opActual.equals("periodo"))
                {
                    hql = hql + sentenciaPeriodo();
                }

                if(i < cantOpSel-1)
                {
                    if((i == 0 && estado.equals("Es indistinto")) &&
                            (jCheckBoxCliente.isSelected()     == true ||
                            jCheckBoxMozo.isSelected()        == true ||
                            jCheckBoxNroFactura.isSelected()  == true ||
                            jCheckBoxTipo.isSelected()        == true ||
                            jCheckBoxCondVentas.isSelected()  == true ||
                            jCheckBoxFechaExacta.isSelected() == true ||
                            jCheckBoxPeriodo.isSelected()     == true)
                        )
                    {
                        hql = hql + "";
                    }
                    else
                    {
                        hql = hql + " AND ";
                    }
                }
                else
                {
                    // nada
                }
            }
        }
        return hql;
    }
    
    /**
     * Prepara la parte de la sentencia relacionada con el estado de la factura.
     * 
     * @return la parte de la sentencia relacionada con el estado de la factura
     */
    private String sentenciaEstado()
    {
        String hql = "";
        if(estado.equals("Alta"))
        {    
            hql = "F.estado = true";
        }
        else if(estado.equals("Baja"))
        {
            hql = "F.estado = false";
        }
        else if(estado.equals("Es indistinto"))
        {
            hql = "";
        }
        
        return hql;
    }    

    /**
     * Prepara la parte de la sentencia relacionada con el cliente.
     * 
     * @return la parte de la sentencia relacionada con el cliente
     */    
    private String sentenciaCliente()
    {
        // obtengo el id de cliente que está en el combo
        String clienteSeleccionado = jcbClientes.getSelectedItem().toString();
        int indGuion = clienteSeleccionado.indexOf("-");
        String idCliente = String.valueOf(clienteSeleccionado.substring(0, indGuion-1));
        
        String hql = "F.cliente.id = " + idCliente;
        
        return hql;    
    }    

    /**
     * Prepara la parte de la sentencia relacionada con el mozo
     * 
     * @return la parte de la sentencia relacionada con el mozo
     */        
    private String sentenciaMozo()
    {
        // obtengo el del mozo que está en el combo
        String mozoSeleccionado = jcbMozos.getSelectedItem().toString();
        int indGuion = mozoSeleccionado.indexOf("-");
        String idMozo = String.valueOf(mozoSeleccionado.substring(0, indGuion-1));
        
        String hql = "F.mozo.id = " + idMozo;

        return hql;    
    }

    /**
     * Prepara la parte de la sentencia relacionada con el número de factura.
     * 
     * @return la parte de la sentencia relacionada con el número de factura
     */        
    private String sentenciaNroFactura()
    {
        String hql = "F.numero = " + nroFactura;
        
        return hql;
    }

    /**
     * Prepara la parte de la sentencia relacionada con el tipo de factura.
     * 
     * @return la parte de la sentencia relacionada con el tipo de factura
     */        
    private String sentenciaTipo()
    {
        String hql = "F.tipo = '" + tipo + "'";
        
        return hql;
    }

    /**
     * Prepara la parte de la sentencia relacionada con las condiciones de venta.
     * 
     * @return la parte de la sentencia relacionada con las condiciones de ventas
     */        
    private String sentenciaCondVentas()
    {
        String hql = "F.condicionesDeVenta = '" + condVentas + "'";
        
        return hql;
    }

    /**
     * Prepara la parte de la sentencia relacionada con la fecha de la factura.
     * 
     * @return la parte de la sentencia relacionada con la fecha de la factura
     */        
    private String sentenciaFechaExacta()
    {
        String hql = "F.fecha = '" + anioExacto
                    + "-" + mesExacto
                    + "-" + diaExacto + "'";
        
        return hql;
    }

    /**
     * Prepara la parte de la sentencia relacionada con la fecha de la factura.
     * 
     * @return la parte de la sentencia relacionada con la fecha de la factura
     */            
    private String sentenciaPeriodo()
    {
        String hql = "F.fecha BETWEEN '" + anioDesde
                    + "-" + mesDesde
                    + "-" + diaDesde
                    + "' AND '" + anioHasta
                    + "-" + mesHasta
                    + "-" + diaHasta + "'";
        
        return hql;
    }    
    
    /**
     * Muestra la factura seleccionada con todos los detalles
     * 
     * @param evt el evento de pulsación sobre el botón 'Mostrar factura'
     */
    private void jbMostrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarFacturaActionPerformed
        obtenerIdFacturaSeleccionada();
        
        if(idFac == -1)
        {
            JOptionPane.showMessageDialog(null,
                "Debe seleccionar una factura de la lista",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            IntMostrarFactura intMostFac = new IntMostrarFactura(null, true, sesion,
                    idFac);
            intMostFac.setVisible(true);
        }
    }//GEN-LAST:event_jbMostrarFacturaActionPerformed

    /**
     * Al seleccionarse el checkbox 'Número', se activa su campo de texto. Por el
     * contrario, si se desselecciona, se desactiva dicho campo de texto.
     * 
     * @param evt el evento de pulsación sobre el checkbox 'Número'
     */
    private void jCheckBoxNroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNroFacturaActionPerformed
        if(jCheckBoxNroFactura.isSelected() == true)
        {
            jtfNroFactura.setEnabled(true);
        }
        else
        {
            jtfNroFactura.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxNroFacturaActionPerformed

    /**
     * Al seleccionarse el checkbox 'Fecha exacta', se activan sus campos de
     * texto y se desactivan los de 'Período'.
     * <br>Al deseleccionarse, se desactivan sus campos de texto.
     * 
     * @param evt el evento de pulsación sobre el checkbox 'Fecha exacta'
     */    
    private void jCheckBoxFechaExactaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxFechaExactaActionPerformed
        if(jCheckBoxFechaExacta.isSelected() == true)
        {
            jtfDiaExacto.setEnabled(true);
            jtfMesExacto.setEnabled(true);
            jtfAnioExacto.setEnabled(true);
            
            jCheckBoxPeriodo.setSelected(false);
            jtfDiaDesde.setEnabled(false);
            jtfMesDesde.setEnabled(false);
            jtfAnioDesde.setEnabled(false);
            jtfDiaHasta.setEnabled(false);
            jtfMesHasta.setEnabled(false);
            jtfAnioHasta.setEnabled(false);
        }
        else
        {
            jtfDiaExacto.setEnabled(false);
            jtfMesExacto.setEnabled(false);
            jtfAnioExacto.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxFechaExactaActionPerformed

    /**
     * Al seleccionarse el checkbox 'Período', se activan sus campos de
     * texto y se desactivan los de 'Fecha exacta'.
     * <br>Al deseleccionarse, se desactivan sus campos de texto.
     * 
     * @param evt el evento de pulsación sobre el checkbox 'Período'
     */        
    private void jCheckBoxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPeriodoActionPerformed
        if(jCheckBoxPeriodo.isSelected() == true)
        {
            jtfDiaDesde.setEnabled(true);
            jtfMesDesde.setEnabled(true);
            jtfAnioDesde.setEnabled(true);
            jtfDiaHasta.setEnabled(true);
            jtfMesHasta.setEnabled(true);
            jtfAnioHasta.setEnabled(true);
            
            jCheckBoxFechaExacta.setSelected(false);            
            jtfDiaExacto.setEnabled(false);
            jtfMesExacto.setEnabled(false);
            jtfAnioExacto.setEnabled(false);
        }
        else
        {
            jtfDiaDesde.setEnabled(false);
            jtfMesDesde.setEnabled(false);
            jtfAnioDesde.setEnabled(false);
            jtfDiaHasta.setEnabled(false);
            jtfMesHasta.setEnabled(false);
            jtfAnioHasta.setEnabled(false);
        }        
    }//GEN-LAST:event_jCheckBoxPeriodoActionPerformed

    /**
     * Cierra la ventana.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cancelar'
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfDiaExactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaExactoKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfDiaExactoKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfMesExactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesExactoKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfMesExactoKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 4.
     * 
     * @param evt el evento de tipeo
     */       
    private void jtfAnioExactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnioExactoKeyTyped
        Campos.configurarCampo(evt, 4, "Números");
    }//GEN-LAST:event_jtfAnioExactoKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfDiaDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaDesdeKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfDiaDesdeKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfMesDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesDesdeKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfMesDesdeKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 4.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfAnioDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnioDesdeKeyTyped
        Campos.configurarCampo(evt, 4, "Números");
    }//GEN-LAST:event_jtfAnioDesdeKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfDiaHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDiaHastaKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfDiaHastaKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 2.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfMesHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMesHastaKeyTyped
        Campos.configurarCampo(evt, 2, "Números");
    }//GEN-LAST:event_jtfMesHastaKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 4.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfAnioHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnioHastaKeyTyped
        Campos.configurarCampo(evt, 4, "Números");
    }//GEN-LAST:event_jtfAnioHastaKeyTyped
 
    /**
     * Cuando se selecciona una factura en la tabla, cambia el valor de la
     * variable 'idFac' por el valor del 'id' de la factura seleccionada.
     */        
    public void obtenerIdFacturaSeleccionada()
    {
        idFac = -1;
        int fila = jtResultados.getSelectedRow();
        
        if(fila != -1) 
        {
            idFac = Integer.parseInt(String.valueOf(modeloDetFac.
                    getValueAt(fila, 0)));
        }        
    }   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxCliente;
    private javax.swing.JCheckBox jCheckBoxCondVentas;
    private javax.swing.JCheckBox jCheckBoxFechaExacta;
    private javax.swing.JCheckBox jCheckBoxMozo;
    private javax.swing.JCheckBox jCheckBoxNroFactura;
    private javax.swing.JCheckBox jCheckBoxPeriodo;
    private javax.swing.JCheckBox jCheckBoxTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbMostrarFactura;
    private javax.swing.JComboBox jcbClientes;
    private javax.swing.JComboBox jcbCondVentas;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbMozos;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JLabel jlBarra1;
    private javax.swing.JLabel jlBarra2;
    private javax.swing.JLabel jlBarra3;
    private javax.swing.JLabel jlBarra4;
    private javax.swing.JLabel jlBarra5;
    private javax.swing.JLabel jlBarra6;
    private javax.swing.JLabel jlBusquedaDeFactura;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlFlecha;
    private javax.swing.JLabel jlResultados;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable jtResultados;
    private javax.swing.JTextField jtfAnioDesde;
    private javax.swing.JTextField jtfAnioExacto;
    private javax.swing.JTextField jtfAnioHasta;
    private javax.swing.JTextField jtfDiaDesde;
    private javax.swing.JTextField jtfDiaExacto;
    private javax.swing.JTextField jtfDiaHasta;
    private javax.swing.JTextField jtfMesDesde;
    private javax.swing.JTextField jtfMesExacto;
    private javax.swing.JTextField jtfMesHasta;
    private javax.swing.JTextField jtfNroFactura;
    // End of variables declaration//GEN-END:variables
}
