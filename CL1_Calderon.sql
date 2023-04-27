SET GLOBAL time_zone = '+8:00';
-- borra la bd si existe
DROP DATABASE IF EXISTS CL1_Calderon;
-- creamos la bd
CREATE DATABASE CL1_Calderon;
-- activamos la bd
USE CL1_Calderon;

CREATE TABLE doctores (
    id_doctor INT AUTO_INCREMENT PRIMARY KEY,
    nom_doctor VARCHAR(255),
    especialidad_doctor VARCHAR(255)
);

CREATE TABLE citas (
    id_cita INT AUTO_INCREMENT PRIMARY KEY,
    num_cita VARCHAR (255),
    fecha_cita DATE,
    nom_paciente_cita VARCHAR(255),
    id_doctor INT,
    FOREIGN KEY (id_doctor) REFERENCES doctores(id_doctor)
);

select * from doctores;

select * from citas;

