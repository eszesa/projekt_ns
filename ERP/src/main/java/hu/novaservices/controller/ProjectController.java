package hu.novaservices.controller;

import hu.novaservices.dao.EmployeeDao;
import hu.novaservices.dao.EmployeeDaoImpl;
import hu.novaservices.dao.ProjectDAO;
import hu.novaservices.dao.ProjectDaoImpl;
import hu.novaservices.domain.Employee;
import hu.novaservices.domain.Project;

import java.util.List;

public class ProjectController {

    private ProjectDAO projectDAO = new ProjectDaoImpl();

    public ProjectController() {

    }

    public boolean addProject(Project project) {
        return projectDAO.addProject(project);
    }

    public List<Project> getProjects() {
        return projectDAO.getProjects();
    }

    public Project showProject(Project project) {
        return projectDAO.showProject(project);
    }
}
