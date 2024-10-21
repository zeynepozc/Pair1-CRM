package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.CityService;
import com.etiya.customerservice.service.dto.request.city.CreateCityRequestDto;
import com.etiya.customerservice.service.dto.request.city.UpdateCityRequestDto;
import com.etiya.customerservice.service.dto.response.city.CreateCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.GetByIdCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.ListCityResponseDto;
import com.etiya.customerservice.service.dto.response.city.UpdateCityResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CitysController {
    private final CityService cityService;

    @GetMapping
    public List<ListCityResponseDto> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCityResponseDto> getById(@PathVariable Long id){
        GetByIdCityResponseDto cityResponseDto = cityService.getById(id);

        if (cityResponseDto != null) {
            return ResponseEntity.ok(cityResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateCityResponseDto> add(@RequestBody @Valid CreateCityRequestDto city){
        CreateCityResponseDto _city = cityService.add(city);

        if (_city != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_city);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdCityResponseDto country = cityService.getById(id);

        if (country != null) {
            cityService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateCityResponseDto> update(@RequestBody @Valid UpdateCityRequestDto city){
        GetByIdCityResponseDto cityDto = cityService.getById(city.getId());

        if (cityDto != null) {
            UpdateCityResponseDto cityResponseDto = cityService.update(city);
            return ResponseEntity.ok(cityResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
