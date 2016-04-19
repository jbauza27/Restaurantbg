package interfaz.movimientodestock;

import entidad.MateriaPrima;
import entidad.MovimientoDeStock;
import entidad.ProductoElaborado;
import gestor.GestorMateriasPrimas;
import gestor.GestorMovimientosDeStock;
import gestor.GestorProductosElaborados;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Modelo;


/**
 * Interfaz diseñada para realizar control de stock, realizando entrada y salida
 * tanto de materias primas como de productos elaborados.
 */
public class IntMovimientoDeStock extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private ArrayList<MateriaPrima> listaMatPrim;
    private boolean hayMatPrim;
    private ArrayList<ProductoElaborado> listaProdElab;
    private boolean hayProdElab;
    private GestorMateriasPrimas gesMatPrim;
    private GestorProductosElaborados gesProdElab;
    private GestorMovimientosDeStock gesMovSto;
    private Modelo modeloDetFac;    
    private int idFac;
    private MovimientoDeStock movSto;
    private GregorianCalendar fechaActual;  
    private int diaActual;
    private int mesActual;
    private int anioActual;
    private int horaActual;
    private int minutoActual;
    
    
    /* Constructor */
    public IntMovimientoDeStock(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesMatPrim = new GestorMateriasPrimas(sesion);
        gesProdElab = new GestorProductosElaborados(sesion);
        gesMovSto = new GestorMovimientosDeStock(sesion);
        movSto = new MovimientoDeStock();
        fechaActual = new GregorianCalendar();
        diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
        mesActual = fechaActual.get(Calendar.MONTH);
        anioActual = fechaActual.get(Calendar.YEAR);
        horaActual = fechaActual.get(Calendar.HOUR_OF_DAY);
        minutoActual = fechaActual.get(Calendar.MINUTE);
        
        // compruebo si hay materias primas: si no las hay, desactivo el
        // botón de radio de materias primas y selecciono el de productos elaborados
        listaMatPrim = gesMatPrim.getListaMateriasPrimas();
        if(listaMatPrim.isEmpty() == true)
        {
            hayMatPrim = false;
            jrbMateriasPrimas.setEnabled(false);
            jrbProductosElaborados.setSelected(true);
        }
        else
        {
            hayMatPrim = true;
        }
        
        // compruebo si hay productos elaborados: si no los hay, desactivo el
        // botón de radio de productos elaborados y selecciono el de materias
        // primas
        listaProdElab = gesProdElab.getListaProductosElaboradosActivos();
        if(listaProdElab.isEmpty() == true)
        {
            hayProdElab = false;
            jrbProductosElaborados.setEnabled(false);
            jrbMateriasPrimas.setSelected(true);
        }
        else
        {
            hayProdElab = true;
        }
        
        // so hay ambas cosas, hago que el botón de radio de materias primas
        // aparezca seleccionado por defecto
        if(hayMatPrim == true && hayProdElab == true)
        {
            jrbMateriasPrimas.setSelected(true);
        }
        
        jlMensaje.setVisible(false);        
        cargarItems();
    }


    /* Métodos */    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGrupo = new javax.swing.ButtonGroup();
        jlControlDeStock = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox();
        jcbMotivo = new javax.swing.JComboBox();
        jlCantidad = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jlItem = new javax.swing.JLabel();
        jcbItem = new javax.swing.JComboBox();
        jbGuardarCambios = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlMensaje = new javax.swing.JLabel();
        jrbMateriasPrimas = new javax.swing.JRadioButton();
        jrbProductosElaborados = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Control de stock");

        jlControlDeStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlControlDeStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlControlDeStock.setText("Control de stock");

        jlEstado.setText("Estado:");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Salida" }));
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        jlCantidad.setText("Cantidad:");

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jlItem.setText("Ítem:");

        jbGuardarCambios.setText("Guardar cambios");
        jbGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarCambiosActionPerformed(evt);
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

        bgGrupo.add(jrbMateriasPrimas);
        jrbMateriasPrimas.setText("Materias primas");
        jrbMateriasPrimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateriasPrimasActionPerformed(evt);
            }
        });

        bgGrupo.add(jrbProductosElaborados);
        jrbProductosElaborados.setText("Productos elaborados");
        jrbProductosElaborados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbProductosElaboradosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlControlDeStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbMateriasPrimas)
                                .addGap(18, 18, 18)
                                .addComponent(jrbProductosElaborados))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jlEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbGuardarCambios)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbSalir))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfCantidad)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jcbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jcbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15)))
                        .addGap(0, 96, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlControlDeStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMateriasPrimas)
                    .addComponent(jrbProductosElaborados))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstado)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlItem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardarCambios)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18)
                .addComponent(jlMensaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Carga todos los combobox con la información apropiada.
     */
    public void cargarItems()
    {
        jcbMotivo.removeAllItems();
        jcbItem.removeAllItems();
        
        if(jrbMateriasPrimas.isSelected() == true)
        {
            listaMatPrim = gesMatPrim.getListaMateriasPrimas();
            String materiaPrimaString = "";
        
            for(MateriaPrima matPrim : listaMatPrim)
            {
                materiaPrimaString = matPrim.getId() + " - " + matPrim.getNombre();
                jcbItem.addItem(materiaPrimaString);
            }

            if(jcbEstado.getSelectedItem().toString().equals("Entrada"))
            {
                jcbMotivo.addItem("Compra de materias primas");
                jcbMotivo.addItem("Donación de materias primas");
            }
            else if(jcbEstado.getSelectedItem().toString().equals("Salida"))
            {
                jcbMotivo.addItem("Pérdida de materias primas");
                jcbMotivo.addItem("Rotura de materias primas");
                jcbMotivo.addItem("Vencimiento de materias primas");
            } 
        }

        if(jrbProductosElaborados.isSelected() == true)
        {
            listaProdElab = gesProdElab.getListaProductosElaboradosActivos();
            String productoElaboradoString = "";

            for(ProductoElaborado prodElab : listaProdElab)
            {
                productoElaboradoString = prodElab.getId() + " - " + prodElab.getNombre();
                jcbItem.addItem(productoElaboradoString);
            }         

            if(jcbEstado.getSelectedItem().toString().equals("Entrada"))
            {
                jcbMotivo.addItem("Fabricación de productos elaborados");            
            }
            else if(jcbEstado.getSelectedItem().toString().equals("Salida"))
            {
                jcbMotivo.addItem("Consumición de productos elaborados");
                jcbMotivo.addItem("Pérdida de productos elaborados");
                jcbMotivo.addItem("Rotura de materias primas");   
                jcbMotivo.addItem("Vencimiento de productos elaborados"); 
            }
        }
    }

    /**
     * Si cambio el contenido del combo de 'entrada' a 'salida' o viceversa, se
     * vuelven a cargar todos los combos.
     * 
     * @param evt el cambio de ítem en el combo
     */
    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        cargarItems();
    }//GEN-LAST:event_jcbEstadoActionPerformed

    /**
     * Cierra la ventana sin realizar cambio alguno.
     * 
     * @param evt el evento de pulsación sobre el botón 'Cancelar'
     */
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    /**
     * Guarda el movimiento de stock con toda la información seleccionada.
     * 
     * @param evt el evento de pulsación sobre el botón 'Guardar cambios'
     */
    private void jbGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarCambiosActionPerformed
        /* VALIDACIONES */
        boolean operacionValida = true;

        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        
        /* Me cercioro que no hay campos vacíos */
        if(jtfCantidad.getText().equals(""))
        {
            mensajeDeError = mensajeDeError + "- Debe llenar todos los campos.\n";
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
        /* MOVIMIENTO */
        else
        {
            movSto = new MovimientoDeStock();
            
            if(jrbMateriasPrimas.isSelected() == true)
            {
                // obtengo la materia prima seleccionada y la añado al movimiento de stock
                String materiaPrimaSeleccionada =
                        jcbItem.getSelectedItem().toString();
                int indGuion = materiaPrimaSeleccionada.indexOf("-");
                String idMateriaPrima = 
                        String.valueOf(materiaPrimaSeleccionada.substring(0, indGuion-1));
                MateriaPrima matPrim =
                        gesMatPrim.buscarPorId(Integer.parseInt(idMateriaPrima));        
                movSto.setMateriaPrima(matPrim);
                        
                // añado la fecha y hora actual al movimiento de stock
                GregorianCalendar fechaDelMovimiento = new GregorianCalendar
                    (anioActual, mesActual, diaActual, horaActual, minutoActual);
                movSto.setFecha(fechaDelMovimiento);
                
                // añado el estado al movimiento de stock
                movSto.setEstado(jcbEstado.getSelectedItem().toString());

                // añado el motivo al movimiento de stock
                movSto.setMotivo(jcbMotivo.getSelectedItem().toString());

                // actualizo la cantidad de materias primas
                double cantidadIngresada = Double.parseDouble(jtfCantidad.getText().trim());        
                double cantidadMateriasPrimas = matPrim.getCantidad();
                String estado = jcbEstado.getSelectedItem().toString();

                if(estado.equals("Entrada"))
                {
                    cantidadMateriasPrimas = cantidadMateriasPrimas + cantidadIngresada;
                    movSto.setCantidad(cantidadIngresada);
                }
                else
                {
                    if(cantidadIngresada > cantidadMateriasPrimas)
                    {
                        JOptionPane.showMessageDialog(null,
                                "No puede realizar este movimiento, porque la cantidad "
                                        + "de materias primas ingresada supera"
                                        + " la cantidad en stock",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                        operacionValida = false;
                    }
                    else
                    {
                        cantidadMateriasPrimas = cantidadMateriasPrimas - cantidadIngresada;
                        movSto.setCantidad(cantidadIngresada);
                    }
                }

                matPrim.setCantidad(cantidadMateriasPrimas);

                if(operacionValida == true)
                {
                    // actualizo la materia prima y guardo el movimiento de stock
                    gesMatPrim.guardarOActualizar(matPrim);
                    gesMovSto.guardarOActualizar(movSto);

                    // muestro un mensaje diciendo que todo salió bien
                    jlMensaje.setVisible(true);
                    jlMensaje.setText("Movimiento de "
                                        + matPrim.getNombre()
                                        + " guardado con éxito");
                }
            }
            
            if(jrbProductosElaborados.isSelected() == true)
            {
                // obtengo el producto elaborado seleccionado y lo añado
                // al movimiento de stock
                String productoElaboradoSeleccionado =
                        jcbItem.getSelectedItem().toString();
                int indGuion = productoElaboradoSeleccionado.indexOf("-");
                String idProductoElaborado = 
                        String.valueOf(productoElaboradoSeleccionado.substring(0, indGuion-1));
                ProductoElaborado prodElab =
                        gesProdElab.buscarPorId(Integer.parseInt(idProductoElaborado));        
                movSto.setProductoElaborado(prodElab);
                        
                // añado la fecha y hora actual al movimiento de stock
                GregorianCalendar fechaDelMovimiento = new GregorianCalendar();
                movSto.setFecha(fechaDelMovimiento);
                
                // añado el estado al movimiento de stock
                movSto.setEstado(jcbEstado.getSelectedItem().toString());

                // añado el motivo al movimiento de stock
                movSto.setMotivo(jcbMotivo.getSelectedItem().toString());

                // actualizo la cantidad de productos elaborados
                int cantidadIngresada = Integer.parseInt(jtfCantidad.getText());        
                int cantidadProductosElaborados = prodElab.getCantidad();
                String estado = jcbEstado.getSelectedItem().toString();

                if(estado.equals("Entrada"))
                {
                    cantidadProductosElaborados
                            = cantidadProductosElaborados + cantidadIngresada;
                }
                else
                {
                    if(cantidadIngresada > cantidadProductosElaborados)
                    {
                        JOptionPane.showMessageDialog(null,
                                "No puede realizar este movimiento, porque la cantidad "
                                        + "de productos elaborados ingresada supera"
                                        + " la cantidad en stock",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                        operacionValida = false;
                    }
                    else
                    {
                        cantidadProductosElaborados
                                = cantidadProductosElaborados - cantidadIngresada;
                    }
                }

                prodElab.setCantidad(cantidadProductosElaborados);

                if(operacionValida == true)
                {

                    // actualizo el producto elaborado y guardo el movimiento de stock
                    gesMatPrim.guardarOActualizar(prodElab);
                    gesMovSto.guardarOActualizar(movSto);

                    // muestro un mensaje diciendo que todo salió bien
                    jlMensaje.setVisible(true);
                    jlMensaje.setText("Movimiento de "
                                        + prodElab.getNombre()
                                        + " guardado con éxito");
                }
            }
        }
    }//GEN-LAST:event_jbGuardarCambiosActionPerformed

    /**
     * Si la opción elegida para el movimiento de stock es 'Materias primas',
     * entonces se permite solamente ingresar números con el caracter punto y en
     * una cantidad de 10.
     * <p>Si, por el contrario, la opción elegida para el movimiento de stock es
     * 'Productos elaborados', entonces se permite solamente ingresar números y
     * en una cantidad de 10.
     * 
     * @param evt el evento de tipeo en el campo de texto 'Cantidad'
     */
    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        if(jrbMateriasPrimas.isSelected() == true)
        {
            Campos.configurarCampo(evt, 10, "NúmerosConPunto");
        }
        else
        {
            Campos.configurarCampo(evt, 10, "Números");
        }
    }//GEN-LAST:event_jtfCantidadKeyTyped

    /**
     * Si e selecciona el botón de radio 'Productos elaborados', entonces se vuelven
     * a llenar todos los combos con la información apropiada.
     * 
     * @param evt el evento de selección del botón de radio 'Productos elaborados'
     */
    private void jrbProductosElaboradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbProductosElaboradosActionPerformed
        cargarItems();
    }//GEN-LAST:event_jrbProductosElaboradosActionPerformed

    /**
     * Si e selecciona el botón de radio 'Materias primas', entonces se vuelven
     * a llenar todos los combos con la información apropiada.
     * 
     * @param evt el evento de selección del botón de radio 'Materias primas'
     */    
    private void jrbMateriasPrimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateriasPrimasActionPerformed
        cargarItems();
    }//GEN-LAST:event_jrbMateriasPrimasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGrupo;
    private javax.swing.JButton jbGuardarCambios;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbItem;
    private javax.swing.JComboBox jcbMotivo;
    private javax.swing.JLabel jlCantidad;
    private javax.swing.JLabel jlControlDeStock;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlItem;
    private javax.swing.JLabel jlMensaje;
    private javax.swing.JRadioButton jrbMateriasPrimas;
    private javax.swing.JRadioButton jrbProductosElaborados;
    private javax.swing.JTextField jtfCantidad;
    // End of variables declaration//GEN-END:variables
}
