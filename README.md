# 📬 Microservicio de Notificaciones

Este microservicio RESTful permite enviar notificaciones por diferentes canales: **EMAIL**, **SMS** y **WHATSAPP**.  
Está desarrollado con **Java 17** y **Spring Boot 3.4.8**, aplicando buenas prácticas de arquitectura limpia, principios SOLID y patrón Strategy.

---

## 🚀 Características principales

- Envío de notificaciones por múltiples canales
- Validaciones específicas por tipo de canal
- Persistencia de historial de notificaciones
- Endpoints REST documentados con Swagger
- Arquitectura modular con alta cohesión y bajo acoplamiento

---

## 📂 Estructura del proyecto

```
com.example.notificacion
├── controller           # Endpoints REST
├── dto                  # Request DTOs
├── exception            # Excepciones personalizadas
├── model                # Entidades JPA (Canal, Notificacion)
├── repository           # Interfaces JpaRepository
├── service              # Lógica de negocio
│   └── canales          # Clases que implementan lógica por canal (Strategy)
├── util                 # Validadores reutilizables
└── config               # Configuración adicional (Swagger, Carga inicial, etc.)
```

---

## ✅ Endpoints REST

| Método | Endpoint                   | Descripción                                        |
|--------|----------------------------|----------------------------------------------------|
| GET    | `/api/canales`             | Lista los canales activos disponibles              |
| POST   | `/api/enviarNotificacion`  | Envía una notificación por el canal especificado   |
| GET    | `/api/reporteEnvios`       | Muestra el historial de notificaciones enviadas    |

---

## 🧠 Lógica de validación por canal

- **EMAIL**:  
  - El correo debe ser válido (`@` y dominio `.com`)
  - Mensaje máximo: 500 caracteres

- **SMS**:  
  - Número debe iniciar con `+57`
  - Mensaje máximo: 160 caracteres

- **WHATSAPP**:  
  - Número válido colombiano (`+57`)
  - Mensaje no puede estar vacío
  - Simula validación por token

---

## 🧪 Ejemplos de peticiones POST

### Enviar notificación por EMAIL

```json
{
  "canal": "EMAIL",
  "destino": "usuario@gmail.com",
  "mensaje": "Hola, este es un correo de prueba"
}
```

### Enviar notificación por SMS

```json
{
  "canal": "SMS",
  "destino": "+573001112233",
  "mensaje": "Mensaje corto para SMS"
}
```

### Enviar notificación por WHATSAPP

```json
{
  "canal": "WHATSAPP",
  "destino": "+573223334455",
  "mensaje": "Hola, este es un mensaje por WhatsApp"
}
```

---

## 🧪 Cómo ejecutar el proyecto

1. Clona el repositorio
2. Asegúrate de tener **Java 17** y **Maven**
3. Ejecuta:

   ```bash
   mvn spring-boot:run
   ```

4. Accede a:
   - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
   - Consola H2: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🧾 Configuración H2 (persistente)

```properties
spring.datasource.url=jdbc:h2:file:./data/notificacionesdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jackson.time-zone=America/Bogota
```

---

## 🧠 Diseño técnico

- Se utiliza el **patrón Strategy** para delegar la lógica de envío a clases por canal (`EmailNotificacion`, `SmsNotificacion`, `WhatsappNotificacion`)
- La validación está centralizada en una clase `Validador`
- Las excepciones personalizadas (`CanalInactivoException`, `ValidacionException`, etc.) aseguran claridad y control

---

## 💡 Consideraciones

- Fácil de extender: solo agrega una clase que implemente `CanalNotificacion` para crear un nuevo canal.
- Pensado para pruebas técnicas, pero adaptable a producción.
- Puede integrarse fácilmente con colas, logs o sistemas externos.

---

## 📊 Diagramas

### 🔎 Diagramas

- [Ver Diagrama de Clases UML](https://www.plantuml.com/plantuml/png/fLHDJm8n4BttL_I88SiF88PWa4GJuq68deVk06EwxTfMeb7_kztk0ksowqVehJElRrvVPygcre5nhuNaES76G06Pa63HPaexMfC0GLenLWKjluzY_8Dnlp9-fzM6Kzxi5iwGtmjG8DDGZjQHqccmG6NX6TEW1qAk3_G2v3KuN5A1V8rY2tEr8ys-zgfcLQs3d8P3wM9bzhmhhIM2uY0SxQAJWIY-r0E-lFhgRRB_tiON8ENGh44WJ_bBRSbfynu1Wlueqs7s0isEFBJMDUJeXOCPc5hkkFSY5-E4fZcjLmuLcXkolXw177ZOdTzSnjX9o-2sX8RaAbXg3nG1EzdBz0zP0mR1md5Zb0StJv9Q5GvtDDcGRz0jgTHLcPhYJ2EEBL009IMR-AAm7T6dBJWBPPcasAdioy_Hg8Ew1zYkrGFhBdxQB3EjdD5Ieca_LY16-_ER1KTZlZFRhEfiup2SjR-rsYD8oaDm_YQmT4Vh6rCMkcBptqDd_bRL8tvCiXvdicpIDM4_mUCnO5tJsUQCPheF_YVEatvWoKGU8F4VCaML-s-TVGC0)

- [Ver Diagrama de Secuencia UML](https://www.plantuml.com/plantuml/png/XP31JiCm38RlVOOip63hD4q4A84aH0MI7yZglXBMGzz_7Q66vPl0UCMEzGa8NGoRTiUxa-VhOYXz-JRxMJl-QjLd2VPK7wRoL_a9ym31kIEmbdcPyKsw7rLplmBuw_CnDeIck-KTeYqXtJHNTN3FhGHSiRQOgmduo8BJ7p9P_-zPwj-xMkSIXil06ZnG2Iu4RzD97OShLfglFHRpbHZm00)

---

## ✍️ Autor

Basado en el desarrollo del **Ingeniero Hector**.

Desarrollado por **Sergio A. Perdomo Ortiz** como parte de una prueba técnica.
