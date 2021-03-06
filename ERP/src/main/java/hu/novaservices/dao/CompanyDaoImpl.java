package hu.novaservices.dao;

import hu.novaservices.domain.Company;
import hu.novaservices.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao{

    //private static final String INSERT_COMPANY = "INSERT INTO Company (short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES " +"(?,?,?,?,?,?)";

    private static final String SELECT_COMPANIES = "SELECT (name, position, status_type, department, monthly_hours) FROM Employee";

    private static final String SHOW_COMPANY = "from Company c where c.short_name=:short_name";


    @Override
    public boolean addCompany(Company c) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            //Query q = session.createQuery(INSERT_COMPANY);

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
    public List<Company> getCompanies() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery(SELECT_COMPANIES);

        List<Company> resultList = q.list();

        session.close();
        HibernateUtil.getSessionFactory().close();
        return resultList;
    }

    @Override
    public Company showCompany(Company c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query=session.createQuery(SHOW_COMPANY);
        // query.setParameter("name", name);
        Company company= (Company) query.uniqueResult();

        session.close();
        HibernateUtil.getSessionFactory().close();

        return company;
    }
}
