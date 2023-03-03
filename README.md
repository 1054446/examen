# examen
Prueba Tecnica

#Instrucciones

1.- La collection Postman esta adjunta en el repositorio
2.- Primero insertar una Zona
3.- Luego insertar un Estudiante
4.- Crear un Examen
5.- Crear una Pregunta
6.- Crear las opciones de la pregunta
7.- Hacer una asignacion de Estudiante con Examen
  7.- Al insertar la fecha con formato "2023-02-01T19:03:05" internamente con el id del Estudiante se obtiene su Zona para hacer la transformacion del formato de la fecha y hora, se puso el ejemplo de America/Bogota
8.- insertar las respuestas del examen de un alumno
9.- obtener respuestas por alumno y por examen
10.- obtener la calificación dado el id de un Alumno y un examen

#Scrip de las tablas de la base de datos con algunos datos insertados

CREATE DATABASE IF NOT EXISTS examen;

use examen;

CREATE TABLE IF NOT EXISTS zonahoraria(
	zonahoraria_id INT(11) NOT NULL AUTO_INCREMENT,
    zone VARCHAR(100) NOT NULL,
    CONSTRAINT zonahoraria_pk PRIMARY KEY (zonahoraria_id)
);

CREATE TABLE IF NOT EXISTS estudiantes(
	estudiante_id INT(11) NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    edad INT(2),
    ciudad VARCHAR(50),
    zonahoraria_id INT(11),
    CONSTRAINT estudiantes_pk PRIMARY KEY (estudiante_id),
    FOREIGN KEY(zonahoraria_id) REFERENCES zonahoraria(zonahoraria_id)
);

CREATE TABLE IF NOT EXISTS examenes(
	examen_id INT(11) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    CONSTRAINT examen_pk PRIMARY KEY (examen_id)
);

CREATE TABLE IF NOT EXISTS examenpreguntas(
	pregunta_id INT(11) NOT NULL AUTO_INCREMENT,
    pregunta VARCHAR(255) NOT NULL,
    examen_id int (11),
    CONSTRAINT examenpreguntas_pk PRIMARY KEY (pregunta_id),
    FOREIGN KEY(examen_id) REFERENCES examenes(examen_id)
);

CREATE TABLE IF NOT EXISTS examenopciones(
	opcion_id INT(11) NOT NULL AUTO_INCREMENT,
    opcion VARCHAR(255) NOT NULL,
    is_correct boolean NOT NULL,
    pregunta_id int (11),
    CONSTRAINT examenopciones_pk PRIMARY KEY (opcion_id),
    FOREIGN KEY(pregunta_id) REFERENCES examenpreguntas(pregunta_id)
);

CREATE TABLE IF NOT EXISTS estudianteexamen(
	estudianteexamen_id INT(11) NOT NULL AUTO_INCREMENT,
    calificacion double(10,2),
    fecha_examen date,
    examen_id INT(11),
    estudiante_id INT(11),
    CONSTRAINT estudianteexamen_pk PRIMARY KEY (estudianteexamen_id),
    FOREIGN KEY(examen_id) REFERENCES examenes(examen_id),
    FOREIGN KEY(estudiante_id) REFERENCES estudiantes(estudiante_id)
);

CREATE TABLE IF NOT EXISTS examenrespuestas(
	respuesta_id INT(11) NOT NULL AUTO_INCREMENT,
    estudianteexamen_id INT(11),
    pregunta_id INT(11),
    opcion_id INT(11),
    CONSTRAINT examenrespuestas_pk PRIMARY KEY (respuesta_id),
    FOREIGN KEY(estudianteexamen_id) REFERENCES estudianteexamen(estudianteexamen_id),
    FOREIGN KEY(pregunta_id) REFERENCES examenpreguntas(pregunta_id),
    FOREIGN KEY(opcion_id) REFERENCES examenopciones(opcion_id)
);
-- insertar registros
insert into zonahoraria (zone) values ('America/Bogota');

insert into estudiantes (nombres, apellidos, edad, ciudad, zonahoraria_id) values ('jesus', 'dominguez', 26, 'CDMX', 1);

insert into examenes (nombre) values ('programación');

insert into examenpreguntas (pregunta, examen_id) values ('¿Qué significa instanciar una clase?', 1);
insert into examenpreguntas (pregunta, examen_id) values ('¿Cuál es la descripción que crees que define mejor el concepto clase en la programación orientada a objetos?', 1);
insert into examenpreguntas (pregunta, examen_id) values ('¿Qué elementos crees que definen a un objeto?', 1);

insert into examenopciones (opcion, is_correct, pregunta_id) values ('Duplicar una clase',false, 1);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Eliminar una clase', false, 1);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Crear un objeto a partir de la clase', true, 1);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Conectar dos clases entre sí', false, 1);

insert into examenopciones (opcion, is_correct, pregunta_id) values ('Es un concepto similar al de array', false, 2);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Es un tipo particular de variable', false, 2);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Es un modelo o plantilla a partir de la cual creamos objetos', true, 2);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Es una categoria de datos ordenada secuencialmente', false, 2);

insert into examenopciones (opcion, is_correct, pregunta_id) values ('Sus cardinalidad y su tipo', false, 3);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Sus atributos y sus métodos', true, 3);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('La forma en que establece comunicación e intercambia mensajes', false, 3);
insert into examenopciones (opcion, is_correct, pregunta_id) values ('Su interfaz y los eventos asociados', false, 3);

insert into estudianteexamen (calificacion, fecha_examen, examen_id, estudiante_id) values (10, '2023-03-02', 1, 1);

insert into examenrespuestas (estudianteexamen_id, pregunta_id, opcion_id) values (1, 1, 3);
insert into examenrespuestas (estudianteexamen_id, pregunta_id, opcion_id) values (1, 2, 7);
insert into examenrespuestas (estudianteexamen_id, pregunta_id, opcion_id) values (1, 3, 10);

#consulta obtener respuestas de un estudiante por examen
select er.respuesta_id, er.estudianteexamen_id, er.pregunta_id, er.opcion_id from examenrespuestas as er
inner join estudianteexamen as e
on er.estudianteexamen_id = e.estudianteexamen_id
where e.estudiante_id = 1 and e.examen_id = 1;
