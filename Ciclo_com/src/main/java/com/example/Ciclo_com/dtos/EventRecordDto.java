package com.example.Ciclo_com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventRecordDto(@NotBlank String name, @NotBlank String data_hora,
                             @NotNull BigDecimal dificuldade, @NotBlank String descricao,
                             @NotBlank String encontro) {
}