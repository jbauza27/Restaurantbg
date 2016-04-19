package interfaz.facturacion;

import entidad.DetalleFactura;
import entidad.Factura;
import gestor.GestorClientes;
import gestor.GestorEmpleados;
import gestor.GestorFacturacion;
import gestor.GestorProductosElaborados;
import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.classic.Session;
import utilidades.Modelo;


/**
 * Muestra la factura seleccionada con en formulario de búsqueda en forma
 * detallada.
 */
public class IntMostrarFactura extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion;
    private GestorFacturacion gesFac;
    private GestorEmpleados gesEmp;
    private GestorClientes gesCli;
    private GestorProductosElaborados gesProdElab;
    private Modelo modeloDetFac;    
    private ArrayList<DetalleFactura> listaDetallesFacturas;
    
    
    /* Constructor */
    public IntMostrarFactura(java.awt.Frame parent, boolean modal,
            Session sesion, int idFactura)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        gesFac = new GestorFacturacion(sesion);
        gesEmp = new GestorEmpleados(sesion);
        gesCli = new GestorClientes(sesion);
        gesProdElab = new GestorProductosElaborados(sesion);
        listaDetallesFacturas = new ArrayList<>();
        
        mostrarTodo(idFactura);
    }

    
    /* Métodos */
    /**
     * Muestra toda la información de una factura.
     * 
     * @param id el 'id' de la factura que se mostrará
     */
    private void mostrarTodo(int id)
    {
        Factura fac = gesFac.buscarFacturaPorId(id);
        
        // información principal de la factura
        jlInfoMozo.setText(fac.getEmpleado().getApellido() + " "
                + fac.getEmpleado().getNombre());
        jlInfoTipo.setText(fac.getTipo());
        String dia = Integer.toString(fac.getFecha().get(Calendar.DAY_OF_MONTH));
        jlDia.setText(dia);
        String mes = Integer.toString(fac.getFecha().get(Calendar.MONTH) + 1);
        jlMes.setText(mes);
        String anio = Integer.toString(fac.getFecha().get(Calendar.YEAR));
        jlAnio.setText(anio);
        jlHora.setText(fac.getFecha().get(Calendar.HOUR_OF_DAY)
                + ":" + fac.getFecha().get(Calendar.MINUTE));
        jlInfoCliente.setText(fac.getCliente().getApellido() + " "
                + fac.getEmpleado().getNombre());
        jlInfoCondicionesDeVenta.setText(fac.getCondicionesDeVenta());
        String nroFactura = Integer.toString(fac.getNumero());
        jlInfoNumeroDeFactura.setText(nroFactura);
        
        // el detalle de la factura
        listaDetallesFacturas = gesFac
                .getListaDetallesFacturaRelacionadosConFactura(id);

        modeloDetFac = gesFac.configurarModeloFacturando(modeloDetFac,
                listaDetallesFacturas);
        jtDetalleFactura.setModel(modeloDetFac);
        jtDetalleFactura.getColumnModel().removeColumn(jtDetalleFactura.
                getColumnModel().getColumn(0));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        jlFactura = new javax.swing.JLabel();
        jlMozo = new javax.swing.JLabel();
        jlInfoMozo = new javax.swing.JLabel();
        jlTipo = new javax.swing.JLabel();
        jlInfoTipo = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlDia = new javax.swing.JLabel();
        jlBarraUno = new javax.swing.JLabel();
        jlMes = new javax.swing.JLabel();
        jlBarraDos = new javax.swing.JLabel();
        jlAnio = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jlInfoCliente = new javax.swing.JLabel();
        jlCondicionesDeVenta = new javax.swing.JLabel();
        jlInfoCondicionesDeVenta = new javax.swing.JLabel();
        jlNumeroDeFactura = new javax.swing.JLabel();
        jlInfoNumeroDeFactura = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlDetalleDeFactura = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalleFactura = new javax.swing.JTable();
        jlMenos = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Visualización de factura");

        jlFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFactura.setText("Factura");

        jlMozo.setText("Mozo:");

        jlInfoMozo.setText("info");

        jlTipo.setText("Tipo:");

        jlInfoTipo.setText("info");

        jlFecha.setText("Fecha:");

        jlDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDia.setText("día");

        jlBarraUno.setText("/");

        jlMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMes.setText("mes");

        jlBarraDos.setText("/");

        jlAnio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAnio.setText("Año");

        jlCliente.setText("Cliente:");

        jlInfoCliente.setText("info");

        jlCondicionesDeVenta.setText("Condiciones de venta:");

        jlInfoCondicionesDeVenta.setText("info");

        jlNumeroDeFactura.setText("Número de factura:");

        jlInfoNumeroDeFactura.setText("info");

        jlDetalleDeFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlDetalleDeFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDetalleDeFactura.setText("Detalle de factura");

        jtDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtDetalleFactura);

        jlMenos.setText("-");

        jlHora.setText("Hora");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jlFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlNumeroDeFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCondicionesDeVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlMozo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlInfoMozo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlInfoTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlInfoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlInfoCondicionesDeVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpPrincipalLayout.createSequentialGroup()
                                .addComponent(jlDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBarraUno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBarraDos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlMenos)
                                .addGap(18, 18, 18)
                                .addComponent(jlHora)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jlInfoNumeroDeFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jlDetalleDeFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMozo)
                    .addComponent(jlInfoMozo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipo)
                    .addComponent(jlInfoTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFecha)
                    .addComponent(jlDia)
                    .addComponent(jlBarraUno)
                    .addComponent(jlMes)
                    .addComponent(jlBarraDos)
                    .addComponent(jlAnio)
                    .addComponent(jlMenos)
                    .addComponent(jlHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCliente)
                    .addComponent(jlInfoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCondicionesDeVenta)
                    .addComponent(jlInfoCondicionesDeVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumeroDeFactura)
                    .addComponent(jlInfoNumeroDeFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDetalleDeFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlAnio;
    private javax.swing.JLabel jlBarraDos;
    private javax.swing.JLabel jlBarraUno;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlCondicionesDeVenta;
    private javax.swing.JLabel jlDetalleDeFactura;
    private javax.swing.JLabel jlDia;
    private javax.swing.JLabel jlFactura;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel jlInfoCliente;
    private javax.swing.JLabel jlInfoCondicionesDeVenta;
    private javax.swing.JLabel jlInfoMozo;
    private javax.swing.JLabel jlInfoNumeroDeFactura;
    private javax.swing.JLabel jlInfoTipo;
    private javax.swing.JLabel jlMenos;
    private javax.swing.JLabel jlMes;
    private javax.swing.JLabel jlMozo;
    private javax.swing.JLabel jlNumeroDeFactura;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JTable jtDetalleFactura;
    // End of variables declaration//GEN-END:variables
}
