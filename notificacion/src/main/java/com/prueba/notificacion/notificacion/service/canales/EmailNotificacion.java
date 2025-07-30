package com.prueba.notificacion.notificacion.service.canales;

import org.springframework.stereotype.Component;

import com.prueba.notificacion.notificacion.dto.EnvioNotificacionRequest;
import com.prueba.notificacion.notificacion.exception.ValidacionException;
import com.prueba.notificacion.notificacion.model.Notificacion;
import com.prueba.notificacion.notificacion.util.Validador;

@Component
public class EmailNotificacion implements CanalNotificacion {
    public String getTipo() {
        return "EMAIL";
    }

    public Notificacion enviar(EnvioNotificacionRequest request) {
        if (!Validador.emailValido(request.getDestino()) || request.getMensaje().length() > 500) {
            throw new ValidacionException("Email inválido o mensaje demasiado largo.");
        }
        return new Notificacion(getTipo(), request.getDestino(), request.getMensaje(), "ENVIADO");
    }
}
