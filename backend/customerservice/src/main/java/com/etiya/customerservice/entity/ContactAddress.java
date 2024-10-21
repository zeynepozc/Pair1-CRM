package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address_desc")
    private String addressDesc;

    @ManyToOne
    @JoinColumn(name = "neighborhood_id")
    private Neighborhood neighborhood;
}