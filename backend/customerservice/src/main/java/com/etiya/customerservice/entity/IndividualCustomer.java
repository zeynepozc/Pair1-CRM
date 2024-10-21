package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "individual_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class IndividualCustomer extends Customer
{
    @Column(name = "nat_ID")
    private String natID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;
}
