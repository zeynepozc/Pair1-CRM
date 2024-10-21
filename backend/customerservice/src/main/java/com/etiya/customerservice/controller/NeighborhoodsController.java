package com.etiya.customerservice.controller;

import com.etiya.customerservice.service.abstracts.NeighborhoodService;
import com.etiya.customerservice.service.dto.request.neighborhood.CreateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.request.neighborhood.UpdateNeighborhoodRequestDto;
import com.etiya.customerservice.service.dto.response.neighborhood.CreateNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.GetByIdNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.ListNeighborhoodResponseDto;
import com.etiya.customerservice.service.dto.response.neighborhood.UpdateNeighborhoodResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/neighborhoods")
@RequiredArgsConstructor
public class NeighborhoodsController {
    private final NeighborhoodService neighborhoodService;

    @GetMapping
    public List<ListNeighborhoodResponseDto> getAll(){
        return neighborhoodService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdNeighborhoodResponseDto> getById(@PathVariable Long id){
        GetByIdNeighborhoodResponseDto neighborhoodResponseDto = neighborhoodService.getById(id);

        if (neighborhoodResponseDto != null) {
            return ResponseEntity.ok(neighborhoodResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateNeighborhoodResponseDto> add(@RequestBody CreateNeighborhoodRequestDto neighborhood){
        CreateNeighborhoodResponseDto _neighborhood = neighborhoodService.add(neighborhood);

        if (_neighborhood != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_neighborhood);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdNeighborhoodResponseDto country = neighborhoodService.getById(id);

        if (country != null) {
            neighborhoodService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<UpdateNeighborhoodResponseDto> update(@RequestBody @Valid UpdateNeighborhoodRequestDto neighborhood){
        GetByIdNeighborhoodResponseDto neighborhoodDto = neighborhoodService.getById(neighborhood.getId());

        if (neighborhoodDto != null) {
            UpdateNeighborhoodResponseDto neighborhoodResponseDto = neighborhoodService.update(neighborhood);
            return ResponseEntity.ok(neighborhoodResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
