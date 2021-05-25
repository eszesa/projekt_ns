package hu.novaservices.dao;

import hu.novaservices.domain.Employee;

import java.util.List;

public interface EmployeeDao {

    public boolean addEmployee(Employee e);

    public List<Employee> getEmployees();

    public Employee showEmployee(Employee e);

}
