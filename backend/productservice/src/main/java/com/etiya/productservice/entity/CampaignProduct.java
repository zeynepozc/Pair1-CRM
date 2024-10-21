package com.etiya.productservice.entity;

import jakarta.persistence.*;

public class CampaignProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaignId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
