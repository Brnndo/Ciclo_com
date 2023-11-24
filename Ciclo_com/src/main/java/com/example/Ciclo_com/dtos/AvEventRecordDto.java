package com.example.Ciclo_com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AvEventRecordDto(@NotBlank String comentario, @NotBlank String avaliacao) {
}