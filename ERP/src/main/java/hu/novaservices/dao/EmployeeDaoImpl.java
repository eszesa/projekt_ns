package hu.novaservices.dao;

import hu.novaservices.domain.Employee;
import hu.novaservices.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String INSERT_EMPLOYEE = "INSERT INTO Employee (short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES " +
            "(?,?,?,?,?,?)";

    private static final String SELECT_EMPLOYEES = "SELECT (name, position, status_type, department, monthly_hours) FROM Employee";

    private static final String SHOW_EMPLOYEE = "from Employee e where e.name=:name";


    @Override
    public boolean addEmployee(Employee e) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Query q = session.createQuery(INSERT_EMPLOYEE);

            session.close();
            HibernateUtil.getSessionFactory().close();

            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery(SELECT_EMPLOYEES);

        List<Employee> resultList = q.list();

        session.close();
        HibernateUtil.getSessionFactory().close();
        return resultList;
    }

    @Override
    public Employee showEmployee(Employee e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query=session.createQuery(SHOW_EMPLOYEE);
       // query.setParameter("name", name);
        Employee employee= (Employee) query.uniqueResult();

        session.close();
        HibernateUtil.getSessionFactory().close();

        return employee;
    }
}
