-- Usamos la master para eliminar la DB que ocupamos
use master;
go

-- Si la base de datos existe, ponerla en modo SINGLE_USER y eliminarla
if DB_ID('DBProyectoProgra2') is not null
begin
    alter database DBProyectoProgra2 set single_user with rollback immediate;
    drop database DBProyectoProgra2;
end
go

CREATE DATABASE DBProyectoProgra2;
GO

USE DBProyectoProgra2;
GO

CREATE TABLE Empresas(
	IdEmpresa INT IDENTITY(1,1) PRIMARY KEY,
	Nombre NVARCHAR(50) NOT NULL,
	Descripcion NVARCHAR(150),
);
GO

CREATE TABLE Solicitantes(
	IdSolicitante INT IDENTITY(1,1) PRIMARY KEY,
	Nombres NVARCHAR(25) NOT NULL,
	Apellidos NVARCHAR(25) NOT NULL,
	Correo NVARCHAR(50),
	Telefono NVARCHAR(10)
);
GO

CREATE TABLE Empleados(
	IdEmpleado INT IDENTITY(1,1) PRIMARY KEY,
	Nombres NVARCHAR(25) NOT NULL,
	Apellidos NVARCHAR(25) NOT NULL,
	Correo NVARCHAR(50),
	Telefono NVARCHAR(10),
	FK_IdEmpresa INT
	CONSTRAINT FK_Empleados_Empresa
		FOREIGN KEY (FK_IdEmpresa)
			REFERENCES Empresas (IdEmpresa)
);
GO

CREATE TABLE Horarios(
	IdHorario INT IDENTITY(1,1) PRIMARY KEY,
	HoraInicio DATETIME NOT NULL,
	HoraFin DATETIME NOT NULL
);
GO

CREATE TABLE Usuarios(
	IdUsuario INT IDENTITY(1,1) PRIMARY KEY,
	Username VARCHAR(25) NOT NULL,
	Pass NVARCHAR(25) NOT NULL,
	FK_IdEmpleado INT
	CONSTRAINT FK_Usuarios_Empleados
		FOREIGN KEY (FK_IdEmpleado)
			REFERENCES Empleados(IdEmpleado)
);
GO

CREATE TABLE Citas (
    IdCita INT IDENTITY(1,1) PRIMARY KEY,
    FK_IdSolicitante INT NOT NULL,
    FK_IdEmpleado INT NOT NULL,
    FK_IdHorario INT NOT NULL,
	FK_IdEmpresa INT NOT NULL,
	Estado NVARCHAR(15) NOT NULL,
	Motivo NVARCHAR(25),
    FechaSolicitud DATETIME DEFAULT GETDATE(),
    CONSTRAINT FK_Citas_Solicitantes FOREIGN KEY (FK_IdSolicitante) REFERENCES Solicitantes(IdSolicitante),
    CONSTRAINT FK_Citas_Empleados FOREIGN KEY (FK_IdEmpleado) REFERENCES Empleados(IdEmpleado),
    CONSTRAINT FK_Citas_Horarios FOREIGN KEY (FK_IdHorario) REFERENCES Horarios(IdHorario),
	CONSTRAINT FK_Citas_Empresas FOREIGN KEY (FK_IdEmpresa) REFERENCES Empresas(IdEmpresa)
);
GO

-- Inserts de ejemplo para Empresas
INSERT INTO Empresas (Nombre, Descripcion) VALUES ('Tech Solutions', 'Empresa de tecnología');
INSERT INTO Empresas (Nombre, Descripcion) VALUES ('Logística Express', 'Servicios de logística');
INSERT INTO Empresas (Nombre, Descripcion) VALUES ('Finanzas Plus', 'Servicios financieros');
INSERT INTO Empresas (Nombre, Descripcion) VALUES ('Educación Global', 'Institución educativa');
INSERT INTO Empresas (Nombre, Descripcion) VALUES ('Salud Integral', 'Clínica médica');
GO

