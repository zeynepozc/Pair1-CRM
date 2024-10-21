package com.etiya.customerservice.entity;

import io.github.cagataysero.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "billing_products")
public class BillingProduct extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_account_id", referencedColumnName = "id")
    private BillingAccount customerAccount;

    @ElementCollection
    private List<Long> productIdList;
}
