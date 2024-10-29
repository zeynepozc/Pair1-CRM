package com.etiya.customerservice.specification;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.helper.StringFormatter;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class CustomerSpecifications {

    public static Specification<IndividualCustomer> hasNatId(String natId) {
        return (root, query, criteriaBuilder) -> {
            if (natId == null || natId.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("natID"), natId);
        };
    }

    public static Specification<IndividualCustomer> hasCustomerId(Long customerId) {
        return (root, query, criteriaBuilder) -> {
            if (customerId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("id"), customerId);
        };
    }

    public static Specification<IndividualCustomer> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) -> {
            if (firstName == null || firstName.isBlank()) {
                return criteriaBuilder.conjunction();
            }

            String pattern = StringFormatter.formatInput(firstName);
            return criteriaBuilder.like(root.get("firstName"), pattern);
        };
    }

    public static Specification<IndividualCustomer> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) -> {
            if (lastName == null || lastName.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("lastName"), lastName);
        };
    }

    public static Specification<IndividualCustomer> hasPhoneNo(String phoneNo) {
        return (root, query, criteriaBuilder) -> {
            if (phoneNo == null || phoneNo.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            Join<IndividualCustomer, ContactMedium> contactMediumJoin =
                    root.join("contactMediumList", JoinType.LEFT);
            return criteriaBuilder.or(
                    criteriaBuilder.equal(contactMediumJoin.get("homePhone"), phoneNo),
                    criteriaBuilder.equal(contactMediumJoin.get("mobilePhone"), phoneNo)
            );
        };
    }


    public static Specification<IndividualCustomer> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> {
            if (email == null || email.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            Join<IndividualCustomer, ContactMedium> contactMediumJoin =
                    root.join("contactMediumList", JoinType.LEFT);
            return criteriaBuilder.equal(contactMediumJoin.get("email"), email);
        };
    }


    // todo active
    public static Specification<IndividualCustomer> isActive(Boolean isActive) {
        return (root, query, criteriaBuilder) -> {
            if (isActive == null) {
                return criteriaBuilder.conjunction();
            }
            return isActive ? criteriaBuilder.isNull(root.get("deletedDate")) : criteriaBuilder.isNotNull(root.get("deletedDate"));
        };
    }

    public static Specification<IndividualCustomer> hasCreatedDate(LocalDateTime createdDate) {
        return (root, query, criteriaBuilder) -> {
            if (createdDate == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("createdDate"), createdDate);
        };
    }
}
