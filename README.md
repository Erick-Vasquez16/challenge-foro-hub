# Challenge Foro Hub

Este proyecto es una aplicación Spring Boot que demuestra el uso de varias tecnologías y prácticas modernas, incluyendo inyección de dependencias, migraciones de bases de datos . Está diseñado para servir como un foro donde los usuarios pueden crear topicos.

## Tecnologías Utilizadas

### Spring Boot
- **Spring Boot Starter Web**: Para construir aplicaciones web utilizando Spring MVC.
- **Spring Boot Starter Validation**: Para validar datos de solicitud.
- **Spring Boot DevTools**: Proporciona características adicionales en tiempo de desarrollo, como reinicios automáticos y recarga en vivo.
- **Spring Boot Starter Data JPA**: Para interactuar con la base de datos utilizando Java Persistence API.

### Base de Datos
- **Flyway**: Para el control de versiones de la base de datos. Gestiona la evolución del esquema de la base de datos a lo largo del tiempo.
- **MySQL**: La base de datos utilizada para persistir los datos de la aplicación.
- **MySQL Connector/J**: Controlador JDBC para MySQL.

### Bibliotecas Utilitarias
- **Lombok**: Reduce el código repetitivo generando getters, setters, constructores y más en tiempo de compilación.


## Empezando

### Prerrequisitos
- Java 17 o superior
- Maven 3.8.1 o superior
- MySQL 8.0 o superior


2. **Configura la base de datos**:
    - Crea una base de datos MySQL llamada `foro`.
    - Actualiza el archivo `application.properties` con tus credenciales de base de datos.

3. **Ejecuta la aplicación**:
    ```bash
    mvn spring-boot:run
    ```

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a ella en `http://localhost:8080`.

