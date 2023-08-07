package com.example.machineservice.service;

import com.example.machineservice.entity.Product;
import com.example.machineservice.model.ProductDTO;
import com.example.machineservice.repository.ProductGroupRepository;
import com.example.machineservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductGroupRepository productGroupRepository;
    private final ModelMapper modelMapper;

    public ProductDTO create(ProductDTO productDTO){
        Product product = new Product();
        modelMapper.map(productDTO,product);

        if (productDTO.getProductGroupId() != null){
            product.setProductGroup(productGroupRepository.findById(productDTO.getProductGroupId()).get());
        }

        product = productRepository.save(product);
        return modelMapper.map(product,ProductDTO.class);
    }

    public ProductDTO update(ProductDTO productDTO){
        Product product = productRepository.findById(productDTO.getId())
                .orElseThrow(EntityNotFoundException::new);

        modelMapper.map(productDTO,product);
        Optional.ofNullable(productDTO.getProductGroupId())
                .ifPresent(productGroupId -> product.setProductGroup(productGroupRepository.findById(productGroupId).get()));

        productRepository.save(product);
        return modelMapper.map(product,ProductDTO.class);
    }

    public void delete(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(EntityNotFoundException::new);
        productRepository.delete(product);
    }

    public List<ProductDTO> getListByIds(List<Long> ids){
        return productRepository.findAllById(ids)
                .stream()
                .map(p -> modelMapper.map(p,ProductDTO.class))
                .collect(Collectors.toList());
    }
}
