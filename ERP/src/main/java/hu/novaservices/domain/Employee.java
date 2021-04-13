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

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    public String getSecondary_name() {
        return secondary_name;
    }

    public void setSecondary_name(String secondary_name) {
        this.secondary_name = secondary_name;
    }

    public String getSecondary_phone() {
        return secondary_phone;
    }

    public void setSecondary_phone(String secondary_phone) {
        this.secondary_phone = secondary_phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(int hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public int getMonthly_hours() {
        return monthly_hours;
    }

    public void setMonthly_hours(int monthly_hours) {
        this.monthly_hours = monthly_hours;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
