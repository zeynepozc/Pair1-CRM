package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.service.dto.request.contactMedium.CreateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.request.contactMedium.UpdateContactMediumRequestDto;
import com.etiya.customerservice.service.dto.response.contactMedium.CreateContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.GetByIdContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.ListContactMediumResponseDto;
import com.etiya.customerservice.service.dto.response.contactMedium.UpdateContactMediumResponseDto;

import java.util.List;

public interface ContactMediumService {
    List<ListContactMediumResponseDto> getAll();
    GetByIdContactMediumResponseDto getById(Long id);
    CreateContactMediumResponseDto add(CreateContactMediumRequestDto dto);
    UpdateContactMediumResponseDto update(UpdateContactMediumRequestDto dto);
    void delete(Long id);
}
