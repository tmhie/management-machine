package com.example.machineservice.controller;

import com.example.machineservice.model.ProductDTO;
import com.example.machineservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO){
        return this.productService.create(productDTO);
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO productDTO){
        return this.productService.update(productDTO);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long productId){
        this.productService.delete(productId);
    }

    @GetMapping
    public List<ProductDTO> getListByIds(@RequestBody List<Long> ids){
        return productService.getListByIds(ids);
    }
}
