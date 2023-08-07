package com.example.machineservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductGroupDTO {
    private Long id;

    private String name;
}
