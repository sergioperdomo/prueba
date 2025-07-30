package com.prueba.notificacion.notificacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.notificacion.notificacion.dto.EnvioNotificacionRequest;
import com.prueba.notificacion.notificacion.exception.CanalInactivoException;
import com.prueba.notificacion.notificacion.exception.CanalNoSoportadoException;
import com.prueba.notificacion.notificacion.model.Notificacion;
import com.prueba.notificacion.notificacion.repository.NotificacionRepository;
import com.prueba.notificacion.notificacion.service.canales.CanalNotificacion;

@Service
public class NotificacionService {
    private final NotificacionRepository repo;
    private final CanalService canalService;
    private final List<CanalNotificacion> canales;

    public NotificacionService(NotificacionRepository repo, CanalService canalService,
            List<CanalNotificacion> canales) {
        this.repo = repo;
        this.canalService = canalService;
        this.canales = canales;
    }

    public Notificacion enviar(EnvioNotificacionRequest request) {
        if (!canalService.estaActivo(request.getCanal())) {
            throw new CanalInactivoException("El canal está inactivo.");
        }

        return canales.stream()
                .filter(c -> c.getTipo().equalsIgnoreCase(request.getCanal()))
                .findFirst()
                .map(canal -> {
                    Notificacion noti = canal.enviar(request);
                    return repo.save(noti);
                })
                .orElseThrow(() -> new CanalNoSoportadoException("Canal no soportado."));
    }

    public List<Notificacion> obtenerHistorial() {
        return repo.findAll();
    }
}
