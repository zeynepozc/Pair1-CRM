package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.BillingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingProductRepository extends JpaRepository<BillingProduct, Long> {
    List<BillingProduct> findBillingProductsByBillingAccount_Id(Long id);
}
