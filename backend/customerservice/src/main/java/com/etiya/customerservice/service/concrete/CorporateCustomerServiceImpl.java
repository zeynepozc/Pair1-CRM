package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.mapper.CorporateCustomerMapper;
import com.etiya.customerservice.repository.CorporateCustomerRepository;
import com.etiya.customerservice.service.abstracts.CorporateCustomerService;
import com.etiya.customerservice.service.dto.request.corporateCustomer.CreateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.request.corporateCustomer.UpdateCorporateCustomerRequestDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.CreateCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.GetByIdCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.ListCorporateCustomerResponseDto;
import com.etiya.customerservice.service.dto.response.corporateCustomer.UpdateCorporateCustomerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final CorporateCustomerMapper corporateCustomerMapper;


    @Override
    public List<ListCorporateCustomerResponseDto> getAll() {
        List<CorporateCustomer> corporateCustomerList = corporateCustomerRepository.findAll();
        return corporateCustomerMapper.listCorporateCustomerResponseDtoListFromCorporateCustomerList(corporateCustomerList);
    }

    @Override
    public GetByIdCorporateCustomerResponseDto getById(Long id) {
        Optional<CorporateCustomer> corporateCustomer = corporateCustomerRepository.findById(id);
        return corporateCustomerMapper.getByIdCorporateCustomerResponseDtoFromCorporateCustomer(corporateCustomer.get());
    }

    @Override
    public CreateCorporateCustomerResponseDto add(CreateCorporateCustomerRequestDto createCorporateCustomerRequestDto) {
        // todo check if the given city exists
        CorporateCustomer corporateCustomer = corporateCustomerMapper.corporateCustomerFromCreateCorporateCustomerRequestDto(createCorporateCustomerRequestDto);
        return corporateCustomerMapper.createCorporateCustomerResponseDtoFromCorporateCustomer(corporateCustomerRepository.save(corporateCustomer));
    }

    @Override
    public UpdateCorporateCustomerResponseDto update(UpdateCorporateCustomerRequestDto updateCorporateCustomerRequestDto) {
        // todo check if the given city exists
        CorporateCustomer corporateCustomer = corporateCustomerMapper.corporateCustomerFromUpdateCorporateCustomerRequestDto(updateCorporateCustomerRequestDto);
        corporateCustomer = corporateCustomerRepository.save(corporateCustomer);
        return corporateCustomerMapper.updateCorporateCustomerResponseDtoFromCorporateCustomer(corporateCustomer);
    }

    @Override
    public void delete(Long id) {
        corporateCustomerRepository.deleteById(id);
    }
}
