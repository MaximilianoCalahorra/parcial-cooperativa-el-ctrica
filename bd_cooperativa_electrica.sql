CREATE DATABASE IF NOT EXISTS `bd_cooperativa_electrica`;
USE `bd_cooperativa_electrica`;

SET GLOBAL time_zone = '-3:00'; /* Para sincronizar el uso horario */

/* ESTRUCTURAS */

/* Tabla persona: */
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` 
(
    `idPersona` INT(11) NOT NULL AUTO_INCREMENT,
    `apellido` VARCHAR(45) NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
    `dni` INT(11) NOT NULL,
    PRIMARY KEY(idPersona)
);

/* Tabla cliente: */
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` 
(
    `idCliente` INT(11) NOT NULL,
    `nroCliente` VARCHAR(6) NOT NULL,
    PRIMARY KEY(idCliente),
    FOREIGN KEY(idCliente) REFERENCES `persona`(idPersona)
);

/* Tabla inspector: */
DROP TABLE IF EXISTS `inspector`;
CREATE TABLE `inspector` 
(
    `idInspector` INT(11) NOT NULL,
    `zona` VARCHAR(7) NOT NULL,
    PRIMARY KEY(idInspector),
    FOREIGN KEY(idInspector) REFERENCES `persona`(idPersona)
);

/* Tabla medidorAlta: */
DROP TABLE IF EXISTS `medidorAlta`;
CREATE TABLE `medidorAlta`
(
    idMedidorAlta INT(11) NOT NULL AUTO_INCREMENT,
    nroSerie VARCHAR(6) NOT NULL,
    domicilioMedidor VARCHAR(45) NOT NULL,
    zona INT(11) NOT NULL,
    idCliente INT(11) NOT NULL,
    PRIMARY KEY(idMedidorAlta),
    FOREIGN KEY(idCliente) REFERENCES `cliente`(idCliente)
);

/* Tabla consumo: */
DROP TABLE IF EXISTS `consumo`;
CREATE TABLE `consumo`
(
    idConsumo INT(11) NOT NULL AUTO_INCREMENT,
    horasValle FLOAT NOT NULL,
    horasPico FLOAT NOT NULL,
    horasResto FLOAT NOT NULL,
    PRIMARY KEY(idConsumo)
);

/* Tabla lectura: */
DROP TABLE IF EXISTS `lectura`;
CREATE TABLE `lectura`
(
    idLectura INT(11) NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    idMedidorAlta INT(11) NOT NULL,
    idInspector INT(11) NOT NULL,
    idConsumo INT(11) NOT NULL,
    PRIMARY KEY(idLectura),
    FOREIGN KEY(idMedidorAlta) REFERENCES `medidorAlta`(idMedidorAlta),
    FOREIGN KEY(idInspector) REFERENCES `inspector`(idInspector),
    FOREIGN KEY(idConsumo) REFERENCES `consumo`(idConsumo)
);

/* INSERCIÓN DE DATOS */

/* Insertamos 6 registros a la tabla persona (4 cliente y 2 inspector): */
INSERT INTO persona VALUES (1, "Perez", "Ana", 11111111), (2, "Cacerez", "Martina", 38911266), (3, "Gimenez", "Martin", 40193325);

/* Insertamos dos registros a la tabla cliente: */
INSERT INTO cliente VALUES (1, "111111"), (2, "222222");

/* Insertamos un registro a la tabla inspector: */
INSERT INTO inspector VALUES (3, "Zona A");

/* Insertamos dos registros a la tabla medidorAlta: */
INSERT INTO medidorAlta VALUES (1, "438823", "29 de Septiembre 3500 R.Escalada", 1, 1), (2, "934152", "29 de Septiembre 3400 R.Escalada", 1, 2); 

/* Insertamos 10 registros a la tabla consumo */
INSERT INTO consumo VALUES
(1, 0.12, 0.10, 0.05),
(2, 0.15, 0.11, 0.03),
(3, 0.81, 0.75, 0.51),
(4, 0.90, 0.93, 0.64),
(5, 1.57, 1.80, 1.20),
(6, 1.60, 1.44, 1.80),
(7, 2.26, 2.16, 2.061),
(8, 2.41, 2.70, 2.10),
(9, 2.85, 2.81, 2.98),
(10, 3.12, 3.21, 3.56);

/* Insertamos 10 registros a la tabla lectura (5 por cada medidorAlta) */
INSERT INTO lectura VALUES 
(1, "2018-11-10", 1, 3, 1),
(2, "2018-12-10", 2, 3, 2),
(3, "2019-01-10", 1, 3, 3),
(4, "2019-02-10", 2, 3, 4),
(5, "2019-03-10", 1, 3, 5),
(6, "2018-11-10", 2, 3, 6),
(7, "2018-12-10", 1, 3, 7),
(8, "2019-01-10", 2, 3, 8),
(9, "2019-02-10", 1, 3, 9),
(10, "2019-03-10", 2, 3, 10);
