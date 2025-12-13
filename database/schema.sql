-- =========================================
-- Base de datos: biblioteca_db
-- Sistema de Gestión de Biblioteca
-- =========================================

CREATE DATABASE IF NOT EXISTS biblioteca_db
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_spanish_ci;

USE biblioteca_db;

-- =========================================
-- Tabla: usuarios
-- =========================================
CREATE TABLE usuarios (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  tipo_documento VARCHAR(20) NOT NULL,
  numero_documento VARCHAR(30) NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  direccion VARCHAR(150) DEFAULT NULL,
  telefono VARCHAR(20) DEFAULT NULL,
  correo VARCHAR(100) DEFAULT NULL,
  llave_saber VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY uk_usuario_numero_documento (numero_documento)
) ENGINE=InnoDB;

-- =========================================
-- Tabla: funcionarios
-- =========================================
CREATE TABLE funcionarios (
  id_funcionario INT NOT NULL AUTO_INCREMENT,
  tipo_documento VARCHAR(20) NOT NULL,
  numero_documento VARCHAR(30) NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  cargo VARCHAR(100) DEFAULT NULL,
  telefono VARCHAR(20) DEFAULT NULL,
  correo VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (id_funcionario),
  UNIQUE KEY uk_funcionario_numero_documento (numero_documento)
) ENGINE=InnoDB;

-- =========================================
-- Tabla: libros
-- =========================================
CREATE TABLE libros (
  id_libro INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(200) NOT NULL,
  autor VARCHAR(150) DEFAULT NULL,
  editorial VARCHAR(100) DEFAULT NULL,
  anio INT DEFAULT NULL,
  codigo VARCHAR(100) DEFAULT NULL,
  estado ENUM('DISPONIBLE','PRESTADO','DANADO') DEFAULT 'DISPONIBLE',
  numero_prestamos INT DEFAULT 0,
  numero_renovaciones INT DEFAULT 0,
  PRIMARY KEY (id_libro)
) ENGINE=InnoDB;

-- =========================================
-- Tabla: eventos
-- =========================================
CREATE TABLE eventos (
  id_evento INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  tema VARCHAR(200) NOT NULL,
  descripcion TEXT,
  colegios_participantes VARCHAR(255) DEFAULT NULL,
  numero_asistentes INT DEFAULT 0,
  PRIMARY KEY (id_evento)
) ENGINE=InnoDB;

-- =========================================
-- Tabla: prestamos
-- =========================================
CREATE TABLE prestamos (
  id_prestamo INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_libro INT NOT NULL,
  fecha_prestamo DATE NOT NULL,
  fecha_devolucion DATE NOT NULL,
  renovaciones INT DEFAULT 0,
  PRIMARY KEY (id_prestamo),
  KEY idx_prestamo_usuario (id_usuario),
  KEY idx_prestamo_libro (id_libro),
  CONSTRAINT fk_prestamo_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios (id_usuario),
  CONSTRAINT fk_prestamo_libro
    FOREIGN KEY (id_libro)
    REFERENCES libros (id_libro)
) ENGINE=InnoDB;
