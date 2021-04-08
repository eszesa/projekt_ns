package hu.novaservices.domain;

import javax.persistence.*;

@Entity
@Table
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String id_card;

    // constructors
    public Employees() {}

    // getters & setters
    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
