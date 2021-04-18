package hu.novaservices.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String id_card;
    private String name;
    private String sex;
    private String address;
    private String email;
    private Date birth_date;
    private String birth_place;
    private String phone;
    private String status;
    private String status_type;
    private String secondary_name;
    private String secondary_phone;
    private String department;
    private int hourly_rate;
    private int monthly_hours;
    private String position;

    // constructors
    public Employee() {
    }

    public Employee(String name, String email, String status, String status_type, String department, int hourly_rate) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.status_type = status_type;
        this.department = department;
        this.hourly_rate = hourly_rate;
    }

    public Employee(String id_card, String name, String sex, String address, String email, Date birth_date, String birth_place, String phone, String status, String status_type, String secondary_name, String secondary_phone, String department, int hourly_rate, int monthly_hours, String position) {
        this.id_card = id_card;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.birth_date = birth_date;
        this.birth_place = birth_place;
        this.phone = phone;
        this.status = status;
        this.status_type = status_type;
        this.secondary_name = secondary_name;
        this.secondary_phone = secondary_phone;
        this.department = department;
        this.hourly_rate = hourly_rate;
        this.monthly_hours = monthly_hours;
        this.position = position;
    }


}
