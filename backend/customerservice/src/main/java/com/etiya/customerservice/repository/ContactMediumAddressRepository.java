package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.ContactMediumAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMediumAddressRepository extends JpaRepository<ContactMediumAddress, Long> {
}
