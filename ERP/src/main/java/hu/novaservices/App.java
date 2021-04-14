package hu.novaservices;

import java.io.*;
import hu.novaservices.domain.Employee;
import hu.novaservices.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;
import hu.novaservices.domain.Employee;
import hu.novaservices.util.*;
import org.hibernate.*;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.Query;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 800, 600);
        stage.setTitle("NovaServices ERP");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    //Session session = HibernateUtil.getSessionFactory().openSession();
    //session.beginTransaction();
    //Employee employee = new Employee("Teszt", "teszt@gmail.com", "aktív", "alkalmazott", "belsős", 100);
    //session.getTransaction().commit();

    /*getting data back from the DB*/
    //session.beginTransaction();
    //Employee loadedEmployee = (Employee) session.get(Employee.class, 1);
    //Employee loadedEmployee = (Employee) session.load(Employee.class, 1);
    //System.out.println(loadedEmployee.getName());

    //session.getTransaction().commit();

    /*QUERY*/
    //session.beginTransaction();

    //Query query = session.createQuery("from employees")
    //Query query = session.createQuery("select * from employees where name = :name").setString("name", param);
    //List<Employee> employee = query.list();
    //for(Employee employee : employees) {
    //  System.out.println(employee.getName());
    // }

    //session.getTransaction().commit();

    //session.close();
    //HibernateUtil.getSessionFactory().close();

}