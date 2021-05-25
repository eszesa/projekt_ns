package hu.novaservices.dao;

import hu.novaservices.domain.Employee;
import hu.novaservices.domain.Project;
import hu.novaservices.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ProjectDaoImpl implements ProjectDAO {

    //private static final String INSERT_PROJECT = "INSERT INTO Project (code, name, starting_date, ending_date, status, income, contractor, project_manager) VALUES " + "(?,?,?,?,?,?, ?, ?)";

    private static final String SELECT_PROJECTS = "SELECT (code, name, starting_date, ending_date, status, income, contractor, project_manager) FROM Project";

    private static final String SHOW_PROJECT = "from Project p where p.name=:name";


    @Override
    public boolean addProject(Project p) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            //Query q = session.createQuery(INSERT_PROJECT);

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
    public List<Project> getProjects() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery(SELECT_PROJECTS);

        List<Project> resultList = q.list();

        session.close();
        HibernateUtil.getSessionFactory().close();
        return resultList;
    }

    @Override
    public Project showProject(Project p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query=session.createQuery(SHOW_PROJECT);
        // query.setParameter("name", name);
        Project project = (Project) query.uniqueResult();

        session.close();
        HibernateUtil.getSessionFactory().close();

        return project;
    }
}
