package com.prueba.notificacion.notificacion.service.canales;

import org.springframework.stereotype.Component;

import com.prueba.notificacion.notificacion.dto.EnvioNotificacionRequest;
import com.prueba.notificacion.notificacion.exception.ValidacionException;
import com.prueba.notificacion.notificacion.model.Notificacion;
import com.prueba.notificacion.notificacion.util.Validador;

@Component
public class SmsNotificacion implements CanalNotificacion {

    public String getTipo() {
        return "SMS";
    }

    public Notificacion enviar(EnvioNotificacionRequest request) {
        if (!Validador.numeroColombianoValido(request.getDestino()) || request.getMensaje().length() > 160) {
            throw new ValidacionException("Número no válido o mensaje supera los 160 caracteres.");
        }
        return new Notificacion(getTipo(), request.getDestino(), request.getMensaje(), "ENVIADO");
    }

}
