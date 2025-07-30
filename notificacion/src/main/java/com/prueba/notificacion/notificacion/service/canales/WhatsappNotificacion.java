package com.prueba.notificacion.notificacion.service.canales;

import org.springframework.stereotype.Component;

import com.prueba.notificacion.notificacion.dto.EnvioNotificacionRequest;
import com.prueba.notificacion.notificacion.exception.ValidacionException;
import com.prueba.notificacion.notificacion.model.Notificacion;
import com.prueba.notificacion.notificacion.util.Validador;

@Component
public class WhatsappNotificacion implements CanalNotificacion {
    public String getTipo() {
        return "WHATSAPP";
    }

    public Notificacion enviar(EnvioNotificacionRequest request) {
        if (!Validador.numeroColombianoValido(request.getDestino()) || request.getMensaje().isEmpty()) {
            throw new ValidacionException("Número inválido o mensaje vacío.");
        }
        
        return new Notificacion(getTipo(), request.getDestino(), request.getMensaje(), "ENVIADO");
    }
}
