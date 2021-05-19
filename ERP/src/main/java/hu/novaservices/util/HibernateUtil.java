package hu.novaservices.util;

import javafx.scene.control.Alert;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static
    {
        try {
            //Configuration configuration = new Configuration().configure();
            Configuration cfg=new Configuration().configure();
            StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(
                    cfg.getProperties());
            SessionFactory factory= cfg.buildSessionFactory(builder.build());
            //serviceRegistry = new StandardServiceRegistry().applySettings(configuration.getProperties());
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        } catch (HibernateException exception) {
            System.out.println("Problem creating session factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
    /*


    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
*/


}
