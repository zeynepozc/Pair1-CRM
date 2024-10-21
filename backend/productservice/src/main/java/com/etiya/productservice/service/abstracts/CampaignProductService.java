package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.service.dto.request.campaignProduct.*;
import com.etiya.productservice.service.dto.responses.campaignProduct.*;

import java.util.List;

public interface CampaignProductService {
    CreateCampaignProductResponseDto add(CreateCampaignProductRequestDto createCampaignProductRequestDto);
    public UpdateCampaignProductResponseDto update(Long id, UpdateCampaignProductRequestDto updateCampaignProductRequestDto);
    void delete(Long id);
    List<ListCampaignProductResponseDto> getAll();
    GetByIdCampaignProductResponseDto getById(Long id);
}
