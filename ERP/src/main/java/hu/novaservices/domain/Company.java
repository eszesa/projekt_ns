package hu.novaservices.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public @Data class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private String short_name;
    private String full_name;
    private String tax_number;
    private String industry_classification;
    private String headquarters;
    private Object connection_type;
    private String comp_contact;
    private String our_contact;
    private Integer reg_number;
    private String bank_account_number;
    private String description;
    private String billing_name;
    private String billing_address;



}
