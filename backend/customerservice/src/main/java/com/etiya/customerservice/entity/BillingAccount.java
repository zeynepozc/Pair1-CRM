package com.etiya.customerservice.entity;

import io.github.cagataysero.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "billing_accounts")
public class BillingAccount extends BaseEntity {
    // todo Billing Hesap ise ve create, update ve delete tarihleri baseEntityden geliyorsa billingDate nedir?
    // todo bu bir hesap fatura değil fatura tarihi neyi ifade ediyor?

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_account_id", referencedColumnName = "id")
    private CustomerAccount customerAccountId;

    @Column(name = "billing_date")
    private LocalDateTime billingDate;
}
