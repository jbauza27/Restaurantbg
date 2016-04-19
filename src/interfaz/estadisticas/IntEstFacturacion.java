package interfaz.estadisticas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidad.Factura;
import gestor.GestorEstadisticas;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
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
import utilidades.Modelo;


/**
 * Interfaz diseñada para mostrar estadísticas de facturación, brindando la 
 * posibilidad de generar un reporte en formato 'pdf' y 'excel'.
 * 
 * Las estadísticas consisten en señalar cuanto se facturó en un determinado
 * período de tiempo, así como cuanto se facturó en cada mes de ese período.
 */
public class IntEstFacturacion extends javax.swing.JDialog
{
    /* Atributos */
    private GestorEstadisticas gesEst;
    private ArrayList<Factura> listaFacturas;
    private ArrayList<CantFacturas> listaCantFacturas;
    private Modelo modeloCantFac;
    private Session sesion; 
    private GregorianCalendar fechaActual;
    private int anioActual;
    private int mesActual;  
    private String tiempo;
    
    
    /* Constructor */
    public IntEstFacturacion(java.awt.Frame parent, boolean modal,
                    Session sesion)
    {
        super(parent, modal);
        initComponents();

        this.sesion = sesion;
        gesEst = new GestorEstadisticas(sesion);
        listaFacturas = new ArrayList<>();
        listaCantFacturas = new ArrayList<>();
        fechaActual = new GregorianCalendar();
        anioActual = fechaActual.get(Calendar.YEAR);
        mesActual = fechaActual.get(Calendar.MONTH)+1;
        jbGenerarPDF.setEnabled(false);
        jbGenerarExcel.setEnabled(false);
        
        // código para que la tabla aparezca inicialmente con los encabezados
        // de columna adecuados
        ArrayList<CantFacturas> vacio = new ArrayList<>();      
        modeloCantFac = gesEst.configurarModeloCantFacturas(modeloCantFac, vacio);        
        jtFacturacion.setModel(modeloCantFac);
        
        jtFacturacion.getColumn("Año y mes").setPreferredWidth(75);
        jtFacturacion.getColumn("Facturación total").setPreferredWidth(75);         
    }


