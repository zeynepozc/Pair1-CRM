package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.ContactMediumAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactMediumAddressRepository extends JpaRepository<ContactMediumAddress, Long> {
    ContactMediumAddress findByContactMediumCustomerIdAndPrimaryAddressTrue(Long customerId);

    List<ContactMediumAddress> findAllByContactMedium_Id(Long id);
}
