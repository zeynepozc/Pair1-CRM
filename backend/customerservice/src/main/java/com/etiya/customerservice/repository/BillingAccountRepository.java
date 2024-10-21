package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long> {
}
