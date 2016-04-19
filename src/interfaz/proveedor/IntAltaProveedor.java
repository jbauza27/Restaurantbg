package interfaz.proveedor;

import entidad.*;
import gestor.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;


/**
 * Formulario para dar de alta un proveedor.
 */
public class IntAltaProveedor extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GestorProveedores gesProv;
    private GestorPaises gesPai;
    private ArrayList<Provincia> listaProvincias;
    private static final String PATRON_DE_MAIL
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";    
    
    
    /* Constructor */
    public IntAltaProveedor(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        jlMensaje.setVisible(false);
        gesProv = new GestorProveedores(sesion);
        gesPai = new GestorPaises(sesion);  
        listaProvincias = new ArrayList<>();
        
        llenarComboPais();
        llenarComboProvincia();
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlAltaDeProveedor = new javax.swing.JLabel();
        jlDatosPersonales = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlTelefonoUno = new javax.swing.JLabel();
        jtfTelefonoUno = new javax.swing.JTextField();
        jlTelefonoDos = new javax.swing.JLabel();
        jtfTelefonoDos = new javax.swing.JTextField();
        jlTelefonoTres = new javax.swing.JLabel();
        jtfTelefonoTres = new javax.swing.JTextField();
        jlTipo = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox();
        jlNombreDeContacto = new javax.swing.JLabel();
        jtfNombreDeContacto = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jlCalle = new javax.swing.JLabel();
        jtfCalle = new javax.swing.JTextField();
        jlLocalidad = new javax.swing.JLabel();
        jtfLocalidad = new javax.swing.JTextField();
        jlProvincia = new javax.swing.JLabel();
        jcbProvincia = new javax.swing.JComboBox();
        jlPais = new javax.swing.JLabel();
        jcbPais = new javax.swing.JComboBox();
        jbDarDeAlta = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlMensaje = new javax.swing.JLabel();
        jlNota = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Alta de proveedor");

        jlAltaDeProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlAltaDeProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAltaDeProveedor.setText("Alta de proveedor");

        jlDatosPersonales.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDatosPersonales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatosPersonales.setText("Datos personales");

        jlNombre.setText("*Nombre:");

        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });

        jlTelefonoUno.setText("*Teléfono 1:");

        jtfTelefonoUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelefonoUnoActionPerformed(evt);
            }
        });
        jtfTelefonoUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoUnoKeyTyped(evt);
            }
        });

        jlTelefonoDos.setText("Teléfono 2:");

        jtfTelefonoDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoDosKeyTyped(evt);
            }
        });

        jlTelefonoTres.setText("Teléfono 3:");

        jtfTelefonoTres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTelefonoTresKeyTyped(evt);
            }
        });

        jlTipo.setText("*Tipo:");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Persona", "Empresa" }));

        jlNombreDeContacto.setText("Nombre de contacto:");

        jtfNombreDeContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreDeContactoKeyTyped(evt);
            }
        });

        jlEmail.setText("*Email:");

        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEmailKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Domicilio");

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

        jlNota.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jlNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNota.setText("Nota: los campos marcados con asterisco son obligatorios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlAltaDeProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbDarDeAlta)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jlDatosPersonales, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jlEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlNombreDeContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(jlTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlTelefonoTres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlTelefonoDos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlTelefonoUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfNombre)
                                        .addComponent(jtfTelefonoTres, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(jtfTelefonoDos)
                                        .addComponent(jtfTelefonoUno)
                                        .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfNombreDeContacto)
                                        .addComponent(jtfEmail)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlLocalidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(jlCalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfCalle)
                                    .addComponent(jtfLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jcbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jbSalir))
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlAltaDeProveedor)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatosPersonales)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCalle)
                    .addComponent(jtfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTelefonoUno)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfTelefonoUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlLocalidad)
                        .addComponent(jtfLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTelefonoDos)
                    .addComponent(jtfTelefonoDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlProvincia)
                        .addComponent(jcbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTelefonoTres)
                            .addComponent(jtfTelefonoTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlPais))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTipo)
                            .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNombreDeContacto)
                            .addComponent(jtfNombreDeContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEmail)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDarDeAlta)
                    .addComponent(jbSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jlNota)
                .addGap(18, 18, 18)
                .addComponent(jlMensaje)
                .addGap(23, 23, 23))
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
     * Cierra la ventana sin efectuar ninguna operación.
     * 
     * @param evt el evento de clic sobre el botón 'Cancelar'
     */    
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    /**
     * Guarda el proveedor o notifica al usuario que hay algún error.
     * 
     * @param evt el evento de pulsación sobre el botón 'Dar de alta'
     */    
    private void jbDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeAltaActionPerformed
        /* VALIDACIONES */
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        
        /* Me cercioro que no hay campos obligatorios vacíos */
        if(jtfNombre.getText().equals("") || jtfTelefonoUno.getText().equals("")
                || jtfEmail.getText().equals("")
                || jtfCalle.getText().equals("") || jtfLocalidad.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar todos los campos marcados "
                    + "con asterisco.\n";
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
            // armando objeto 'Proveedor'
            Proveedor prov = new Proveedor();
            
            prov.setActivo(true);
            prov.setNombre(jtfNombre.getText().trim());                        
            prov.setTelefonoUno(jtfTelefonoUno.getText().trim());
            prov.setTelefonoDos(jtfTelefonoDos.getText().trim());
            prov.setTelefonoTres(jtfTelefonoTres.getText().trim());            
            prov.setTipo(jcbTipo.getSelectedItem().toString());
            prov.setNombreDeContacto(jtfNombreDeContacto.getText().trim());            
            prov.setEmail(jtfEmail.getText().trim());
            prov.setCalle(jtfCalle.getText().trim());
            prov.setLocalidad(jtfLocalidad.getText().trim());
            
            ArrayList<Provincia> provinciaElegida = new ArrayList<>();
            String hql = "FROM Provincia P WHERE P.nombreProvincia LIKE '" 
                    + (jcbProvincia.getSelectedItem()).toString()
                    + "' AND P.pais.nombrePais LIKE '"
                    + (jcbPais.getSelectedItem()).toString()
                    + "'";
            Query query = sesion.createQuery(hql);
            provinciaElegida = (ArrayList<Provincia>) query.list();
            for(Provincia pro : provinciaElegida)
            {
                prov.setProvincia(pro);
            }        
            ArrayList<Pais> paisElegido = new ArrayList<>();
            hql = "FROM Pais P WHERE P.nombrePais LIKE '" 
                    + (jcbPais.getSelectedItem()).toString()
                    + "'";
            query = sesion.createQuery(hql);
            paisElegido = (ArrayList<Pais>) query.list();
            for(Pais pais : paisElegido)
            {
                prov.setPais(pais);
            }
            
            // cerciorándome de que no haya en la base de datos otro empleado con
            // ese email
            ArrayList<Proveedor> repetidos = new ArrayList<>();
            hql = "FROM Proveedor P WHERE P.email = '" 
                    + jtfEmail.getText() + "'";
            query = sesion.createQuery(hql);
            repetidos = (ArrayList<Proveedor>) query.list();
            
            // si no se encontró ningún proveedor con ese mail, entonces se puede
            // ingresar este a la base de datos
            if(repetidos.isEmpty() == true)
            {             
                // guardando objetos en la base de datos
                gesProv.guardarOActualizar(prov);

                // impresión de mensaje confirmando éxito
                jlMensaje.setVisible(true);
                jlMensaje.setText("Proveedor " + prov.getNombre()
                        + " agregado a la base de datos");  
                
            }
            // caso contrario, muestro un mensaje de error
            else
            {
                JOptionPane.showMessageDialog(null,
                        "No puede dar de alta este proveedor porque ya existe en"
                                + " la base de datos",
                        "Registro duplicado",
                        JOptionPane.ERROR_MESSAGE); 
            }        
        }
    }//GEN-LAST:event_jbDarDeAltaActionPerformed

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
     * Permite que solamente se ingresen letras y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
        Campos.configurarCampo(evt, 50, "Cadena");
    }//GEN-LAST:event_jtfNombreKeyTyped

    private void jtfTelefonoUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTelefonoUnoActionPerformed
        // nada, este método lo coloqué por error
    }//GEN-LAST:event_jtfTelefonoUnoActionPerformed

    /**
     * Permite que solamente se ingresen números y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfTelefonoUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoUnoKeyTyped
        Campos.configurarCampo(evt, 30, "Números");
    }//GEN-LAST:event_jtfTelefonoUnoKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfTelefonoDosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoDosKeyTyped
        Campos.configurarCampo(evt, 30, "Números");
    }//GEN-LAST:event_jtfTelefonoDosKeyTyped

    /**
     * Permite que solamente se ingresen números y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfTelefonoTresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTelefonoTresKeyTyped
        Campos.configurarCampo(evt, 30, "Números");
    }//GEN-LAST:event_jtfTelefonoTresKeyTyped

    /**
     * Permite que solamente se ingresen letras y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */    
    private void jtfNombreDeContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreDeContactoKeyTyped
        Campos.configurarCampo(evt, 30, "Cadena");
    }//GEN-LAST:event_jtfNombreDeContactoKeyTyped

    /**
     * Permite que se ingresen todo tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfEmailKeyTyped

    /**
     * Permite que se ingresen todo tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCalleKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfCalleKeyTyped

    /**
     * Permite que se ingresen todo tipo de caracteres y en un máximo de 30.
     * 
     * @param evt el evento de tipeo
     */        
    private void jtfLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLocalidadKeyTyped
        Campos.configurarCampo(evt, 30, "Todo");
    }//GEN-LAST:event_jtfLocalidadKeyTyped

    /**
     * Llena el combo país con todos los países existentes en la tabla 'país' de
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbDarDeAlta;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JComboBox jcbProvincia;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JLabel jlAltaDeProveedor;
    private javax.swing.JLabel jlCalle;
    private javax.swing.JLabel jlDatosPersonales;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlLocalidad;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNombreDeContacto;
    private javax.swing.JLabel jlNota;
    private javax.swing.JLabel jlPais;
    private javax.swing.JLabel jlProvincia;
    private javax.swing.JLabel jlTelefonoDos;
    private javax.swing.JLabel jlTelefonoTres;
    private javax.swing.JLabel jlTelefonoUno;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JTextField jtfCalle;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLocalidad;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNombreDeContacto;
    private javax.swing.JTextField jtfTelefonoDos;
    private javax.swing.JTextField jtfTelefonoTres;
    private javax.swing.JTextField jtfTelefonoUno;
    // End of variables declaration//GEN-END:variables
}
