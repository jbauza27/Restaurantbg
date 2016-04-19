package configuracion;

import entidad.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * Contiene información necesaria para el buen funcionamiento de hibernate.
 */
public class HibernateUtil
{    
   /* Atributos */
   private static SessionFactory sessionFactory;
   private static String user = "root";
   private static String password = "123456";
   private static String puerto = "3306";
   private static String catalogo = "restaurantbg";
   private static String host = "localhost";
   
   
   /* Métodos */
   public static void load()
   {
        try
        {
            AnnotationConfiguration config = new AnnotationConfiguration();
            config.setProperty("hibernate.connection.url", "jdbc:mysql://" +
                    host + ":" + puerto + "/" + catalogo);
            config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            config.setProperty("hibernate.connection.username", user);
            config.setProperty("hibernate.connection.password", password);
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            config.setProperty("hibernate.c3p0.min_size","0");
            config.setProperty("hibernate.c3p0.max_size","7");
            config.setProperty("hibernate.c3p0.timeout","100");
            config.setProperty("hibernate.c3p0.max_elements","100");
            config.setProperty("hibernate.c3p0.idle_test_period","100");
            config.setProperty("hibernate.c3p0.autoCommitOnClose","true");
            config.setProperty("hibernate.forceIgnoreUnresolvedTransactions","true");
            config.setProperty("hibernate.show_sql", "false");
            config.setProperty("hibernate.transaction.factory_class",
                    "org.hibernate.transaction.JDBCTransactionFactory");
            config.setProperty("hibernate.hbm2ddl.auto", "update");            
            
            config.addPackage("entidad");
            config.addAnnotatedClass(AcontecimientoImportante.class);
            config.addAnnotatedClass(Cargo.class);
            config.addAnnotatedClass(Cliente.class);
            config.addAnnotatedClass(DetalleFactura.class);
            config.addAnnotatedClass(Empleado.class);
            config.addAnnotatedClass(Factura.class);
            config.addAnnotatedClass(HorariosDeTrabajo.class);
            config.addAnnotatedClass(MateriaPrima.class);
            config.addAnnotatedClass(Mesa.class);
            config.addAnnotatedClass(MovimientoDeStock.class);
            config.addAnnotatedClass(Pais.class);
            config.addAnnotatedClass(Preferencia.class);
            config.addAnnotatedClass(PrimerUso.class);
            config.addAnnotatedClass(ProductoElaborado.class);            
            config.addAnnotatedClass(Proveedor.class);
            config.addAnnotatedClass(Provincia.class);           
            config.addAnnotatedClass(Reserva.class);
            
                                    
            sessionFactory = config.buildSessionFactory();
        }
        catch (HibernateException e)
        {
           System.out.println("Error: HibernateUtil.HibernateException: "
                   + e.getMessage());
        }
        catch (Throwable ex)
        {
           ex.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null)
        {
                load();                
        }
        
        return sessionFactory;
    }

    public static void setSessionFactory()
    {
        try
        {
            if(sessionFactory != null)
            {
                    sessionFactory.close();			
            }
        }
        catch (Exception e)
        {
                e.printStackTrace();					
        }
        finally
        {
                sessionFactory = null;
        }
    }
}