    /* Métodos */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlEstadisticasDeFacturacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFacturacion = new javax.swing.JTable();
        jbGenerarTabla = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jlCantidadFacturas = new javax.swing.JLabel();
        jcbCantMeses = new javax.swing.JComboBox();
        jbGenerarPDF = new javax.swing.JButton();
        jbGenerarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurant \"Buen gusto\" - Estadísticas de facturación");

        jlEstadisticasDeFacturacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlEstadisticasDeFacturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEstadisticasDeFacturacion.setText("Estadísticas de facturación");

        jtFacturacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtFacturacion);

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

        jlCantidadFacturas.setText("Cantidad facturas últimos:");

        jcbCantMeses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3 meses", "6 meses", "12 meses" }));
        jcbCantMeses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCantMesesActionPerformed(evt);
            }
        });

        jbGenerarPDF.setText("Generar PDF");
        jbGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarPDFActionPerformed(evt);
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
            .addComponent(jlEstadisticasDeFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlCantidadFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbCantMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGenerarTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGenerarPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGenerarExcel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jbVolver)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlEstadisticasDeFacturacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCantidadFacturas)
                    .addComponent(jcbCantMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGenerarTabla)
                    .addComponent(jbGenerarPDF)
                    .addComponent(jbGenerarExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbVolver)
                .addGap(255, 255, 255))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(jcbCantMeses.getSelectedItem().toString().equals("3 meses"))
        {
            comprobarCantFacturas(3, -3);
            tiempo = "Últimos tres meses";
        }
        
        if(jcbCantMeses.getSelectedItem().toString().equals("6 meses"))
        {
            comprobarCantFacturas(6, -6);
            tiempo = "Últimos seis meses";            
        }
        
        if(jcbCantMeses.getSelectedItem().toString().equals("12 meses"))
        {
            comprobarCantFacturas(12, -12);
            tiempo = "Últimos doce meses";            
        }        
        
        jbGenerarPDF.setEnabled(true);
        jbGenerarExcel.setEnabled(true);
        
        actualizarTablaEstadisticas();
    }//GEN-LAST:event_jbGenerarTablaActionPerformed

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
    
    // nada, escribí este método por error
    private void jcbCantMesesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCantMesesActionPerformed

    }//GEN-LAST:event_jcbCantMesesActionPerformed

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
                
                com.itextpdf.text.Font fuenteTitulo = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 16, com.itextpdf.text.Font.BOLD);
                fuenteTitulo.setColor(BaseColor.GREEN);
                Paragraph titulo = new Paragraph("Restaurant \"Buen gusto\"", fuenteTitulo);
                titulo.setAlignment(Element.ALIGN_CENTER);
                doc.add(titulo);
                Image logo = Image.getInstance("logo.jpg");
                logo.setAlignment(Element.ALIGN_CENTER);            
                doc.add(logo);            
                com.itextpdf.text.Font fuenteTitulo1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.UNDERLINE | com.itextpdf.text.Font.BOLD);
                Paragraph estadisticas = new Paragraph("Estadísticas de facturación", fuenteTitulo1);
                estadisticas.setAlignment(Element.ALIGN_CENTER);
                doc.add(estadisticas);
                com.itextpdf.text.Font fComentario = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 8, com.itextpdf.text.Font.ITALIC);
                Paragraph comentario = new Paragraph(tiempo, fComentario);
                comentario.setAlignment(Element.ALIGN_CENTER);
                doc.add(comentario);

                // para insertar líneas en blanco
                doc.add(Chunk.NEWLINE);

                PdfPTable table = new PdfPTable(2); // 2 columnas
                com.itextpdf.text.Font formatoTituloTabla = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.BOLD);
                Paragraph tituloTabla = new Paragraph("Año y mes", formatoTituloTabla);
                tituloTabla.setAlignment(Element.ALIGN_CENTER);
                PdfPCell celda = new PdfPCell();
                celda.addElement(tituloTabla);
                table.addCell(celda);
                tituloTabla = new Paragraph("Facturación total", formatoTituloTabla);
                tituloTabla.setAlignment(Element.ALIGN_CENTER);
                celda = new PdfPCell();
                celda.addElement(tituloTabla);
                table.addCell(celda);
                com.itextpdf.text.Font fChica = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10);            

                for(CantFacturas cf : listaCantFacturas)
                {
                    Paragraph texto = new Paragraph(cf.getAnioyMes(), fChica);
                    texto.setAlignment(Element.ALIGN_CENTER);
                    celda = new PdfPCell();
                    celda.addElement(texto);
                    table.addCell(celda);
                    Integer n = cf.getCantFacturas();
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

    /**
     * Genera un reporte en Excel que contiene los datos solicitados.
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
                HSSFSheet hoja = libro.createSheet("Estadísticas de facturación");
                
                
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
                        col+1 // ña segunda columna
                        ));
                
                
                // Tercera fila, con un título
                fil++;
                fila = hoja.createRow(fil);
                
                // Celdas
                col = 0;
                celda = fila.createCell(col);
                
                col++;
                celda = fila.createCell(col);
                cadenaCelda = "Estadísticas de facturación";
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
                        fil, // mention first row here
                        fil, //mention last row here, it is 1 as we are doing a column wise merging
                        col, //mention first column of merging
                        col+1  //mention last column to include in merge
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
                cadenaCelda = "Año y mes";
                fuente = libro.createFont();
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);
                
                col++;
                celda = fila.createCell(col);
                cadenaCelda = "Facturación total";
                fuente = libro.createFont();
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);                
                
                
                // los períodos y cantidades
                for(CantFacturas cf : listaCantFacturas)
                {
                    fil++;
                    fila = hoja.createRow(fil);
                    // celdas
                    String anioyMes = cf.getAnioyMes();
                    Integer cantFac = cf.getCantFacturas();
                    String cadenaCantFac = cantFac.toString();
                    col = 0;
                    celda = fila.createCell(col);       
                    col++;
                    celda = fila.createCell(col);
                    cadenaCelda = anioyMes;
                    estilo = libro.createCellStyle();
                    estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);                    
                    celda.setCellValue(cadenaCelda);
                    celda.setCellStyle(estilo);  
                    col++;
                    celda = fila.createCell(col);
                    cadenaCelda = cadenaCantFac;
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
        modeloCantFac = gesEst.configurarModeloCantFacturas(modeloCantFac, listaCantFacturas);        
        jtFacturacion.setModel(modeloCantFac);
        
        jtFacturacion.getColumn("Año y mes").setPreferredWidth(75);
        jtFacturacion.getColumn("Facturación total").setPreferredWidth(75);        
    }
    
    /**
     * Comprueba la cantidad de facturas que se han emitido en el período 
     * solicitado, tanto total como por mes.
     * 
     * @param cantMesesPositivo la cantidad de meses solicitados en número positivo
     * @param cantMesesNegativo la cantidad de meses solicitados en número negativo
     */
    public void comprobarCantFacturas(int cantMesesPositivo, int cantMesesNegativo)
    {
        listaCantFacturas = new ArrayList<>();
        
        GregorianCalendar fechaAnterior = new GregorianCalendar();
        int anioAnterior;
        int mesAnterior;          
        GregorianCalendar fechaPosterior = new GregorianCalendar();
        int anioPosterior;
        int mesPosterior;  
        String nombreMes = "";        
            
        // 'mar' = "Meses a retroceder" - utilizo esta variable para ir
        // recorriendo todos los meses, uno por uno, según la cantidad
        // solicitada
        for(int i = 0, mar = 1 ; i <= cantMesesPositivo ; i++, mar--)
        {
            // variable para almacenar la cantidad de facturas
            int cantFac = 0;
            // si i es igual a 0, entonces calcularemos el total de facturas
            // emitidas en un período de varios meses
            if(i == 0)
            {            
                fechaAnterior.add(Calendar.MONTH, cantMesesNegativo);
                anioAnterior = fechaAnterior.get(Calendar.YEAR);
                mesAnterior = fechaAnterior.get(Calendar.MONTH)+1;

                String hql = "FROM Factura F WHERE F.estado = true AND "
                        + "F.fecha BETWEEN '" + anioAnterior
                        + "-" + mesAnterior
                        + "-" + "1"
                        + "' AND '" + anioActual
                        + "-" + mesActual
                        + "-" + "1" + "'";
                Query query = sesion.createQuery(hql);
                listaFacturas = (ArrayList<Factura>) query.list();

                for(Factura fac : listaFacturas)
                {
                    cantFac++;
                }

                CantFacturas cf = new CantFacturas();
                cf.setAnioyMes("Cantidad total de facturas");
                cf.setCantFacturas(cantFac);

                listaCantFacturas.add(cf);                    
            }
            // caso contrario, calculamos la cantidad de facturas emitidas
            // en un mes dado
            else
            {
                fechaPosterior = new GregorianCalendar();
                fechaAnterior = new GregorianCalendar();
                fechaPosterior.add(Calendar.MONTH, mar);
                anioPosterior = fechaPosterior.get(Calendar.YEAR);
                mesPosterior = fechaPosterior.get(Calendar.MONTH)+1;
                int temp = mar-1;
                fechaAnterior.add(Calendar.MONTH, temp);
                anioAnterior = fechaAnterior.get(Calendar.YEAR);
                mesAnterior = fechaAnterior.get(Calendar.MONTH)+1;
                
                String hql = "FROM Factura F WHERE F.estado = true AND "
                        + "F.fecha BETWEEN '" + anioAnterior
                        + "-" + mesAnterior
                        + "-" + "1"
                        + "' AND '" + anioPosterior
                        + "-" + mesPosterior
                        + "-" + "1" + "'";
                Query query = sesion.createQuery(hql);
                listaFacturas = (ArrayList<Factura>) query.list();

                for(Factura fac : listaFacturas)
                {
                    cantFac++;
                }

                CantFacturas cf = new CantFacturas();            
                nombreMes = darNombreMes(mesAnterior);
                cf.setAnioyMes(anioAnterior + " - " + nombreMes);
                cf.setCantFacturas(cantFac);
                
                listaCantFacturas.add(cf);                       
            }
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGenerarExcel;
    private javax.swing.JButton jbGenerarPDF;
    private javax.swing.JButton jbGenerarTabla;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox jcbCantMeses;
    private javax.swing.JLabel jlCantidadFacturas;
    private javax.swing.JLabel jlEstadisticasDeFacturacion;
    private javax.swing.JTable jtFacturacion;
    // End of variables declaration//GEN-END:variables
}
