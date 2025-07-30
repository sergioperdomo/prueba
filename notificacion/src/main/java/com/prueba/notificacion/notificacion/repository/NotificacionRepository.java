package com.prueba.notificacion.notificacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.notificacion.notificacion.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
