package com.prueba.notificacion.notificacion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.notificacion.notificacion.dto.EnvioNotificacionRequest;
import com.prueba.notificacion.notificacion.model.Canal;
import com.prueba.notificacion.notificacion.model.Notificacion;
import com.prueba.notificacion.notificacion.service.CanalService;
import com.prueba.notificacion.notificacion.service.NotificacionService;

@RestController
@RequestMapping("/api")
public class NotificacionController {

    private final NotificacionService notificacionService;
    private final CanalService canalService;

    public NotificacionController(NotificacionService notificacionService, CanalService canalService) {
        this.notificacionService = notificacionService;
        this.canalService = canalService;
    }

    @GetMapping("/canales")
    public List<Canal> obtenerCanalesActivos() {
        return canalService.obtenerActivos();
    }

    @PostMapping("/enviarNotificacion")
    public Notificacion enviarNotificacion(@RequestBody EnvioNotificacionRequest request) {
        return notificacionService.enviar(request);
    }

    @GetMapping("/reporteEnvios")
    public List<Notificacion> obtenerReporteEnvios() {
        return notificacionService.obtenerHistorial();
    }
}
