package hu.novaservices.dao;

import hu.novaservices.domain.Company;
import hu.novaservices.domain.Employee;

import java.util.List;

public interface CompanyDao {

    public boolean addCompany(Company c);

    public List<Company> getCompanies();

    public Company showCompany(Company c);
}
