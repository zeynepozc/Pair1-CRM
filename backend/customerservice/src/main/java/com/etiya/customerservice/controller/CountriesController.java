package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.CountryService;
import com.etiya.customerservice.service.dto.request.country.CreateCountryRequestDto;
import com.etiya.customerservice.service.dto.request.country.UpdateCountryRequestDto;
import com.etiya.customerservice.service.dto.response.country.CreateCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.GetByIdCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.ListCountryResponseDto;
import com.etiya.customerservice.service.dto.response.country.UpdateCountryResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountriesController {
    private final CountryService countryService;

    @GetMapping
    public List<ListCountryResponseDto> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCountryResponseDto> getById(@PathVariable Short id){
        GetByIdCountryResponseDto countryResponseDto = countryService.getById(id);

        if (countryResponseDto != null) {
            return ResponseEntity.ok(countryResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateCountryResponseDto> add(@RequestBody @Valid CreateCountryRequestDto country){
        CreateCountryResponseDto _country = countryService.add(country);

        if (_country != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_country);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Short id){
        GetByIdCountryResponseDto country = countryService.getById(id);

        if (country != null) {
            countryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateCountryResponseDto> update(@RequestBody @Valid UpdateCountryRequestDto country){
        GetByIdCountryResponseDto countryDto = countryService.getById(country.getId());

        if (countryDto != null) {
            UpdateCountryResponseDto countryResponseDto = countryService.update(country);
            return ResponseEntity.ok(countryResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
