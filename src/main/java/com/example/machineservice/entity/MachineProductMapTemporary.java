package com.example.machineservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "tbl_machine_product_map_temporary")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MachineProductMapTemporary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference
    private Product product;

    @Column(name = "remain")
    private Integer remain;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "slot_no")
    private Integer slotNo;

    @Column(name = "price")
    private Double price;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    @JoinColumn
    @JsonBackReference
    private Machine machine;

    @OneToOne(optional = true,fetch = FetchType.LAZY,orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "id")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private MachineProductMap machineProductMap;
}
