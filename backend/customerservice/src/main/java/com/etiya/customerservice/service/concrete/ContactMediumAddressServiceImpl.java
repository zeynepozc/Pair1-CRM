package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.ContactMediumAddress;
import com.etiya.customerservice.mapper.ContactMediumAddressMapper;
import com.etiya.customerservice.repository.ContactMediumAddressRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumAddressService;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.CreateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.UpdateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.CreateContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.GetByIdContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.ListContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.UpdateContactMediumAddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactMediumAddressServiceImpl implements ContactMediumAddressService
{
    private final ContactMediumAddressRepository contactMediumAddressRepository;
    private final ContactMediumAddressMapper contactMediumAddressMapper;


    @Override
    public List<ListContactMediumAddressResponseDto> getAll() {
        List<ContactMediumAddress> contactMediumAddressList = contactMediumAddressRepository.findAll();
        return contactMediumAddressMapper.listContactMediumAddressResponseDtoListFromContactMediumAddressList(contactMediumAddressList);
    }

    @Override
    public GetByIdContactMediumAddressResponseDto getById(Long id) {
        Optional<ContactMediumAddress> contactMediumAddress = contactMediumAddressRepository.findById(id);
        return contactMediumAddressMapper.getByIdContactMediumAddressResponseDtoFromContactMediumAddress(contactMediumAddress.get());
    }

    @Override
    public CreateContactMediumAddressResponseDto add(CreateContactMediumAddressRequestDto createContactMediumAddressRequestDto) {
        // todo check if the given country exists
        ContactMediumAddress contactMediumAddress = contactMediumAddressMapper.contactMediumAddressFromCreateContactMediumAddressRequestDto(createContactMediumAddressRequestDto);
        return contactMediumAddressMapper.createContactMediumAddressResponseDtoFromContactMediumAddress(contactMediumAddressRepository.save(contactMediumAddress));
    }

    @Override
    public UpdateContactMediumAddressResponseDto update(UpdateContactMediumAddressRequestDto updateContactMediumAddressRequestDto) {
        // todo check if the given country exists
        ContactMediumAddress contactMediumAddress = contactMediumAddressMapper.contactMediumAddressFromUpdateContactMediumAddressRequestDto(updateContactMediumAddressRequestDto);
        contactMediumAddress = contactMediumAddressRepository.save(contactMediumAddress);
        return contactMediumAddressMapper.updateContactMediumAddressResponseDtoFromContactMediumAddress(contactMediumAddress);
    }

    @Override
    public void delete(Long id) {
        contactMediumAddressRepository.deleteById(id);
    }
}