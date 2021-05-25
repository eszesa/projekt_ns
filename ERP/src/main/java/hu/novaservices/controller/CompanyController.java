package hu.novaservices.controller;

import hu.novaservices.dao.CompanyDao;
import hu.novaservices.dao.CompanyDaoImpl;
import hu.novaservices.dao.EmployeeDao;
import hu.novaservices.dao.EmployeeDaoImpl;
import hu.novaservices.domain.Company;
import hu.novaservices.domain.Employee;
import hu.novaservices.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CompanyController {

    private CompanyDao companyDao = new CompanyDaoImpl();

    public CompanyController() {

    }

    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }

    public List<Company> getCompanies() {
        return companyDao.getCompanies();
    }

    public Company showCompany(Company company) {
        return companyDao.showCompany(company);
    }


    /*public Company showCompany(Session session, String name) {
        Query query=session.createQuery("from Company c where c.short_name=:name");
        query.setParameter("name", name);
        Company c= (Company) query.uniqueResult();
        return c;
    }

    public static void listCompanies() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("SELECT short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact FROM Company");

        List<Company> resultList = q.list();

        session.close();
        HibernateUtil.getSessionFactory().close();
    }*/

}
