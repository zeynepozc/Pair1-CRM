package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.service.dto.request.contactMedium.CreateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.IsContactMediumExistsWithEmailRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.IsContactMediumExistsWithMobilePhoneRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.UpdateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.response.contactMedium.*;

import java.util.List;
import java.util.Optional;

public interface ContactMediumService {
    List<ListContactMediumResponseDto> getAll();
    GetByIdContactMediumResponseDto getById(Long id);
    CreateContactMediumResponseDto add(CreateContactMediumRequestDto dto);
    UpdateContactMediumResponseDto update(UpdateContactMediumRequestDto dto);
    void delete(Long id);

    Optional<ContactMedium> findByCustomerId(Long id);

    IsContactMediumExistsWithEmailResponseDto isContactMediumExistsWithEmail(IsContactMediumExistsWithEmailRequestDto dto);
    IsContactMediumExistsWithMobilePhoneResponseDto isContactMediumExistsWithMobilePhone(IsContactMediumExistsWithMobilePhoneRequestDto dto);

}
