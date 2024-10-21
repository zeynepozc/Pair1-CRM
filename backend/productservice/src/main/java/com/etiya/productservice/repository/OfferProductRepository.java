package com.etiya.productservice.repository;

import com.etiya.productservice.entity.OfferProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferProductRepository extends JpaRepository<OfferProduct, Long> {
}
