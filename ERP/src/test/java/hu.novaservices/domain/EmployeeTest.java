package hu.novaservices.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class EmployeeTest {
    SessionFactory factory;

/*      @BeforeClass
        public void setup() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
        srBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }*/

    @BeforeMethod
    public void setup() {
        Configuration cfg=new Configuration().configure();
        StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(
                cfg.getProperties());
        factory= cfg.buildSessionFactory(builder.build());
/*      Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistryBuilder srBuilder = new ServiceRegistryBuilder();
        srBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = srBuilder.buildServiceRegistry();
        factory = configuration.buildSessionFactory(serviceRegistry);*/
    }

    @AfterMethod
    public void shutdown() {

        factory.close();
    }

    @Test
    public void testSaveEmployee() {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        Employee employee=new Employee(
                "Teszt Dolgozo",
                "teszt@teszt.com",
                "active",
                "employee",
                "external",
                100);
        session.save(employee);
        tx.commit();
        session.close();
    }
}