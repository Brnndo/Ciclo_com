package com.example.Ciclo_com.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_Avaliacoes")
public class AvEventModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private UUID idAvEvent;
    private String Avaliacao;
    private String Comentario;


    public UUID getIdAvEvent() {
        return idAvEvent;
    }

    public void setIdAvEvent(UUID idAvEvent) {
        this.idAvEvent = idAvEvent;
    }

    public String getAvaliacao() {
        return Avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        Avaliacao = avaliacao;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }


}