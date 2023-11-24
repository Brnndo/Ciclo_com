package com.example.Ciclo_com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RouteRecordDto(@NotBlank String name, @NotBlank String distancia,
                             @NotNull BigDecimal dificuldade, @NotBlank String descricao) {
}