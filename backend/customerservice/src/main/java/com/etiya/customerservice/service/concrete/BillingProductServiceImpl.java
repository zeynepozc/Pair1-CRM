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

import java.util.ArrayList;
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
    public List<Product> getProducts(List<Long> idList) {
        return productServiceClient.findAllByIds(idList);
    }

    @Override
    public List<Product> getProductsByBillingAccountId(Long id) {
        List<BillingProduct> billingProductList = billingProductRepository.findBillingProductsByBillingAccount_Id(id);
        List<Product> products = new ArrayList<>();

        // Ürünleri ekle
        billingProductList.forEach(_billingProduct -> {
            List<Long> productIdList = _billingProduct.getProductIdList();
            products.addAll(productServiceClient.findAllByIds(productIdList)); // Ürünleri products listesine ekle
        });

        return products;
    }

    // todo
    @Override
    public GetByIdBillingProductResponseDto getById(Long id) {
        Optional<BillingProduct> billingProduct = billingProductRepository.findById(id);
        return billingProductMapper.getByIdBillingProductResponseDtoFromBillingProduct(billingProduct.get());
    }

    @Override
    public List<BillingProduct> findBillingProductsByBillingAccountId(Long id){
        return billingProductRepository.findBillingProductsByBillingAccount_Id(id);
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
