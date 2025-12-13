# 📚 Gestión de Biblioteca — Java + MySQL + JDBC + DAO + Arquitectura en 3 Capas

Este proyecto es un sistema completo para la **gestión de biblioteca**, implementado en Java con:

- JDBC para conexión con MySQL  
- Patrón de diseño **DAO** para acceso a datos  
- Arquitectura en capas (**Dominio – Datos – Presentación**)  
- CRUD completos para usuarios, libros, préstamos, funcionarios y eventos  
- Menús interactivos en consola para cada módulo  
- Manejo de excepciones con `try-catch` para robustez  

---

# 🏗 Arquitectura del Proyecto

```

/src/main/java/gestion_biblioteca
 ├── conexion/
 │     └── Conexion.java
 │
 ├── datos/
 │     ├── IUsuarioDAO.java
 │     ├── UsuarioDAO.java
 │     ├── ILibroDAO.java
 │     ├── LibroDAO.java
 │     ├── IPrestamoDAO.java
 │     ├── PrestamoDAO.java
 │     ├── IFuncionarioDAO.java
 │     ├── FuncionarioDAO.java
 │     ├── IEventoDAO.java
 │     └── EventoDAO.java
 │
 ├── dominio/
 │     ├── Usuario.java
 │     ├── Libro.java
 │     ├── Prestamo.java
 │     ├── Funcionario.java
 │     └── Evento.java
 │
 └── presentacion/
       ├── BibliotecaMain.java
       ├── UsuarioCRUD.java
       ├── LibrosCRUD.java
       ├── PrestamoCRUD.java
       ├── FuncionarioCRUD.java
       └── EventoCRUD.java

```

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

```
1. Gestión Usuarios
2. Gestión Libros
3. Gestión Préstamos
4. Gestión Funcionarios
5. Gestión Eventos
6. Salir
```

Cada opción despliega un submenú específico con las operaciones CRUD correspondientes.

---

## 📋 Base de Datos

- La base de datos se llama `biblioteca_db`
- El script para crear la base y tablas está en `database/schema.sql`
- Ejecutar este script antes de iniciar la aplicación

---

# 📌 Objetivo del Proyecto

Este repositorio forma parte de mi ruta de aprendizaje backend con Java, donde desarrollo un CRUD por cada módulo del sistema **Gestión de Biblioteca**, iniciando con JDBC antes de avanzar hacia:

➡ Spring Boot  
➡ Spring MVC + Thymeleaf

---

🙌 Autor
morocho
📧 Correo: *portafoliomoro@gmail.com*
🔗 GitHub: *portafoliomoro-moro*


