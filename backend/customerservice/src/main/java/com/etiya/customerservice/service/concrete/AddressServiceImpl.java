package com.etiya.customerservice.service.concrete;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.ContactMediumAddress;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.service.abstracts.*;
import com.etiya.customerservice.service.dto.request.address.CreateAddressRequestDto;
import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.contactAddress.CreateContactAddressRequestDto;
import com.etiya.customerservice.service.dto.request.contactMediumAddress.CreateContactMediumAddressRequestDto;
import com.etiya.customerservice.service.dto.request.district.CreateDistrictRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.address.CreateAddressResponseDto;
import com.etiya.customerservice.service.dto.response.address.GetByIdAddressResponseDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.GetByIdCityResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.CreateContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactAddress.GetByIdContactAddressResponseDto;
import com.etiya.customerservice.service.dto.response.contactMediumAddress.CreateContactMediumAddressResponseDto;
import com.etiya.customerservice.service.dto.response.district.CreateDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.district.GetByIdDistrictResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.CreateNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.GetByIdNeighborhoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    public final CityService cityService;
    public final DistrictService districtService;
    public final NeighborhoodService neighborhoodService;
    public final ContactAddressService contactAddressService;
    private final ContactMediumService contactMediumService;
    private final ContactMediumAddressService contactMediumAddressService;

    @Override
    public CreateAddressResponseDto add(CreateAddressRequestDto dto){
        CreateAddressResponseDto createAddressResponseDto = new CreateAddressResponseDto();

        Optional<ContactMedium> contactMedium = contactMediumService.findByCustomerId(dto.getCustomerId());
        boolean isContactMediumPresent = contactMedium.isPresent();

        if (isContactMediumPresent){
            createAddressResponseDto.setCustomerId(dto.getCustomerId());
        }
        
        CreateCityRequestDto createCityRequestDto = new CreateCityRequestDto(dto.getCity(), (short) 1);
        CreateCityResponseDto createCityResponseDto = cityService.add(createCityRequestDto);
        createAddressResponseDto.setCity(createCityResponseDto.getName());

        CreateDistrictRequestDto createDistrictRequestDto = new CreateDistrictRequestDto(dto.getDistrict(),createCityResponseDto.getId());
        CreateDistrictResponseDto createDistrictResponseDto = districtService.add(createDistrictRequestDto);
        createAddressResponseDto.setDistrict(createDistrictResponseDto.getName());

        CreateNeighborhoodRequestDto createNeighborhoodRequestDto = new CreateNeighborhoodRequestDto(dto.getNeighborhood(),dto.getPostalCode(),dto.getHouseNo(),createDistrictResponseDto.getId());
        CreateNeighborhoodResponseDto createNeighborhoodResponseDto = neighborhoodService.add(createNeighborhoodRequestDto);
        createAddressResponseDto.setNeighborhood(createNeighborhoodResponseDto.getName());

        CreateContactAddressRequestDto createContactAddressRequestDto = new CreateContactAddressRequestDto(dto.getName(),dto.getDescription(),createNeighborhoodResponseDto.getId());
        CreateContactAddressResponseDto createContactAddressResponseDto = contactAddressService.add(createContactAddressRequestDto);
        createAddressResponseDto.setDescription(createContactAddressResponseDto.getAddressDesc());

        createAddressResponseDto.setId(createContactAddressResponseDto.getId());
        createAddressResponseDto.setName(dto.getName());
        createAddressResponseDto.setPostalCode(dto.getPostalCode());
        createAddressResponseDto.setHouseNo(dto.getHouseNo());
        createAddressResponseDto.setPrimaryAddress(dto.getPrimaryAddress());

        if (isContactMediumPresent) {
            CreateContactMediumAddressRequestDto contactMediumAddressRequestDto = new CreateContactMediumAddressRequestDto(
                    contactMedium.get().getId(),
                    createContactAddressResponseDto.getId(),
                    dto.getPrimaryAddress()
            );
            contactMediumAddressService.add(contactMediumAddressRequestDto);
        }

        return createAddressResponseDto;
    }

    @Override
    public List<GetByIdAddressResponseDto> getById(Long id) {
        Optional<ContactMedium> contactMedium = contactMediumService.findByCustomerId(id);
        List<ContactMediumAddress> contactMediumAddressList = contactMediumAddressService.getAllByContactMediumId( contactMedium.get().getId() );
        List<GetByIdAddressResponseDto> addressResponseDtoList = new ArrayList<>();

        for( ContactMediumAddress contactMediumAddress: contactMediumAddressList ) {
            GetByIdAddressResponseDto dto = new GetByIdAddressResponseDto();
            dto.setId(contactMediumAddress.getId());
            dto.setCustomerId(id);
            dto.setName(contactMediumAddress.getContactAddress().getName());
            dto.setDescription(contactMediumAddress.getContactAddress().getAddressDesc());
            dto.setNeighborhood(contactMediumAddress.getContactAddress().getNeighborhood().getName());
            dto.setPostalCode(contactMediumAddress.getContactAddress().getNeighborhood().getPostalCode());
            dto.setHouseNo(contactMediumAddress.getContactAddress().getNeighborhood().getHouseNo());
            dto.setDistrict(contactMediumAddress.getContactAddress().getNeighborhood().getDistrict().getName());
            dto.setCity(contactMediumAddress.getContactAddress().getNeighborhood().getDistrict().getCity().getName());
            dto.setPrimaryAddress(contactMediumAddress.getPrimaryAddress());

            addressResponseDtoList.add(dto);
        }

        return addressResponseDtoList;

    }


}
