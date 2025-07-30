package com.prueba.notificacion.notificacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.notificacion.notificacion.model.Canal;

public interface CanalRepository extends JpaRepository<Canal, String> {
}
