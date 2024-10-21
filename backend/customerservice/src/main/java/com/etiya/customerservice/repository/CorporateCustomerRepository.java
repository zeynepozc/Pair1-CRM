package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long> {
}
