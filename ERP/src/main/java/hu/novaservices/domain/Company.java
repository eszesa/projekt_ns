package hu.novaservices.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
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
    private String connection_type;
    private String comp_contact;
    private String our_contact;
    private Integer reg_number;
    private String bank_account_number;
    private String description;
    private String billing_name;
    private String billing_address;

    public Company(String short_name, String full_name, String tax_number, String industry_classification, String headquarters, String connection_type, String comp_contact, String our_contact, Integer reg_number, String bank_account_number, String description, String billing_name, String billing_address) {
        this.short_name = short_name;
        this.full_name = full_name;
        this.tax_number = tax_number;
        this.industry_classification = industry_classification;
        this.headquarters = headquarters;
        this.connection_type = connection_type;
        this.comp_contact = comp_contact;
        this.our_contact = our_contact;
        this.reg_number = reg_number;
        this.bank_account_number = bank_account_number;
        this.description = description;
        this.billing_name = billing_name;
        this.billing_address = billing_address;
    }
}
