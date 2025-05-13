Base de datos 

CREATE DATABASE "DonChapato";


CREATE TABLE Tipo (
    ID_Tipo INT PRIMARY KEY NOT NULL,
    Descripcion TEXT NOT NULL
);

CREATE TABLE Producto (
    ID_Producto INT PRIMARY KEY NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Precio NUMERIC(8, 2) NOT NULL,
    Tipo VARCHAR(80) NOT NULL,
    Descripcion TEXT NOT NULL
);


CREATE TABLE Usuario (
    ID_Usuario INT PRIMARY KEY NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Apellido_P VARCHAR(50) NOT NULL,
    Apellido_S VARCHAR(50),  
    Telefono VARCHAR(10) NOT NULL,
    Correo VARCHAR(50) NOT NULL,
    Rol CHAR(1) NOT NULL
);

CREATE TABLE Ubicacion (
    ID_Ubicacion INT PRIMARY KEY NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Descripcion VARCHAR(100) NOT NULL
);


CREATE TABLE Orden (
    ID_Orden INT PRIMARY KEY NOT NULL,
    ID_Ubicacion INT NOT NULL,
    ID_Cliente INT NOT NULL,
    Estado CHAR(1) NOT NULL,
    FOREIGN KEY (ID_Ubicacion) REFERENCES Ubicacion(ID_Ubicacion),
    FOREIGN KEY (ID_Cliente) REFERENCES Usuario(ID_Usuario)
);


CREATE TABLE Orden_Producto (
    ID_Orden INT NOT NULL,
    ID_Producto INT NOT NULL,
    PRIMARY KEY (ID_Orden, ID_Producto),
    FOREIGN KEY (ID_Orden) REFERENCES Orden(ID_Orden),
    FOREIGN KEY (ID_Producto) REFERENCES Producto(ID_Producto)
);
