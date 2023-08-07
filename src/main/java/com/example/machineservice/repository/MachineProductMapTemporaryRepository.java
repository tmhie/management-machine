package com.example.machineservice.repository;

import com.example.machineservice.entity.MachineProductMapTemporary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineProductMapTemporaryRepository extends JpaRepository<MachineProductMapTemporary,Long> {
}
