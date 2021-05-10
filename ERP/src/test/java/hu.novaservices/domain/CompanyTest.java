package hu.novaservices.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;


public class CompanyTest {
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
        factory = configuration.buildSessionFactory(serviceRegistry);
*/
    }

    @AfterMethod
    public void shutdown() {
        factory.close();
    }

    @Test
    public void testSaveCompany() {
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        Company company=new Company(
                "Teszt",
                "Teszt Cég",
                "11111111111",
                "healthcare",
                "0000 Budapest Alma utca 1.",
                "not_supported",
                "Cég Kapcsolattartó",
                "Saját Kapcsolattartó",
                123,
                "000000001111111122222222",
                "blabla",
                "Számlázási név",
                "Számlázási cím");

        session.save(company);
        tx.commit();
        session.close();
    }

}

