package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.service.dto.response.individualCustomer.SearchIndividualCustomerResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {

    @Query("SELECT c FROM IndividualCustomer c " +
            "JOIN ContactMedium cm ON cm.customer.id = c.id " +
            "WHERE " +
            "(:natId IS NULL OR c.natID = :natId) AND " +
            "(:customerId IS NULL OR c.id = :customerId) AND " +
            "(:firstName IS NULL OR c.firstName = :firstName) AND " +
            "(:lastName IS NULL OR c.lastName = :lastName) AND " +
            "(:phoneNo IS NULL OR (cm.homePhone = :phoneNo OR cm.mobilePhone = :phoneNo)) AND " + // Telefon numarasını kontrol ettik
            "(:email IS NULL OR cm.email = :email) AND " + // Email kontrolü düzeltildi
            "(:isActive IS NULL OR c.deletedDate = null) AND " +
            "(:createdDate IS NULL OR c.createdDate = :createdDate)")
    List<SearchIndividualCustomerResponseDto> searchCustomers(
            @Param("natId") String natId,
            @Param("customerId") Long customerId,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("phoneNo") String phoneNo,
            @Param("email") String email,
            @Param("isActive") Boolean isActive,
            @Param("createdDate") LocalDateTime createdDate);
}
