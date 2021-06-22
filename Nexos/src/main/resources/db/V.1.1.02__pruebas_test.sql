CREATE TABLE IF NOT EXISTS cargo (
	codigo serial,
	nombre text not null unique,
	estado boolean  default true,
	PRIMARY KEY(codigo)
);


CREATE TABLE IF NOT EXISTS usuario (
	codigo serial,
	nombre text not null unique,
	fecha_nacimiento date not null,

	cargo_codigo integer,
	fecha_ingreso date not null,
	estado boolean  default true,
	PRIMARY KEY(codigo),
	   CONSTRAINT fk_cargo
	      FOREIGN KEY(cargo_codigo) 
		  REFERENCES cargo(codigo)
);


CREATE TABLE IF NOT EXISTS producto (
	codigo serial,
	nombre text not null unique,
	cantidad integer not null,

	creador_codigo integer,
	fecha_ingreso date not null,

	PRIMARY KEY(codigo),
	   CONSTRAINT fk_creador
	      FOREIGN KEY(creador_codigo) 
		  REFERENCES usuario(codigo)
);

insert into cargo (codigo, nombre) 
values(1, 'Asesor de ventas'),
(2, 'Administrador'),
(3, 'Soporte');

insert into usuario (nombre, fecha_nacimiento, cargo_codigo, fecha_ingreso) values
('Arthuro Suarez', '1989-08-31', 2, '2021-06-15'),
('Carlos Suarez', '1980-02-01', 1, '2021-06-15'),
('Andrea Varón', '1989-10-31', 1, '2021-06-15');

insert into producto (codigo, nombre, cantidad, creador_codigo, fecha_ingreso) values
(1, 'Motor',  20, 1, '2021-06-15'),
(2, 'Parabrisas',  30, 1, '2021-01-15'),
(3, 'Puertas',  40, 1, '2021-06-01'),

(4, 'Rin',  50, 1, '2021-01-01'),
(5, 'Neumatico',  60, 1, '2021-01-01'),
(6, 'Radiador',  70, 1, '2021-01-01');






