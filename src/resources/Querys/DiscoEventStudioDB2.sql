DROP DATABASE IF EXISTS DiscoEventStudioDB;
CREATE DATABASE DiscoEventStudioDB;
USE DiscoEventStudioDB;

-- Tabla Tipos_Boda
CREATE TABLE Tipos_Boda (
    id_tipo_boda INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    tipo_pack ENUM('base', 'pro', 'diamante', 'platino'),
    descripcion TEXT,
    importe_base DECIMAL(10, 2)
);

-- Tabla Tipos_Fiesta
CREATE TABLE Tipos_Fiesta (
    id_tipo_fiesta INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    tipo_fiesta ENUM('disco_movil', 'karaoke', 'proyeccion'),
    descripcion TEXT,
    importe_base DECIMAL(10, 2)
);

-- Tabla Clientes
CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    CIF VARCHAR(50),
    nombre VARCHAR(100) UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

-- Tabla Empleados
CREATE TABLE Empleados (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellidos VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

-- Tabla Material
CREATE TABLE Material (
    id_articulo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    unidades_disponibles INT,
    unidades_no_disponibles INT
);

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(25) UNIQUE,
    contrasena VARCHAR(9)
);

-- Tabla Furgonetas
CREATE TABLE Furgonetas (
    id_furgoneta INT PRIMARY KEY AUTO_INCREMENT,
    modelo VARCHAR(100)
);

-- Tabla Eventos
CREATE TABLE Eventos (
    id_evento INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    id_furgoneta INT,
    tipo_evento ENUM('boda', 'fiesta'),
    id_tipo_boda INT NULL,
    id_tipo_fiesta INT NULL,
    fecha_evento DATE,
    fotomaton BOOLEAN,
    karaoke BOOLEAN,
    proyeccion BOOLEAN,
    horas_extra_disco INT,
    horas_extra_fotomaton INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
    FOREIGN KEY (id_furgoneta) REFERENCES Furgonetas(id_furgoneta),
    FOREIGN KEY (id_tipo_boda) REFERENCES Tipos_Boda(id_tipo_boda),
    FOREIGN KEY (id_tipo_fiesta) REFERENCES Tipos_Fiesta(id_tipo_fiesta)
);

-- Tabla Empleados_Eventos (para la relación muchos a muchos entre empleados y eventos)
CREATE TABLE Empleados_Eventos (
    id_empleado INT,
    id_evento INT,
    PRIMARY KEY (id_empleado, id_evento),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado),
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento)
);



INSERT INTO Usuarios (usuario, contrasena) VALUES 
('admin', 'admin');

