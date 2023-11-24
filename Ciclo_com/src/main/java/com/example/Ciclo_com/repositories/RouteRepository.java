package com.example.Ciclo_com.repositories;

import com.example.Ciclo_com.models.RouteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<RouteModel, UUID> {
}
