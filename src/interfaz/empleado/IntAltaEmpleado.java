package interfaz.empleado;

import entidad.AcontecimientoImportante;
import entidad.Cargo;
import entidad.Empleado;
import entidad.HorariosDeTrabajo;
import entidad.Pais;
import entidad.Provincia;
import gestor.GestorAcontecimientosImportantes;
import gestor.GestorCargos;
import gestor.GestorEmpleados;
import gestor.GestorPaises;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Fecha;


/**
 * Formulario para dar de alta a un empleado.
 */
public class IntAltaEmpleado extends javax.swing.JDialog
{
    // una constante
    public static final int ANIOANUAL = AcontecimientoImportante.A_ANUAL;
    
    
    /* Atributos */
    private Session sesion;
    private GestorAcontecimientosImportantes gesAcoImp;
    private GestorEmpleados gesEmp;
    private GestorPaises gesPai;
    private GestorCargos gesCar;
    private ArrayList<Provincia> listaProvincias;
    private ArrayList<Cargo> listaCargos;
    private ArrayList<AcontecimientoImportante> listaAcoImp;
    private ArrayList<HorariosDeTrabajo> listaHorTrab;    
    private static final String PATRON_DE_MAIL
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private GregorianCalendar fechaActual;
    
    
    /* Constructor */
    public IntAltaEmpleado(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
                
        this.sesion = sesion;
        jlMensaje.setVisible(false);
        gesAcoImp = new GestorAcontecimientosImportantes(sesion);
        gesEmp = new GestorEmpleados(sesion);
        gesPai = new GestorPaises(sesion);  
        gesCar = new GestorCargos(sesion);
        listaProvincias = new ArrayList<>();
        listaAcoImp = new ArrayList<>();
        listaHorTrab = new ArrayList<>();
        fechaActual = new GregorianCalendar();
        
        llenarComboPais();
        llenarComboProvincia();
        llenarComboCargo();
        cambiarDescripcion();
    }

    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlAltaDeEmpleado = new javax.swing.JLabel();
        jlDatosPersonales = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jlFechaDeNacimiento = new javax.swing.JLabel();
        jtfDia = new javax.swing.JTextField();
        jlBarraUno = new javax.swing.JLabel();
        jtfMes = new javax.swing.JTextField();
        jlBarraDos = new javax.swing.JLabel();
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
        jlDomicilio = new javax.swing.JLabel();
        jlCalle = new javax.swing.JLabel();
        jtfCalle = new javax.swing.JTextField();
        jlLocalidad = new javax.swing.JLabel();
        jtfLocalidad = new javax.swing.JTextField();
        jlProvincia = new javax.swing.JLabel();
        jcbProvincia = new javax.swing.JComboBox();
        jlPais = new javax.swing.JLabel();
        jcbPais = new javax.swing.JComboBox();
        jlSueldoBruto = new javax.swing.JLabel();
        jtfSueldoBruto = new javax.swing.JTextField();
        jlCargo = new javax.swing.JLabel();
        jcbCargo = new javax.swing.JComboBox();
        jlDescripcion = new javax.swing.JLabel();
        jlDescripcionCargo = new javax.swing.JLabel();
        jbDarDeAlta = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlMensaje = new javax.swing.JLabel();
        jlEmpleo = new javax.swing.JLabel();
        jbGestionarHorariosDeTrabajo = new javax.swing.JButton();
        jlNota = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Alta de empleado");

        jlAltaDeEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlAltaDeEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAltaDeEmpleado.setText("Alta de empleado");

        jlDatosPersonales.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDatosPersonales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatosPersonales.setText("Datos personales");

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

        jlFechaDeNacimiento.setText("*Fecha de nacimiento:");

