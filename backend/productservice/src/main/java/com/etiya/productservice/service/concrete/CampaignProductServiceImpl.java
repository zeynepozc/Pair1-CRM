package com.etiya.productservice.service.concrete;

import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.mapper.CampaignProductMapper;
import com.etiya.productservice.repository.CampaignProductRepository;
import com.etiya.productservice.service.abstracts.CampaignProductService;
import com.etiya.productservice.service.dto.request.campaignProduct.*;
import com.etiya.productservice.service.dto.responses.campaignProduct.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignProductServiceImpl implements CampaignProductService {
    private final CampaignProductRepository campaignProductRepository;
    private final CampaignProductMapper campaignProductMapper;

    @Override
    public List<ListCampaignProductResponseDto> getAll() {
        List<CampaignProduct> campaignProducts = campaignProductRepository.findAll();
        return campaignProductMapper.campaignProductList(campaignProducts);
    }

    @Override
    public GetByIdCampaignProductResponseDto getById(Long id) {
        CampaignProduct campaignProduct = campaignProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CampaignProduct not found with id: " + id));
        return campaignProductMapper.getByIdCampaignProductResponseDtoFromCampaignProduct(campaignProduct);
    }

    @Override
    public CreateCampaignProductResponseDto add(CreateCampaignProductRequestDto createCampaignProductRequestDto) {
        CampaignProduct campaignProduct = campaignProductMapper.campaignProductFromCreateCampaignProductRequestDto(createCampaignProductRequestDto);
        CampaignProduct addedCampaignProduct = campaignProductRepository.save(campaignProduct);
        return campaignProductMapper.createCampaignProductResponseDtoFromCampaignProduct(addedCampaignProduct);
    }

    @Override
    public void delete(Long id) {
        campaignProductRepository.deleteById(id);
    }

    @Override
    public UpdateCampaignProductResponseDto update(Long id, UpdateCampaignProductRequestDto updateCampaignProductRequestDto) {
        CampaignProduct campaignProduct = campaignProductMapper.campaignProductFromUpdateCampaignProductRequestDto(updateCampaignProductRequestDto);
        campaignProduct.setId(id);
        CampaignProduct updatedCampaignProduct = campaignProductRepository.save(campaignProduct);
        return campaignProductMapper.updateCampaignProductResponseDtoFromCampaignProduct(updatedCampaignProduct);
    }
}