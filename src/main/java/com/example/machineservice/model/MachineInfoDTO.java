package com.example.machineservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class MachineInfoDTO {
    private Long id;
    private double temperature;
    private double cashInMachine;
    private long lastUpdateTime;
    private String machineId;
}
