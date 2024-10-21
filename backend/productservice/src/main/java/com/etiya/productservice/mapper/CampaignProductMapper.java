package com.etiya.productservice.mapper;

import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.service.dto.request.campaignProduct.CreateCampaignProductRequestDto;
import com.etiya.productservice.service.dto.request.campaignProduct.UpdateCampaignProductRequestDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.CreateCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.GetByIdCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.ListCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.UpdateCampaignProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CampaignProductMapper {
    @Mapping(source="productId", target = "product.id")
    @Mapping(source="campaignId", target = "campaign.id")
    public abstract CampaignProduct campaignProductFromCreateCampaignProductRequestDto(CreateCampaignProductRequestDto createCampaignProductRequestDto);
    @Mapping(source = "product.id", target="productId")
    @Mapping(source = "campaign.id", target="campaignId")
    public abstract CreateCampaignProductResponseDto createCampaignProductResponseDtoFromCampaignProduct(CampaignProduct campaignProduct);
    @Mapping(source="productId", target = "product.id")
    @Mapping(source="campaignId", target = "campaign.id")
    public abstract CampaignProduct campaignProductFromUpdateCampaignProductRequestDto(UpdateCampaignProductRequestDto updateCampaignProductRequestDto);
    @Mapping(source = "product.id", target="productId")
    @Mapping(source = "campaign.id", target="campaignId")
    public abstract UpdateCampaignProductResponseDto updateCampaignProductResponseDtoFromCampaignProduct(CampaignProduct campaignProduct);
    @Mapping(source = "product.id", target="productId")
    @Mapping(source = "campaign.id", target="campaignId")
    public abstract List<ListCampaignProductResponseDto> campaignProductList(List<CampaignProduct> campaignProductList);
    @Mapping(source = "product.id", target="productId")
    @Mapping(source = "campaign.id", target="campaignId")
    public abstract ListCampaignProductResponseDto campaignProductList(CampaignProduct campaignProduct);
    @Mapping(source = "product.id", target="productId")
    @Mapping(source = "campaign.id", target="campaignId")
    public abstract GetByIdCampaignProductResponseDto getByIdCampaignProductResponseDtoFromCampaignProduct(CampaignProduct campaignProduct);
}
