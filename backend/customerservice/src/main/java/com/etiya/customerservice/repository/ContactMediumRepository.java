package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMediumRepository extends JpaRepository<ContactMedium, Long> {
}
