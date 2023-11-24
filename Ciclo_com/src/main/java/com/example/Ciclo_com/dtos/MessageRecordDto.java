package com.example.Ciclo_com.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record MessageRecordDto(@NotBlank String remetente, @NotBlank String destinatario,
                             @NotBlank String conteudo_mensagem, @NotBlank String data_hora) {
}