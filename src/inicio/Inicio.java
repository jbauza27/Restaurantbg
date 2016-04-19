package inicio;

import configuracion.HibernateUtil;
import entidad.*;
import gestor.*;
import interfaz.IntPrincipal;
import interfaz.recordatorios.IntRecordatorios;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.hibernate.classic.Session;
import org.hibernate.Query;



/**
 * Se encarga de iniciar el programa, lo que implica:
 * <br>- conectarse a la base de datos y, si es la primera vez que usa 
 * el programa, crear todas las tablas,
 * <br>- si es la primera vez que se usa el programa, crear ciertos datos en la
 * base de datos que son necesarios para el normal funcionamiento del programa,
 * <br>- crear la primera ventana con la que interactuará el usuario. 
 */
public class Inicio
{
    // una constante
    public static final int ANIOANUAL = AcontecimientoImportante.A_ANUAL;
    
    
    /* Atributos */
    private static Session sesion;  
            
    
    /* Método principal */
    public static void main(String[] args)
    {        
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        
        GestorPrimerUso gesPrimUso = new GestorPrimerUso(sesion);        
        ArrayList<PrimerUso> primerUso = gesPrimUso.getPrimerUso();
        
        // si esta es la primera vez que se usa el programa, es necesario guardar
        // cierta información en la base de datos por única vez
        // se realizará una consulta: si la respuesta viene vacía, entonces es
        // la primera vez que se usa el programa
        if(primerUso.isEmpty())
        {
            // agrego algo a la tabla "Primer uso", para que las próximas veces
            // que se inicie el programa no se repita el proceso de agregado de
            // datos
            PrimerUso primUso = new PrimerUso();
            primUso.setPrimerUso("No");
            gesPrimUso.guardarOActualizar(primUso);
            
            guardarInformacion();            
        }
        else
        {
            // si la consulta trae datos, entonces esta no es la primera vez que
            // se usa el programa, y, por ende, no hago nada
        }

        // genero muchos registros únicamente para probar la aplicación
        //crearEntidades();
        
        // comprobando si hay fechas importantes cercanas a la actual
        GregorianCalendar fechaActual = new GregorianCalendar();
        int diaSemana = fechaActual.get(Calendar.DAY_OF_WEEK);
        
        if(diaSemana == Calendar.SUNDAY)
        {
            comprobarFechasImportantesEnDosSemanas(fechaActual);            
        }
        
        // creo la ventana principal y la hago visible
        IntPrincipal intPri = new IntPrincipal(sesion);
        intPri.setVisible(true);        
    }
    
    /**
     * Busca las fechas importantes que sean desde hoy hasta dos semanas en el
     * futuro, y realiza un resumen de las preferencias de los clientes que 
     * tengan acontecimientos en estas dos semanas, sugiriendo la posibilidad
     * de realizar una promoción a los mismos.
     * 
     * @param fechaActual la fecha al día de hoy
     */
    public static void comprobarFechasImportantesEnDosSemanas(GregorianCalendar fechaActual)
    {
        ArrayList<AcontecimientoImportante> listaAcoUnicos = new ArrayList<>();        
        ArrayList<AcontecimientoImportante> listaAcoAnuales = new ArrayList<>();
        ArrayList<AcontecimientoImportante> listaRecordatorios = new ArrayList<>();
                
        GestorAcontecimientosImportantes gesAcoImp
                = new GestorAcontecimientosImportantes(sesion);
        int anioActual = fechaActual.get(Calendar.YEAR);        
        int mesActual = fechaActual.get(Calendar.MONTH) + 1;
        int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);   
        
        // fecha a dos semanas en el futuro
        GregorianCalendar fechaPosterior = new GregorianCalendar();
        fechaPosterior.add(Calendar.DAY_OF_MONTH, 14);
        int anioPosterior = fechaPosterior.get(Calendar.YEAR);
        int mesPosterior = fechaPosterior.get(Calendar.MONTH) + 1;
        int diaPosterior = fechaPosterior.get(Calendar.DAY_OF_MONTH);        
        
        // primero me traigo todas las fechas importantes únicas desde hoy hasta
        // las dos semanas siguientes
        String hql = "FROM AcontecimientoImportante AI WHERE "
                + "AI.fechaUnica BETWEEN '" + anioActual + "-" + mesActual + "-" + diaActual
                + "' AND '" + anioPosterior + "-" + mesPosterior + "-" + diaPosterior + "'"
                + " ORDER BY AI.fechaUnica ASC";
        Query query = sesion.createQuery(hql);
        listaAcoUnicos = (ArrayList<AcontecimientoImportante>) query.list();
        
        // luego, me traigo todas las fechas importantes anuales desde hoy hasta
        // las dos semanas siguientes
        hql = "FROM AcontecimientoImportante AI WHERE "
                + "AI.fechaAnual BETWEEN '" + ANIOANUAL + "-" + mesActual + "-" + diaActual
                + "' AND '" + ANIOANUAL + "-" + mesPosterior + "-" + diaPosterior + "'"
                + " ORDER BY AI.fechaAnual ASC";
        query = sesion.createQuery(hql);
        listaAcoAnuales = (ArrayList<AcontecimientoImportante>) query.list();
        
