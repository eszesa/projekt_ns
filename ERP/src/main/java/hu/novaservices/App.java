package hu.novaservices;

import hu.novaservices.controller.CompanyController;
import hu.novaservices.controller.EmployeeController;
import hu.novaservices.domain.Company;
import hu.novaservices.domain.Employee;
import hu.novaservices.util.HibernateUtil;
import hu.novaservices.view.CompanyAddDialog;
import hu.novaservices.view.EmployeeAddDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;

import org.hibernate.query.Query;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    TableView<Employee> table = new TableView<>();
    TableView<Company> companiesTable = new TableView<>();

    private EmployeeController employeeController = new EmployeeController();
    private CompanyController companyController = new CompanyController();

    private Scene employeeListScene;
    private Scene companiesListScene;

    @Override
    public void start(Stage stage) throws IOException {
        constructTable();
        constructCompaniesTable();

        Button addEmployee = new Button("Új létrehozása");
        addEmployee.setOnAction(e -> new EmployeeAddDialog(employeeController)); // menupont esemenykezelese

        Button addCompany = new Button("Új létrehozása");
        addCompany.setOnAction(e2 -> new CompanyAddDialog(companyController)); // menupont esemenykezelese

        FlowPane buttonPane = new FlowPane();
        buttonPane.setOrientation(Orientation.HORIZONTAL);
        buttonPane.setHgap(30);
        buttonPane.setVgap(30);
        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        buttonPane.getChildren().addAll(addEmployee);

        FlowPane buttonPane2 = new FlowPane();
        buttonPane2.setOrientation(Orientation.HORIZONTAL);
        buttonPane2.setHgap(30);
        buttonPane2.setVgap(30);
        buttonPane2.setAlignment(Pos.BOTTOM_CENTER);
        buttonPane2.getChildren().addAll(addCompany);

        VBox root = new VBox(createMenuBar(stage), table, buttonPane);
        root.setSpacing(20);
        VBox root2 = new VBox(createMenuBar(stage), companiesTable, buttonPane2);
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

        nameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        positionCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        typeCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        taskCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));
        monthlyHoursCol.prefWidthProperty().bind(table.widthProperty().multiply(0.20));

        table.getColumns().addAll(nameCol, positionCol, typeCol, taskCol, monthlyHoursCol);
        //TODO EmployeeController getAll()
        //table.setItems(FXCollections.observableArrayList(employeeController.getAll()));
    }

    private void constructCompaniesTable() {
        companiesTable.setEditable(false);

        TableColumn<Company, String> shortNameCol = new TableColumn<>("Rövid név");
        shortNameCol.setCellValueFactory(new PropertyValueFactory<Company, String>("short_name"));

        TableColumn<Company, String> headquartersCol = new TableColumn<>("Székhely");
        headquartersCol.setCellValueFactory(new PropertyValueFactory<Company, String>("headquarters"));

        TableColumn<Company, String> industryCol = new TableColumn<>("Iparági besorolás");
        industryCol.setCellValueFactory(new PropertyValueFactory<Company, String>("industry_classification"));

        TableColumn<Company, String> connectionCol = new TableColumn<>("Cég kapcsolattípus");
        connectionCol.setCellValueFactory(new PropertyValueFactory<Company, String>("connection_type"));

        TableColumn<Company, String> compContactCol = new TableColumn<>("Cégtől kapcsolattartó");
        compContactCol.setCellValueFactory(new PropertyValueFactory<Company, String>("comp_contact"));

        TableColumn<Company, String> ourContactCol = new TableColumn<>("Tőlünk kapcsolattartó");
        ourContactCol.setCellValueFactory(new PropertyValueFactory<Company, String>("our_contact"));

        shortNameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.17));
        headquartersCol.prefWidthProperty().bind(table.widthProperty().multiply(0.17));
        industryCol.prefWidthProperty().bind(table.widthProperty().multiply(0.17));
        connectionCol.prefWidthProperty().bind(table.widthProperty().multiply(0.17));
        compContactCol.prefWidthProperty().bind(table.widthProperty().multiply(0.16));
        ourContactCol.prefWidthProperty().bind(table.widthProperty().multiply(0.16));

        companiesTable.getColumns().addAll(shortNameCol, headquartersCol, industryCol, connectionCol, compContactCol, ourContactCol);
    }

    public static void hibernateSession() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(new Employee("Gipsz Jakab","teszt@gmail.com", "aktív", "alkalmazott", "belsős", 100));

        session.getTransaction().commit();

        Query q = session.createQuery("From Employee ");

        List<Employee> resultList = q.list();
        System.out.println("num of employees:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }

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
        //hibernateSession();
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