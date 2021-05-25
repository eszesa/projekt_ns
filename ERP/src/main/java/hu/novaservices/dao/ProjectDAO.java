package hu.novaservices.dao;

import hu.novaservices.domain.Employee;
import hu.novaservices.domain.Project;

import java.util.List;

public interface ProjectDAO {

    public boolean addProject(Project p);

    public List<Project> getProjects();

    public Project showProject(Project p);
}
