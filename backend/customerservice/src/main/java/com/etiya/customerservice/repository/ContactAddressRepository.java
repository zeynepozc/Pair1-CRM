package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.ContactAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactAddressRepository extends JpaRepository<ContactAddress, Long> {
}
