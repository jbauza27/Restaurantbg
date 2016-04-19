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
 * Interfaz diseñada para mostrar estadísticas de productos elaborados,
 * brindando la posibilidad de generar un reporte en formato 'pdf' y 'excel'.
 * 
 * Las estadísticas consisten en señalar cuantas veces un determinado producto
 * fue consumido por cada cliente.
 */
public class IntEstProductosElaborados extends javax.swing.JDialog
{
    /* Atributos */
    private Session sesion; 
    private ArrayList<ProductoElaborado> listaProdElab;
    private ArrayList<DetalleFactura> listaDetallesFacturas;
    private ArrayList<CantConsumicionesXCliente> listaCantConsumicionesXCliente;
    private GestorClientes gesCli;
    private GestorEstadisticas gesEst;
    private GestorProductosElaborados gesProdElab;
    private Modelo modeloCantCons;
    private String comida;
    
    
    /* Constructor */
    public IntEstProductosElaborados(java.awt.Frame parent, boolean modal, Session sesion)
    {
        super(parent, modal);
        initComponents();
        
        this.sesion = sesion;
        listaProdElab = new ArrayList<>();    
        listaDetallesFacturas = new ArrayList<>();
        listaCantConsumicionesXCliente = new ArrayList<>();
        gesCli = new GestorClientes(sesion);
        gesEst = new GestorEstadisticas(sesion);
        gesProdElab = new GestorProductosElaborados(sesion);
        
        cargarProductosElaborados();
        
        jbGenerarPDF.setEnabled(false);
        jbGenerarExcel.setEnabled(false);
        
        // código para que la tabla aparezca inicialmente con los encabezados
        // de columna adecuados 
        ArrayList<CantConsumicionesXCliente> vacio = new ArrayList<>();        
        modeloCantCons = gesEst.configurarModeloCantVecesPE
            (modeloCantCons, vacio);
        jtProductosElaborados.setModel(modeloCantCons);
        
        jtProductosElaborados.getColumn("Cliente").setPreferredWidth(225);
        jtProductosElaborados.getColumn("Cantidad de veces que consumió el producto").setPreferredWidth(125);         
    }
    
    
    /* Métodos */
    /**
     * Llena el combo productos elaborados con todos los productos elaborados
     * almacenados en la base de datos.
     */
    public void cargarProductosElaborados()
    {
        listaProdElab = gesProdElab.getListaProductosElaborados();
        String prodElab = "";
        
        for(ProductoElaborado pe : listaProdElab)
        {
            prodElab = pe.getId() + " - " + pe.getNombre();
            jcbProductosElaborados.addItem(prodElab);            
        }
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlEstadisticasDeProductosElaborados = new javax.swing.JLabel();
        jlProductosElaborados = new javax.swing.JLabel();
        jcbProductosElaborados = new javax.swing.JComboBox();
        jbGenerarTabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductosElaborados = new javax.swing.JTable();
        jbVolver = new javax.swing.JButton();
        jbGenerarPDF = new javax.swing.JButton();
        jbGenerarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlEstadisticasDeProductosElaborados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlEstadisticasDeProductosElaborados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlEstadisticasDeProductosElaborados.setText("Estadísticas de productos elaborados");

        jlProductosElaborados.setText("Productos elaborados:");

        jbGenerarTabla.setText("Generar tabla");
        jbGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarTablaActionPerformed(evt);
            }
        });

        jtProductosElaborados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProductosElaborados);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlEstadisticasDeProductosElaborados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlProductosElaborados, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbProductosElaborados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jbGenerarTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGenerarPDF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbGenerarExcel))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlEstadisticasDeProductosElaborados)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlProductosElaborados)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbProductosElaborados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbGenerarTabla)
                        .addComponent(jbGenerarPDF)
                        .addComponent(jbGenerarExcel)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     * Genera la tabla de estadísticas según el producto elaborado solicitado.
     * 
     * @param evt el evento de clic sobre el botón 'Generar tabla'
     */    
    private void jbGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarTablaActionPerformed
        // vacío el arreglo de modo que no conserve y utilice los resultados
        // anteriores a la hora de generar la tabla
        listaCantConsumicionesXCliente.clear();

        // obtengo el 'id' del producto elaborado que voy a consultar
        String prodElabSel = jcbProductosElaborados.getSelectedItem().toString();
        int indGuion = prodElabSel.indexOf("-");
        String idProdElabSel = String.valueOf(prodElabSel.substring(0, indGuion-1));
        comida = "Mayores consumidores de " + prodElabSel.substring(indGuion+2);
        
        // busco todos los datalles de factura del producto elaborado seleccionado
        String hql = "FROM DetalleFactura DF WHERE DF.productoElaborado = "
                + idProdElabSel;
        Query query = sesion.createQuery(hql);
        listaDetallesFacturas = (ArrayList<DetalleFactura>) query.list();

        // Pasos a seguir:
        // Recorro todos los detalles de factura
        // En cada detalle de factura:
        //      a- veo la cantidad de consumiciones del producto actual
        //      b- busco la factura con la que está relacionada
        //      c- si el arreglo de clientes está vacío, añado el cliente de la factura
        //          y le añado la cantidad de consumiciones del producto actual
        //      d- caso contrario:
        //          * recorro el arreglo de clientes:
        //          * si encuentro un cliente con el mismo 'id' del cliente de la factura,
        //          le sumo la cantidad de consumiciones a la cantidad de
        //          veces que compró en el período elegido
        //          * caso contrario, añado el cliente al arreglo de clientes        
        for(DetalleFactura df : listaDetallesFacturas)
        {
            int cantConsDetFac = df.getCantidad();
            Factura f = new Factura();
            f = df.getFactura();            
            int idCliente = f.getCliente().getId();

            if(listaCantConsumicionesXCliente.isEmpty())
            {
                CantConsumicionesXCliente c = new CantConsumicionesXCliente();
                c.setIdCliente(idCliente);
                c.setCantConsumiciones(cantConsDetFac);
                listaCantConsumicionesXCliente.add(c);
            }
            else
            {
                boolean clienteExiste = false;
                int posArreglo = 0;

                arreglo_de_clientes:
                for(CantConsumicionesXCliente c : listaCantConsumicionesXCliente)
                {
                    if(idCliente == c.getIdCliente())
                    {
                        int cantConsTotal = c.getCantConsumiciones();
                        cantConsTotal = cantConsTotal + cantConsDetFac;
                        c.setCantConsumiciones(cantConsTotal);
                        listaCantConsumicionesXCliente.set(posArreglo, c);
                        clienteExiste = true;

                        break arreglo_de_clientes;
                    }

                    posArreglo++;
                }

                if(clienteExiste == false)
                {
                    CantConsumicionesXCliente c = new CantConsumicionesXCliente();
                    c.setIdCliente(idCliente);
                    c.setCantConsumiciones(cantConsDetFac);
                    listaCantConsumicionesXCliente.add(c);    
                }
            }
        }

        listaCantConsumicionesXCliente.sort(null);        
        
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
                Paragraph estadisticas = new Paragraph("Estadísticas de productos elaborados", fuenteTitulo1);
                estadisticas.setAlignment(Element.ALIGN_CENTER);
                doc.add(estadisticas);
                Font fComentario = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.ITALIC);
                Paragraph comentario = new Paragraph(comida, fComentario);
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
                tituloTabla = new Paragraph("Cantidad de veces que consumió el producto", formatoTituloTabla);
                tituloTabla.setAlignment(Element.ALIGN_CENTER);
                celda = new PdfPCell();
                celda.addElement(tituloTabla);
                table.addCell(celda);
                Font fChica = new Font(Font.FontFamily.TIMES_ROMAN, 10);            

                for(CantConsumicionesXCliente ccxc : listaCantConsumicionesXCliente)
                {
                    Cliente cli = gesCli.buscarPorId(ccxc.getIdCliente());
                    String cliente = cli.getApellido() + " " + cli.getNombre();
                    Paragraph texto = new Paragraph(cliente, fChica);
                    texto.setAlignment(Element.ALIGN_CENTER);
                    celda = new PdfPCell();
                    celda.addElement(texto);
                    table.addCell(celda);
                    Integer n = ccxc.getCantConsumiciones();
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
                HSSFSheet hoja = libro.createSheet("Estadísticas de productos elaborados");
                
                
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
                cadenaCelda = "Estadísticas de productos elaborados";
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
                cadenaCelda = comida;
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
                cadenaCelda = "Cantidad de veces que consumió el producto";
                fuente = libro.createFont();
                fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                estilo = libro.createCellStyle();
                estilo.setFont(fuente);
                estilo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                celda.setCellValue(cadenaCelda);
                celda.setCellStyle(estilo);             
                
                // los clientes y la cantidad de veces que consumieron el producto
                // seleccionado
                for(CantConsumicionesXCliente ccxc : listaCantConsumicionesXCliente)
                {
                    // creación de filas
                    fil++;
                    fila = hoja.createRow(fil);
                    // celdas
                    Cliente cli = gesCli.buscarPorId(ccxc.getIdCliente());
                    String cliente = cli.getApellido() + " " + cli.getNombre();
                    Integer n = ccxc.getCantConsumiciones();
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
        modeloCantCons = gesEst.configurarModeloCantVecesPE
            (modeloCantCons, listaCantConsumicionesXCliente);
        jtProductosElaborados.setModel(modeloCantCons);
        
        jtProductosElaborados.getColumn("Cliente").setPreferredWidth(225);
        jtProductosElaborados.getColumn("Cantidad de veces que consumió el producto").setPreferredWidth(125);        
    }    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGenerarExcel;
    private javax.swing.JButton jbGenerarPDF;
    private javax.swing.JButton jbGenerarTabla;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox jcbProductosElaborados;
    private javax.swing.JLabel jlEstadisticasDeProductosElaborados;
    private javax.swing.JLabel jlProductosElaborados;
    private javax.swing.JTable jtProductosElaborados;
    // End of variables declaration//GEN-END:variables
}
