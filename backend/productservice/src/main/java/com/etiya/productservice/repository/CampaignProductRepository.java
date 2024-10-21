package com.etiya.productservice.repository;

import com.etiya.productservice.entity.CampaignProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignProductRepository extends JpaRepository<CampaignProduct,Long> {
}
