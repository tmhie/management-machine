package com.example.machineservice.controller;

import com.example.machineservice.model.ProductGroupDTO;
import com.example.machineservice.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/api/productGroup")
@RequiredArgsConstructor
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    @PostMapping
    public ProductGroupDTO create(@RequestBody ProductGroupDTO productGroupDTO){
        return this.productGroupService.create(productGroupDTO);
    }

    @GetMapping
    public List<ProductGroupDTO> getAll(){
        return productGroupService.findAll();
    }

    @PutMapping
    public void update(@RequestBody ProductGroupDTO productGroupDTO){
        productGroupService.update(productGroupDTO);
    }
}
