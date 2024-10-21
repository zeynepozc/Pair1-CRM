package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Offer;
import com.etiya.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository  extends JpaRepository<Offer,Long> {
    List<Offer> findByIdIn(List<Long> ids);
}
