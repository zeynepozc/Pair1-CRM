package com.etiya.customerservice.entity;

import io.github.cagataysero.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_mediums")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMedium extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "email")
    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "fax")
    private String fax;
}
