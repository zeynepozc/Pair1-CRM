package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.etiya.productservice.service.dto.request.campaign.*;
import com.etiya.productservice.service.dto.responses.campaign.*;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CampaignMapper {
    public abstract Campaign campaignFromCreateCampaignRequestDto(CreateCampaignRequestDto dto);
    public abstract CreateCampaignResponseDto createCampaignResponseDtoFromCampaign(Campaign campaign);
    public abstract Campaign campaignFromUpdateCampaignRequestDto(UpdateCampaignRequestDto dto);
    public abstract UpdateCampaignResponseDto updateCampaignResponseDtoFromCampaign(Campaign campaign);
    public abstract GetByIdCampaignResponseDto getByIdCampaignResponseDtoFromCampaign(Campaign campaign);
    public abstract List<ListCampaignResponseDto> campaignList(List<Campaign> campaigns);
}