        jtfDia.setText("dd");
        jtfDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaKeyTyped(evt);
            }
        });

        jlBarraUno.setText("/");

        jtfMes.setText("mm");
        jtfMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesKeyTyped(evt);
            }
        });

        jlBarraDos.setText("/");

        jtfAnio.setText("aaaa");
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

        jlEmail.setText("*Email:");

        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEmailKeyTyped(evt);
            }
        });

        jlDomicilio.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDomicilio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDomicilio.setText("Domicilio");

        jlCalle.setText("*Calle:");

        jtfCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCalleKeyTyped(evt);
            }
        });

        jlLocalidad.setText("*Localidad:");

        jtfLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfLocalidadKeyTyped(evt);
            }
        });

        jlProvincia.setText("*Provincia:");

        jlPais.setText("*País:");

        jcbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaisActionPerformed(evt);
            }
        });

        jlSueldoBruto.setText("*Sueldo bruto:");

        jtfSueldoBruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSueldoBrutoKeyTyped(evt);
            }
        });

        jlCargo.setText("*Cargo:");

        jcbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCargoActionPerformed(evt);
            }
        });

        jlDescripcion.setText("Descripción:");

        jlDescripcionCargo.setText("descripcion_cargo");

        jbDarDeAlta.setText("Dar de alta");
        jbDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeAltaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMensaje.setText("Mensaje");

        jlEmpleo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlEmpleo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEmpleo.setText("Empleo");

        jbGestionarHorariosDeTrabajo.setText("Gestionar horarios de trabajo");
        jbGestionarHorariosDeTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGestionarHorariosDeTrabajoActionPerformed(evt);
            }
        });

        jlNota.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jlNota.setText("Nota: los campos marcados con asterisco son obligatorios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlAltaDeEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(409, 409, 409)
                                .addComponent(jlDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jlApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jlEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jlDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jlTelefonoCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jlTelefonoFijo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jlSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jlFechaDeNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jtfTelefonoCelular, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jtfTelefonoFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jlBarraUno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jlBarraDos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jlEmpleo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jlPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlLocalidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlCalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(jcbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfCalle)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jlDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlCargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jlSueldoBruto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jtfSueldoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jbGestionarHorariosDeTrabajo))
                                            .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlDescripcionCargo)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbDarDeAlta)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbSalir)
                                        .addGap(172, 172, 172)))))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNota)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlAltaDeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatosPersonales)
                    .addComponent(jlDomicilio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCalle)
                            .addComponent(jtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLocalidad)
                            .addComponent(jtfLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlProvincia)
                            .addComponent(jcbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPais)
                            .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlNombre)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlApellido))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFechaDeNacimiento)
                            .addComponent(jtfDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlBarraUno)
                            .addComponent(jtfMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlBarraDos)
                            .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSexo)
                            .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTelefonoFijo)
                            .addComponent(jtfTelefonoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTelefonoCelular)
                            .addComponent(jtfTelefonoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDni)
                            .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEmail)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addComponent(jlEmpleo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSueldoBruto)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfSueldoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbGestionarHorariosDeTrabajo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCargo)
                    .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDescripcion)
                    .addComponent(jlDescripcionCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbSalir))
                .addGap(11, 11, 11)
                .addComponent(jlNota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlMensaje)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
     * Da de alta a un empleado que contiene todos los datos ingresados.
     * 
     * @param evt el evento de pulsación del botón 'Dar de alta'
     */
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        /* VALIDACIONES */
        int diaNac = 0;
        int mesNac = 0;
        int anioNac = 0;
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        
        /* Me cercioro que no hay campos vacíos */
        if(jtfNombre.getText().equals("") || jtfApellido.getText().equals("") 
                || jtfDia.getText().equals("") || jtfMes.getText().equals("")
                || jtfAnio.getText().equals("") || jtfDni.getText().equals("")
                || jtfEmail.getText().equals("") || jtfCalle.getText().equals("")
                || jtfLocalidad.getText().equals("")
                || jtfDia.getText().equals("dd") || jtfDia.getText().equals("d")
                || jtfDia.getText().equals("")
                || jtfMes.getText().equals("mm") || jtfMes.getText().equals("m")
                || jtfMes.getText().equals("")
                || jtfAnio.getText().equals("aaaa") || jtfAnio.getText().equals("aaa")
                || jtfAnio.getText().equals("aa") || jtfAnio.getText().equals("a")
                || jtfAnio.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar todos los campos"
                    + " marcados con asterisco.\n";
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
            diaNac = Integer.parseInt(jtfDia.getText());
            mesNac = Integer.parseInt(jtfMes.getText());
            anioNac = Integer.parseInt(jtfAnio.getText());
        
            boolean fechaValida = fec.validarFecha(anioNac, mesNac, diaNac);
        
            if(fechaValida == false)
            {
                mensajeDeError = mensajeDeError + "- La fecha ingresada no es "
                        + "correcta.\n"; 
                error = true;
            }        
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
        if(error == false)
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
        /* ALTA */
        else
        {
            Empleado emp = new Empleado();
            
            emp.setActivo(true);
            emp.setNombre(jtfNombre.getText().trim());
            emp.setApellido(jtfApellido.getText().trim());

            GregorianCalendar fecNac = new GregorianCalendar(anioNac, mesNac, diaNac);
            GregorianCalendar fecNacAnual = new GregorianCalendar(ANIOANUAL, mesNac, diaNac);
            emp.setFechaDeNacimiento(fecNac);
            
            emp.setSexo((jcbSexo.getSelectedItem()).toString());
            emp.setTelefonoFijo(jtfTelefonoFijo.getText().trim());
            emp.setTelefonoCelular(jtfTelefonoCelular.getText().trim());
            emp.setDni(jtfDni.getText().trim());
            emp.setEmail(jtfEmail.getText().trim());
            emp.setCalle(jtfCalle.getText().trim());
            emp.setLocalidad(jtfLocalidad.getText().trim());
            
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
                emp.setProvincia(prov);
            }        
            ArrayList<Pais> paisElegido = new ArrayList<>();
            hql = "FROM Pais P WHERE P.nombrePais LIKE '" 
                    + (jcbPais.getSelectedItem()).toString()
                    + "'";
            query = sesion.createQuery(hql);
            paisElegido = (ArrayList<Pais>) query.list();
            for(Pais pais : paisElegido)
            {
                emp.setPais(pais);
            }
            
            Float sb = Float.parseFloat(jtfSueldoBruto.getText().trim());
            emp.setSueldoBruto(sb);
            
            String cargoSeleccionado = (String) jcbCargo.getSelectedItem();
            hql = "FROM Cargo C WHERE C.nombreCargo = '" + cargoSeleccionado + "'";        
            query = sesion.createQuery(hql);
            
            // en realidad, va a traer sólo un cargo, pero igualmente es
            // necesaria esta sintaxis porque los objetos query están preparados
            // para traer muchos objetos
            listaCargos = (ArrayList<Cargo>) query.list();             
            for(Cargo car : listaCargos)
            {
                emp.setCargo(car);
            }            
            
            // relación muchos a muchos: al empleado le asigno los múltiples
            // horarios de trabajo, y a cada uno de los horarios de trabajo
            // le asigno el empleado
            for(HorariosDeTrabajo ht : listaHorTrab)
            {
                ArrayList<Empleado> arrEmp = new ArrayList<>();
                arrEmp.add(emp);
                ht.setEmpleados(arrEmp);
            }
            emp.setHorariosDeTrabajo(listaHorTrab);
                    
            // armando objeto 'AcontecimientoImportante' con nacimiento del empleado
            AcontecimientoImportante acoImp = new AcontecimientoImportante();
            acoImp.setEmpleado(emp);
            acoImp.setAcontecimiento("Nacimiento");
            acoImp.setTipo("Anual");
            acoImp.setFechaUnica(fecNac);
            acoImp.setFechaAnual(fecNacAnual);
            listaAcoImp.add(acoImp);
            
            emp.setListaAcontecimientosImportantes(listaAcoImp);   
            
            // cerciorándome de que no haya en la base de datos otro empleado con
            // ese dni
            ArrayList<Empleado> repetidos = new ArrayList<>();
            hql = "FROM Empleado E WHERE E.dni = " 
                    + jtfDni.getText();
            query = sesion.createQuery(hql);
            repetidos = (ArrayList<Empleado>) query.list();            

            // si no se encontró ningún empleado con ese dni, entonces se puede
            // dar de alta el actual en la base de datos
            if(repetidos.isEmpty() == true)
            {
                // guardando objetos en la base de datos
                gesEmp.guardarOActualizar(emp);
                
                ArrayList<Empleado> empActualLista = new ArrayList<>();
                hql = "FROM Empleado E WHERE E.dni = " 
                        + jtfDni.getText();
                query = sesion.createQuery(hql);
                empActualLista = (ArrayList<Empleado>) query.list();                
                
                Empleado empActual = empActualLista.get(0);
                
                acoImp.setEmpleado(empActual);
                listaAcoImp.set(0, acoImp);
                
                for(AcontecimientoImportante ai : listaAcoImp)
                {                
                    gesAcoImp.guardarOActualizar(ai);                
                }

                // impresión de mensaje confirmando éxito
                jlMensaje.setVisible(true);
                jlMensaje.setText("Empleado " + emp.getNombre() + " " + emp.getApellido()
                        + " agregado a la base de datos"); 
            }
            // caso contrario, muestro un mensaje de error
            else
            {
                JOptionPane.showMessageDialog(null,
                        "No puede dar de alta este empleado porque ya existe en"
                                + " la base de datos",
                        "Registro duplicado",
                        JOptionPane.ERROR_MESSAGE); 
            }            
        }
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

    /**
     * Cuando se elige otra opción en el combo 'País', se vuelve a llenar el combo
     * 'Provincia' con las provincias que correspondan.
     * 
     * @param evt el evento de cambio de opción en el combo 'País'
     */
    private void jcbPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaisActionPerformed
        llenarComboProvincia();
    }//GEN-LAST:event_jcbPaisActionPerformed

    /**
     * Cuando se elige otra opción en el combo 'Cargo', se cambia la descripción
     * en la etiqueta de descripción.
     * 
     * @param evt el evento de cambio de opción en el combo 'Cargo'
     */
    private void jcbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCargoActionPerformed
        cambiarDescripcion();
    }//GEN-LAST:event_jcbCargoActionPerformed

    /**
     * Cierra la ventana sin guardar ningún cambio.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cancelar'
     */
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

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
     * Permite que solamente se ingresen números y en un máximo de 30.
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
     * Permite que solamente se ingresen números con punto y en un máximo de 7.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfSueldoBrutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSueldoBrutoKeyTyped
        Campos.configurarCampo(evt, 7, "NúmerosConPunto");
    }//GEN-LAST:event_jtfSueldoBrutoKeyTyped

    /**
     * Abre una ventana que permite guardar los horarios de trabajo del empleado.
     * 
     * @param evt el evento de pulsación del botón 'Gestionar horarios de trabajo'
     */
    private void jbGestionarHorariosDeTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionarHorariosDeTrabajoActionPerformed
        IntAltaHorariosDeEmpleado intAltGesHorTrab =
                new IntAltaHorariosDeEmpleado(null, true, sesion, this);
        intAltGesHorTrab.setVisible(true);
    }//GEN-LAST:event_jbGestionarHorariosDeTrabajoActionPerformed

    /**
     * Permite que se ingrese cualuiqer tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */       
    private void jtfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfEmailKeyTyped

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
     * Recibe los horarios de trabajo seleccionados en otra ventana por el usuario.
     * 
     * @param horTrab los horarios de trabajo elegidos en otra ventana
     */
    public void recibirHorariosDeTrabajo(ArrayList<HorariosDeTrabajo> horTrab)
    {
        listaHorTrab = horTrab;
    }
    
    /**
     * Llena el combo 'Cargo' con los nombres de los cargos que se hallen en la
     * base de datos.
     */
    private void llenarComboCargo()
    {
        ArrayList<Cargo> listaCargos = gesCar.getListaCargos();
                
        for(Cargo car : listaCargos)
        {
            jcbCargo.addItem(car.getNombreCargo());
        }
    }    
    
    /**
     * Cambia el contenido de la etiqueta que contiene la descripción del cargo
     * en base al cargo seleccionado en el combo 'Cargo'.
     */
    private void cambiarDescripcion()
    {
        String cargoSeleccionado = (String) jcbCargo.getSelectedItem();
        String hql = "FROM Cargo C WHERE C.nombreCargo = '"
                + cargoSeleccionado + "'";
        
        Query query = sesion.createQuery(hql);
        listaCargos = (ArrayList<Cargo>) query.list();   
        
        for(Cargo car : listaCargos)
        {
            jlDescripcionCargo.setText(car.getDescripcion());
        }
    }    
    
    /**
     * Llena el combo 'País' con los nombres de todos los países almacenados en
     * la base de datos.
     */
    private void llenarComboPais()
    {
        ArrayList<Pais> listaPaises = gesPai.getListaPaises();
                
        for(Pais pai : listaPaises)
        {
            jcbPais.addItem(pai.getNombrePais());
        }
    }
    
    /**
     * Llena el combo 'Provincia' con las provincias almacenadas en la base de 
     * datos que estén relacionadas con el país seleccionado en el combo 'País'.
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbGestionarHorariosDeTrabajo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcbCargo;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JComboBox jcbProvincia;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JLabel jlAltaDeEmpleado;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlBarraDos;
    private javax.swing.JLabel jlBarraUno;
    private javax.swing.JLabel jlCalle;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlDatosPersonales;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlDescripcionCargo;
    private javax.swing.JLabel jlDni;
    private javax.swing.JLabel jlDomicilio;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlEmpleo;
    private javax.swing.JLabel jlFechaDeNacimiento;
    private javax.swing.JLabel jlLocalidad;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNota;
    private javax.swing.JLabel jlPais;
    private javax.swing.JLabel jlProvincia;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlSueldoBruto;
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
    private javax.swing.JTextField jtfSueldoBruto;
    private javax.swing.JTextField jtfTelefonoCelular;
    private javax.swing.JTextField jtfTelefonoFijo;
    // End of variables declaration//GEN-END:variables
}
