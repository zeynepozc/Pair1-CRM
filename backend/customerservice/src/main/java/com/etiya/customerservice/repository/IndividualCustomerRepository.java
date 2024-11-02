package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.service.dto.response.individualCustomer.SearchIndividualCustomerResponseDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long>, JpaSpecificationExecutor<IndividualCustomer> {

    List<IndividualCustomer> findAll(Specification<IndividualCustomer> spec);

    boolean existsByNatID(String natID);
}
