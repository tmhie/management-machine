package com.example.machineservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_machine_product_map")
@Builder
public class MachineProductMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_id")
    @JsonBackReference
    private Machine machine;
}
