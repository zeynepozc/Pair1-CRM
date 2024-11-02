package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.mapper.ContactMediumMapper;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import com.etiya.customerservice.service.dto.request.contactMedium.CreateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.IsContactMediumExistsWithEmailRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.IsContactMediumExistsWithMobilePhoneRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.UpdateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.response.contactMedium.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private final ContactMediumRepository contactMediumRepository;
    private final ContactMediumMapper contactMediumMapper;


    @Override
    public List<ListContactMediumResponseDto> getAll() {
        List<ContactMedium> contactMediumList = contactMediumRepository.findAll();
        return contactMediumMapper.listContactMediumResponseDtoListFromContactMediumList(contactMediumList);
    }

    @Override
    public GetByIdContactMediumResponseDto getById(Long id) {
        Optional<ContactMedium> contactMedium = contactMediumRepository.findById(id);
        return contactMediumMapper.getByIdContactMediumResponseDtoFromContactMedium(contactMedium.get());
    }

    @Override
    public CreateContactMediumResponseDto add(CreateContactMediumRequestDto createContactMediumRequestDto) {
        // todo check if the given city exists
        ContactMedium contactMedium = contactMediumMapper.contactMediumFromCreateContactMediumRequestDto(createContactMediumRequestDto);
        return contactMediumMapper.createContactMediumResponseDtoFromContactMedium(contactMediumRepository.save(contactMedium));
    }

    @Override
    public UpdateContactMediumResponseDto update(UpdateContactMediumRequestDto updateContactMediumRequestDto) {
        // todo check if the given city exists
        ContactMedium contactMedium = contactMediumMapper.contactMediumFromUpdateContactMediumRequestDto(updateContactMediumRequestDto);
        contactMedium = contactMediumRepository.save(contactMedium);
        return contactMediumMapper.updateContactMediumResponseDtoFromContactMedium(contactMedium);
    }

    @Override
    public void delete(Long id) {
        contactMediumRepository.deleteById(id);
    }

    @Override
    public Optional<ContactMedium> findByCustomerId(Long id){
       return contactMediumRepository.findByCustomerId(id);
    }

    @Override
    public IsContactMediumExistsWithEmailResponseDto isContactMediumExistsWithEmail(IsContactMediumExistsWithEmailRequestDto dto) {
        return new IsContactMediumExistsWithEmailResponseDto(contactMediumRepository.existsByEmail(dto.getEmail()));
    }

    @Override
    public IsContactMediumExistsWithMobilePhoneResponseDto isContactMediumExistsWithMobilePhone(IsContactMediumExistsWithMobilePhoneRequestDto dto) {
        boolean isExists = contactMediumRepository.existsByMobilePhone(dto.getMobilePhone());
        IsContactMediumExistsWithMobilePhoneResponseDto responseDto =new IsContactMediumExistsWithMobilePhoneResponseDto();
        responseDto.setExists(isExists);
        return responseDto;
    }


}
