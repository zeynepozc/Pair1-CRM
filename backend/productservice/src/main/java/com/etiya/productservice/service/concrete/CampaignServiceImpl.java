package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.mapper.CampaignMapper;
import com.etiya.productservice.repository.CampaignRepository;
import com.etiya.productservice.service.abstracts.CampaignService;
import com.etiya.productservice.service.dto.request.campaign.*;
import com.etiya.productservice.service.dto.responses.campaign.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {
    private final CampaignRepository campaignRepository;
    private final CampaignMapper campaignMapper;

    @Override
    public CreateCampaignResponseDto add(CreateCampaignRequestDto createCampaignRequestDto) {
        Campaign campaign = campaignMapper.campaignFromCreateCampaignRequestDto(createCampaignRequestDto);
        Campaign addedCampaign = campaignRepository.save(campaign);
        return campaignMapper.createCampaignResponseDtoFromCampaign(addedCampaign);
    }

    @Override
    public UpdateCampaignResponseDto update(UpdateCampaignRequestDto updateCampaignRequestDto) {
        Campaign campaign = campaignMapper.campaignFromUpdateCampaignRequestDto(updateCampaignRequestDto);
        campaign.setId(updateCampaignRequestDto.getId());
        Campaign updatedCampaign = campaignRepository.save(campaign);
        return campaignMapper.updateCampaignResponseDtoFromCampaign(updatedCampaign);
    }

    @Override
    public void delete(Long id) {
        campaignRepository.deleteById(id);
    }

    @Override
    public GetByIdCampaignResponseDto getById(Long id) {
        return null;
    }

    @Override
    public List<ListCampaignResponseDto> getAll() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaignMapper.campaignList(campaigns);
    }


}
