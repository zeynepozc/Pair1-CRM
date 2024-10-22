package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.client.ProductServiceClient;
import com.etiya.customerservice.entity.BillingProduct;
import com.etiya.customerservice.entity.Product;
import com.etiya.customerservice.mapper.BillingProductMapper;
import com.etiya.customerservice.repository.BillingProductRepository;
import com.etiya.customerservice.service.abstracts.BillingProductService;
import com.etiya.customerservice.service.dto.request.billingProduct.CreateBillingProductRequestDto;
import com.etiya.customerservice.service.dto.response.billingProduct.CreateBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.GetByIdBillingProductResponseDto;
import com.etiya.customerservice.service.dto.response.billingProduct.ListBillingProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillingProductServiceImpl implements BillingProductService
{
    private final BillingProductRepository billingProductRepository;
    private final BillingProductMapper billingProductMapper;
    private final ProductServiceClient productServiceClient;


    @Override
    public List<ListBillingProductResponseDto> getAll() {
        List<BillingProduct> billingProductList = billingProductRepository.findAll();
        return billingProductMapper.listBillingProductResponseDtoListFromBillingProductList(billingProductList);
    }

    @Override
    public GetByIdBillingProductResponseDto getById(Long id) {
        Optional<BillingProduct> billingProduct = billingProductRepository.findById(id);
        return billingProductMapper.getByIdBillingProductResponseDtoFromBillingProduct(billingProduct.get());
    }

    @Override
    public CreateBillingProductResponseDto add(CreateBillingProductRequestDto createBillingProductRequestDto) {


        BillingProduct billingProduct = billingProductMapper.billingProductFromCreateBillingProductRequestDto(createBillingProductRequestDto);
        return billingProductMapper.createBillingProductResponseDtoFromBillingProduct(billingProductRepository.save(billingProduct));
    }

    @Override
    public void delete(Long id) {
        billingProductRepository.deleteById(id);
    }
}
