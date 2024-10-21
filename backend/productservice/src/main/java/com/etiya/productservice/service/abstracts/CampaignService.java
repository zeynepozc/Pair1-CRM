package com.etiya.productservice.service.abstracts;


import com.etiya.productservice.service.dto.request.campaign.*;
import com.etiya.productservice.service.dto.responses.campaign.*;

import java.util.List;
public interface CampaignService {

    CreateCampaignResponseDto add(CreateCampaignRequestDto requestDto);
    UpdateCampaignResponseDto update(UpdateCampaignRequestDto requestDto);
    void delete(Long id);
    GetByIdCampaignResponseDto getById(Long id);
    List<ListCampaignResponseDto> getAll();
}
