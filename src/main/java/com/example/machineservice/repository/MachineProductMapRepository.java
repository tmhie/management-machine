package com.example.machineservice.repository;

import com.example.machineservice.entity.MachineProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineProductMapRepository extends JpaRepository<MachineProductMap,Long> {
    @Query("select mpm from MachineProductMap mpm where mpm.machine.id=?1")
    List<MachineProductMap> findByMachineId(Long machineId);
}
