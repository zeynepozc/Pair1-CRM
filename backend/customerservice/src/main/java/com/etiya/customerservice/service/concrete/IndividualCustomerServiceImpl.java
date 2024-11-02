package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.IsCustomerExistsWithNatIDRequestDto;
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
    private final ContactMediumService contactMediumService;


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

        IndividualCustomer individualCustomer = individualCustomerMapper.individualCustomerFromCreateIndividualCustomerRequestDto(createIndividualCustomerRequestDto);
        return individualCustomerMapper.createIndividualCustomerResponseDtoFromIndividualCustomer(individualCustomerRepository.save(individualCustomer));
    }

    @Override
    public UpdateIndividualCustomerResponseDto update(UpdateIndividualCustomerRequestDto updateIndividualCustomerRequestDto) {

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
                        .and(CustomerSpecifications.isActive(dto.getIsActive()))
                        .and(CustomerSpecifications.hasCreatedDate(dto.getCreatedDate()));

         List<IndividualCustomer> customers = individualCustomerRepository.findAll(spec);

         return customers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @Override
    public IsCustomerExistsWithNatIDResponseDto isCustomerExistsWithNatID(IsCustomerExistsWithNatIDRequestDto dto){
        Boolean isCustomerExistsWithNatID = individualCustomerRepository.existsByNatID(dto.getNatID());
        IsCustomerExistsWithNatIDResponseDto isCustomerExistsWithNatIDResponseDto = new IsCustomerExistsWithNatIDResponseDto();
        isCustomerExistsWithNatIDResponseDto.setIsExists(isCustomerExistsWithNatID);

        return isCustomerExistsWithNatIDResponseDto;
    }

    private SearchIndividualCustomerResponseDto convertToDto(IndividualCustomer customer) {

        Optional<ContactMedium> contactMedium = contactMediumService.findByCustomerId(customer.getId());

        SearchIndividualCustomerResponseDto responseDto = new SearchIndividualCustomerResponseDto();

        responseDto.setNatID(customer.getNatID());
        responseDto.setCustomerId(customer.getId());
        responseDto.setFirstName(customer.getFirstName());
        responseDto.setLastName(customer.getLastName());

        if (contactMedium.isPresent()) {
            if (contactMedium.get().getMobilePhone() != null) {
                responseDto.setPhoneNo(contactMedium.get().getHomePhone());
            } else {
                responseDto.setPhoneNo(null);
            }
            if (contactMedium.get().getEmail() != null) {
                responseDto.setEmail(contactMedium.get().getEmail());
            } else {
                responseDto.setEmail(null);
            }
        } else {
            responseDto.setPhoneNo(null);
            responseDto.setEmail(null);
        }

        responseDto.setCreatedDate(customer.getCreatedDate());
        responseDto.setIsActive(customer.getDeletedDate() == null ? true : false);
        return responseDto;
    }



}
