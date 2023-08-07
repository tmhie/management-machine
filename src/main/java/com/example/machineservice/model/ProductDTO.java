package com.example.machineservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String code;
    private String description;
    private String imageDetail;
    private Double standardPrice;
    private Byte type;
    private Boolean active;
    private Long productGroupId;

    private ProductGroupDTO productGroup;
}
