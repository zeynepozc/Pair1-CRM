package com.etiya.productservice.repository;

import com.etiya.productservice.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute,Long> {
}
