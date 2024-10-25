package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.SearchIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.*;

import com.etiya.customerservice.specification.CustomerSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService
{
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;


    @Override
    public List<ListIndividualCustomerResponseDto> getAll() {
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAll();
        return individualCustomerMapper.listIndividualCustomerResponseDtoListFromIndividualCustomerList(individualCustomerList);
    }

    @Override
    public GetByIdIndividualCustomerResponseDto getById(Long id) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(id);
        return individualCustomerMapper.getByIdIndividualCustomerResponseDtoFromIndividualCustomer(individualCustomer.get());
    }

    @Override
    public CreateIndividualCustomerResponseDto add(CreateIndividualCustomerRequestDto createIndividualCustomerRequestDto) {
        // todo check if the given city exists
        IndividualCustomer individualCustomer = individualCustomerMapper.individualCustomerFromCreateIndividualCustomerRequestDto(createIndividualCustomerRequestDto);
        return individualCustomerMapper.createIndividualCustomerResponseDtoFromIndividualCustomer(individualCustomerRepository.save(individualCustomer));
    }

    @Override
    public UpdateIndividualCustomerResponseDto update(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto) {
        // todo check if the given city exists
        IndividualCustomer individualCustomer = individualCustomerMapper.individualCustomerFromUpdateIndividualCustomerRequestDto(updateIndividualCustomerRequestDto);
        individualCustomer = individualCustomerRepository.save(individualCustomer);
        return individualCustomerMapper.updateIndividualCustomerResponseDtoFromIndividualCustomer(individualCustomer);
    }

    @Override
    public void delete(Long id) {
        individualCustomerRepository.deleteById(id);
    }

    @Override
    public List<SearchIndividualCustomerResponseDto> searchByFilters(SearchIndividualCustomerRequestDto dto){
         Specification<IndividualCustomer> spec = Specification.where(CustomerSpecifications.hasNatId(dto.getNatID()))
                        .and(CustomerSpecifications.hasCustomerId(dto.getCustomerId()))
                        .and(CustomerSpecifications.hasFirstName(dto.getFirstName()))
                        .and(CustomerSpecifications.hasLastName(dto.getLastName()))
                        .and(CustomerSpecifications.hasPhoneNo(dto.getPhoneNo()))
                        .and(CustomerSpecifications.hasEmail(dto.getEmail()))
                        .and(CustomerSpecifications.isActive(dto.isActive()))
                        .and(CustomerSpecifications.hasCreatedDate(dto.getCreatedDate()));

         List<IndividualCustomer> customers = individualCustomerRepository.findAll(spec);

         return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    private SearchIndividualCustomerResponseDto convertToDto(IndividualCustomer customer) {
        // todo liste dönebilir
        ContactMedium contactMedium = customer.getContactMediumList().isEmpty() ? null : customer.getContactMediumList().get(0);

        SearchIndividualCustomerResponseDto responseDto = new SearchIndividualCustomerResponseDto();

        responseDto.setNatID(customer.getNatID());
        responseDto.setCustomerId(customer.getId());
        responseDto.setFirstName(customer.getFirstName());
        responseDto.setLastName(customer.getLastName());

        if (contactMedium != null) {
            if (contactMedium.getHomePhone() != null) {
                responseDto.setPhoneNo(contactMedium.getHomePhone());
            } else {
                responseDto.setPhoneNo(contactMedium.getMobilePhone());
            }
        } else {
            responseDto.setPhoneNo(null);
        }

        if (contactMedium != null) {
            responseDto.setEmail(contactMedium.getEmail());
        } else {
            responseDto.setEmail(null);
        }

        responseDto.setCreatedDate(customer.getCreatedDate());
        responseDto.setActive(customer.getDeletedDate() == null ? true : false);
        return responseDto;
    }



}
