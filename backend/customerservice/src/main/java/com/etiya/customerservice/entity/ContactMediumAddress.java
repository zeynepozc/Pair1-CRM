package com.etiya.customerservice.entity;

import io.github.cagataysero.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_medium_addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumAddress extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private ContactMedium contactMedium;

    @ManyToOne
    @JoinColumn(name = "contact_address_id")
    private ContactAddress contactAddress;
}