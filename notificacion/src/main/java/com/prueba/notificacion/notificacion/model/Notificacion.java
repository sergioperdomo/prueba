package com.prueba.notificacion.notificacion.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String canal;
    private String destino;
    private String mensaje;
    private String estado;
    private LocalDate fechaEnvio = LocalDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();

    public Notificacion(String canal, String destino, String mensaje, String estado) {
        this.canal = canal;
        this.destino = destino;
        this.mensaje = mensaje;
        this.estado = estado;
    }

}
