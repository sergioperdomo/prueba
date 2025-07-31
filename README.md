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

- Ver [Diagrama de Clases UML](/docs/diagrams/diagrama-clases-notificacion.puml)
- Ver [Diagrama de Secuencia UML](/docs/diagrams/diagrama-secuencia-notificacion.puml)

---

## ✍️ Autor

Basado en el desarrollo del **Ingeniero Hector**.

Desarrollado por **Sergio A. Perdomo Ortiz** como parte de una prueba técnica.
