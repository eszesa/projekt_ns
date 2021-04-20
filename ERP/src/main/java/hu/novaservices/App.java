package hu.novaservices;

import java.io.*;
import hu.novaservices.domain.Employee;
import hu.novaservices.domain.Person;
import hu.novaservices.util.HibernateUtil;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;
import lombok.*;
import javax.persistence.*;
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
    TableView<Employee> table = new TableView<>();
    TableView<Employee> companiesTable = new TableView<>();
    private SecondaryController employeeController = new SecondaryController();
    private Scene employeeListScene;
    private Scene companiesListScene;

    @Override
    public void start(Stage stage) throws IOException {
        constructTable();

        Button addEmployee = new Button("Új személy hozzáadása");
        addEmployee.setOnAction(event -> {
            try {
                scene = new Scene(loadFXML("addemployee"), 800, 600);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Új személy hozzáadása - ERP Nova Services");
            stage.setScene(scene);
            stage.show();
        });

        VBox root = new VBox(createMenuBar(stage), table, addEmployee);
        root.setSpacing(20);
        VBox root2 = new VBox(createMenuBar(stage), companiesTable);
        root2.setSpacing(20);
        employeeListScene = new Scene(root, 900, 600);
        companiesListScene = new Scene(root2, 900, 600);

        stage.setTitle("ERP Nova Services");
        stage.setScene(employeeListScene);
        stage.show();
    }

    private MenuBar createMenuBar(Stage stage) {
        MenuBar menuBar = new MenuBar();
        Menu dataMenu = new Menu("Törzsadatok"); // menu letrehozasa
        menuBar.getMenus().addAll(dataMenu); // menu hozzaadasa a menubarhoz
        MenuItem listEmployeesMenuItem = new MenuItem("Személyek"); // menupont letrehozasa
        MenuItem listCompaniesMenuItem = new MenuItem("Cégek"); // menupont letrehozasa

        listEmployeesMenuItem.setOnAction(e -> {
            stage.setScene(employeeListScene);
        });
        listCompaniesMenuItem.setOnAction(e -> {
            stage.setScene(companiesListScene);
        });

        dataMenu.getItems().addAll(listEmployeesMenuItem, listCompaniesMenuItem); // menupont hozzaadasa a menuhoz

        return menuBar;
    }

    private void constructTable() {
        table.setEditable(false);


        TableColumn<Employee, String> nameCol = new TableColumn<>("Név");
        nameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));

        TableColumn<Employee, String> positionCol = new TableColumn<>("Munkakör");
        positionCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));

        TableColumn<Employee, String> typeCol = new TableColumn<>("Típus");
        typeCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("status_type"));

        TableColumn<Employee, String> taskCol = new TableColumn<>("Feladat osztály");
        taskCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("department"));

        TableColumn<Employee, String> monthlyHoursCol = new TableColumn<>("Munkaidő alap");
        monthlyHoursCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("monthly_hours"));


        table.getColumns().addAll(nameCol, positionCol, typeCol, taskCol, monthlyHoursCol);
        //TODO
        //table.setItems(FXCollections.observableArrayList(employeeController.getAll()));
    }

    public static void hibernateSession() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //Employee employee = new Employee("Teszt", "teszt@gmail.com", "aktív", "alkalmazott", "belsős", 100);
        //session.getTransaction().commit();

        session.close();
        HibernateUtil.getSessionFactory().close();

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
        hibernateSession();
    }

    /*Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Employee employee = new Employee("Teszt", "teszt@gmail.com", "aktív", "alkalmazott", "belsős", 100);
    session.getTransaction().commit();

    *//*getting data back from the DB*//*
    session.beginTransaction();
    Employee loadedEmployee = (Employee) session.get(Employee.class, 1);
    Employee loadedEmployee = (Employee) session.load(Employee.class, 1);
    System.out.println(loadedEmployee.getName());

    session.getTransaction().commit();

    *//*QUERY*//*
    session.beginTransaction();

    Query query = session.createQuery("from employees");
    Query query2 = session.createQuery("select * from employees where name = :name").setString("name", param);
    List<Employee> employee2 = query.list();
    for(Employee employee2 : employees) {
      System.out.println(employee.getName());
     }*/

    //session.getTransaction().commit();

    //session.close();
    //HibernateUtil.getSessionFactory().close();

}