        // añado todos los acontecimientos únicos a la lista de recordatorios
        for(int i = 0 ; i < listaAcoUnicos.size() ; i++)
        {
            listaRecordatorios.add(listaAcoUnicos.get(i));
        }
        
        // añado todos los acontecimientos anuales a la lista de recordatorios
        for(int i = 0 ; i < listaAcoAnuales.size() ; i++)
        {
            listaRecordatorios.add(listaAcoAnuales.get(i));
        }        
        
        IntRecordatorios intRec = new IntRecordatorios
            (null, true, sesion,
             fechaActual, fechaPosterior,
             listaRecordatorios);
        intRec.setVisible(true);
    }        
    
    /**
     * Si es la primera vez que se usa el programa, se invocará este método, que
     * se encargará de crear ciertos datos en la base de datos que son necesarios
     * para el normal funcionamiento del programa.
     */
    public static void guardarInformacion()
    {
        // Cargos
        GestorCargos gesCar = new GestorCargos(sesion);
        
        Cargo car = new Cargo();        
        car.setNombreCargo("Mozo");
        car.setDescripcion("Encargado de repartir la comida y cobrarla");
        gesCar.guardarOActualizar(car);        
        
        car = new Cargo();
        car.setNombreCargo("Cocinero");
        car.setDescripcion("Encargado de preparar la comida");
        gesCar.guardarOActualizar(car);        
        
        car = new Cargo();
        car.setNombreCargo("Encargado de limpieza");
        car.setDescripcion("Encargado de realizar la limpieza del local");
        gesCar.guardarOActualizar(car);
        
        car = new Cargo();
        car.setNombreCargo("Cajero");
        car.setDescripcion("Encargado de realizar la facturación");
        gesCar.guardarOActualizar(car);
        
        car = new Cargo();
        car.setNombreCargo("Gerente");
        car.setDescripcion("Líder del restaurant");
        gesCar.guardarOActualizar(car);        
        
        
        // Países
        GestorPaises gesPai = new GestorPaises(sesion);
        
        Pais pai = new Pais();        
        pai.setNombrePais("Argentina");
        gesPai.guardarOActualizar(pai);        
        
        pai = new Pais();
        pai.setNombrePais("Chile");
        gesPai.guardarOActualizar(pai);        
        
        pai = new Pais();
        pai.setNombrePais("Uruguay");
        gesPai.guardarOActualizar(pai);
        
        
        // Provincias
        GestorProvincias gesProv = new GestorProvincias(sesion);
        
        ArrayList<Pais> listaPaises = gesPai.getListaPaises();
        
        for(Pais pais : listaPaises)
        {
            if(pais.getNombrePais().equals("Argentina"))
            {
                Provincia prov = new Provincia();
                prov.setNombreProvincia("Buenos Aires");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Capital Federal");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Catamarca");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Chaco");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Chubut");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Córdoba");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Corrientes");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Entre Ríos");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Formosa");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Jujuy");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("La Pampa");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("La Rioja");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Mendoza");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Misiones");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Neuquén");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Río Negro");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Salta");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("San Juan");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("San Luis");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Santa Cruz");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Santa Fe");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Santiago del Estero");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Tierra del Fuego");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
            }
            
            if(pais.getNombrePais().equals("Chile"))
            {
                Provincia prov = new Provincia();
                prov.setNombreProvincia("Reg I - Tarapacá");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg II - Antofagasta");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg III - Atacama");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg IV - Coquimbo");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg V - Valparaíso");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg VI - Libertador General Bernardo O'Higgins");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg VII - Maule");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg VII - Biobío");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg IV - La Araucanía");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg X - Los Lagos");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg XI - Aysén del General Carlos Ibañez del Campo");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg XII - Magallanes y Antártica chilena");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg Met - Región Metropolitana de Santiago");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg XIV - Los Ríos");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Reg XV - Arica y Paranicota");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
            }
            
            if(pais.getNombrePais().equals("Uruguay"))
            {
                Provincia prov = new Provincia();
                prov.setNombreProvincia("Artigas");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Canelones");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Cerro Largo");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Colonia");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Durazno");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Flores");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Florida");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Lavalleja");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Maldonado");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Montevideo");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Paisandú");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Río Negro");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Rivera");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Rocha");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Salto");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("San José");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Soriano");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Tacuarembó");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);
                
                prov = new Provincia();
                prov.setNombreProvincia("Treinta y tres");
                prov.setPais(pais);
                gesProv.guardarOActualizar(prov);  
            }  
        }
        
        
        // Horarios de trabajo
        GestorEmpleados gesEmp =
                new GestorEmpleados(sesion);
        
        HorariosDeTrabajo horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Lunes");
        GregorianCalendar horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        GregorianCalendar horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab);
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Lunes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab);     

        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Lunes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 

        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Martes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 

        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Martes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Martes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 

        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Miércoles");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Miércoles");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Miércoles");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Jueves");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Jueves");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Jueves");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Viernes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Viernes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Viernes");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Sábado");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Sábado");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Sábado");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Mañana");
        horTrab.setDiaDeSemana("Domingo");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 9, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 14, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Tarde");
        horTrab.setDiaDeSemana("Domingo");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 14, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 21, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab); 
        
        horTrab = new HorariosDeTrabajo();
        horTrab.setActivo(true);
        horTrab.setParteDelDia("Noche");
        horTrab.setDiaDeSemana("Domingo");
        horaDeInicio = new GregorianCalendar(1, 1, 1, 21, 0);        
        horTrab.setHoraDeInicio(horaDeInicio);
        horaDeFinalizacion = new GregorianCalendar(1, 1, 1, 3, 0);
        horTrab.setHoraDeFinalizacion(horaDeFinalizacion);
        gesEmp.guardarOActualizar(horTrab);
    }


    // genero muchos registros únicamente para probar la aplicación
    public static void crearEntidades()
    {
        // gestores
        GestorClientes gesCli = new GestorClientes(sesion);
        GestorEmpleados gesEmp = new GestorEmpleados(sesion);        
        GestorMesas gesMes = new GestorMesas(sesion);
        GestorProveedores gesProv = new GestorProveedores(sesion);
        GestorMateriasPrimas gesMatPrim = new GestorMateriasPrimas(sesion);
        GestorProductosElaborados gesProdElab = new GestorProductosElaborados(sesion);
        GestorMovimientosDeStock gesMovSto = new GestorMovimientosDeStock(sesion);
        GestorAcontecimientosImportantes gesAcoImp = new GestorAcontecimientosImportantes(sesion);
        
        
        // mesas
        Mesa mes = new Mesa();
        mes.setActivo(true);
        mes.setNroMesa("A02");
        mes.setCantPersonas("2");
        mes.setDescripcion("Una mesa de 2 personas ubicada en el sector sur.");
        gesMes.guardarOActualizar(mes);
        
        mes = new Mesa();
        mes.setActivo(true);
        mes.setNroMesa("A03");
        mes.setCantPersonas("3");
        mes.setDescripcion("Una mesa de 3 personas ubicada en el sector norte.");
        gesMes.guardarOActualizar(mes);
        
        mes = new Mesa();
        mes.setActivo(true);
        mes.setNroMesa("A04");
        mes.setCantPersonas("4");
        mes.setDescripcion("Una mesa de 4 personas ubicada en el sector este.");
        gesMes.guardarOActualizar(mes);
        
        
        // clientes
        Cliente cli = new Cliente();            
        cli.setNombre("CliNombreA");
        cli.setApellido("CliApellidoA");            
        GregorianCalendar fec = new GregorianCalendar(1981, (1-1), 1);
        GregorianCalendar fecAnual = new GregorianCalendar(ANIOANUAL, (1-1), 1);
        cli.setFechaDeNacimiento(fec);            
        cli.setSexo("Masculino");
        cli.setTelefonoFijo("1");
        cli.setTelefonoCelular("1");
        cli.setDni("1");
        cli.setEmail("climaila@gmail.com");
        cli.setCalle("CliCalleA");
        cli.setLocalidad("CliLocalidadA");
        ArrayList<Provincia> listaProvincias = new ArrayList<>();
        String hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Mendoza'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        Query query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            cli.setProvincia(prov);
        }        
        ArrayList<Pais> listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            cli.setPais(pais);
        }                    
        gesCli.guardarOActualizar(cli);   
        AcontecimientoImportante acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setCliente(cli);
        gesAcoImp.guardarOActualizar(acoImp);        
        
        cli = new Cliente();            
        cli.setNombre("CliNombreB");
        cli.setApellido("CliApellidoB");            
        fec = new GregorianCalendar(1982, (2-1), 2);
        fecAnual = new GregorianCalendar(ANIOANUAL, (2-1), 2);
        cli.setFechaDeNacimiento(fec);            
        cli.setSexo("Femenino");
        cli.setTelefonoFijo("2");
        cli.setTelefonoCelular("2");
        cli.setDni("2");
        cli.setEmail("climailb@gmail.com");
        cli.setCalle("CliCalleB");
        cli.setLocalidad("CliLocalidadB");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'San Juan'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            cli.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            cli.setPais(pais);
        }            
        gesCli.guardarOActualizar(cli);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setCliente(cli);
        gesAcoImp.guardarOActualizar(acoImp);    
        
        cli = new Cliente();            
        cli.setNombre("CliNombreC");
        cli.setApellido("CliApellidoC");            
        fec = new GregorianCalendar(1983, (3-1), 3);
        fecAnual = new GregorianCalendar(ANIOANUAL, (3-1), 3);
        cli.setFechaDeNacimiento(fec);            
        cli.setSexo("Masculino");
        cli.setTelefonoFijo("3");
        cli.setTelefonoCelular("3");
        cli.setDni("3");
        cli.setEmail("climailc@gmail.com");
        cli.setCalle("CliCalleC");
        cli.setLocalidad("CliLocalidadC");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Buenos Aires'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            cli.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            cli.setPais(pais);
        }           
        gesCli.guardarOActualizar(cli);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setCliente(cli);
        gesAcoImp.guardarOActualizar(acoImp);                   
        
        cli = new Cliente();            
        cli.setNombre("CliNombreD");
        cli.setApellido("CliApellidoD");            
        fec = new GregorianCalendar(1984, (4-1), 4);
        fecAnual = new GregorianCalendar(ANIOANUAL, (4-1), 4);
        cli.setFechaDeNacimiento(fec);            
        cli.setSexo("Femenino");
        cli.setTelefonoFijo("4");
        cli.setTelefonoCelular("4");
        cli.setDni("4");
        cli.setEmail("climaild@gmail.com");
        cli.setCalle("CliCalleD");
        cli.setLocalidad("CliLocalidadD");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Reg V - Valparaíso'"
                + " AND P.pais.nombrePais LIKE 'Chile'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            cli.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Chile'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            cli.setPais(pais);
        }           
        gesCli.guardarOActualizar(cli);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setCliente(cli);
        gesAcoImp.guardarOActualizar(acoImp);                    
        
        cli = new Cliente();            
        cli.setNombre("CliNombreE");
        cli.setApellido("CliApellidoE");            
        fec = new GregorianCalendar(1985, (5-1), 5);
        fecAnual = new GregorianCalendar(ANIOANUAL, (5-1), 5);
        cli.setFechaDeNacimiento(fec);            
        cli.setSexo("Masculino");
        cli.setTelefonoFijo("5");
        cli.setTelefonoCelular("5");
        cli.setDni("5");
        cli.setEmail("climaile@gmail.com");
        cli.setCalle("CliCalleE");
        cli.setLocalidad("CliLocalidadE");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Cerro Largo'"
                + " AND P.pais.nombrePais LIKE 'Uruguay'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            cli.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Uruguay'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            cli.setPais(pais);
        }       
        gesCli.guardarOActualizar(cli);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setCliente(cli);
        gesAcoImp.guardarOActualizar(acoImp);                  
        
        
        // empleados                
        Empleado emp = new Empleado();            
        emp.setActivo(true);
        emp.setNombre("EmpNombreA");
        emp.setApellido("EmpApellidoA");            
        fec = new GregorianCalendar(1986, (6-1), 6);
        fecAnual = new GregorianCalendar(ANIOANUAL, (6-1), 6);
        emp.setFechaDeNacimiento(fec);            
        emp.setSexo("Masculino");
        emp.setTelefonoFijo("1");
        emp.setTelefonoCelular("1");
        emp.setDni("1");
        emp.setEmail("empa@hotmail.com");
        emp.setCalle("EmpCalleA");
        emp.setLocalidad("EmpLocalidadA");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Mendoza'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            emp.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            emp.setPais(pais);
        }
        emp.setSueldoBruto(1000);            
        ArrayList<Cargo> listaCargos = new ArrayList<>();
        hql = "FROM Cargo C WHERE C.nombreCargo = 'Mozo'";        
        query = sesion.createQuery(hql);            
        listaCargos = (ArrayList<Cargo>) query.list();             
        for(Cargo car : listaCargos)
        {
            emp.setCargo(car);
        }            
        ArrayList<HorariosDeTrabajo> horTrab = new ArrayList<>();
        hql = "FROM HorariosDeTrabajo H WHERE H.parteDelDia LIKE 'Mañana'";
        query = sesion.createQuery(hql);
        horTrab = (ArrayList<HorariosDeTrabajo>) query.list();
        for(HorariosDeTrabajo ht : horTrab)
        {
            ArrayList<Empleado> arrEmp = new ArrayList<>();
            arrEmp.add(emp);
            ht.setEmpleados(arrEmp);
        }
        emp.setHorariosDeTrabajo(horTrab);
        gesEmp.guardarOActualizar(emp);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setEmpleado(emp);
        gesAcoImp.guardarOActualizar(acoImp);    
        
        emp = new Empleado();            
        emp.setActivo(true);
        emp.setNombre("EmpNombreB");
        emp.setApellido("EmpApellidoB");            
        fec = new GregorianCalendar(1987, (7-1), 7);
        fecAnual = new GregorianCalendar(ANIOANUAL, (7-1), 7);
        emp.setFechaDeNacimiento(fec);            
        emp.setSexo("Femenino");
        emp.setTelefonoFijo("2");
        emp.setTelefonoCelular("2");
        emp.setDni("2");
        emp.setEmail("empb@hotmail.com");
        emp.setCalle("EmpCalleB");
        emp.setLocalidad("EmpLocalidadB");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'San Juan'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            emp.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            emp.setPais(pais);
        }
        emp.setSueldoBruto(2000);            
        listaCargos = new ArrayList<>();
        hql = "FROM Cargo C WHERE C.nombreCargo = 'Cocinero'";        
        query = sesion.createQuery(hql);            
        listaCargos = (ArrayList<Cargo>) query.list();             
        for(Cargo car : listaCargos)
        {
            emp.setCargo(car);
        }            
        horTrab = new ArrayList<>();
        hql = "FROM HorariosDeTrabajo H WHERE H.diaDeSemana LIKE 'Domingo'";
        query = sesion.createQuery(hql);
        horTrab = (ArrayList<HorariosDeTrabajo>) query.list();
        for(HorariosDeTrabajo ht : horTrab)
        {
            ArrayList<Empleado> arrEmp = new ArrayList<>();
            arrEmp.add(emp);
            ht.setEmpleados(arrEmp);
        }
        emp.setHorariosDeTrabajo(horTrab);        
        gesEmp.guardarOActualizar(emp);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setEmpleado(emp);
        gesAcoImp.guardarOActualizar(acoImp);    
        
        emp = new Empleado();            
        emp.setActivo(true);
        emp.setNombre("EmpNombreC");
        emp.setApellido("EmpApellidoC");            
        fec = new GregorianCalendar(1988, (8-1), 8);
        fecAnual = new GregorianCalendar(ANIOANUAL, (8-1), 8);
        emp.setFechaDeNacimiento(fec);            
        emp.setSexo("Masculino");
        emp.setTelefonoFijo("3");
        emp.setTelefonoCelular("3");
        emp.setDni("3");
        emp.setEmail("empc@hotmail.com");
        emp.setCalle("EmpCalleC");
        emp.setLocalidad("EmpLocalidadC");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Buenos Aires'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            emp.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            emp.setPais(pais);
        }
        emp.setSueldoBruto(3000);            
        listaCargos = new ArrayList<>();
        hql = "FROM Cargo C WHERE C.nombreCargo = 'Encargado de limpieza'";        
        query = sesion.createQuery(hql);            
        listaCargos = (ArrayList<Cargo>) query.list();             
        for(Cargo car : listaCargos)
        {
            emp.setCargo(car);
        }            
        horTrab = new ArrayList<>();
        hql = "FROM HorariosDeTrabajo H WHERE H.parteDelDia LIKE 'Tarde'";
        query = sesion.createQuery(hql);
        horTrab = (ArrayList<HorariosDeTrabajo>) query.list();
        for(HorariosDeTrabajo ht : horTrab)
        {
            ArrayList<Empleado> arrEmp = new ArrayList<>();
            arrEmp.add(emp);
            ht.setEmpleados(arrEmp);
        }
        emp.setHorariosDeTrabajo(horTrab);
        gesEmp.guardarOActualizar(emp);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setEmpleado(emp);
        gesAcoImp.guardarOActualizar(acoImp);    
        
        emp = new Empleado();            
        emp.setActivo(true);
        emp.setNombre("EmpNombreD");
        emp.setApellido("EmpApellidoD");            
        fec = new GregorianCalendar(1989, (9-1), 9);
        fecAnual = new GregorianCalendar(ANIOANUAL, (9-1), 9);
        emp.setFechaDeNacimiento(fec);            
        emp.setSexo("Femenino");
        emp.setTelefonoFijo("4");
        emp.setTelefonoCelular("4");
        emp.setDni("4");
        emp.setEmail("empd@hotmail.com");
        emp.setCalle("EmpCalleD");
        emp.setLocalidad("EmpLocalidadD");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Reg V - Valparaíso'"
                + " AND P.pais.nombrePais LIKE 'Chile'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            emp.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Chile'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            emp.setPais(pais);
        }
        emp.setSueldoBruto(4000);            
        listaCargos = new ArrayList<>();
        hql = "FROM Cargo C WHERE C.nombreCargo = 'Mozo'";        
        query = sesion.createQuery(hql);            
        listaCargos = (ArrayList<Cargo>) query.list();             
        for(Cargo car : listaCargos)
        {
            emp.setCargo(car);
        }   
        horTrab = new ArrayList<>();
        hql = "FROM HorariosDeTrabajo H WHERE H.parteDelDia LIKE 'Noche'";
        query = sesion.createQuery(hql);
        horTrab = (ArrayList<HorariosDeTrabajo>) query.list();
        for(HorariosDeTrabajo ht : horTrab)
        {
            ArrayList<Empleado> arrEmp = new ArrayList<>();
            arrEmp.add(emp);
            ht.setEmpleados(arrEmp);
        }
        emp.setHorariosDeTrabajo(horTrab);
        gesEmp.guardarOActualizar(emp);
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setEmpleado(emp);
        gesAcoImp.guardarOActualizar(acoImp);    
        
        emp = new Empleado();            
        emp.setActivo(true);
        emp.setNombre("EmpNombreE");
        emp.setApellido("EmpApellidoE");            
        fec = new GregorianCalendar(1990, (10-1), 10);
        fecAnual = new GregorianCalendar(ANIOANUAL, (10-1), 10);
        emp.setFechaDeNacimiento(fec);            
        emp.setSexo("Masculino");
        emp.setTelefonoFijo("5");
        emp.setTelefonoCelular("5");
        emp.setDni("5");
        emp.setEmail("empe@hotmail.com");
        emp.setCalle("EmpCalleE");
        emp.setLocalidad("EmpLocalidadE");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Cerro Largo'"
                + " AND P.pais.nombrePais LIKE 'Uruguay'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia prov : listaProvincias)
        {
            emp.setProvincia(prov);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Uruguay'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            emp.setPais(pais);
        }
        emp.setSueldoBruto(5000);            
        listaCargos = new ArrayList<>();
        hql = "FROM Cargo C WHERE C.nombreCargo = 'Cocinero'";        
        query = sesion.createQuery(hql);            
        listaCargos = (ArrayList<Cargo>) query.list();             
        for(Cargo car : listaCargos)
        {
            emp.setCargo(car);
        }    
        horTrab = new ArrayList<>();
        hql = "FROM HorariosDeTrabajo H WHERE H.diaDeSemana LIKE 'Lunes'";
        query = sesion.createQuery(hql);
        horTrab = (ArrayList<HorariosDeTrabajo>) query.list();
        for(HorariosDeTrabajo ht : horTrab)
        {
            ArrayList<Empleado> arrEmp = new ArrayList<>();
            arrEmp.add(emp);
            ht.setEmpleados(arrEmp);
        }
        emp.setHorariosDeTrabajo(horTrab);
        gesEmp.guardarOActualizar(emp);        
        acoImp = new AcontecimientoImportante();
        acoImp.setTipo("Anual");
        acoImp.setFechaUnica(fec);
        acoImp.setFechaAnual(fecAnual);
        acoImp.setAcontecimiento("Nacimiento");        
        acoImp.setEmpleado(emp);
        gesAcoImp.guardarOActualizar(acoImp);    

        
        // proveedores        
        Proveedor prov = new Proveedor();            
        prov.setActivo(true);
        prov.setNombre("ProvNombreA");        
        prov.setTelefonoUno("1");
        prov.setTelefonoDos("11");
        prov.setTelefonoTres("111");
        prov.setTipo("Persona");
        prov.setNombreDeContacto("ProvNombreDeContactoA");
        prov.setEmail("prova@yahoo.com.ar");
        prov.setCalle("ProvCalleA");
        prov.setLocalidad("ProvLocalidadA");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Mendoza'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia p : listaProvincias)
        {
            prov.setProvincia(p);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            prov.setPais(pais);
        }                       
        gesProv.guardarOActualizar(prov);
        
        prov = new Proveedor();            
        prov.setActivo(true);
        prov.setNombre("ProvNombreB");        
        prov.setTelefonoUno("2");
        prov.setTelefonoDos("22");
        prov.setTelefonoTres("222");
        prov.setTipo("Persona");
        prov.setNombreDeContacto("ProvNombreDeContactoB");
        prov.setEmail("provb@yahoo.com.ar");
        prov.setCalle("ProvCalleB");
        prov.setLocalidad("ProvLocalidadB");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'San Juan'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia p : listaProvincias)
        {
            prov.setProvincia(p);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            prov.setPais(pais);
        }                      
        gesProv.guardarOActualizar(prov);
        
        prov = new Proveedor();            
        prov.setActivo(true);
        prov.setNombre("ProvNombreC");        
        prov.setTelefonoUno("3");
        prov.setTelefonoDos("33");
        prov.setTelefonoTres("333");
        prov.setTipo("Persona");
        prov.setNombreDeContacto("ProvNombreDeContactoC");
        prov.setEmail("provc@yahoo.com.ar");
        prov.setCalle("ProvCalleC");
        prov.setLocalidad("ProvLocalidadC");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Buenos Aires'"
                + " AND P.pais.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia p : listaProvincias)
        {
            prov.setProvincia(p);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Argentina'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            prov.setPais(pais);
        }                       
        gesProv.guardarOActualizar(prov);
        
        prov = new Proveedor();            
        prov.setActivo(true);
        prov.setNombre("ProvNombreD");        
        prov.setTelefonoUno("4");
        prov.setTelefonoDos("44");
        prov.setTelefonoTres("444");
        prov.setTipo("Persona");
        prov.setNombreDeContacto("ProvNombreDeContactoD");
        prov.setEmail("provd@yahoo.com.ar");
        prov.setCalle("ProvCalleD");
        prov.setLocalidad("ProvLocalidadD");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Reg V - Valparaíso'"
                + " AND P.pais.nombrePais LIKE 'Chile'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia p : listaProvincias)
        {
            prov.setProvincia(p);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Chile'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            prov.setPais(pais);
        }                   
        gesProv.guardarOActualizar(prov);
        
        prov = new Proveedor();            
        prov.setActivo(true);
        prov.setNombre("ProvNombreE");        
        prov.setTelefonoUno("5");
        prov.setTelefonoDos("55");
        prov.setTelefonoTres("555");
        prov.setTipo("Persona");
        prov.setNombreDeContacto("ProvNombreDeContactoE");
        prov.setEmail("prove@yahoo.com.ar");
        prov.setCalle("ProvCalleE");
        prov.setLocalidad("ProvLocalidadE");
        listaProvincias = new ArrayList<>();
        hql = "FROM Provincia P WHERE P.nombreProvincia LIKE 'Cerro Largo'"
                + " AND P.pais.nombrePais LIKE 'Uruguay'";
        query = sesion.createQuery(hql);
        listaProvincias = (ArrayList<Provincia>) query.list();
        for(Provincia p : listaProvincias)
        {
            prov.setProvincia(p);
        }        
        listaPaises = new ArrayList<>();
        hql = "FROM Pais P WHERE P.nombrePais LIKE 'Uruguay'";
        query = sesion.createQuery(hql);
        listaPaises = (ArrayList<Pais>) query.list();
        for(Pais pais : listaPaises)
        {
            prov.setPais(pais);
        }                      
        gesProv.guardarOActualizar(prov);      
        
        
        // materias primas        
        MateriaPrima matPrim = new MateriaPrima();
        matPrim.setNombre("MatPrimNombreA");
        matPrim.setPrecio(1);
        matPrim.setCantidad(0);
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        listaProveedores = gesProv.getListaProveedores();
        for(Proveedor p : listaProveedores)
        {
                ArrayList<MateriaPrima> arrMatPrim = new ArrayList<>();
                arrMatPrim.add(matPrim);
                prov.setMateriasPrimas(arrMatPrim);
        }
        matPrim.setProveedores(listaProveedores);        
        gesMatPrim.guardarOActualizar(matPrim);
        
        matPrim = new MateriaPrima();
        matPrim.setNombre("MatPrimNombreB");
        matPrim.setPrecio(2);
        matPrim.setCantidad(0);
        listaProveedores = new ArrayList<>();
        listaProveedores = gesProv.getListaProveedores();
        for(Proveedor p : listaProveedores)
        {
                ArrayList<MateriaPrima> arrMatPrim = new ArrayList<>();
                arrMatPrim.add(matPrim);
                prov.setMateriasPrimas(arrMatPrim);
        }
        matPrim.setProveedores(listaProveedores);        
        gesMatPrim.guardarOActualizar(matPrim);
        
        matPrim = new MateriaPrima();
        matPrim.setNombre("MatPrimNombreC");
        matPrim.setPrecio(3);
        matPrim.setCantidad(0);
        listaProveedores = new ArrayList<>();
        listaProveedores = gesProv.getListaProveedores();
        for(Proveedor p : listaProveedores)
        {
                ArrayList<MateriaPrima> arrMatPrim = new ArrayList<>();
                arrMatPrim.add(matPrim);
                prov.setMateriasPrimas(arrMatPrim);
        }
        matPrim.setProveedores(listaProveedores);        
        gesMatPrim.guardarOActualizar(matPrim);
        
        matPrim = new MateriaPrima();
        matPrim.setNombre("MatPrimNombreD");
        matPrim.setPrecio(4);
        matPrim.setCantidad(0);
        listaProveedores = new ArrayList<>();
        listaProveedores = gesProv.getListaProveedores();
        for(Proveedor p : listaProveedores)
        {
                ArrayList<MateriaPrima> arrMatPrim = new ArrayList<>();
                arrMatPrim.add(matPrim);
                prov.setMateriasPrimas(arrMatPrim);
        }
        matPrim.setProveedores(listaProveedores);        
        gesMatPrim.guardarOActualizar(matPrim);
        
        matPrim = new MateriaPrima();
        matPrim.setNombre("MatPrimNombreE");
        matPrim.setPrecio(5);
        matPrim.setCantidad(0);
        listaProveedores = new ArrayList<>();
        listaProveedores = gesProv.getListaProveedores();
        for(Proveedor p : listaProveedores)
        {
                ArrayList<MateriaPrima> arrMatPrim = new ArrayList<>();
                arrMatPrim.add(matPrim);
                prov.setMateriasPrimas(arrMatPrim);
        }
        matPrim.setProveedores(listaProveedores);        
        gesMatPrim.guardarOActualizar(matPrim);
        
        
        // productos elaborados        
        ProductoElaborado prodElab = new ProductoElaborado();
        prodElab.setActivo(true);
        prodElab.setNombre("ProdElabNombreA");
        prodElab.setPrecio(1);
        prodElab.setCantidad(0);
        ArrayList<MateriaPrima> listaMateriasPrimas = new ArrayList<>();
        listaMateriasPrimas = gesMatPrim.getListaMateriasPrimas();
        for(MateriaPrima m : listaMateriasPrimas)
        {
                ArrayList<ProductoElaborado> arrProdElab = new ArrayList<>();
                arrProdElab.add(prodElab);
                matPrim.setProductosElaborados(arrProdElab);
        }
        prodElab.setMateriasPrimas(listaMateriasPrimas);        
        gesProdElab.guardarOActualizar(prodElab);
        
        prodElab = new ProductoElaborado();
        prodElab.setActivo(true);
        prodElab.setNombre("ProdElabNombreB");
        prodElab.setPrecio(2);
        prodElab.setCantidad(0);
        listaMateriasPrimas = new ArrayList<>();
        listaMateriasPrimas = gesMatPrim.getListaMateriasPrimas();
        for(MateriaPrima m : listaMateriasPrimas)
        {
                ArrayList<ProductoElaborado> arrProdElab = new ArrayList<>();
                arrProdElab.add(prodElab);
                matPrim.setProductosElaborados(arrProdElab);
        }
        prodElab.setMateriasPrimas(listaMateriasPrimas);        
        gesProdElab.guardarOActualizar(prodElab);
        
        prodElab = new ProductoElaborado();
        prodElab.setActivo(true);
        prodElab.setNombre("ProdElabNombreC");
        prodElab.setPrecio(3);
        prodElab.setCantidad(0);
        listaMateriasPrimas = new ArrayList<>();
        listaMateriasPrimas = gesMatPrim.getListaMateriasPrimas();
        for(MateriaPrima m : listaMateriasPrimas)
        {
                ArrayList<ProductoElaborado> arrProdElab = new ArrayList<>();
                arrProdElab.add(prodElab);
                matPrim.setProductosElaborados(arrProdElab);
        }
        prodElab.setMateriasPrimas(listaMateriasPrimas);        
        gesProdElab.guardarOActualizar(prodElab);
        
        prodElab = new ProductoElaborado();
        prodElab.setActivo(true);
        prodElab.setNombre("ProdElabNombreD");
        prodElab.setPrecio(4);
        prodElab.setCantidad(0);
        listaMateriasPrimas = new ArrayList<>();
        listaMateriasPrimas = gesMatPrim.getListaMateriasPrimas();
        for(MateriaPrima m : listaMateriasPrimas)
        {
                ArrayList<ProductoElaborado> arrProdElab = new ArrayList<>();
                arrProdElab.add(prodElab);
                matPrim.setProductosElaborados(arrProdElab);
        }
        prodElab.setMateriasPrimas(listaMateriasPrimas);        
        gesProdElab.guardarOActualizar(prodElab);
        
        prodElab = new ProductoElaborado();
        prodElab.setActivo(true);
        prodElab.setNombre("ProdElabNombreE");
        prodElab.setPrecio(5);
        prodElab.setCantidad(0);
        listaMateriasPrimas = new ArrayList<>();
        listaMateriasPrimas = gesMatPrim.getListaMateriasPrimas();
        for(MateriaPrima m : listaMateriasPrimas)
        {
                ArrayList<ProductoElaborado> arrProdElab = new ArrayList<>();
                arrProdElab.add(prodElab);
                matPrim.setProductosElaborados(arrProdElab);
        }
        prodElab.setMateriasPrimas(listaMateriasPrimas);        
        gesProdElab.guardarOActualizar(prodElab);
        
        
        // movimientos de stock   
        MovimientoDeStock movSto = new MovimientoDeStock();
        GregorianCalendar f = new GregorianCalendar(2013, (1-1), 1, 14, 0, 0);
        movSto.setFecha(f);
        movSto.setCantidad(1);
        movSto.setEstado("Entrada");
        movSto.setMotivo("Compra de materias primas");
        ArrayList<MateriaPrima> muchasMatPrim = new ArrayList<>();
        muchasMatPrim = gesMatPrim.getListaMateriasPrimas();
        matPrim = new MateriaPrima();
        matPrim = muchasMatPrim.get(0);
        movSto.setMateriaPrima(matPrim);
        matPrim.setCantidad(1);
        gesMatPrim.guardarOActualizar(matPrim);
        gesMovSto.guardarOActualizar(movSto);
        
        movSto = new MovimientoDeStock();        
        f = new GregorianCalendar(2013, (2-1), 2, 14, 0, 0);
        movSto.setFecha(f);
        movSto.setCantidad(2);
        movSto.setEstado("Entrada");
        movSto.setMotivo("Fabricación de productos elaborados");
        ArrayList<ProductoElaborado> muchosProdElab = new ArrayList<>();
        muchosProdElab = gesProdElab.getListaProductosElaborados();
        prodElab = new ProductoElaborado();
        prodElab = muchosProdElab.get(1);        
        movSto.setProductoElaborado(prodElab);
        prodElab.setCantidad(2);
        gesProdElab.guardarOActualizar(prodElab);
        gesMovSto.guardarOActualizar(movSto);
        
        movSto = new MovimientoDeStock();        
        f = new GregorianCalendar(2013, (3-1), 3, 14, 0, 0);
        movSto.setFecha(f);
        movSto.setCantidad(3);
        movSto.setEstado("Entrada");
        movSto.setMotivo("Donación de materias primas");
        muchasMatPrim = new ArrayList<>();
        muchasMatPrim = gesMatPrim.getListaMateriasPrimas();
        matPrim = new MateriaPrima();
        matPrim = muchasMatPrim.get(2);        
        movSto.setMateriaPrima(matPrim);
        matPrim.setCantidad(3);
        gesMatPrim.guardarOActualizar(matPrim);
        gesMovSto.guardarOActualizar(movSto);
        
        movSto = new MovimientoDeStock();        
        f = new GregorianCalendar(2013, (4-1), 4, 14, 0, 0);
        movSto.setFecha(f);
        movSto.setCantidad(4);
        movSto.setEstado("Entrada");
        movSto.setMotivo("Fabricación de productos elaborados");
        muchosProdElab = new ArrayList<>();
        muchosProdElab = gesProdElab.getListaProductosElaborados();
        prodElab = new ProductoElaborado();
        prodElab = muchosProdElab.get(3);                
        movSto.setProductoElaborado(prodElab);
        prodElab.setCantidad(4);
        gesProdElab.guardarOActualizar(prodElab);
        gesMovSto.guardarOActualizar(movSto);
        
        movSto = new MovimientoDeStock();        
        f = new GregorianCalendar(2013, (5-1), 5, 14, 0, 0);
        movSto.setFecha(f);
        movSto.setCantidad(5);
        movSto.setEstado("Entrada");
        movSto.setMotivo("Compra de materias primas");
        muchasMatPrim = new ArrayList<>();
        muchasMatPrim = gesMatPrim.getListaMateriasPrimas();
        matPrim = new MateriaPrima();
        matPrim = muchasMatPrim.get(4);        
        movSto.setMateriaPrima(matPrim);
        matPrim.setCantidad(5);
        gesMatPrim.guardarOActualizar(matPrim);
        gesMovSto.guardarOActualizar(movSto);
    }
}    
