package com.example.Ciclo_com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UserRecordDto(@NotBlank String name, @NotBlank String localizacao,
                            @NotNull BigDecimal nivel_habilidade, @NotBlank String senha, @NotBlank String email) {
}
