package com.example.machineservice.controller;

import com.example.machineservice.model.MachineDTO;
import com.example.machineservice.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/api/machine")
@RequiredArgsConstructor
public class MachineController {
    public final MachineService machineService;

    @PostMapping
    public MachineDTO create(MachineDTO machineDTO){
        return this.machineService.create(machineDTO);
    }
}
