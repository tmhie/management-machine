package com.example.machineservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "reference_name")
    private String referenceName;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private Byte type;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "ward")
    private String ward;

    @Column(name = "address")
    private String address;

    @Column(name = "identify_code")
    private String identifyCode;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MachineProductMap> machineProductMaps;

    @ManyToOne
    @JoinColumn(name = "machineInfo_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private MachineInfo machineInfo;
}
