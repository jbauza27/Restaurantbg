package interfaz.empleado;

import entidad.HorariosDeTrabajo;
import gestor.GestorEmpleados;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import org.hibernate.classic.Session;


/**
 * Permite elegir los horarios de trabajo de un empleado.
 */
public class IntAltaHorariosDeEmpleado extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GestorEmpleados gesEmp;
    private ArrayList<HorariosDeTrabajo> listaHorariosDeTrabajo;
    
    private ArrayList<String> cadenasHorariosDeTrabajo;
    private DefaultListModel modeloListaDisponibles;
    private DefaultListModel modeloListaSeleccionados;
    
    private IntAltaEmpleado intAltEmp;
    
    
    /* Constructor */
    public IntAltaHorariosDeEmpleado(java.awt.Frame parent, boolean modal,
            Session sesion, IntAltaEmpleado intAltaEmpleado)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesEmp = new GestorEmpleados(sesion);
        listaHorariosDeTrabajo = gesEmp.getListaHorariosDeTrabajo();
        
        modeloListaDisponibles = new DefaultListModel();        
        modeloListaSeleccionados = new DefaultListModel();
        
        cadenasHorariosDeTrabajo = new ArrayList<>();
        intAltEmp = intAltaEmpleado;
        
        llenarListaDisponibles();
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlGestorDeHorariosDeTrabajo = new javax.swing.JLabel();
        jLabelDisponibles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDisponibles = new javax.swing.JList();
        jbAnadir = new javax.swing.JButton();
        jbQuitar = new javax.swing.JButton();
        jLabelSeleccionados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSeleccionados = new javax.swing.JList();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\": Gestor de horarios de trabajo del empleado");

        jlGestorDeHorariosDeTrabajo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlGestorDeHorariosDeTrabajo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlGestorDeHorariosDeTrabajo.setText("Gestor de horarios de trabajo");

        jLabelDisponibles.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabelDisponibles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDisponibles.setText("Disponibles");

        jScrollPane1.setViewportView(jListDisponibles);

        jbAnadir.setText("Añadir ->");
        jbAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnadirActionPerformed(evt);
            }
        });

        jbQuitar.setText("<- Quitar");
        jbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarActionPerformed(evt);
            }
        });

        jLabelSeleccionados.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabelSeleccionados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSeleccionados.setText("Seleccionados");

        jScrollPane2.setViewportView(jListSeleccionados);

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
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
            .addComponent(jlGestorDeHorariosDeTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbAnadir)
                                    .addComponent(jbQuitar))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jLabelSeleccionados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jbAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlGestorDeHorariosDeTrabajo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDisponibles)
                    .addComponent(jLabelSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jbAnadir)
                        .addGap(18, 18, 18)
                        .addComponent(jbQuitar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar)
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
     * Transfiere un horario de trabajo de la lista de disponibles a la lista de
     * seleccionados.
     * 
     * @param evt el evento de clic sobre el botón 'Añadir'
     */
    private void jbAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnadirActionPerformed
        if(jListDisponibles.isSelectionEmpty() == true)
        {
            // nada
        }
        else
        {
            // guardo todas las cadenas seleccionadas en un arreglo de cadenas
            cadenasHorariosDeTrabajo =
                    (ArrayList<String>) jListDisponibles.getSelectedValuesList();

            // recorro dicho arreglo, y con ello voy agregando las cadenas al modelo
            // de horarios de trabajo seleccionados y quitándolas del modelo de horarios
            // de trabajo disponibles
            for(String cadenaActual : cadenasHorariosDeTrabajo)
            {
                modeloListaSeleccionados.addElement(cadenaActual);
                modeloListaDisponibles.removeElement(cadenaActual);
            }

            // agrego el modelo al gráfico de lista
            jListDisponibles.setModel(modeloListaDisponibles);
            jListSeleccionados.setModel(modeloListaSeleccionados); 
        }
    }//GEN-LAST:event_jbAnadirActionPerformed

    /**
     * Cierra la ventana sin guardar ningún cambio.
     * 
     * @param evt el evento de pulsación del botón 'Cancelar'
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    /**
     * Transfiere un horario de trabajo de la lista de seleccionados a la lista de
     * disponibles.
     * 
     * @param evt el evento de clic sobre el botón 'Quitar'
     */    
    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        if(jListSeleccionados.isSelectionEmpty() == true)
        {
            // nada
        }
        else
        {
            // guardo todas las cadenas seleccionadas en un arreglo de cadenas
            cadenasHorariosDeTrabajo =
                    (ArrayList<String>) jListSeleccionados.getSelectedValuesList();

            // recorro dicho arreglo, y con ello voy agregando las cadenas al modelo
            // de horarios de trabajo disponibles y quitándolas del modelo de
            // horarios de trabajo seleccionados
            for(String cadenaActual : cadenasHorariosDeTrabajo)
            {
                modeloListaDisponibles.addElement(cadenaActual);
                modeloListaSeleccionados.removeElement(cadenaActual);
            }

            // agrego el modelo al gráfico de lista
            jListDisponibles.setModel(modeloListaDisponibles);
            jListSeleccionados.setModel(modeloListaSeleccionados);   
        }
    }//GEN-LAST:event_jbQuitarActionPerformed

    /**
     * Cierra la ventana y asigna todos los horarios de trabajo que se hallen
     * en la lista 'seleccionados' al empleado actual.
     * 
     * @param evt el evento de pulsación del botón 'Aceptar'
     */
    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        // guardo el contenido del modelo de horarios de trabajo seleccionados en un
        // arreglo de cadenas
        ArrayList<String> horTrabElegString = new ArrayList<>();
        for(int i = 0 ; i < modeloListaSeleccionados.size() ; i++)
        {
            horTrabElegString.add((String) modeloListaSeleccionados.get(i));
        }
            
        // creo un arreglo de horarios de trabajo y guardo en él todos los
        // horarios de trabajo del arreglo de cadenas
        ArrayList<HorariosDeTrabajo> horTrabEleg = new ArrayList<>();
        for(String horTrabActualString : horTrabElegString)
        {                
            HorariosDeTrabajo horTrabActual = new HorariosDeTrabajo();
            int indGuion = horTrabActualString.indexOf("-");
            String idHorTrabString = String.valueOf(horTrabActualString.substring(0, indGuion-1));
            horTrabActual = gesEmp.buscarHorariosDeTrabajoPorId(Integer.parseInt(idHorTrabString));
            horTrabEleg.add(horTrabActual);
        }
            
        intAltEmp.recibirHorariosDeTrabajo(horTrabEleg);
        this.dispose();     
    }//GEN-LAST:event_jbAceptarActionPerformed

    /**
     * Llena la lista 'disponibles' con todos los horarios de trabajo existentes.
     */
    private void llenarListaDisponibles()
    {        
        for(HorariosDeTrabajo horTrab : listaHorariosDeTrabajo)
        {
            String cadenaHorTrab = horTrab.getId()
                    + " - "
                    + "Turno " + horTrab.getParteDelDia()
                    + ", el día " + horTrab.getDiaDeSemana()
                    + ", de " + horTrab.getHoraDeInicio().get(Calendar.HOUR_OF_DAY)
                    + ":" + horTrab.getHoraDeInicio().get(Calendar.MINUTE) + "0"
                    + " a " + horTrab.getHoraDeFinalizacion().get(Calendar.HOUR_OF_DAY)
                    + ":" + horTrab.getHoraDeFinalizacion().get(Calendar.MINUTE) + "0";
            
            modeloListaDisponibles.addElement(cadenaHorTrab); // se añade al modelo
        }    
        
        // añado el modelo al gráfico lista
        jListDisponibles.setModel(modeloListaDisponibles); 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDisponibles;
    private javax.swing.JLabel jLabelSeleccionados;
    private javax.swing.JList jListDisponibles;
    private javax.swing.JList jListSeleccionados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbAnadir;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JLabel jlGestorDeHorariosDeTrabajo;
    // End of variables declaration//GEN-END:variables
}
