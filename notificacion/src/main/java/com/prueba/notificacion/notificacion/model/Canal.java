package com.prueba.notificacion.notificacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Canal {

    @Id
    private String nombre;
    private boolean activo;

    public Canal(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

}
