package com.example.Ciclo_com.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_Inscricao")
public class EnrollmentModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID idEnrollment;

    @ManyToOne
    @JoinColumn(name = "idEvent")

    private EventModel idEvent;

    @OneToOne
    @JoinColumn(name = "idUser")

    private UserModel idUser;

    public UUID getIdEnrollment() {
        return idEnrollment;
    }

    public void setIdEnrollment(UUID idEnrollment) {
        this.idEnrollment = idEnrollment;
    }

    public EventModel getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(EventModel idEvent) {
        this.idEvent = idEvent;
    }

    public UserModel getIdUser() {
        return idUser;
    }

    public void setIdUser(UserModel idUser) {
        this.idUser = idUser;
    }
}

