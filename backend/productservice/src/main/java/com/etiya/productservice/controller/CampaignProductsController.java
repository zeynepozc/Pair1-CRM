package com.etiya.productservice.controller;

import com.etiya.productservice.service.abstracts.CampaignProductService;
import com.etiya.productservice.service.abstracts.CampaignProductService;
import com.etiya.productservice.service.dto.request.campaignProduct.CreateCampaignProductRequestDto;
import com.etiya.productservice.service.dto.request.campaignProduct.UpdateCampaignProductRequestDto;
import com.etiya.productservice.service.dto.request.campaignProduct.CreateCampaignProductRequestDto;
import com.etiya.productservice.service.dto.request.campaignProduct.UpdateCampaignProductRequestDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.CreateCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.GetByIdCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.ListCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.UpdateCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.CreateCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.GetByIdCampaignProductResponseDto;
import com.etiya.productservice.service.dto.responses.campaignProduct.UpdateCampaignProductResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/campaignProducts")
@RequiredArgsConstructor
public class CampaignProductsController {
    private final CampaignProductService campaignProductService;

    @GetMapping
    public List<ListCampaignProductResponseDto> getAll(){
        return campaignProductService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCampaignProductResponseDto> getById(@PathVariable Long id){
        GetByIdCampaignProductResponseDto campaignProduct = campaignProductService.getById(id);

        if (campaignProduct != null) {
            return ResponseEntity.ok(campaignProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CreateCampaignProductResponseDto> add(@RequestBody @Valid CreateCampaignProductRequestDto createCampaignProductRequestDto){
        CreateCampaignProductResponseDto createCampaignProductResponseDto = campaignProductService.add(createCampaignProductRequestDto);

        if (createCampaignProductResponseDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createCampaignProductResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        GetByIdCampaignProductResponseDto campaignProduct = campaignProductService.getById(id);

        if (campaignProduct != null) {
            campaignProductService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCampaignProductResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateCampaignProductRequestDto updateCampaignProductRequestDto){
        UpdateCampaignProductResponseDto campaignProduct = campaignProductService.update(id, updateCampaignProductRequestDto);

        if (campaignProduct != null) {
            return ResponseEntity.ok(campaignProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
