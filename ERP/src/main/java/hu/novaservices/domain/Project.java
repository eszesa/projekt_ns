package hu.novaservices.domain;

import javafx.beans.property.StringProperty;
import org.hibernate.Query;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public @Data class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String code;
    private String name;
    private Date starting_date;
    private Date ending_date;
    private String status;
    private Long income;
    private String contractor;
    private String project_manager;
    private String description;

    public Project() {
    }

    public Project(Long id, String code, String name, Date starting_date, Date ending_date, String status, Long income, String contractor, String project_manager, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.starting_date = starting_date;
        this.ending_date = ending_date;
        this.status = status;
        this.income = income;
        this.contractor = contractor;
        this.project_manager = project_manager;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", starting_date=" + starting_date +
                ", ending_date=" + ending_date +
                ", status='" + status + '\'' +
                ", income=" + income +
                ", contractor='" + contractor + '\'' +
                ", project_manager='" + project_manager + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
