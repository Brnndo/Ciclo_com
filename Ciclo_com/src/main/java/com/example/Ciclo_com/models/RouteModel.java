package com.example.Ciclo_com.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_Rotas")
public class RouteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID idRoute;
    private String name;
    private String distancia;
    private BigDecimal dificuldade;
    private String descricao;

    public UUID getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(UUID idRoute) {
        this.idRoute = idRoute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public BigDecimal getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(BigDecimal dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