-- Inserts de ejemplo para Solicitantes
INSERT INTO Solicitantes (Nombres, Apellidos, Correo, Telefono) VALUES ('Juan', 'Pérez', 'juan.perez@mail.com', '5551234');
INSERT INTO Solicitantes (Nombres, Apellidos, Correo, Telefono) VALUES ('Ana', 'García', 'ana.garcia@mail.com', '5552345');
INSERT INTO Solicitantes (Nombres, Apellidos, Correo, Telefono) VALUES ('Luis', 'Martínez', 'luis.martinez@mail.com', '5553456');
INSERT INTO Solicitantes (Nombres, Apellidos, Correo, Telefono) VALUES ('María', 'López', 'maria.lopez@mail.com', '5554567');
INSERT INTO Solicitantes (Nombres, Apellidos, Correo, Telefono) VALUES ('Carlos', 'Ruiz', 'carlos.ruiz@mail.com', '5555678');
GO

-- Inserts de ejemplo para Empleados
INSERT INTO Empleados (Nombres, Apellidos, Correo, Telefono, FK_IdEmpresa) VALUES ('Pedro', 'Santos', 'pedro.santos@mail.com', '5556789', 1);
INSERT INTO Empleados (Nombres, Apellidos, Correo, Telefono, FK_IdEmpresa) VALUES ('Lucía', 'Ramírez', 'lucia.ramirez@mail.com', '5557890',  2);
INSERT INTO Empleados (Nombres, Apellidos, Correo, Telefono, FK_IdEmpresa) VALUES ('Miguel', 'Castillo', 'miguel.castillo@mail.com', '5558901', 3);
INSERT INTO Empleados (Nombres, Apellidos, Correo, Telefono, FK_IdEmpresa) VALUES ('Sofía', 'Mendoza', 'sofia.mendoza@mail.com', '5559012', 4);
INSERT INTO Empleados (Nombres, Apellidos, Correo, Telefono, FK_IdEmpresa) VALUES ('Diego', 'Flores', 'diego.flores@mail.com', '5550123', 5);
GO

-- Inserts de ejemplo para Horarios
INSERT INTO Horarios (HoraInicio, HoraFin) VALUES ('2025-08-02 08:00:00', '2025-08-02 17:00:00');
INSERT INTO Horarios (HoraInicio, HoraFin) VALUES ('2025-08-03 09:00:00', '2025-08-03 18:00:00');
INSERT INTO Horarios (HoraInicio, HoraFin) VALUES ('2025-08-04 10:00:00', '2025-08-04 19:00:00');
INSERT INTO Horarios (HoraInicio, HoraFin) VALUES ('2025-08-05 11:00:00', '2025-08-05 20:00:00');
INSERT INTO Horarios (HoraInicio, HoraFin) VALUES ('2025-08-06 12:00:00', '2025-08-06 21:00:00');
GO

-- Inserts de ejemplo para Usuarios		
INSERT INTO Usuarios (Username, Pass, FK_IdSolicitante) VALUES ('juanp', 'pass123', 1);
INSERT INTO Usuarios (Username, Pass, FK_IdSolicitante) VALUES ('anag', 'pass234', 2);
INSERT INTO Usuarios (Username, Pass, FK_IdSolicitante) VALUES ('luism', 'pass345', 3);
INSERT INTO Usuarios (Username, Pass, FK_IdSolicitante) VALUES ('marial', 'pass456', 4);
INSERT INTO Usuarios (Username, Pass, FK_IdSolicitante) VALUES ('carlosr', 'pass567', 5);
GO

-- Inserts de ejemplo para Citas
INSERT INTO Citas (
    FK_IdSolicitante, FK_IdEmpleado, FK_IdHorario, FK_IdEmpresa, Estado, Motivo
)
VALUES
    (1, 1, 1, 1, 'Pendiente', 'Consulta general'),
    (2, 2, 2, 2, 'Confirmada', 'Seguimiento de proyecto'),
    (3, 3, 3, 3, 'Reprogramada', 'Asesoría financiera'),
    (4, 4, 4, 4, 'Pendiente', 'Solicitud de información'),
    (5, 5, 5, 5, 'Cancelada', 'No especificado');
