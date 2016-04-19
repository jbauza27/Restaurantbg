package interfaz.cliente;

import entidad.AcontecimientoImportante;
import entidad.Cliente;
import entidad.Pais;
import entidad.Provincia;
import gestor.GestorAcontecimientosImportantes;
import gestor.GestorClientes;
import gestor.GestorPaises;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Fecha;


/**
 * El formulario para modificar un cliente.
 */
public class IntModificarCliente extends javax.swing.JDialog
{
    // una constante
    public static final int ANIOANUAL = AcontecimientoImportante.A_ANUAL;
    
    
    /* Atributos */
    private Session sesion;
    private Cliente cli;
    private GestorClientes gesCli;
    private GestorPaises gesPai;
    private GestorAcontecimientosImportantes gesAcoImp;
    private int id;
    private ArrayList<Provincia> listaProvincias;
    private ArrayList<AcontecimientoImportante> listaAcoImp;
    private static final String PATRON_DE_MAIL
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private GregorianCalendar fechaActual;
    private DefaultComboBoxModel cbmPais;
    private DefaultComboBoxModel cbmProvincia;
    private String dniActual;
        
    
    /* Constructor */
    public IntModificarCliente(java.awt.Frame parent, boolean modal, Session sesion,
            int idCliente)
    {
        super(parent, modal);
        initComponents();
                
        this.sesion = sesion;
        gesCli = new GestorClientes(sesion);
        gesPai = new GestorPaises(sesion);  
        gesAcoImp = new GestorAcontecimientosImportantes(sesion);
        id = idCliente;
        listaProvincias = new ArrayList<>();
        listaAcoImp = new ArrayList<>();
        fechaActual = new GregorianCalendar();
        cbmPais = new DefaultComboBoxModel();
        cbmProvincia = new DefaultComboBoxModel();
        
        cli = gesCli.buscarPorId(id);

        jtfNombre.setText(cli.getNombre());
        jtfApellido.setText(cli.getApellido());
        
        if(cli.getFechaDeNacimiento() != null)
        {
            Integer diaNac = cli.getFechaDeNacimiento().get(Calendar.DAY_OF_MONTH);
            String dn = diaNac.toString();
            jtfDia.setText(dn);
            Integer mesNac = cli.getFechaDeNacimiento().get(Calendar.MONTH)+1;
            String mn = mesNac.toString();
            jtfMes.setText(mn);
            Integer anioNac = cli.getFechaDeNacimiento().get(Calendar.YEAR);
            String an = anioNac.toString();        
            jtfAnio.setText(an);        
        }
        else
        {
            jtfDia.setText("");
            jtfMes.setText("");
            jtfAnio.setText("");
        }
        
        jtfTelefonoFijo.setText(cli.getTelefonoFijo());
        jtfTelefonoCelular.setText(cli.getTelefonoCelular());
        jtfDni.setText(cli.getDni());
        jtfEmail.setText(cli.getEmail());
        jtfCalle.setText(cli.getCalle());
        jtfLocalidad.setText(cli.getLocalidad());
        
        llenarModeloComboPais();
        llenarModeloComboProvincia();    
        
        String paisSeleccionado = cli.getPais().getNombrePais();
        cbmPais.setSelectedItem(paisSeleccionado);
        jcbPais.setModel(cbmPais);
        
        String provinciaSeleccionada = cli.getProvincia().getNombreProvincia();
        cbmProvincia.setSelectedItem(provinciaSeleccionada);
        jcbProvincia.setModel(cbmProvincia);
        
        dniActual = cli.getDni();
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlAltaDeCliente = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jlFechaDeNacimiento = new javax.swing.JLabel();
        jtfDia = new javax.swing.JTextField();
        jlBarra1 = new javax.swing.JLabel();
        jtfMes = new javax.swing.JTextField();
        jlBarra2 = new javax.swing.JLabel();
        jtfAnio = new javax.swing.JTextField();
        jlSexo = new javax.swing.JLabel();
        jcbSexo = new javax.swing.JComboBox();
        jlTelefonoFijo = new javax.swing.JLabel();
        jtfTelefonoFijo = new javax.swing.JTextField();
        jlTelefonoCelular = new javax.swing.JLabel();
        jtfTelefonoCelular = new javax.swing.JTextField();
        jlDni = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlCalle = new javax.swing.JLabel();
        jtfCalle = new javax.swing.JTextField();
        jlLocalidad = new javax.swing.JLabel();
        jtfLocalidad = new javax.swing.JTextField();
        jlDatosPersonales = new javax.swing.JLabel();
        jlDomicilio = new javax.swing.JLabel();
        jlProvincia = new javax.swing.JLabel();
        jcbProvincia = new javax.swing.JComboBox();
        jlPais = new javax.swing.JLabel();
        jcbPais = new javax.swing.JComboBox();
        jbModificar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jlNota = new javax.swing.JLabel();
        jlFormato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Modificación de cliente");

        jlAltaDeCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlAltaDeCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAltaDeCliente.setText("Modificación de cliente");

        jlNombre.setText("*Nombre:");

        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });

        jlApellido.setText("*Apellido:");

        jtfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfApellidoKeyTyped(evt);
            }
        });

        jlFechaDeNacimiento.setText("Fecha de nacimiento:");

        jtfDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaKeyTyped(evt);
            }
        });

        jlBarra1.setText("/");

        jtfMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesKeyTyped(evt);
            }
        });

        jlBarra2.setText("/");

        jtfAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioKeyTyped(evt);
            }
        });

        jlSexo.setText("*Sexo:");

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        jlTelefonoFijo.setText("Teléfono fijo:");

        jtfTelefonoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoFijoKeyTyped(evt);
            }
        });

        jlTelefonoCelular.setText("Teléfono celular:");

        jtfTelefonoCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoCelularKeyTyped(evt);
            }
        });

        jlDni.setText("*DNI:");

        jtfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDniKeyTyped(evt);
            }
        });

        jlEmail.setText("Email:");

        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEmailKeyTyped(evt);
            }
        });

        jlCalle.setText("Calle:");

        jtfCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCalleKeyTyped(evt);
            }
        });

        jlLocalidad.setText("Localidad:");

        jtfLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfLocalidadKeyTyped(evt);
            }
        });

        jlDatosPersonales.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDatosPersonales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatosPersonales.setText("Datos personales");

        jlDomicilio.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDomicilio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDomicilio.setText("Domicilio");

        jlProvincia.setText("*Provincia:");

        jlPais.setText("*País:");

        jcbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaisActionPerformed(evt);
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

        jlNota.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jlNota.setText("Nota: los campos marcados con asterisco son obligatorios");

        jlFormato.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jlFormato.setText("formato: dd/mm/aaaa - ejemplo: 12/12/1994");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlAltaDeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlFechaDeNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jlNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlBarra1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlBarra2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 103, Short.MAX_VALUE))
                            .addComponent(jlFormato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbModificar)
                .addGap(18, 18, 18)
                .addComponent(jbCancelar)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlCalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jlEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlTelefonoCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlTelefonoFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfTelefonoFijo)
                                        .addComponent(jtfTelefonoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addComponent(jlDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlNota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlAltaDeCliente)
                .addGap(18, 18, 18)
                .addComponent(jlDatosPersonales)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFechaDeNacimiento)
                    .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra1)
                    .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarra2)
                    .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jlFormato)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSexo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTelefonoFijo)
                    .addComponent(jtfTelefonoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTelefonoCelular)
                    .addComponent(jtfTelefonoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDni)
                    .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlDomicilio)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCalle)
                    .addComponent(jtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLocalidad)
                    .addComponent(jtfLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProvincia)
                    .addComponent(jcbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPais)
                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlNota)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar)
                    .addComponent(jbCancelar))
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
     * Crea el modelo del combo 'País'. 
     */
    private void llenarModeloComboPais()
    {       
        ArrayList<Pais> listaPaises = gesPai.getListaPaises();
                
        for(Pais pai : listaPaises)
        {            
            cbmPais.addElement(pai.getNombrePais());
        }       
    }
    
    /**
     * Crea el modelo del combo 'Provincia'.
     */
    private void llenarModeloComboProvincia()
    {
        String paisSeleccionado = cli.getPais().getNombrePais();
        String hql = "FROM Provincia P WHERE P.pais.nombrePais = '"
                + paisSeleccionado + "'";
        
        Query query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        
        for(Provincia pro : listaProvincias)
        {            
            cbmProvincia.addElement(pro.getNombreProvincia());
        }
    }

    /**
     * Llena el combo provincia con todas las provincias que se relacionan con el
     * país seleccionado en el combo país.
     */
    private void llenarComboProvincia()
    {
        jcbProvincia.removeAllItems();
        
        String paisSeleccionado = (String) jcbPais.getSelectedItem();
        String hql = "FROM Provincia P WHERE P.pais.nombrePais = '"
                + paisSeleccionado + "'";
        
        Query query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        
        for(Provincia pro : listaProvincias)
        {
            jcbProvincia.addItem(pro.getNombreProvincia());
        }
    }
    
    /**
     * Valida que el email ingresado por el usuario puede existir, teniendo en
     * cuenta cosas tales como la existencia del nombre del usuario, el arroba,
     * y el dominio.
     * 
     * @param email el mail que se comprobará
     * @return 'true' si puede existir, 'false' en caso contrario
     */
    public static boolean validarEmail(String email)
    { 
        // Compila la expresión regular recibida en un patrón
        Pattern patron = Pattern.compile(PATRON_DE_MAIL);
 
        // Compara la cadena de mail recibida contra este patrón
        Matcher matcher = patron.matcher(email);
        
        return matcher.matches(); 
    }
    
    /**
     * Cierra la ventana sin efectuar ninguna operación.
     * 
     * @param evt el evento de clic sobre el botón 'Cancelar'
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Modifica el cliente o notifica al usuario que hay algún error.
     * 
     * @param evt el evento de pulsación sobre el botón 'Modificar'
     */
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        /* VALIDACIONES */
        int diaNac = 0;
        int mesNac = 0;
        int anioNac = 0;
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        
        /* Me cercioro que los campos obligatorios no están vacíos */
        if(jtfNombre.getText().equals("")
                || jtfApellido.getText().equals("")
                || jtfDni.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar los campos marcados"
                    + " con asterisco.\n";
            error = true;
        }
        
        /* Valido que la fecha ingresada pueda existir */
        // si todos los campos están llenos, valido la fecha        
        boolean fechaValida = false;
        if( !(jtfDia.getText().equals(""))   &&
            !(jtfMes.getText().equals(""))   &&
            !(jtfAnio.getText().equals(""))
          )
        {
            Fecha fec = new Fecha();
            diaNac = Integer.parseInt(jtfDia.getText());
            mesNac = Integer.parseInt(jtfMes.getText());
            anioNac = Integer.parseInt(jtfAnio.getText());
        
            fechaValida = fec.validarFecha(anioNac, mesNac, diaNac);
        
            if(fechaValida == false)
            {
                mensajeDeError = mensajeDeError + "- La fecha ingresada no es"
                        + " correcta.\n"; 
                error = true;
            }            
        }        
        // si todos los campos están vacíos, no hago nada
        else if((jtfDia.getText().equals("")) &&
                (jtfMes.getText().equals("")) &&
                (jtfAnio.getText().equals(""))
                )
        {
            
        }
        // si algunos campos están llenos, envío un mensaje de error al usuario
        else
        {
            mensajeDeError = mensajeDeError + "- El campo fecha debe llenarse "
                + "totalmente o no llenarse, no puede llenarse en "
                + "formar parcial.\n";       
            error = true;
        }        
        
        /* Valido el email ingresado */
        if(!(jtfEmail.getText().equals("")))
        {
            String email = jtfEmail.getText();
            boolean eMailValido = validarEmail(email);
        
            if(eMailValido == false)
            {
                mensajeDeError = mensajeDeError + "- El email ingresado no es un email "
                        + "correcto.\n";
                error = true;
            }
        }

        /* Valido que la fecha de nacimiento ingresada no sea mayor a la actual */
        // si previamente hay errores, ni siquiera entro a realizar esta comparación
        if(fechaValida == true)
        {
            Fecha fec = new Fecha();
            diaNac = Integer.parseInt(jtfDia.getText());
            mesNac = Integer.parseInt(jtfMes.getText()) - 1;
            anioNac = Integer.parseInt(jtfAnio.getText());
            GregorianCalendar fechaDeNacimiento =
                    new GregorianCalendar(anioNac, mesNac, diaNac);
            
            int res = fec.comparacionDeFechas(fechaDeNacimiento, fechaActual);
            if(res == 0 || res == 1)
            {
                mensajeDeError = mensajeDeError + "- La fecha de nacimiento no puede "
                        + "ser ni igual ni mayor a la actual.\n";
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
        /* MODIFICACIÓN */
        else
        {
            // obteniendo al cliente
            gesCli = new GestorClientes(sesion);
            cli = gesCli.buscarPorId(id);

            // armando objeto 'Cliente'            
            cli.setNombre(jtfNombre.getText().trim());
            cli.setApellido(jtfApellido.getText().trim());
            
            // si se llenó la fecha la guardo en la base de datos, caso contrario
            // guardo 'null'
            GregorianCalendar fecNacActual = null;
            GregorianCalendar fecNacAnual = null;
            if(fechaValida == true)
            {
                fecNacActual = new GregorianCalendar(anioNac, mesNac, diaNac);
                fecNacAnual = new GregorianCalendar(ANIOANUAL, mesNac, diaNac);
            }            
            cli.setFechaDeNacimiento(fecNacActual);
            
            cli.setSexo((jcbSexo.getSelectedItem()).toString());
            cli.setTelefonoFijo(jtfTelefonoFijo.getText().trim());
            cli.setTelefonoCelular(jtfTelefonoCelular.getText().trim());
            cli.setDni(jtfDni.getText().trim());
            cli.setEmail(jtfEmail.getText().trim());
            cli.setCalle(jtfCalle.getText().trim());
            cli.setLocalidad(jtfLocalidad.getText().trim());
            
            ArrayList<Provincia> provinciaElegida = new ArrayList<>();
            String hql = "FROM Provincia P WHERE P.nombreProvincia LIKE '" 
                    + (jcbProvincia.getSelectedItem()).toString()
                    + "' AND P.pais.nombrePais LIKE '"
                    + (jcbPais.getSelectedItem()).toString()
                    + "'";
            Query query = sesion.createQuery(hql);
            provinciaElegida = (ArrayList<Provincia>) query.list();
            for(Provincia prov : provinciaElegida)
            {
                cli.setProvincia(prov);
            }        
            ArrayList<Pais> paisElegido = new ArrayList<>();
            hql = "FROM Pais P WHERE P.nombrePais LIKE '" 
                    + (jcbPais.getSelectedItem()).toString()
                    + "'";
            query = sesion.createQuery(hql);
            paisElegido = (ArrayList<Pais>) query.list();
            for(Pais pais : paisElegido)
            {
                cli.setPais(pais);
            }
            
            /* Comprobación de registros duplicados */
            ArrayList<Cliente> repetidos = new ArrayList<>();
            // si el usuario no cambió el dni del cliente, entonces no se
            // realiza la comprobación por registros duplicados
            if(jtfDni.getText().equals(dniActual))
            {
                
            }
            else
            {            
                // cerciorándome de que no haya en la base de datos otro cliente con
                // ese dni
                hql = "FROM Cliente C WHERE C.dni = " 
                        + jtfDni.getText();
                query = sesion.createQuery(hql);
                repetidos = (ArrayList<Cliente>) query.list();            
            }
            
            // si no se encontró ningún cliente con ese dni, entonces se puede
            // proceder con la modificación
            if(repetidos.isEmpty() == true)
            {
                // 'Acontecimiento importante'
                // aquí pueden pasar varias cosas:
                //      1- que el usuario no haya ingresado una fecha de nacimiento
                //          y que no exista un acontecimiento relacionado con nacimiento
                //      2- que el usuario no haya ingresado una fecha de nacimiento
                //          y que exista un acontecimiento relacionado con un nacimiento
                //      3- que el usuario haya ingresado una fecha de nacimiento
                //          y que no exista un acontecimiento relacionado con nacimiento
                //      4- que el usuario haya ingresado una fecha de nacimiento
                //          y que exista un acontecimiento relacionado con nacimiento
                int situacion = 0;

                // obtengo la lista de acontecimientos
                hql = "FROM AcontecimientoImportante AI WHERE AI.cliente.id = "
                        + cli.getId();
                query = sesion.createQuery(hql);
                listaAcoImp = (ArrayList<AcontecimientoImportante>) query.list();
                System.out.println(listaAcoImp);
                if(listaAcoImp.toString().equals("[]"))
                {
                    listaAcoImp = null;
                }
                AcontecimientoImportante acoImp = null;

                // recorro la lista de acontecimientos del cliente, buscando aquel
                // relacionado con el nacimiento
                if(listaAcoImp != null)
                {
                    for(AcontecimientoImportante ai : listaAcoImp)
                    {
                        if(ai.getAcontecimiento().equals("Nacimiento"))
                        {
                            acoImp = ai;
                        }
                    }
                }

                // Primer caso: que el usuario no haya ingresado una fecha de nacimiento
                //          y que no exista un acontecimiento relacionado con nacimiento
                // Resultado: no hago nada
                if(fecNacActual == null && acoImp == null)
                {
                    situacion = 1;
                }

                // Segundo caso: que el usuario no haya ingresado una fecha de nacimiento
                //          y que exista un acontecimiento relacionado con un nacimiento
                // Resultado: borro el acontecimiento importante
                if(fecNacActual == null && acoImp != null)
                {
                    situacion = 2;
                }

                // Tercer caso: que el usuario haya ingresado una fecha de nacimiento
                //          y que no exista un acontecimiento relacionado con nacimiento
                // Resultado: creo un acontecimiento importante nuevo
                if(fecNacActual != null && acoImp == null)
                {
                    situacion = 3;
                }

                // Cuarto caso: que el usuario haya ingresado una fecha de nacimiento
                //          y que exista un acontecimiento relacionado con nacimiento
                // Resultado: actualizo el acontecimiento importante
                if(fecNacActual != null && acoImp != null)
                {
                    situacion = 4;                
                }


                // guardando objetos en la base de datos
                gesCli.guardarOActualizar(cli);

                if(situacion == 1)
                {

                }
                else if(situacion == 2)
                {
                    gesAcoImp.eliminarEntidad(acoImp);
                }
                else if(situacion == 3)
                {
                    acoImp = new AcontecimientoImportante();
                    acoImp.setFechaUnica(fecNacActual);
                    acoImp.setFechaAnual(fecNacAnual);
                    acoImp.setAcontecimiento("Nacimiento");
                    acoImp.setTipo("Anual");
                    acoImp.setCliente(cli);
                    acoImp.setEmpleado(null); 

                    gesAcoImp.guardarOActualizar(acoImp);
                }         
                else if(situacion == 4)
                {
                    int idAcoImp = acoImp.getId();
                    acoImp = gesAcoImp.buscarPorId(idAcoImp);
                    acoImp.setFechaUnica(fecNacActual);
                    acoImp.setFechaAnual(fecNacAnual);                
                    acoImp.setAcontecimiento("Nacimiento");
                    acoImp.setTipo("Anual");
                    acoImp.setCliente(cli);
                    acoImp.setEmpleado(null);  

                    gesAcoImp.guardarOActualizar(acoImp);
                    
                    this.dispose();
                }
            }
            // caso contrario, muestro un mensaje de error
            else
            {
                JOptionPane.showMessageDialog(null,
                        "No puede realizar esta modificación porque el dni ingresado ya "
                                + "pertenece a otro cliente",
                        "DNI duplicado",
                        JOptionPane.ERROR_MESSAGE);                 
            }            
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    /**
     * Permite que solamente se ingresen letras y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */
    private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
        Campos.configurarCampo(evt, 30, "Cadena");
    }//GEN-LAST:event_jtfNombreKeyTyped

    /**
     * Permite que solamente se ingresen letras y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfApellidoKeyTyped
        Campos.configurarCampo(evt, 30, "Cadena");
    }//GEN-LAST:event_jtfApellidoKeyTyped

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

    /**
     * Permite que solamente se ingresen números y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfTelefonoFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoFijoKeyTyped
        Campos.configurarCampo(evt, 30, "Números");
    }//GEN-LAST:event_jtfTelefonoFijoKeyTyped

    /**
     * Permite que solamente se ingresen letras y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfTelefonoCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoCelularKeyTyped
        Campos.configurarCampo(evt, 30, "Números");
    }//GEN-LAST:event_jtfTelefonoCelularKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 8.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDniKeyTyped
        Campos.configurarCampo(evt, 8, "Números");
    }//GEN-LAST:event_jtfDniKeyTyped

    /**
     * Llena el combo provincia con todas las provincias almacenadas en la base
     * de datos y relacionadas con el país seleccionado.
     * 
     * @param evt el evento de clic sobre el combo 
     */    
    private void jcbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaisActionPerformed
        llenarComboProvincia();
    }//GEN-LAST:event_jcbPaisActionPerformed

    /**
     * Permite que se ingrese cualquier tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */          
    private void jtfCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCalleKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfCalleKeyTyped

    /**
     * Permite que se ingrese cualquier tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */          
    private void jtfLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLocalidadKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfLocalidadKeyTyped

    /**
     * Permite que se ingrese cualquier tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */     
    private void jtfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfEmailKeyTyped
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JComboBox jcbProvincia;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JLabel jlAltaDeCliente;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlBarra1;
    private javax.swing.JLabel jlBarra2;
    private javax.swing.JLabel jlCalle;
    private javax.swing.JLabel jlDatosPersonales;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlDomicilio;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFechaDeNacimiento;
    private javax.swing.JLabel jlFormato;
    private javax.swing.JLabel jlLocalidad;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNota;
    private javax.swing.JLabel jlPais;
    private javax.swing.JLabel jlProvincia;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlTelefonoCelular;
    private javax.swing.JLabel jlTelefonoFijo;
    private javax.swing.JTextField jtfAnio;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCalle;
    private javax.swing.JTextField jtfDia;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLocalidad;
    private javax.swing.JTextField jtfMes;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTelefonoCelular;
    private javax.swing.JTextField jtfTelefonoFijo;
    // End of variables declaration//GEN-END:variables
}
