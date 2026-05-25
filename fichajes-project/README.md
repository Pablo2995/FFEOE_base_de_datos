# Sistema de Fichaje de Empleados

Aplicación web para registrar las entradas y salidas de empleados, especificando el centro de trabajo.

## Tecnologías
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- Thymeleaf
- H2 Database (en memoria)

## Ejecución
1. Clonar el repositorio o descomprimir el ZIP.
2. Ir al directorio del proyecto: `cd fichajes-project`
3. Ejecutar con Maven: `mvn spring-boot:run`
4. Abrir en el navegador: `http://localhost:8080/fichajes`
5. Consola H2 (opcional): `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:fichajesdb`
   - Usuario: `sa` (sin contraseña)

## Funcionalidades
- Listar fichajes con filtros por empleado y rango de fechas.
- Crear un nuevo fichaje (ENTRADA/SALIDA).
- Editar un fichaje existente.
- Eliminar un fichaje.
