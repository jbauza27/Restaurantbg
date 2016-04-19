package interfaz;

import entidad.*;
import gestor.*;
import inicio.Inicio;
import interfaz.acontecimientosimportantes.*;
import interfaz.cliente.*;
import interfaz.empleado.*;
import interfaz.estadisticas.*;
import interfaz.facturacion.*;
import interfaz.materiaprima.*;
import interfaz.mesas.*;
import interfaz.movimientodestock.*;
import interfaz.preferencias.*;
import interfaz.productoelaborado.*;
import interfaz.proveedor.*;
import interfaz.reservas.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import org.hibernate.classic.Session;


/**
 * La ventana que se abrirá al iniciar el programa.
 */
public class IntPrincipal extends javax.swing.JFrame
{
    /* Atributos */
    private Session sesion;
    private GestorClientes gesCli;
    private GestorEmpleados gesEmp;
    private GestorMateriasPrimas gesMatPrim;
    private GestorMesas gesMes;
    private GestorProductosElaborados gesProdElab;
    private GestorProveedores gesProv;
    
    
    /* Constructor */
    public IntPrincipal(Session sesion)
    {
        initComponents();
        this.sesion = sesion;
        
        gesCli = new GestorClientes(sesion);
        gesEmp = new GestorEmpleados(sesion);
        gesMatPrim = new GestorMateriasPrimas(sesion);
        gesMes = new GestorMesas(sesion);
        gesProdElab = new GestorProductosElaborados(sesion);
        gesProv = new GestorProveedores(sesion);
    }

    
    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlLogoRestaurant = new javax.swing.JLabel();
        jlNombreRestaurant = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmArchivo = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();
        jmPersonas = new javax.swing.JMenu();
        jmClientes = new javax.swing.JMenu();
        jmiAltaClientes = new javax.swing.JMenuItem();
        jmiMostrarClientes = new javax.swing.JMenuItem();
        jmiVerPreferencias = new javax.swing.JMenuItem();
        jmEmpleados = new javax.swing.JMenu();
        jmiAltaEmpleados = new javax.swing.JMenuItem();
        jmiMostrarEmpleados = new javax.swing.JMenuItem();
        jmProveedores = new javax.swing.JMenu();
        jmiAltaProveedor = new javax.swing.JMenuItem();
        jmiMostrarProveedores = new javax.swing.JMenuItem();
        jmiAcontecimientosImportantes = new javax.swing.JMenuItem();
        jmiRecordatorio = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenu();
        jmMateriasPrimas = new javax.swing.JMenu();
        jmiAltaMateriasPrimas = new javax.swing.JMenuItem();
        jmiMostrarMateriasPrimas = new javax.swing.JMenuItem();
        jmProductosElaborados = new javax.swing.JMenu();
        jmiAltaProductosElaborados = new javax.swing.JMenuItem();
        jmiMostrarProductosElaborados = new javax.swing.JMenuItem();
        jmMovimientosDeStock = new javax.swing.JMenu();
        jmiControlDeStock = new javax.swing.JMenuItem();
        jmiMostrarMovimientos = new javax.swing.JMenuItem();
        jmFacturacion = new javax.swing.JMenu();
        jmiGenerarFactura = new javax.swing.JMenuItem();
        jmiBuscarFactura = new javax.swing.JMenuItem();
        jmMesas = new javax.swing.JMenu();
        jmiAltaMesas = new javax.swing.JMenuItem();
        jmiMostrarMesas = new javax.swing.JMenuItem();
        jmReservas = new javax.swing.JMenu();
        jmiGenerarReserva = new javax.swing.JMenuItem();
        jmiMostrarReservas = new javax.swing.JMenuItem();
        jmEstadisticas = new javax.swing.JMenu();
        jmiFacturacion = new javax.swing.JMenuItem();
        jmiClientes = new javax.swing.JMenuItem();
        jmiProductosElaborados = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\"");

        jlLogoRestaurant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogoRestaurant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/logo.jpg"))); // NOI18N

        jlNombreRestaurant.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jlNombreRestaurant.setForeground(new java.awt.Color(0, 153, 51));
        jlNombreRestaurant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombreRestaurant.setText("Restaurant \"Buen gusto\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogoRestaurant, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addComponent(jlNombreRestaurant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLogoRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlNombreRestaurant)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jmArchivo.setMnemonic('A');
        jmArchivo.setText("Archivo");

        jmiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmArchivo.add(jmiSalir);

        jMenuBar2.add(jmArchivo);

        jmPersonas.setMnemonic('P');
        jmPersonas.setText("Personas");

        jmClientes.setText("Clientes");

        jmiAltaClientes.setText("Alta clientes");
        jmiAltaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAltaClientesActionPerformed(evt);
            }
        });
        jmClientes.add(jmiAltaClientes);

        jmiMostrarClientes.setText("Mostrar clientes");
        jmiMostrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarClientesActionPerformed(evt);
            }
        });
        jmClientes.add(jmiMostrarClientes);

        jmiVerPreferencias.setText("Ver preferencias");
        jmiVerPreferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVerPreferenciasActionPerformed(evt);
            }
        });
        jmClientes.add(jmiVerPreferencias);

        jmPersonas.add(jmClientes);

        jmEmpleados.setText("Empleados");

        jmiAltaEmpleados.setText("Alta empleados");
        jmiAltaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAltaEmpleadosActionPerformed(evt);
            }
        });
        jmEmpleados.add(jmiAltaEmpleados);

        jmiMostrarEmpleados.setText("Mostrar empleados");
        jmiMostrarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarEmpleadosActionPerformed(evt);
            }
        });
        jmEmpleados.add(jmiMostrarEmpleados);

        jmPersonas.add(jmEmpleados);

        jmProveedores.setText("Proveedores");

        jmiAltaProveedor.setText("Alta proveedor");
        jmiAltaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAltaProveedorActionPerformed(evt);
            }
        });
        jmProveedores.add(jmiAltaProveedor);

        jmiMostrarProveedores.setText("Mostrar proveedores");
        jmiMostrarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarProveedoresActionPerformed(evt);
            }
        });
        jmProveedores.add(jmiMostrarProveedores);

        jmPersonas.add(jmProveedores);

        jmiAcontecimientosImportantes.setText("Acontecimientos importantes");
        jmiAcontecimientosImportantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAcontecimientosImportantesActionPerformed(evt);
            }
        });
        jmPersonas.add(jmiAcontecimientosImportantes);

        jmiRecordatorio.setText("Ver recordatorio próximas semanas");
        jmiRecordatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRecordatorioActionPerformed(evt);
            }
        });
        jmPersonas.add(jmiRecordatorio);

        jMenuBar2.add(jmPersonas);

        jmProductos.setMnemonic('R');
        jmProductos.setText("Productos");

        jmMateriasPrimas.setText("Materias primas");

        jmiAltaMateriasPrimas.setText("Alta materias primas");
        jmiAltaMateriasPrimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAltaMateriasPrimasActionPerformed(evt);
            }
        });
        jmMateriasPrimas.add(jmiAltaMateriasPrimas);

        jmiMostrarMateriasPrimas.setText("Mostrar materias primas");
        jmiMostrarMateriasPrimas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarMateriasPrimasActionPerformed(evt);
            }
        });
        jmMateriasPrimas.add(jmiMostrarMateriasPrimas);

        jmProductos.add(jmMateriasPrimas);

        jmProductosElaborados.setText("Productos elaborados");

        jmiAltaProductosElaborados.setText("Alta productos elaborados");
        jmiAltaProductosElaborados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAltaProductosElaboradosActionPerformed(evt);
            }
        });
        jmProductosElaborados.add(jmiAltaProductosElaborados);

        jmiMostrarProductosElaborados.setText("Mostrar productos elaborados");
        jmiMostrarProductosElaborados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarProductosElaboradosActionPerformed(evt);
            }
        });
        jmProductosElaborados.add(jmiMostrarProductosElaborados);

        jmProductos.add(jmProductosElaborados);

        jMenuBar2.add(jmProductos);

        jmMovimientosDeStock.setMnemonic('M');
        jmMovimientosDeStock.setText("Movimientos de stock");

        jmiControlDeStock.setText("Control de stock");
        jmiControlDeStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiControlDeStockActionPerformed(evt);
            }
        });
        jmMovimientosDeStock.add(jmiControlDeStock);

        jmiMostrarMovimientos.setText("Mostrar movimientos");
        jmiMostrarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarMovimientosActionPerformed(evt);
            }
        });
        jmMovimientosDeStock.add(jmiMostrarMovimientos);

        jMenuBar2.add(jmMovimientosDeStock);

        jmFacturacion.setText("Facturación");

        jmiGenerarFactura.setText("Generar factura");
        jmiGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenerarFacturaActionPerformed(evt);
            }
        });
        jmFacturacion.add(jmiGenerarFactura);

        jmiBuscarFactura.setText("Buscar factura");
        jmiBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBuscarFacturaActionPerformed(evt);
            }
        });
        jmFacturacion.add(jmiBuscarFactura);

        jMenuBar2.add(jmFacturacion);

        jmMesas.setText("Mesas");

        jmiAltaMesas.setText("Alta mesas");
        jmiAltaMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAltaMesasActionPerformed(evt);
            }
        });
        jmMesas.add(jmiAltaMesas);

        jmiMostrarMesas.setText("Mostrar mesas");
        jmiMostrarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarMesasActionPerformed(evt);
            }
        });
        jmMesas.add(jmiMostrarMesas);

        jMenuBar2.add(jmMesas);

        jmReservas.setText("Reservas");

        jmiGenerarReserva.setText("Generar reserva");
        jmiGenerarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGenerarReservaActionPerformed(evt);
            }
        });
        jmReservas.add(jmiGenerarReserva);

        jmiMostrarReservas.setText("Mostrar reservas");
        jmiMostrarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMostrarReservasActionPerformed(evt);
            }
        });
        jmReservas.add(jmiMostrarReservas);

        jMenuBar2.add(jmReservas);

        jmEstadisticas.setText("Estadísticas");

        jmiFacturacion.setText("Facturación");
        jmiFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFacturacionActionPerformed(evt);
            }
        });
        jmEstadisticas.add(jmiFacturacion);

        jmiClientes.setText("Clientes");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        jmEstadisticas.add(jmiClientes);

        jmiProductosElaborados.setText("Productos elaborados");
        jmiProductosElaborados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductosElaboradosActionPerformed(evt);
            }
        });
        jmEstadisticas.add(jmiProductosElaborados);

        jMenuBar2.add(jmEstadisticas);

        setJMenuBar(jMenuBar2);

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
     * Sale del programa.
     *
     * @param evt el evento de clic sobre el ítem de menú 
     */
    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSalirActionPerformed

    /**
     * Muestra los empleados que coincidan con los criterios especificados.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiMostrarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarEmpleadosActionPerformed
        IntBusquedaEmpleados intBusEmp = new IntBusquedaEmpleados(null, true, sesion);
        intBusEmp.setVisible(true);        
    }//GEN-LAST:event_jmiMostrarEmpleadosActionPerformed

    /**
     * Abre la ventana para dar de alta a un empleado.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiAltaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAltaEmpleadosActionPerformed
        IntAltaEmpleado intAltEmp = new IntAltaEmpleado(null, true, sesion);
        intAltEmp.setVisible(true);
    }//GEN-LAST:event_jmiAltaEmpleadosActionPerformed

    /**
     * Muestra los clientes que coincidan con los criterios especificados.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiMostrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarClientesActionPerformed
        IntBusquedaClientes intBusCli = new IntBusquedaClientes(null, true, sesion);
        intBusCli.setVisible(true);
    }//GEN-LAST:event_jmiMostrarClientesActionPerformed

    /**
     * Abre la ventana para dar de alta a un cliente.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiAltaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAltaClientesActionPerformed
        IntAltaCliente intAltCli = new IntAltaCliente(null, true, sesion);
        intAltCli.setVisible(true);
    }//GEN-LAST:event_jmiAltaClientesActionPerformed

    /**
     * Abre la ventana para dar de alta a un proveedor.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiAltaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAltaProveedorActionPerformed
        IntAltaProveedor intAltProv = new IntAltaProveedor(null, true, sesion);
        intAltProv.setVisible(true);
    }//GEN-LAST:event_jmiAltaProveedorActionPerformed

    /**
     * Muestra los proveedores que coincidan con los criterios especificados.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiMostrarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarProveedoresActionPerformed
        IntBusquedaProveedores intBusProv = new IntBusquedaProveedores(null, true, sesion);
        intBusProv.setVisible(true); 
    }//GEN-LAST:event_jmiMostrarProveedoresActionPerformed

    /**
     * Abre la ventana para dar de alta a una materia prima.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */    
    private void jmiAltaMateriasPrimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAltaMateriasPrimasActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE PROVEEDORES
        
           Para poder dar de alta materias primas, es necesario averiguar con
           anterioridad si hay o no proveedores en la base de datos. Si los hay,
           entonces se permite el alta de materias primas, caso contrario, no.
        */
        
        // primero, consulto si hay proveedores
        ArrayList<Proveedor> listaProv =
                gesProv.getListaProveedores();
        
        // si no los hay, muestro un mensaje de error
        if(listaProv.isEmpty() == true)
        {    
            IntAvisoParaMateriasPrimas intAviso = 
                    new IntAvisoParaMateriasPrimas(null, true, sesion);
            intAviso.setVisible(true);
        }
        // si existen proveedores, permito el ingreso a la interfaz de alta de
        // materias primas
        else
        {
            IntAltaMateriaPrima intAltMatPrim = new IntAltaMateriaPrima(null, true, sesion);
            intAltMatPrim.setVisible(true);
        } 
    }//GEN-LAST:event_jmiAltaMateriasPrimasActionPerformed

    /**
     * Muestra todas las materias primas.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */    
    private void jmiMostrarMateriasPrimasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarMateriasPrimasActionPerformed
        IntMostrarMateriasPrimas intMostMatPrim
                = new IntMostrarMateriasPrimas(null, true, sesion);
        intMostMatPrim.setVisible(true);
    }//GEN-LAST:event_jmiMostrarMateriasPrimasActionPerformed

    /**
     * Abre la ventana para dar de alta a un producto elaborado.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */    
    private void jmiAltaProductosElaboradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAltaProductosElaboradosActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE MATERIAS PRIMAS
        
           Para poder dar de alta productos elaborados, es necesario averiguar con
           anterioridad si hay o no materias primas en la base de datos. Si las hay,
           entonces se permite el alta de productos elaborados, caso contrario, no.
        */
        
        // primero, consulto si hay materias primas
        ArrayList<MateriaPrima> listaMatPrim =
                gesMatPrim.getListaMateriasPrimas();
        
        // si no las hay, muestro un mensaje de error
        if(listaMatPrim.isEmpty() == true)
        {    
            IntAvisoParaProductosElaborados intAviso = 
                    new IntAvisoParaProductosElaborados(null, true, sesion);
            intAviso.setVisible(true);
        }
        // si existen materias primas, permito el ingreso a la interfaz de alta de
        // productos elaborados
        else
        {
            IntAltaProductoElaborado intAltProdElab
                    = new IntAltaProductoElaborado(null, true, sesion);
            intAltProdElab.setVisible(true);
        } 
    }//GEN-LAST:event_jmiAltaProductosElaboradosActionPerformed

    /**
     * Muestra todos los productos elaborados.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */      
    private void jmiMostrarProductosElaboradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarProductosElaboradosActionPerformed
        IntMostrarProductosElaborados intMostProdElab
                = new IntMostrarProductosElaborados(null, true, sesion);
        intMostProdElab.setVisible(true);        
    }//GEN-LAST:event_jmiMostrarProductosElaboradosActionPerformed

    /**
     * Abre una ventana que permite realizar control de stock, haciendo entrada o
     * salida de materias primas y productos elaborados.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiControlDeStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiControlDeStockActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE MATERIAS PRIMAS O PRODUCTOS ELABORADOS
        
           Para poder realizar control de stock, es necesario averiguar con
           anterioridad si hay o no materias primas y productos elaborados en la
           base de datos. Si las hay, se permite realizar control de stock,
           caso contrario, no.
        */
        
        // primero, consulto si hay materias primas y productos elaborados con
        // estado 'activo'
        ArrayList<MateriaPrima> listaMatPrim =
                gesMatPrim.getListaMateriasPrimas();
        ArrayList<ProductoElaborado> listaProdElab =
                gesProdElab.getListaProductosElaboradosActivos();
        
        // si no hay ninguna de las dos cosas, muestro un mensaje de error
        if(listaMatPrim.isEmpty() == true && listaProdElab.isEmpty() == true)
        {    
            JOptionPane.showMessageDialog(null, "No puede realizar control de stock "
                    + "porque no hay materias primas ni productos elaborados almacenados",
                    "Control de stock",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen materias primas o productos elaborados (o ambos), permito el
        // ingreso a la interfaz de control de stock
        else
        {
            IntMovimientoDeStock intMovSto = new IntMovimientoDeStock(null, true, sesion);
            intMovSto.setVisible(true);
        } 
    }//GEN-LAST:event_jmiControlDeStockActionPerformed

    /**
     * Muestra todos los movimientos de stock.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */         
    private void jmiMostrarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarMovimientosActionPerformed
        IntMostrarMovimientosDeStock intMostMovSto
                = new IntMostrarMovimientosDeStock(null, true, sesion);
        intMostMovSto.setVisible(true);
    }//GEN-LAST:event_jmiMostrarMovimientosActionPerformed

    /**
     * Permite guardar una factura en la base de datos.
     * 
     * @param evt el evento de clic sobre el ítem de menú
     */
    private void jmiGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenerarFacturaActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE CLIENTES Y MOZOS
        
           Para poder facturar, es necesario averiguar con anterioridad si hay
           o no clientes y mozos en la base de datos. Si los hay, se permite
           facturar, caso contrario, no.
        */
        
        // primero, consulto si hay clientes y mozos con estado 'activo'
        ArrayList<Cliente> listaCli =
                gesCli.getListaClientes();
        ArrayList<Empleado> listaMozosActivos =
                gesEmp.getListaMozosActivos();
        
        // si falta alguna de las dos cosas, muestro un mensaje de error
        if(listaCli.isEmpty() == true || listaMozosActivos.isEmpty() == true)
        {    
            JOptionPane.showMessageDialog(null, "No puede facturar "
                    + "porque no hay clientes o mozos almacenados",
                    "Control de stock",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen clientes y empleados, permito el ingreso a la interfaz de 
        // facturación
        else
        {
            IntFacturacion intFac = new IntFacturacion(null, true, sesion);
            intFac.setVisible(true);
        }
    }//GEN-LAST:event_jmiGenerarFacturaActionPerformed

    /**
     * Permite buscar facturas que coincidan con criterios elegidos.
     * 
     * @param evt el evento de pulsación sobre el botón 'Buscar factura'
     */
    private void jmiBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBuscarFacturaActionPerformed
        IntBusquedaFactura intBusFac = new IntBusquedaFactura(null, true, sesion);
        intBusFac.setVisible(true);
    }//GEN-LAST:event_jmiBuscarFacturaActionPerformed

    /**
     * Permite ver preferencias de los clientes teniendo en cuenta las
     * consumiciones de los mismos.
     * 
     * @param evt el evento de pulsación sobre el botón 'Ver preferencias'
     */
    private void jmiVerPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVerPreferenciasActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE CLIENTES
        
           Para ver preferencias de clientes, es necesario averiguar con
           anterioridad si hay o no clientes en la base de datos. Si los hay,
           se muestra la interfaz de preferencias, caso contrario, no.
        */
        
        // primero, consulto si hay clientes
        ArrayList<Cliente> listaCli =
                gesCli.getListaClientes();
        
        // si no existen clientes, muestro un mensaje de error
        if(listaCli.isEmpty())
        {    
            JOptionPane.showMessageDialog(null, "No puede ver preferencias "
                    + "porque no hay clientes almacenados",
                    "Preferencias de clientes",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen clientes, permito el ingreso a la interfaz de preferencias
        else
        {               
            IntPreferencias intPref = new IntPreferencias(null, true, sesion);
            intPref.setVisible(true);
        }
    }//GEN-LAST:event_jmiVerPreferenciasActionPerformed

    /**
     * Muestra los acontecimientos importantes de clientes y empleados, como por
     * ejemplo los cumpleaños, y permite añadir otros y modificar los existentes.
     * 
     * @param evt el evento de pulsación sobre el botón 'Acontecimientos importantes'
     */
    private void jmiAcontecimientosImportantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAcontecimientosImportantesActionPerformed
        IntVerAcoImp intvai = new IntVerAcoImp(null, true, sesion);
        intvai.setVisible(true);
    }//GEN-LAST:event_jmiAcontecimientosImportantesActionPerformed

    /**
     * Permite ver los acontecimientos importantes que hay desde la fecha actual
     * hasta dos semanas adelante.
     * 
     * @param evt el evento de pulsación sobre el botón 'Ver recordatorio
     * próximas semanas'
     */
    private void jmiRecordatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRecordatorioActionPerformed
        GestorAcontecimientosImportantes gesRec = new GestorAcontecimientosImportantes(sesion);
        ArrayList<AcontecimientoImportante> listaRecordatorios = new ArrayList<>();
        
        listaRecordatorios = gesRec.getListaAcontecimientosImportantes();
        
        if(listaRecordatorios.isEmpty() == true)
        {
            JOptionPane.showMessageDialog(null, "No puede ver los recordatorios "
                    + "porque aún no hay acontecimientos importantes guardados",
                    "Recordatorios",
                    JOptionPane.ERROR_MESSAGE);            
        }
        else
        {
            GregorianCalendar fechaActual = new GregorianCalendar();
            int anioActual = fechaActual.get(Calendar.YEAR);
            int mesActual = fechaActual.get(Calendar.MONTH) + 1;
            int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
            
            Inicio.comprobarFechasImportantesEnDosSemanas(fechaActual);
        }
    }//GEN-LAST:event_jmiRecordatorioActionPerformed

    /**
     * Abre la ventana para dar de alta una mesa.
     * 
     * @param evt el evento de clic sobre el 'Alta mesas'
     */       
    private void jmiAltaMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAltaMesasActionPerformed
        IntAltaMesa intAltMes = new IntAltaMesa(null, true, sesion);
        intAltMes.setVisible(true);        
    }//GEN-LAST:event_jmiAltaMesasActionPerformed

    /**
     * Muestra todas las mesas.
     * 
     * @param evt el evento de clic sobre el botón 'Mostrar mesas'
     */          
    private void jmiMostrarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarMesasActionPerformed
        IntMostrarMesas intMostMes
                = new IntMostrarMesas(null, true, sesion);
        intMostMes.setVisible(true);                
    }//GEN-LAST:event_jmiMostrarMesasActionPerformed

    /**
     * Abre la ventana que permite generar una reserva.
     * 
     * @param evt el evento de pulsación sobre el botón 'Generar reserva'
     */
    private void jmiGenerarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGenerarReservaActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE MESAS
        
           Para poder generar reservas, es necesario averiguar con anterioridad
           si hay o no mesas en la base de datos. Si las hay, se muestra la
           interfaz de para generar reservas, caso contrario, no.
        */
        
        // primero, consulto si hay productos elaborados
        ArrayList<Mesa> listaMesas =
                gesMes.getListaMesas();
        
        // si no existen mesas, muestro un mensaje de error
        if(listaMesas.isEmpty())
        {    
            JOptionPane.showMessageDialog(null, "Necesita tener mesas "
                    + "en la base de datos para poder generar reservas",
                    "Generación de reservas",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen mesas, permito el ingreso a la interfaz de geenración de
        // reservas
        else
        {               
            IntAltaReserva intAltRes = new IntAltaReserva(null, true, sesion);
            intAltRes.setVisible(true);
        }
    }//GEN-LAST:event_jmiGenerarReservaActionPerformed

    /**
     * Muestra todas las reservas.
     * 
     * @param evt el evento de pulsación sobre el botón 'Mostrar reservas'
     */
    private void jmiMostrarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMostrarReservasActionPerformed
        IntMostrarReservas intMostRes
                = new IntMostrarReservas(null, true, sesion);
        intMostRes.setVisible(true);  
    }//GEN-LAST:event_jmiMostrarReservasActionPerformed

    /**
     * Permite ver estadísticas relacionadas con la facturación.
     * 
     * @param evt el evento de pulsación sobre el botón 'Facturación'
     */
    private void jmiFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFacturacionActionPerformed
        IntEstFacturacion intEstFac = new IntEstFacturacion(null, true, sesion);
        intEstFac.setVisible(true);
    }//GEN-LAST:event_jmiFacturacionActionPerformed

    /**
     * Permite ver estadísticas relacionadas con los clientes.
     * 
     * @param evt el evento de pulsación sobre el botón 'Clientes'
     */    
    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        IntEstClientes intEstCli = new IntEstClientes(null, true, sesion);
        intEstCli.setVisible(true);
    }//GEN-LAST:event_jmiClientesActionPerformed

    /**
     * Permite ver estadísticas relacionadas con los productos elaborados.
     * 
     * @param evt el evento de pulsación sobre el botón 'Productos elaborados'
     */      
    private void jmiProductosElaboradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductosElaboradosActionPerformed
        /*
           COMPROBACIÓN DE EXISTENCIA DE PRODUCTOS ELABORADOS
        
           Para ver las estadísticas de los productos elaborados, es necesario
           averiguar con anterioridad si hay o no productos elaborados en la
           base de datos. Si los hay, se muestra la interfaz de estadísticas
           de productos elaborados, caso contrario, no.
        */
        
        // primero, consulto si hay productos elaborados
        ArrayList<ProductoElaborado> listaProdElab =
                gesProdElab.getListaProductosElaborados();
        
        // si no existen productos elaborados, muestro un mensaje de error
        if(listaProdElab.isEmpty())
        {    
            JOptionPane.showMessageDialog(null, "Necesita tener productos "
                    + "elaborados en la base de datos para poder ver las "
                    + "estadísticas de los productos elaborados",
                    "Estadísticas de productos elaborados",
                    JOptionPane.ERROR_MESSAGE);
        }
        // si existen productos elaborados, permito el ingreso a la interfaz de
        // estadísticas de productos elaborados
        else
        {               
            IntEstProductosElaborados intEstProdElab = new IntEstProductosElaborados(null, true, sesion);
            intEstProdElab.setVisible(true);
        }        
    }//GEN-LAST:event_jmiProductosElaboradosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlLogoRestaurant;
    private javax.swing.JLabel jlNombreRestaurant;
    private javax.swing.JMenu jmArchivo;
    private javax.swing.JMenu jmClientes;
    private javax.swing.JMenu jmEmpleados;
    private javax.swing.JMenu jmEstadisticas;
    private javax.swing.JMenu jmFacturacion;
    private javax.swing.JMenu jmMateriasPrimas;
    private javax.swing.JMenu jmMesas;
    private javax.swing.JMenu jmMovimientosDeStock;
    private javax.swing.JMenu jmPersonas;
    private javax.swing.JMenu jmProductos;
    private javax.swing.JMenu jmProductosElaborados;
    private javax.swing.JMenu jmProveedores;
    private javax.swing.JMenu jmReservas;
    private javax.swing.JMenuItem jmiAcontecimientosImportantes;
    private javax.swing.JMenuItem jmiAltaClientes;
    private javax.swing.JMenuItem jmiAltaEmpleados;
    private javax.swing.JMenuItem jmiAltaMateriasPrimas;
    private javax.swing.JMenuItem jmiAltaMesas;
    private javax.swing.JMenuItem jmiAltaProductosElaborados;
    private javax.swing.JMenuItem jmiAltaProveedor;
    private javax.swing.JMenuItem jmiBuscarFactura;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiControlDeStock;
    private javax.swing.JMenuItem jmiFacturacion;
    private javax.swing.JMenuItem jmiGenerarFactura;
    private javax.swing.JMenuItem jmiGenerarReserva;
    private javax.swing.JMenuItem jmiMostrarClientes;
    private javax.swing.JMenuItem jmiMostrarEmpleados;
    private javax.swing.JMenuItem jmiMostrarMateriasPrimas;
    private javax.swing.JMenuItem jmiMostrarMesas;
    private javax.swing.JMenuItem jmiMostrarMovimientos;
    private javax.swing.JMenuItem jmiMostrarProductosElaborados;
    private javax.swing.JMenuItem jmiMostrarProveedores;
    private javax.swing.JMenuItem jmiMostrarReservas;
    private javax.swing.JMenuItem jmiProductosElaborados;
    private javax.swing.JMenuItem jmiRecordatorio;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiVerPreferencias;
    // End of variables declaration//GEN-END:variables
}
