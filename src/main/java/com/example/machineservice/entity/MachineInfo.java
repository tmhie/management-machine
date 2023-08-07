package com.example.machineservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_machine_info")
public class MachineInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "cash_in_machine")
    private double cashInMachine;

    @Column(name = "last_update_time")
    private long lastUpdateTime;

    @OneToMany(mappedBy = "machineInfo",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Machine> machines;

}
