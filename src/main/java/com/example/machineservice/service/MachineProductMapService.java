package com.example.machineservice.service;

import com.example.machineservice.entity.Machine;
import com.example.machineservice.entity.MachineProductMap;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MachineProductMapService {
    public Set<MachineProductMap> initializeNewProductMap(Machine machine){
        return IntStream.range(0,60).mapToObj(m-> MachineProductMap.builder()
                .remain(0)
                .capacity(5)
                .slotNo(m+1)
                .price(0.0d)
                .active(false)
                .machine(machine)
                .build())
          .collect(Collectors.toSet());
    }
}
