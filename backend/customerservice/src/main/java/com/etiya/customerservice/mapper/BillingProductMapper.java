package com.etiya.customerservice.mapper;

import com.etiya.customerservice.entity.BillingProduct;
import com.etiya.customerservice.service.dto.request.billingProduct.CreateBillingProductRequestDto;
import com.etiya.customerservice.service.dto.response.billingProduct.CreateBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.GetByIdBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.ListBillingProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BillingProductMapper {

    @Mapping(source="billingAccountId", target = "billingAccount.id")
    public abstract BillingProduct billingProductFromCreateBillingProductRequestDto(CreateBillingProductRequestDto dto);

    @Mapping(source="billingAccount.id", target = "billingAccountId")
    public abstract CreateBillingProductResponseDto createBillingProductResponseDtoFromBillingProduct(BillingProduct billingProduct);

    @Mapping(source="billingAccount.id", target = "billingAccountId")
    public abstract GetByIdBillingProductResponseDto getByIdBillingProductResponseDtoFromBillingProduct(BillingProduct billingProduct);

    @Mapping(source="billingAccount.id", target = "billingAccountId")
    public abstract List<ListBillingProductResponseDto> listBillingProductResponseDtoListFromBillingProductList(List<BillingProduct> billingProduct);

    @Mapping(source="billingAccount.id", target = "billingAccountId")
    public abstract ListBillingProductResponseDto billingProductToListBillingProductResponseDto(BillingProduct billingProduct);
}
