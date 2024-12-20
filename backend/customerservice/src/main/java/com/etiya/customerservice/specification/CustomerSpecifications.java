package com.etiya.customerservice.specification;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.helper.Formatter;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerSpecifications {

    public static Specification<IndividualCustomer> hasNatId(String natId) {
        return (root, query, criteriaBuilder) -> {
            if (natId == null || natId.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            String pattern = Formatter.formatString(natId);

            return criteriaBuilder.like(root.get("natID"), pattern);
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

            String pattern = Formatter.formatString(firstName);
            return criteriaBuilder.like(root.get("firstName"), pattern);
        };
    }

    public static Specification<IndividualCustomer> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) -> {
            if (lastName == null || lastName.isBlank()) {
                return criteriaBuilder.conjunction();
            }
            String pattern = Formatter.formatString(lastName);
            return criteriaBuilder.like(root.get("lastName"), pattern);
        };
    }

    public static Specification<IndividualCustomer> hasPhoneNo(String phoneNo) {
        return (root, query, criteriaBuilder) -> {
            if (phoneNo == null || phoneNo.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            String pattern = Formatter.formatString(phoneNo);
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<ContactMedium> contactRoot = subquery.from(ContactMedium.class);

            subquery.select(contactRoot.get("customer").get("id"))
                    .where(criteriaBuilder.and(
                            criteriaBuilder.equal(contactRoot.get("customer").get("id"), root.get("id")),
                            criteriaBuilder.or(
                                    criteriaBuilder.like(contactRoot.get("homePhone"), pattern),
                                    criteriaBuilder.like(contactRoot.get("mobilePhone"), pattern)
                            )
                    ));

            return criteriaBuilder.exists(subquery);
        };
    }


    public static Specification<IndividualCustomer> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> {
            if (email == null || email.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            String pattern = Formatter.formatString(email);

            Subquery<Long> subquery = query.subquery(Long.class);
            Root<ContactMedium> contactRoot = subquery.from(ContactMedium.class);

            subquery.select(contactRoot.get("customer").get("id"))
                    .where(criteriaBuilder.and(
                            criteriaBuilder.equal(contactRoot.get("customer").get("id"), root.get("id")),
                            criteriaBuilder.like(contactRoot.get("email"), pattern)
                    ));

            return criteriaBuilder.exists(subquery);
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

    public static Specification<IndividualCustomer> hasCreatedDate(LocalDate createdDate) {
        return (root, query, criteriaBuilder) -> {
            if (createdDate == null) {
                return criteriaBuilder.conjunction();
            }
            LocalDateTime startDateTime = createdDate.atStartOfDay();
            LocalDateTime endDateTime = createdDate.plusDays(1).atStartOfDay();
            return criteriaBuilder.and(
                    criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate"), startDateTime),
                    criteriaBuilder.lessThan(root.get("createdDate"), endDateTime)
            );
        };
    }
}
