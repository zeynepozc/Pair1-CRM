package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CorporateCustomer extends Customer
{
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_number")
    private String companyNumber;

    @Column(name = "tax_number")
    private String taxNumber;
}
