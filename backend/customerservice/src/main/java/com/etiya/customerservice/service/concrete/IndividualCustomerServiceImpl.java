package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import com.etiya.customerservice.service.dto.request.individualCustomer.CreateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.individualCustomer.UpdateIndividualCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.CreateIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.GetByIdIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.ListIndividualCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.individualCustomer.UpdateIndividualCustomerResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
