package com.example.machineservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MachineDTO {
    private Long id;
    private String referenceName;
    private String serialNumber;
    private String description;
    private Byte type;
    private String province;
    private String district;
    private String ward;
    private String address;
    private String identifyCode;
    private Boolean active;
    private List<MachineProductMapDTO> machineProductMaps;
}
