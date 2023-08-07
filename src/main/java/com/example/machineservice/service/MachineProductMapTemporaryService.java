package com.example.machineservice.service;

import com.example.machineservice.entity.MachineProductMap;
import com.example.machineservice.entity.MachineProductMapTemporary;
import com.example.machineservice.repository.MachineProductMapRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MachineProductMapTemporaryService {
    private final MachineProductMapRepository machineProductMapRepository;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;

    public void syncMachineProductMap(Long machineId){
        log.info("begin sync ");
        List<MachineProductMap> machineProductMaps = machineProductMapRepository.findByMachineId(machineId);
        for (MachineProductMap mpm : machineProductMaps){
            log.info("id: " + mpm.getId());
            MachineProductMapTemporary machineProductMapTemporary = modelMapper.map(mpm,MachineProductMapTemporary.class);
            machineProductMapTemporary.setMachineProductMap(mpm);
            entityManager.persist(machineProductMapTemporary);
        }
    }
}
