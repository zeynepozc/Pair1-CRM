package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
}
