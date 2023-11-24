package com.example.Ciclo_com.repositories;

import com.example.Ciclo_com.models.AvEventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvEventRepository extends JpaRepository<AvEventModel, UUID> {
}
