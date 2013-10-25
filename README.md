Creación de la tabla de SQL necesaria:

create database datasource_conciertos;
use datasource_conciertos;

CREATE TABLE conciertos (
  id_concierto int(32) AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY (id_concierto)
);

CREATE TABLE IF NOT EXISTS entradas (
  id_entrada int auto_increment,
  id_concierto int NOT NULL,
  estado boolean,
  id_tipo varchar(90) DEFAULT NULL,
  cantidad int NOT NULL,
  PRIMARY KEY (id_entrada),
  FOREIGN KEY (id_concierto) REFERENCES conciertos(id_concierto) ON DELETE CASCADE
);

Insertar valores:

INSERT INTO conciertos VALUES(1,'la tortilla');
INSERT INTO conciertos VALUES(2,'el macarron');
INSERT INTO conciertos VALUES(3,'la zola');
INSERT INTO conciertos VALUES(4,'ROC riendose');

INSERT INTO entradas VALUES(1,1,true,'VIP');
INSERT INTO entradas VALUES(2,1,false,'VIP');
INSERT INTO entradas VALUES(3,1,false,'VIP');
INSERT INTO entradas VALUES(4,1,false,'general');
INSERT INTO entradas VALUES(5,1,false,'general');
INSERT INTO entradas VALUES(6,1,true,'general');
INSERT INTO entradas VALUES(7,1,false,'grada');
INSERT INTO entradas VALUES(8,1,true,'grada');