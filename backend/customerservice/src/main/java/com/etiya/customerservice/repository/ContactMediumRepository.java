package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.ContactMediumAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactMediumRepository extends JpaRepository<ContactMedium, Long> {
    Optional<ContactMedium> findByCustomerId(Long id);
}
