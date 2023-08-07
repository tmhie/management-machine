package com.example.machineservice.service;

import com.example.machineservice.entity.Machine;
import com.example.machineservice.model.MachineDTO;
import com.example.machineservice.repository.MachineProductMapRepository;
import com.example.machineservice.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MachineService {
    private final MachineProductMapRepository machineProductMapRepository;
    private final MachineRepository machineRepository;
    private final MachineProductMapTemporaryService machineProductMapTemporaryService;
    private final MachineProductMapService machineProductMapService;
    private final ModelMapper modelMapper;

    public MachineDTO create(MachineDTO machineDTO){
        Machine machine = modelMapper.map(machineDTO,Machine.class);
        machine.setMachineProductMaps(machineProductMapService.initializeNewProductMap(machine));
        machineProductMapTemporaryService.syncMachineProductMap(machine.getId());
        return modelMapper.map(machine,MachineDTO.class);
    }


}
