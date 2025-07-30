package com.prueba.notificacion.notificacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.notificacion.notificacion.model.Canal;
import com.prueba.notificacion.notificacion.repository.CanalRepository;

@Service
public class CanalService {
    private final CanalRepository canalRepository;

    public CanalService(CanalRepository canalRepository) {
        this.canalRepository = canalRepository;
    }

    public List<Canal> obtenerActivos() {
        return canalRepository.findAll().stream().filter(Canal::isActivo).toList();
    }

    public boolean estaActivo(String canal) {
        return canalRepository.findById(canal).map(Canal::isActivo).orElse(false);
    }
}
