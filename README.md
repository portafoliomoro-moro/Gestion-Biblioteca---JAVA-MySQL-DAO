# Gestión de Biblioteca — JDBC + DAO + Arquitectura en 3 Capas

Este proyecto implementa un sistema completo de **gestión de biblioteca**, desarrollado en Java utilizando:

✔ JDBC  
✔ Patrón de diseño DAO  
✔ Arquitectura por capas (Dominio – Datos – Presentación)  
✔ Programación Orientada a Objetos  
✔ CRUD por consola para 5 entidades  


---

# Arquitectura del Proyecto
/src
 ├── dominio/
 │     ├── EstadoLibro.java
 │     ├── Evento.java
 │     ├── Funcionario.java
 │     ├── Libro.java
 │     ├── Prestamo.java
 │     └── Usuario.java
 │
 ├── datos/
 │     ├── EventoDAO.java
 │     ├── FuncionarioDAO.java
 │     ├── IEventoDAO.java
 │     ├── IFuncionarioDAO.java
 │     ├── ILibroDAO.java
 │     ├── IPrestamoDAO.java
 │     ├── IUsuarioDAO.java
 │     ├── LibroDAO.java
 │     ├── PrestamoDAO.java
 │     └── UsuarioDAO.java
 │
 ├── conexion/
 │     └── Conexion.java
 │
 └── presentacion/
       ├── BibliotecaMain.java
       ├── EventoCRUD.java
       ├── FuncionarioCRUD.java
       ├── LibrosCRUD.java
       ├── PrestamoCRUD.java
       └── UsuarioCRUD.java

---

# 🗃 1. Capa de Conexión — JDBC

La clase **Conexion** se encarga de:

- Registrar el driver JDBC  
- Conectar a MySQL  
- Devolver la conexión a los DAO  
- Manejar errores SQL  
- Cerrar conexiones y sentencias de forma segura  

---

# 👤 2. Capa de Dominio — Entidades

El proyecto incluye 6 clases de dominio:

- Usuario
- Libro
- EstadoLibro (enum)
- Prestamo
- Funcionario
- Evento

Cada entidad posee:

- Atributos propios  
- Constructores para crear, buscar y modificar  
- Métodos Getters/Setters  
- toString(), equals(), hashCode()  

---

# 💾 3. Capa de Datos — DAO

Cada módulo cuenta con:

✔ Interfaz DAO  
Define el CRUD respectivo:

- listar()  
- buscarPorId()  
- agregar()  
- modificar()  
- eliminar()  

✔ Implementación DAO  
Las clases XxxDAO.java utilizan:

- Connection
- PreparedStatement
- ResultSet

Todos los CRUD fueron probados desde la capa de presentación.

---

# 🎮 4. Capa de Presentación — Consola

El archivo **BibliotecaMain.java** actúa como menú principal:

1. Gestión Usuarios  
2. Gestión Libros  
3. Gestión Préstamos  
4. Gestión Funcionarios  
5. Gestión Eventos  
6. Salir  

Cada opción abre un submenú CRUD:

- UsuarioCRUD  
- LibrosCRUD  
- PrestamoCRUD  
- FuncionarioCRUD  
- EventoCRUD  

Todos totalmente operativos por consola.

---

#  Tecnologías Utilizadas

- Java 17+  
- MySQL 8  
- JDBC  
- Patrón DAO  
- POO  
- Arquitectura en 3 capas  

---

# Objetivo del Proyecto

Este repositorio es parte de mi evolución como desarrollador backend en Java:

1. CRUD independientes con JDBC  
2. Proyecto integrador (este repositorio)  
3. Próximamente:
   - Spring Boot  
   - Spring MVC + Thymeleaf  

---

# 🙌 Autor

**morocho**  
📧 Correo: portafoliomoro@gmail.com
🔗 GitHub: portafoliomoro-moro

