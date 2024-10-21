package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {
    //isactive olan campaign listesi dönülebilir.
}
