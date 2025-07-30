package com.prueba.notificacion.notificacion.service.canales;

import com.prueba.notificacion.notificacion.dto.EnvioNotificacionRequest;
import com.prueba.notificacion.notificacion.model.Notificacion;

public interface CanalNotificacion {
    String getTipo();

    Notificacion enviar(EnvioNotificacionRequest request);

}