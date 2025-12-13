# 📚 Gestión de Biblioteca — Java + MySQL + JDBC + DAO + Arquitectura en 3 Capas

Este proyecto es un sistema completo para la **gestión de biblioteca**, implementado en Java con:

- JDBC para conexión con MySQL  
- Patrón de diseño **DAO** para acceso a datos  
- Arquitectura en capas (**Dominio – Datos – Presentación**)  
- CRUD completos para usuarios, libros, préstamos, funcionarios y eventos  
- Menús interactivos en consola para cada módulo  
- Manejo de excepciones con `try-catch` para robustez  

---

## 🏗 Arquitectura del Proyecto

/src/main/java/gestion_biblioteca
├── conexion/ # Clase para conexión JDBC a MySQL
├── datos/ # Interfaces y clases DAO para cada entidad
├── dominio/ # Clases de entidad que representan tablas
└── presentacion/ # Menús y lógica para interacción por consola
/database
└── schema.sql # Script para crear la base de datos y tablas
README.md # Documentación del proyecto
pom.xml # Dependencias y configuración Maven

---

## 📦 Módulos y funcionalidades

### 1. Gestión de Usuarios
- Listar, buscar, agregar, modificar y eliminar usuarios
- Representación de la tabla `usuarios`

### 2. Gestión de Libros
- CRUD completo para libros (`libros`)

### 3. Gestión de Préstamos
- Control de préstamos de libros, renovaciones, fechas

### 4. Gestión de Funcionarios
- Registro y manejo de funcionarios del sistema

### 5. Gestión de Eventos
- Gestión de eventos relacionados con la biblioteca

Cada módulo incluye:

- Entidad Java en `dominio/`
- Interfaz DAO en `datos/`
- Implementación DAO en `datos/`
- Clase de presentación con menú y operaciones CRUD en `presentacion/`

---

## 🗃 Capa de Conexión — JDBC

La clase `Conexion` en `conexion/` se encarga de:

- Registrar el driver JDBC de MySQL  
- Establecer y retornar la conexión  
- Manejar excepciones y cerrar recursos

---

## 🖥 Capa de Presentación — Consola

La clase `BibliotecaMain.java` muestra un menú general con opciones para cada módulo:

*** Gestión de Biblioteca ***

Gestión de Usuarios

Gestión de Libros

Gestión de Préstamos

Gestión de Funcionarios

Gestión de Eventos

Salir


Cada opción despliega un submenú específico con las operaciones CRUD correspondientes.

---

## 📋 Base de Datos

- La base de datos se llama `biblioteca_db`
- El script para crear la base y tablas está en `database/schema.sql`
- Ejecutar este script antes de iniciar la aplicación

Ejemplo para ejecutar el script:

```bash
mysql -u usuario -p < database/schema.sql

Tecnologías y Herramientas
Java 17+

MySQL 8+

JDBC Driver oficial

Maven para gestión de dependencias

Patrón DAO y arquitectura en 3 capas

Programación Orientada a Objetos (POO)

📌 Objetivo del Proyecto
Este repositorio forma parte de mi aprendizaje en backend con Java.
Mi objetivo es desarrollar sistemas sólidos con buenas prácticas y arquitectura limpia.
Actualmente uso JDBC y DAOs, con planes de migrar a frameworks como Spring Boot.

🙌 Autor
morocho
📧 Correo: *portafoliomoro@gmail.com*
🔗 GitHub: *portafoliomoro-moro*


