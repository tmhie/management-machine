package com.example.machineservice.service;

import com.example.machineservice.entity.Product;
import com.example.machineservice.entity.ProductGroup;
import com.example.machineservice.model.ProductDTO;
import com.example.machineservice.model.ProductGroupDTO;
import com.example.machineservice.repository.ProductGroupRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductGroupService {
    private final ProductGroupRepository productGroupRepository;
    private final ModelMapper modelMapper;

    public ProductGroupDTO create(ProductGroupDTO productGroupDTO){
        ProductGroup productGroup = modelMapper.map(productGroupDTO,ProductGroup.class);
        productGroupRepository.save(productGroup);
        return modelMapper.map(productGroup, ProductGroupDTO.class);
    }

    public List<ProductGroupDTO> findAll(){
        return productGroupRepository.findAll()
                .stream()
                .map(map->modelMapper.map(map,ProductGroupDTO.class))
                .collect(Collectors.toList());
    }

    public void update(ProductGroupDTO productGroupDTO){
        ProductGroup productGroup = productGroupRepository.findById(productGroupDTO.getId()).get();
        productGroup.setName(productGroupDTO.getName());
        productGroupRepository.save(productGroup);
    }
}
