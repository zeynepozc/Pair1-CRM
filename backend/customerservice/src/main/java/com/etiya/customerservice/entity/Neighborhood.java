package com.etiya.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "neighborhoods")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "house_no")
    private String houseNo;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}
