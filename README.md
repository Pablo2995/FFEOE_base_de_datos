# Sistema de Control de Fichajes con Spring Boot

[![Java](https://img.shields.io/badge/Java-25-blue.svg)](https://openjdk.org/projects/jdk/25/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-orange.svg)](https://www.mysql.com/)
[![Hibernate](https://img.shields.io/badge/Hibernate-JPA-yellow.svg)](https://hibernate.org/)

Aplicación web para la gestión automatizada del control horario de empleados. Centraliza el registro de entradas y salidas, elimina errores del proceso manual y expone toda la funcionalidad a través de una API REST completa con operaciones CRUD.

## 📋 Descripción del Problema

En muchas empresas el control horario se realiza de forma manual, lo que genera:
- **Pérdida de tiempo** para empleados y responsables de RR.HH.
- **Errores humanos** al registrar entradas y salidas.
- **Falta de centralización** de la información.
- **Control deficiente** de las horas trabajadas y del historial de fichajes.

Este proyecto soluciona esos problemas mediante una aplicación web moderna basada en **Spring Boot** y **MySQL**, que automatiza el registro, consulta, modificación y eliminación de fichajes.

## 🚀 Características principales

- Registro de empleados, centros de trabajo y fichajes (entrada/salida).
- API REST con todos los métodos CRUD (GET, POST, PUT, DELETE).
- Persistencia con JPA/Hibernate y MySQL.
- Relaciones uno a muchos entre empleado ↔ fichaje y centro ↔ fichaje.
- Integridad referencial garantizada a nivel de base de datos.
- Arquitectura MVC: Modelo, Repositorio, Servicio y Controlador.

## 🗃️ Modelo de datos (Entidades principales)

| Entidad | Atributos |
|---------|-----------|
| **Empleado** | id, dni, nombre, email, departamento |
| **CentroTrabajo** | id, nombre, dirección, ciudad |
| **Fichaje** | id, tipo (ENTRADA/SALIDA), fechaHora, empleado_id, centro_trabajo_id |

**Relaciones:**
- Un **empleado** puede tener muchos **fichajes** (1:N)
- Un **centro de trabajo** puede tener muchos **fichajes** (1:N)

## 🛠️ Tecnologías utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|------------|
| Java | 25 | Lenguaje principal |
| Spring Boot | 3 | Framework de la aplicación |
| MySQL | 8.x | Base de datos relacional |
| Hibernate | (JPA) | Mapeo objeto-relacional |
| Maven | - | Gestión de dependencias |
| Postman | - | Pruebas de API REST |
| IntelliJ IDEA | - | Entorno de desarrollo |

## 📦 Endpoints de la API REST

Base URL: `http://localhost:8080`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/fichajes` | Obtener todos los fichajes |
| GET | `/fichajes/{id}` | Obtener un fichaje por ID |
| POST | `/fichajes` | Crear un nuevo fichaje |
| PUT | `/fichajes/{id}` | Actualizar un fichaje existente |
| DELETE | `/fichajes/{id}` | Eliminar un fichaje |

### Ejemplo de petición POST para registrar una entrada

```json
{
  "tipo": "ENTRADA",
  "fechaHora": "2026-05-25T10:30:00",
  "empleado": { "id": 1 },
  "centroTrabajo": { "id": 1 }
}
