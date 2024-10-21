package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.ContactAddress;
import com.etiya.customerservice.mapper.ContactAddressMapper;
import com.etiya.customerservice.repository.ContactAddressRepository;
import com.etiya.customerservice.service.abstracts.ContactAddressService;
import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.UpdateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.GetByIdContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.ListContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.UpdateContactAddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactAddressServiceImpl implements ContactAddressService {
    private final ContactAddressRepository contactAddressRepository;
    private final ContactAddressMapper contactAddressMapper;


    @Override
    public List<ListContactAddressResponseDto> getAll() {
        List<ContactAddress> contactAddressList = contactAddressRepository.findAll();
        return contactAddressMapper.listContactAddressResponseDtoListFromContactAddressList(contactAddressList);
    }

    @Override
    public GetByIdContactAddressResponseDto getById(Long id) {
        Optional<ContactAddress> contactAddress = contactAddressRepository.findById(id);
        return contactAddressMapper.getByIdContactAddressResponseDtoFromContactAddress(contactAddress.get());
    }

    @Override
    public CreateContactAddressResponseDto add(CreateContactAddressRequestDto createContactAddressRequestDto) {
        // todo check if the given city exists
        ContactAddress contactAddress = contactAddressMapper.contactAddressFromCreateContactAddressRequestDto(createContactAddressRequestDto);
        return contactAddressMapper.createContactAddressResponseDtoFromContactAddress(contactAddressRepository.save(contactAddress));
    }

    @Override
    public UpdateContactAddressResponseDto update(UpdateContactAddressRequestDto updateContactAddressRequestDto) {
        // todo check if the given city exists
        ContactAddress contactAddress = contactAddressMapper.contactAddressFromUpdateContactAddressRequestDto(updateContactAddressRequestDto);
        contactAddress = contactAddressRepository.save(contactAddress);
        return contactAddressMapper.updateContactAddressResponseDtoFromContactAddress(contactAddress);
    }

    @Override
    public void delete(Long id) {
        contactAddressRepository.deleteById(id);
    }
}
