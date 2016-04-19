package interfaz.empleado;

import entidad.Empleado;
import entidad.Pais;
import entidad.Provincia;
import gestor.GestorEmpleados;
import gestor.GestorPaises;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.classic.Session;


/**
 * Para realizar búsqueda de empleados según determinados criterios.
 */
public class IntBusquedaEmpleados extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GestorEmpleados gesEmp;
    private GestorPaises gesPai;
    private ArrayList<Provincia> listaProvincias;
    private ArrayList<Empleado> listaEmpleados;
    
    // cadenas necesarias para realizar consultas hql
    private String activo;
    private String nombre;
    private String apellido;
    private String sexo;
    private String pais;
    private String provincia;    
    
    
    /* Constructor */
    public IntBusquedaEmpleados(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesEmp = new GestorEmpleados(sesion);
        gesPai = new GestorPaises(sesion);  
        listaProvincias = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        
        llenarComboPais();
        llenarComboProvincia();
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlBusquedaDeClientes = new javax.swing.JLabel();
        jlActivo = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JComboBox();
        jCheckBoxNombre = new javax.swing.JCheckBox();
        jtfNombre = new javax.swing.JTextField();
        jCheckBoxApellido = new javax.swing.JCheckBox();
        jtfApellido = new javax.swing.JTextField();
        jCheckBoxSexo = new javax.swing.JCheckBox();
        jComboBoxSexo = new javax.swing.JComboBox();
        jCheckBoxPais = new javax.swing.JCheckBox();
        jComboBoxPais = new javax.swing.JComboBox();
        jCheckBoxProvincia = new javax.swing.JCheckBox();
        jComboBoxProvincia = new javax.swing.JComboBox();
        jbBuscar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Menú de búsqueda de empleados");

        jlBusquedaDeClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlBusquedaDeClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlBusquedaDeClientes.setText("Búsqueda de empleados");

        jlActivo.setText("Activo:");

        jcbActivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sí", "No", "Es indistinto" }));

        jCheckBoxNombre.setText("Nombre:");
        jCheckBoxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNombreActionPerformed(evt);
            }
        });

        jtfNombre.setEnabled(false);

        jCheckBoxApellido.setText("Apellido:");
        jCheckBoxApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxApellidoActionPerformed(evt);
            }
        });

        jtfApellido.setEnabled(false);

        jCheckBoxSexo.setText("Sexo:");

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        jCheckBoxPais.setText("País:");

        jComboBoxPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPaisActionPerformed(evt);
            }
        });

        jCheckBoxProvincia.setText("Provincia:");
        jCheckBoxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProvinciaActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlBusquedaDeClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBoxProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jCheckBoxPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBoxSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBoxApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBoxNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlActivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNombre)
                                .addComponent(jtfApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar)
                        .addGap(81, 81, 81)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlBusquedaDeClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlActivo)
                    .addComponent(jcbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxApellido)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxSexo)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPais)
                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBoxProvincia)
                    .addComponent(jComboBoxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar)
                    .addComponent(jbCancelar))
                .addContainerGap(46, Short.MAX_VALUE))
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
    * Cierra la ventana sin efectuar ninguna operación.
    * 
    * @param evt el evento de clic sobre el botón
    */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed
    
    /**
     * Realiza la búsqueda de empleados teniendo en cuenta determinados criterios
     * elegidos por el usuario.
     * 
     * @param evt el evento de clic sobre el botón
     */
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        boolean error = false;
        String mensajeDeError = "Se han producido los siguientes errores: \n\n";
        
        /* Capturando lo ingresado por el usuario */
        activo = jcbActivo.getSelectedItem().toString();        
        nombre = "";
        if(jtfNombre.isEnabled() == true)
        {    
            nombre = jtfNombre.getText();        
        }
        apellido = "";
        if(jtfApellido.isEnabled() == true)
        {
            apellido = jtfApellido.getText();
        }
        sexo = jComboBoxSexo.getSelectedItem().toString();        
        pais = jComboBoxPais.getSelectedItem().toString();
        provincia = jComboBoxProvincia.getSelectedItem().toString();
        
        
        /* Comprobación de posibles errores */
        if(jCheckBoxNombre.isSelected() == true && jtfNombre.getText().equals(""))
        {
            error = true;
            mensajeDeError = mensajeDeError
                    + "- el campo nombre ha sido seleccionado como criterio de "
                    + "búsqueda y sin embargo está vacío.\n";
        }
        if(jCheckBoxApellido.isSelected() == true && jtfApellido.getText().equals(""))
        {
            error = true;
            mensajeDeError = mensajeDeError
                    + "- el campo apellido ha sido seleccionado como criterio de "
                    + "búsqueda y sin embargo está vacío.\n";
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
            /* CONSULTAS */
            String sentenciaHQL = "";            
            int cantOpSel = 0;
            ArrayList<String> opSel = new ArrayList<>();
            
            cantOpSel++;
            opSel.add("activo");
            
            if(jCheckBoxNombre.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("nombre");
            }
            if(jCheckBoxApellido.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("apellido");
            }    
            if(jCheckBoxSexo.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("sexo");
            }       
            if(jCheckBoxPais.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("pais");
            }            
            if(jCheckBoxProvincia.isSelected() == true)
            {
                cantOpSel++;
                opSel.add("provincia");
            }            
            
            sentenciaHQL = prepararSentenciaHQL(opSel, cantOpSel);  
            
            Query query = sesion.createQuery(sentenciaHQL);
            listaEmpleados = (ArrayList<Empleado>) query.list();

            IntMostrarEmpleados intMostEmp =
                    new IntMostrarEmpleados(null, true, sesion, listaEmpleados);
            this.dispose();
            intMostEmp.setVisible(true);            
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * Teniendo en cuenta los criterios seleccionados y sus correspondientes
     * valores, prepara la sentencia HQL que se utilizará para traer los empleados
     * deseados.
     * 
     * @param opSel los criterios seleccionados
     * @param cantOpSel la cantidad de criterios seleccionados
     * @return la sentencia HQL lista para ser utilizada para efectuar la
     * consulta
     */
    private String prepararSentenciaHQL(ArrayList<String> opSel, int cantOpSel)
    {        
        String hql;
        
        if(activo.equals("Es indistinto")
                && jCheckBoxNombre.isSelected()    == false
                && jCheckBoxApellido.isSelected()  == false
                && jCheckBoxSexo.isSelected()      == false 
                && jCheckBoxPais.isSelected()      == false
                && jCheckBoxProvincia.isSelected() == false)
        {
            hql = "FROM Empleado E";
        }
        else
        {
            hql = "FROM Empleado E WHERE ";        

            for(int i = 0 ; i < cantOpSel ; i++)
            {
                String opActual = opSel.get(i);

                if(opActual.equals("activo"))
                {
                    hql = hql + sentenciaActivo();
                }
                else if(opActual.equals("nombre"))
                {
                    hql = hql + sentenciaNombre();
                }
                else if(opActual.equals("apellido"))
                {
                    hql = hql + sentenciaApellido();
                }
                else if(opActual.equals("sexo"))
                {
                    hql = hql + sentenciaSexo();
                }
                else if(opActual.equals("pais"))
                {
                    hql = hql + sentenciaPais();
                }
                else if(opActual.equals("provincia"))
                {
                    hql = hql + sentenciaProvincia();
                }

                if(i < cantOpSel-1)
                {
                    if((i == 0 && activo.equals("Es indistinto")) &&
                      (jCheckBoxNombre.isSelected()   == true   ||
                       jCheckBoxApellido.isSelected() == true   ||
                       jCheckBoxSexo.isSelected()     == true   ||
                       jCheckBoxPais.isSelected()     == true   ||
                       jCheckBoxProvincia.isSelected() == true)
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
     * Prepara la parte de la sentencia relacionada con el estado del empleado
     * 
     * @return la parte de la sentencia relacionada con el estado del empleado
     */
    private String sentenciaActivo()
    {
        String hql = "";
        if(activo.equals("Sí"))
        {    
            hql = "E.activo = true";
        }
        else if(activo.equals("No"))
        {
            hql = "E.activo = false";
        }
        
        return hql;
    }    

    /**
     * Prepara la parte de la sentencia relacionada con el nombre
     * 
     * @return la parte de la sentencia relacionada con el nombre
     */    
    private String sentenciaNombre()
    {        
        String hql = "E.nombre LIKE '" + nombre + "'";
        
        return hql;    
    }    

    /**
     * Prepara la parte de la sentencia relacionada con el apellido
     * 
     * @return la parte de la sentencia relacionada con el apellido
     */        
    private String sentenciaApellido()
    {        
        String hql = "E.apellido LIKE '" + apellido + "'";

        return hql;    
    }

    /**
     * Prepara la parte de la sentencia relacionada con el sexo
     * 
     * @return la parte de la sentencia relacionada con el sexo
     */        
    private String sentenciaSexo()
    {
        String hql = "E.sexo = '" + sexo + "'";
        
        return hql;
    }

    /**
     * Prepara la parte de la sentencia relacionada con el país
     * 
     * @return la parte de la sentencia relacionada con el país
     */        
    private String sentenciaPais()
    {
        String hql = "E.pais.nombrePais = '" + pais + "'";
        
        return hql;
    }

    /**
     * Prepara la parte de la sentencia relacionada con la provincia
     * 
     * @return la parte de la sentencia relacionada con la provincia
     */        
    private String sentenciaProvincia()
    {
        String hql = "E.provincia.nombreProvincia = '" + provincia + "'";
        
        return hql;
    }

    
    /**
     * Si se activa el checkbox 'nombre', entonces se activa el campo de texto
     * 'nombre'. Caso contrario, es decir, si se desactiva el checkbox 'nombre',
     * también se desactiva el campo de texto 'nombre'.
     * 
     * @param evt el evento de cambio de estado del checkbox
     */
    private void jCheckBoxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNombreActionPerformed
        if(jCheckBoxNombre.isSelected() == true)
        {
            jtfNombre.setEnabled(true);
        }
        else
        {
            jtfNombre.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxNombreActionPerformed

    /**
     * Si se activa el checkbox 'apellido', entonces se activa el campo de texto
     * 'apellido'. Caso contrario, es decir, si se desactiva el checkbox
     * 'apellido', también se desactiva el campo de texto 'apellido'.
     * 
     * @param evt el evento de cambio de estado del checkbox
     */
    private void jCheckBoxApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxApellidoActionPerformed
        if(jCheckBoxApellido.isSelected() == true)
        {
            jtfApellido.setEnabled(true);
        }
        else
        {
            jtfApellido.setEnabled(false);
        }        
    }//GEN-LAST:event_jCheckBoxApellidoActionPerformed

    /**
     * Si se activa el checkbox 'Provincia', automáticamente se activa el checkbox
     * 'País'.
     * 
     * @param evt el evento de cambio de estado de checkbox 
     */
    private void jCheckBoxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProvinciaActionPerformed
        if(jCheckBoxPais.isSelected() == true)
        {
            // nada
        }
        else
        {
            jCheckBoxPais.setSelected(true);
        }
    }//GEN-LAST:event_jCheckBoxProvinciaActionPerformed

    /**
     * Si se cambia el país en el combobox, el combobox de provincias se vuelve
     * a rellenar con las provincias apropiadas extraídas de la base de datos.
     * 
     * @param evt el evento de cambio de ítem en el combobox
     */
    private void jComboBoxPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPaisActionPerformed
        llenarComboProvincia();
    }//GEN-LAST:event_jComboBoxPaisActionPerformed

    /**
     * Llena el combo país con todos los países existentes en la tabla 'país' de
     * la base de datos.
     */
    private void llenarComboPais()
    {
        ArrayList<Pais> listaPaises = gesPai.getListaPaises();
                
        for(Pais pai : listaPaises)
        {
            jComboBoxPais.addItem(pai.getNombrePais());
        }
    }
    
    /**
     * Llena el combo provincia con todas las provincias que se relacionan con el
     * país seleccionado en el combo país.
     */
    private void llenarComboProvincia()
    {
        jComboBoxProvincia.removeAllItems();
        
        String paisSeleccionado = (String) jComboBoxPais.getSelectedItem();
        String hql = "FROM Provincia P WHERE P.pais.nombrePais = '"
                + paisSeleccionado + "'";
        
        Query query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        
        for(Provincia pro : listaProvincias)
        {
            jComboBoxProvincia.addItem(pro.getNombreProvincia());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxApellido;
    private javax.swing.JCheckBox jCheckBoxNombre;
    private javax.swing.JCheckBox jCheckBoxPais;
    private javax.swing.JCheckBox jCheckBoxProvincia;
    private javax.swing.JCheckBox jCheckBoxSexo;
    private javax.swing.JComboBox jComboBoxPais;
    private javax.swing.JComboBox jComboBoxProvincia;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JComboBox jcbActivo;
    private javax.swing.JLabel jlActivo;
    private javax.swing.JLabel jlBusquedaDeClientes;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
