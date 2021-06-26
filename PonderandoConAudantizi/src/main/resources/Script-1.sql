CREATE DATABASE pc3Audantizi;

USE pc3Audantizi;

CREATE TABLE suscriptor(
	dni VARCHAR(10) PRIMARY KEY,
	nombres VARCHAR(50),
	apellidos VARCHAR(100)
);

INSERT INTO suscriptor(dni,nombres,apellidos)
VALUES('123','Daniel','Garcia');

INSERT INTO suscriptor(dni,nombres,apellidos)
VALUES('1234','Anthony','Avellaneda');

INSERT INTO suscriptor(dni,nombres,apellidos)
VALUES('12345','Paolo','Guerrero');

SELECT dni,nombres,apellidos 
FROM suscriptor
WHERE dni = '123';

SELECT dni,nombres,apellidos 
FROM suscriptor
WHERE apellidos = 'Guerrero';

SELECT * FROM suscriptor;

CREATE TABLE diario(
	codigo_diario VARCHAR(5) PRIMARY KEY,
	nombre VARCHAR(50),
	precio_unitario NUMERIC(5,2)
);

INSERT INTO diario(codigo_diario,nombre,precio_unitario)
VALUES('101','La Republica',3.50);


INSERT INTO diario(codigo_diario,nombre,precio_unitario)
VALUES('102','El comercio',4.50);

INSERT INTO diario(codigo_diario,nombre,precio_unitario)
VALUES('103','Depor',0.50);

SELECT * FROM diario;

SELECT codigo_diario, nombre,precio_unitario
FROM diario
WHERE codigo_diario = '102';

CREATE TABLE plan_sucripcion(
	codigo_plan VARCHAR(50) PRIMARY KEY,
	titulo VARCHAR(100),
	descripcion VARCHAR(80),
	precio NUMERIC(9,2)
);

CREATE TABLE plan_diario(
	codigo_plan VARCHAR(50),
	codigo_diario VARCHAR(5)
);

ALTER TABLE plan_diario ADD FOREIGN KEY (codigo_plan)
REFERENCES plan_sucripcion(codigo_plan);

ALTER TABLE plan_diario ADD FOREIGN KEY (codigo_diario)
REFERENCES diario(codigo_diario);

INSERT INTO plan_sucripcion(codigo_plan,titulo,descripcion,precio)
VALUES('201','Movistar','Regalando megas',45.90);

INSERT INTO plan_sucripcion(codigo_plan,titulo,descripcion,precio)
VALUES('202','Claro','Regalando celulares',115.90);

INSERT INTO plan_sucripcion(codigo_plan,titulo,descripcion,precio)
VALUES('203','Entel','Regalando chips',15.90);


-- Para la tabla diario

INSERT INTO plan_diario(codigo_plan,codigo_diario)
VALUES('202','103');

INSERT INTO plan_diario(codigo_plan,codigo_diario)
VALUES('201','102');

INSERT INTO plan_diario(codigo_plan,codigo_diario)
VALUES('203','101');

SELECT * FROM plan_diario;

SELECT ps.codigo_plan,d.codigo_diario,ps.titulo,ps.descripcion,ps.precio 'Precio del plan suscripcion',d.nombre,d.precio_unitario 'Precio unitario de un diario'
FROM diario d JOIN plan_diario pd ON(d.codigo_diario = pd.codigo_diario)
JOIN plan_sucripcion ps ON(pd.codigo_plan = ps.codigo_plan)
WHERE ps.codigo_plan = '203';