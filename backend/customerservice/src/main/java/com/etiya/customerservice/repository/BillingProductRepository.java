package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.BillingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingProductRepository extends JpaRepository<BillingProduct, Long> {
}
