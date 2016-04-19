package interfaz.estadisticas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidad.*;
import gestor.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import utilidades.Campos;
import utilidades.Fecha;
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar estadísticas de clientes, brindando la 
 * posibilidad de generar un reporte en formato 'pdf' y 'excel'.
 * 
 * Las estadísticas consisten en señalar cuales clientes comieron en el restaurant
 * en un determinado período de tiempo, dando además a conocer la cantidad de 
 * veces que lo hicieron y ordenándolos por esa misma cantidad en forma descendente.
 */
public class IntEstClientes extends javax.swing.JDialog
{
    /* Atributos */
    private GestorEstadisticas gesEst;
    private GestorClientes gesCli;
    private ArrayList<Factura> listaFacturas;    
    private ArrayList<CantVecesCliente> listaCVClientes;
    private Modelo modeloCantCli;
    private Session sesion;         
    private int anioDesde;
    private int mesDesde;
    private int diaDesde;
    private int anioHasta;
    private int mesHasta;
    private int diaHasta;
    private String tiempo;
    
    
    /* Constructor */
    public IntEstClientes(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesEst = new GestorEstadisticas(sesion);
        gesCli = new GestorClientes(sesion);
        listaFacturas = new ArrayList<>();        
        listaCVClientes = new ArrayList<>();

        jbGenerarPDF.setEnabled(false);
        jbGenerarExcel.setEnabled(false);
        
        // código para que la tabla aparezca inicialmente con los encabezados
        // de columna adecuados 
        ArrayList<CantVecesCliente> vacio = new ArrayList<>();
        modeloCantCli = gesEst.configurarModeloCantVecesCliente(modeloCantCli, vacio);
        jtClientes.setModel(modeloCantCli);
        
        jtClientes.getColumn("Cliente").setPreferredWidth(225);
        jtClientes.getColumn("Cantidad de veces que asistió").setPreferredWidth(125);         
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlEstadisticasDeClientes = new javax.swing.JLabel();
        jbGenerarTabla = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbGenerarPDF = new javax.swing.JButton();
        jlPeriodoDeTiempo = new javax.swing.JLabel();
        jtfDiaDesde = new javax.swing.JTextField();
        jlBarraUno = new javax.swing.JLabel();
        jtfMesDesde = new javax.swing.JTextField();
        jlBarraDos = new javax.swing.JLabel();
        jtfAnioDesde = new javax.swing.JTextField();
        jlFlecha = new javax.swing.JLabel();
        jtfDiaHasta = new javax.swing.JTextField();
        jlBarraTres = new javax.swing.JLabel();
        jtfMesHasta = new javax.swing.JTextField();
        jlBarraCuatro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jtfAnioHasta = new javax.swing.JTextField();
        jbGenerarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Estadísticas de clientes");

        jlEstadisticasDeClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlEstadisticasDeClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEstadisticasDeClientes.setText("Estadísticas de clientes");

        jbGenerarTabla.setText("Generar tabla");
        jbGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarTablaActionPerformed(evt);
            }
        });

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbGenerarPDF.setText("Generar PDF");
        jbGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarPDFActionPerformed(evt);
            }
        });

        jlPeriodoDeTiempo.setText("Período de tiempo:");

        jtfDiaDesde.setText("dd");
        jtfDiaDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDiaDesdeActionPerformed(evt);
            }
        });
        jtfDiaDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaDesdeKeyTyped(evt);
            }
        });

        jlBarraUno.setText("/");

        jtfMesDesde.setText("mm");
        jtfMesDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesDesdeKeyTyped(evt);
            }
        });

        jlBarraDos.setText("/");

        jtfAnioDesde.setText("aaaa");
        jtfAnioDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioDesdeKeyTyped(evt);
            }
        });

        jlFlecha.setText("->");

        jtfDiaHasta.setText("dd");
        jtfDiaHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDiaHastaKeyTyped(evt);
            }
        });

        jlBarraTres.setText("/");

        jtfMesHasta.setText("mm");
        jtfMesHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMesHastaKeyTyped(evt);
            }
        });

        jlBarraCuatro.setText("/");

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtClientes);

        jtfAnioHasta.setText("aaaa");
        jtfAnioHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnioHastaKeyTyped(evt);
            }
        });

        jbGenerarExcel.setText("Generar Excel");
        jbGenerarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlEstadisticasDeClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jbVolver))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbGenerarTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGenerarPDF))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlPeriodoDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBarraUno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBarraDos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlFlecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBarraTres)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlBarraCuatro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbGenerarExcel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlEstadisticasDeClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPeriodoDeTiempo)
                    .addComponent(jtfDiaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarraUno)
                    .addComponent(jtfMesDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarraDos)
                    .addComponent(jtfAnioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFlecha)
                    .addComponent(jtfDiaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarraTres)
                    .addComponent(jtfMesHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBarraCuatro)
                    .addComponent(jtfAnioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGenerarTabla)
                    .addComponent(jbGenerarPDF)
                    .addComponent(jbGenerarExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbVolver)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana y vuelve al menú anterior.
     * 
     * @param evt el evento de clic sobre el botón 'Volver'
     */
    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    /**
     * Genera la tabla de estadísticas según la cantidad de meses solicitada.
     * 
     * @param evt el evento de clic sobre el botón 'Generar tabla'
     */
    private void jbGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarTablaActionPerformed
        // vacío el arreglo de modo que no conserve y utilice los resultados
        // anteriores a la hora de generar la tabla
        listaCVClientes.clear();
        
        /* VALIDACIONES */        
        String mensajeDeError = "Se han producido los siguientes errores:\n\n";
        boolean error = false;
        
        /* Me cercioro que no hay campos vacíos */
        if(        jtfDiaDesde.getText().equals("") || jtfMesDesde.getText().equals("")
                || jtfAnioDesde.getText().equals("")                 
                || jtfDiaDesde.getText().equals("dd") || jtfDiaDesde.getText().equals("d")
                || jtfDiaDesde.getText().equals("")
                || jtfMesDesde.getText().equals("mm") || jtfMesDesde.getText().equals("m")
                || jtfMesDesde.getText().equals("")
                || jtfAnioDesde.getText().equals("aaaa") || jtfAnioDesde.getText().equals("aaa")
                || jtfAnioDesde.getText().equals("aa") || jtfAnioDesde.getText().equals("a")
                || jtfAnioDesde.getText().equals("")
                || jtfDiaHasta.getText().equals("") || jtfMesHasta.getText().equals("")
                || jtfAnioHasta.getText().equals("")                 
                || jtfDiaHasta.getText().equals("dd") || jtfDiaHasta.getText().equals("d")
                || jtfDiaHasta.getText().equals("")
                || jtfMesHasta.getText().equals("mm") || jtfMesHasta.getText().equals("m")
                || jtfMesHasta.getText().equals("")
                || jtfAnioHasta.getText().equals("aaaa") || jtfAnioHasta.getText().equals("aaa")
                || jtfAnioHasta.getText().equals("aa") || jtfAnioHasta.getText().equals("a")
                || jtfAnioHasta.getText().equals("")
          )
        {
            mensajeDeError = mensajeDeError + "- Debe llenar todos los campos.\n";
            error = true;
        }
        
        /* Valido que la primera fecha ingresada pueda existir */
        if( !(jtfDiaDesde.getText().equals("dd")) &&
            !(jtfDiaDesde.getText().equals("d"))  &&
            !(jtfDiaDesde.getText().equals("")) &&    
            !(jtfMesDesde.getText().equals("mm")) &&
            !(jtfMesDesde.getText().equals("m")) &&    
            !(jtfMesDesde.getText().equals("")) &&    
            !(jtfAnioDesde.getText().equals("aaaa")) && 
            !(jtfAnioDesde.getText().equals("aaa")) &&
            !(jtfAnioDesde.getText().equals("aa")) &&
            !(jtfAnioDesde.getText().equals("a")) &&
            !(jtfAnioDesde.getText().equals("")))
        {
            Fecha fec = new Fecha();
            int dia = Integer.parseInt(jtfDiaDesde.getText());
            int mes = Integer.parseInt(jtfMesDesde.getText());
            int anio = Integer.parseInt(jtfAnioDesde.getText());
        
            boolean fechaValida = fec.validarFecha(anio, mes, dia);
        
            if(fechaValida == false)
            {
                mensajeDeError = mensajeDeError + "- La primera fecha ingresada "
                        + "del período de tiempo no es correcta.\n"; 
                error = true;
            }        
        }
        
        /* Valido que la segunda fecha ingresada pueda existir */
        if( !(jtfDiaHasta.getText().equals("dd")) &&
            !(jtfDiaHasta.getText().equals("d"))  &&
            !(jtfDiaHasta.getText().equals("")) &&    
            !(jtfMesHasta.getText().equals("mm")) &&
            !(jtfMesHasta.getText().equals("m")) &&    
            !(jtfMesHasta.getText().equals("")) &&    
            !(jtfAnioHasta.getText().equals("aaaa")) && 
            !(jtfAnioHasta.getText().equals("aaa")) &&
            !(jtfAnioHasta.getText().equals("aa")) &&
            !(jtfAnioHasta.getText().equals("a")) &&
            !(jtfAnioHasta.getText().equals("")))
        {
            Fecha fec = new Fecha();
            int dia = Integer.parseInt(jtfDiaHasta.getText());
            int mes = Integer.parseInt(jtfMesHasta.getText());
            int anio = Integer.parseInt(jtfAnioHasta.getText());
        
            boolean fechaValida = fec.validarFecha(anio, mes, dia);
        
            if(fechaValida == false)
            {
                mensajeDeError = mensajeDeError + "- La segunda fecha ingresada "
                        + "del período de tiempo no es correcta.\n"; 
                error = true;
            }        
        }
        
        /* Valido que la segunda fecha del período no sea mayor que la primera */
        // si previamente hay errores, ni siquiera entro a realizar esta comparación
        if(error == false)
        {
            Fecha fec = new Fecha();
            int dia1 = Integer.parseInt(jtfDiaDesde.getText());
            int mes1 = Integer.parseInt(jtfMesDesde.getText()) - 1;
            int anio1 = Integer.parseInt(jtfAnioDesde.getText());
            GregorianCalendar primeraFecha = 
                    new GregorianCalendar(anio1, mes1, dia1);
            int dia2 = Integer.parseInt(jtfDiaHasta.getText());
            int mes2 = Integer.parseInt(jtfMesHasta.getText()) - 1;
            int anio2 = Integer.parseInt(jtfAnioHasta.getText());
            GregorianCalendar segundaFecha = 
                    new GregorianCalendar(anio2, mes2, dia2);            
            
            int res = fec.comparacionDeFechas(primeraFecha, segundaFecha);
            if(res == 0 || res == 1)
            {
                mensajeDeError = mensajeDeError + "- La primera fecha no puede "
                        + "ser ni igual ni mayor a la segunda.\n";
                error = true;                
            }
        }
        
        
        /* Si existen errores, envío una notificación al usuario, caso contrario, 
         * realizo la operación de cálculo de cliente. */
        if(error == true)
        {
            JOptionPane.showMessageDialog(null,
                    mensajeDeError,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        /* CÁLCULO DE CLIENTES */
        else
        {
            // obtengo las fechas del período
            anioDesde = Integer.parseInt(jtfAnioDesde.getText());
            mesDesde = Integer.parseInt(jtfMesDesde.getText());
            diaDesde = Integer.parseInt(jtfDiaDesde.getText());        
            anioHasta = Integer.parseInt(jtfAnioHasta.getText());
            mesHasta = Integer.parseInt(jtfMesHasta.getText());
            diaHasta = Integer.parseInt(jtfDiaHasta.getText());        

            tiempo = "Desde el " + diaDesde + " de " + darNombreMes(mesDesde) + " de " 
                    + anioDesde 
                    + " hasta el " + diaHasta + " de " + darNombreMes(mesHasta) + " de "
                    + anioHasta;

            // obtengo todas las facturas que estén en el período de tiempo ingresado
            String hql = "FROM Factura F WHERE F.estado = true AND "
                            + "F.fecha BETWEEN '" + anioDesde
                            + "-" + mesDesde
                            + "-" + diaDesde
                            + "' AND '" + anioHasta
                            + "-" + mesHasta
                            + "-" + diaHasta + "'";
            Query query = sesion.createQuery(hql);
            listaFacturas = (ArrayList<Factura>) query.list();        

            // Pasos a seguir:
            // Recorro las facturas
            // En cada factura:
            //      a- si el arreglo de clientes está vacío, añado el cliente de la factura
            //      b- caso contrario:
            //          * recorro el arreglo de clientes:
            //          * si encuentro un cliente con el mismo 'id' del cliente de la factura,
            //          le sumo 1 a la cantidad de veces que compró en el período elegido
            //          * caso contrario, añado el cliente al arreglo de clientes
            for(Factura f : listaFacturas)
            {
                int idCliente = f.getCliente().getId();

                if(listaCVClientes.isEmpty())
                {
                    CantVecesCliente c = new CantVecesCliente();
                    c.setIdCliente(idCliente);
                    c.setCantVecesAsistio(1);
                    listaCVClientes.add(c);
                }
                else
                {
                    boolean clienteExiste = false;
                    int posArreglo = 0;

                    arreglo_de_clientes:
                    for(CantVecesCliente c : listaCVClientes)
                    {
                        if(idCliente == c.getIdCliente())
                        {
                            int cantVeces = c.getCantVecesAsistio();
                            cantVeces++;
                            c.setCantVecesAsistio(cantVeces);
                            listaCVClientes.set(posArreglo, c);
                            clienteExiste = true;

                            break arreglo_de_clientes;
                        }

                        posArreglo++;
                    }

                    if(clienteExiste == false)
                    {
                        CantVecesCliente c = new CantVecesCliente();
                        c.setIdCliente(idCliente);
                        c.setCantVecesAsistio(1);
                        listaCVClientes.add(c);                    
                    }
                }
            }

            listaCVClientes.sort(null);
        }
        
        jbGenerarPDF.setEnabled(true);
        jbGenerarExcel.setEnabled(true);
        
        actualizarTablaEstadisticas();
    }//GEN-LAST:event_jbGenerarTablaActionPerformed

    /**
     * Genera un reporte en PDF que contiene los datos solicitados.
     * 
     * @param evt el evento de pulsación sobre el botón 'Generar PDF'
     */
    private void jbGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarPDFActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File("."));
        
        int resultado = selector.showSaveDialog(null);        
        
        FileOutputStream salida;
        try
        {
            if(resultado == JFileChooser.APPROVE_OPTION)
            {
                String directorio = selector.getSelectedFile().getAbsolutePath();        
                salida = new FileOutputStream(directorio);
                Document doc = new Document();
                PdfWriter.getInstance(doc, salida);
                doc.open();
                Font fuenteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
                fuenteTitulo.setColor(BaseColor.GREEN);
                Paragraph titulo = new Paragraph("Restaurant \"Buen gusto\"", fuenteTitulo);
                titulo.setAlignment(Element.ALIGN_CENTER);
                doc.add(titulo);
                Image logo = Image.getInstance("logo.jpg");
                logo.setAlignment(Element.ALIGN_CENTER);            
                doc.add(logo);            
                Font fuenteTitulo1 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE | Font.BOLD);
                Paragraph estadisticas = new Paragraph("Estadísticas de clientes", fuenteTitulo1);
                estadisticas.setAlignment(Element.ALIGN_CENTER);
                doc.add(estadisticas);
                Font fComentario = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.ITALIC);
                Paragraph comentario = new Paragraph(tiempo, fComentario);
                comentario.setAlignment(Element.ALIGN_CENTER);
                doc.add(comentario);

                // para insertar líneas en blanco
                doc.add(Chunk.NEWLINE);

                PdfPTable table = new PdfPTable(2); // 2 columnas
                Font formatoTituloTabla = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
                Paragraph tituloTabla = new Paragraph("Cliente", formatoTituloTabla);
                tituloTabla.setAlignment(Element.ALIGN_CENTER);
                PdfPCell celda = new PdfPCell();
                celda.addElement(tituloTabla);
                table.addCell(celda);
                tituloTabla = new Paragraph("Cantidad de veces que asistió", formatoTituloTabla);
                tituloTabla.setAlignment(Element.ALIGN_CENTER);
                celda = new PdfPCell();
                celda.addElement(tituloTabla);
                table.addCell(celda);
                Font fChica = new Font(Font.FontFamily.TIMES_ROMAN, 10);            

                for(CantVecesCliente cvc : listaCVClientes)
                {
                    Cliente cli = gesCli.buscarPorId(cvc.getIdCliente());
                    String cliente = cli.getApellido() + " " + cli.getNombre();
                    Paragraph texto = new Paragraph(cliente, fChica);
                    texto.setAlignment(Element.ALIGN_CENTER);
                    celda = new PdfPCell();
                    celda.addElement(texto);
                    table.addCell(celda);
                    Integer n = cvc.getCantVecesAsistio();
                    String t = n.toString();
                    texto = new Paragraph(t, fChica);
                    texto.setAlignment(Element.ALIGN_CENTER);
                    celda = new PdfPCell();
                    celda.addElement(texto);                
                    table.addCell(celda);
                }

                doc.add(table);
                doc.close();
                salida.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch(DocumentException e)
        {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_jbGenerarPDFActionPerformed

    // nada, coloqué este método por error
    private void jtfDiaDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDiaDesdeActionPerformed
        
    }//GEN-LAST:event_jtfDiaDesdeActionPerformed

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
     * Genera un reporte en 'Excel' que contiene los datos solicitados.
     * 
     * @param evt el evento de pulsación sobre el botón 'Generar Excel'
     */    
    private void jbGenerarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarExcelActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File("."));
        
        int resultado = selector.showSaveDialog(null);        
        
        FileOutputStream salida;
        try
        {
            if(resultado == JFileChooser.APPROVE_OPTION)
            {
                int fil = 0;
                int col = 0;
                String directorio = selector.getSelectedFile().getAbsolutePath();        
                salida = new FileOutputStream(directorio);
                
                // Creamos una instancia de la clase HSSFWorkbook llamada libro
                HSSFWorkbook libro = new HSSFWorkbook();

                // Creamos una instancia de la clase HSSFSheet llamada hoja y la
                // creamos
                HSSFSheet hoja = libro.createSheet("Estadísticas de clientes");
                
                
                // Creamos una instancia de la clase HSSFRow llamada fila y
                // creamos la fila con el indice 0. Esta fila irá en blanco
                HSSFRow fila = hoja.createRow(fil);
                
                // Creamos la segunda fila, que contendrá el nombre del restaurant
                fil++;
                fila = hoja.createRow(fil);                
                
                // Creamos las celdas
                HSSFCell celda = fila.createCell(col);
                
                col++;
                celda = fila.createCell(col);
                String cadenaCelda = "Restaurant 'Buen Gusto'";
                HSSFFont fuente = libro.createFont();
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                fuente.setColor(HSSFColor.GREEN.index);
                fuente.setFontHeightInPoints((short)18);
                HSSFCellStyle estilo = libro.createCellStyle();
                estilo.setFont(fuente);           
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);
                hoja.addMergedRegion(new CellRangeAddress(
                        fil,  // la primera fila
                        fil,  // la segunda fila
                        col,  // la primera columna
                        col+1 // la segunda columna
                        ));
                
                
                // Tercera fila, con un título
                fil++;
                fila = hoja.createRow(fil);
                
                // Celdas
                col = 0;
                celda = fila.createCell(col);
                
                col++;
                celda = fila.createCell(col);
                cadenaCelda = "Estadísticas de clientes";
                fuente = libro.createFont();
                fuente.setFontHeightInPoints((short)12);
                fuente.setUnderline(HSSFFont.U_SINGLE);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);
                hoja.addMergedRegion(new CellRangeAddress(
                        fil,  // la primera fila
                        fil,  // la segunda fila
                        col,  // la primera columna
                        col+1 // la segunda columna
                        ));                
                
                // Cuarta fila, con el tiempo de facturación
                fil++;
                fila = hoja.createRow(fil);
                
                // Celdas
                col = 0;
                celda = fila.createCell(col);
                
                col++;
                celda = fila.createCell(col);
                cadenaCelda = tiempo;
                fuente = libro.createFont();
                fuente.setFontHeightInPoints((short)10);
                fuente.setItalic(true);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);
                hoja.addMergedRegion(new CellRangeAddress(
                        fil,  // la primera fila
                        fil,  // la segunda fila
                        col,  // la primera columna
                        col+1 // la segunda columna
                        ));                
                
                // Quinta fila, una fila vacía
                fil++;
                fila = hoja.createRow(fil);
                
                // Sexta fila
                fil++;
                fila = hoja.createRow(fil);
                // celdas
                col = 0;
                celda = fila.createCell(col);
                
                col++;
                celda = fila.createCell(col);
                cadenaCelda = "Cliente";
                fuente = libro.createFont();
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);
                
                col++;
                celda = fila.createCell(col);
                cadenaCelda = "Cantidad de veces que asistió";
                fuente = libro.createFont();
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);             
                
                // los clientes y la cantidad de veces que asistieron
                for(CantVecesCliente cvc : listaCVClientes)
                {
                    // creación de filas
                    fil++;
                    fila = hoja.createRow(fil);
                    // celdas
                    Cliente cli = gesCli.buscarPorId(cvc.getIdCliente());
                    String cliente = cli.getApellido() + " " + cli.getNombre();
                    Integer n = cvc.getCantVecesAsistio();
                    String t = n.toString();
                    
                    col = 0;
                    celda = fila.createCell(col);       
                    col++;
                    celda = fila.createCell(col);
                    cadenaCelda = cliente;
                    estilo = libro.createCellStyle();
                    estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);                    
                    celda.setCellValue(cadenaCelda);
                    celda.setCellStyle(estilo);  
                    col++;
                    celda = fila.createCell(col);
                    cadenaCelda = t;
                    estilo = libro.createCellStyle();
                    estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);                    
                    celda.setCellValue(cadenaCelda);  
                    celda.setCellStyle(estilo);  
                }                     
                
                hoja.autoSizeColumn(1, true);
                hoja.autoSizeColumn(2);
                
                libro.write(salida);
                salida.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }                
    }//GEN-LAST:event_jbGenerarExcelActionPerformed

    /**
     * Actualiza la tabla de estadísticas.
     */
    public void actualizarTablaEstadisticas()
    {        
        modeloCantCli = gesEst.configurarModeloCantVecesCliente(modeloCantCli, listaCVClientes);
        jtClientes.setModel(modeloCantCli);
        
        jtClientes.getColumn("Cliente").setPreferredWidth(225);
        jtClientes.getColumn("Cantidad de veces que asistió").setPreferredWidth(125);        
    }    

    /**
     * Recibe el número de un mes y devuelve ese mismo mes en texto.
     * 
     * @param nroMes un mes en número
     * @return el mes que se envió en texto
     */
    public String darNombreMes(int nroMes)
    {
        String nombreMes = "";
        
        if(nroMes == 1)
        {
            nombreMes = "Enero";
        }
        else if(nroMes == 2)
        {
            nombreMes = "Febrero";
        }
        else if(nroMes == 3)
        {
            nombreMes = "Marzo";
        }
        else if(nroMes == 4)
        {
            nombreMes = "Abril";
        }
        else if(nroMes == 5)
        {
            nombreMes = "Mayo";
        }
        else if(nroMes == 6)
        {
            nombreMes = "Junio";
        }
        else if(nroMes == 7)
        {
            nombreMes = "Julio";
        }
        else if(nroMes == 8)
        {
            nombreMes = "Agosto";
        }
        else if(nroMes == 9)
        {
            nombreMes = "Setiembre";
        }
        else if(nroMes == 10)
        {
            nombreMes = "Octubre";
        }
        else if(nroMes == 11)
        {
            nombreMes = "Noviembre";
        }
        else if(nroMes == 12)
        {
            nombreMes = "Diciembre";
        }
        
        return nombreMes;
    }    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGenerarExcel;
    private javax.swing.JButton jbGenerarPDF;
    private javax.swing.JButton jbGenerarTabla;
    private javax.swing.JButton jbVolver;
    private javax.swing.JLabel jlBarraCuatro;
    private javax.swing.JLabel jlBarraDos;
    private javax.swing.JLabel jlBarraTres;
    private javax.swing.JLabel jlBarraUno;
    private javax.swing.JLabel jlEstadisticasDeClientes;
    private javax.swing.JLabel jlFlecha;
    private javax.swing.JLabel jlPeriodoDeTiempo;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtfAnioDesde;
    private javax.swing.JTextField jtfAnioHasta;
    private javax.swing.JTextField jtfDiaDesde;
    private javax.swing.JTextField jtfDiaHasta;
    private javax.swing.JTextField jtfMesDesde;
    private javax.swing.JTextField jtfMesHasta;
    // End of variables declaration//GEN-END:variables
}
