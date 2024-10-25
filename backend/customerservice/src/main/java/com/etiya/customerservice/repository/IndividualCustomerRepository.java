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

    @Query("SELECT c FROM IndividualCustomer c " +
            "JOIN ContactMedium cm ON cm.customer.id = c.id " +
            "WHERE " +
            "(c.natID = :natId OR :natId IS NULL) AND " +
            "(c.id = :customerId OR :customerId IS NULL) AND " +
            "(c.firstName = :firstName OR :firstName IS NULL) AND " +
            "(c.lastName = :lastName OR :lastName IS NULL) AND " +
            "((cm.homePhone = :phoneNo OR cm.mobilePhone = :phoneNo) OR :phoneNo IS NULL) AND " +
            "(cm.email = :email OR :email IS NULL) AND " +
            "(:isActive IS NULL OR (c.deletedDate IS NULL AND :isActive = true)) AND " + // isActive kontrolü
            "(c.createdDate = :createdDate OR :createdDate IS NULL)")
    List<Object> searchCustomers(
            @Param("natId") String natId,
            @Param("customerId") Long customerId,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("phoneNo") String phoneNo,
            @Param("email") String email,
            @Param("isActive") Boolean isActive,
            @Param("createdDate") LocalDateTime createdDate);


    List<IndividualCustomer> findAll(Specification<IndividualCustomer> spec);
}
