package hu.novaservices.controller;

import hu.novaservices.domain.Employee;
import hu.novaservices.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class EmployeeController {

    public Employee showEmployee(Session session, String name) {
        Query query=session.createQuery("from Employee e where e.name=:name");
        query.setParameter("name", name);
        Employee e= (Employee) query.uniqueResult();
        return e;
    }

    // TODO listEmployees()

    public static void listEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //session.save(new Employee("Gipsz Jakab","teszt@gmail.com", "aktív", "alkalmazott", "belsős", 100));
        //session.getTransaction().commit();

        Query q = session.createQuery("SELECT name, position, status_type, department, monthly_hours FROM Employee");

        List<Employee> resultList = q.list();

        session.close();
        HibernateUtil.getSessionFactory().close();

    }

    public static void addEmployee() {


    }


}
