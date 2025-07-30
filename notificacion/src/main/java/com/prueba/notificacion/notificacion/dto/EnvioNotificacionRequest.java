package com.prueba.notificacion.notificacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvioNotificacionRequest {
    private String canal;
    private String destino;
    private String mensaje;
}
