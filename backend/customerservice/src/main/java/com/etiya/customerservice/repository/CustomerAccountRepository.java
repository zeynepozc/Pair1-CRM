package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
    @Query("SELECT COALESCE(MAX(c.accountNumber), '0') FROM CustomerAccount c")
    String findMaxAccountNumber();

    List<CustomerAccount> getCustomerAccountsByCustomer_Id(Long id);
}
