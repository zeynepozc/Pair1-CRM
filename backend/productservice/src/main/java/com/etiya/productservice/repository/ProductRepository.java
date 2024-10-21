package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByIdIn(List<Long> ids);
}
