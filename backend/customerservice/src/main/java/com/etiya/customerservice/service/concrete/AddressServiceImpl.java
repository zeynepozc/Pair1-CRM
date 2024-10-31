package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.service.abstracts.*;
import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    public final CityService cityService;
    public final DistrictService districtService;
    public final NeighborhoodService neighborhoodService;
    public final ContactAddressService contactAddressService;
    private final ContactMediumService contactMediumService;

    @Override
    public CreateAddressResponseDto addAddress(CreateAddressRequestDto dto){
        Optional<ContactMedium> contactMedium = contactMediumService.findByCustomerId(dto.getCustomerId());

        // City city = cityService.add(new City(dto.getCity(), ));
        return null;
    }

}
