package com.etiya.productservice.repository;

import com.etiya.productservice.entity.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification,Long> {
}
