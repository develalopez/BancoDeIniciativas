-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-08 05:14:42.137

-- tables
-- Table: Likes
CREATE TABLE Likes (
    Users_correo varchar(200)  NOT NULL,
    Sugerencias_id int  NOT NULL,
    CONSTRAINT Likes_pk PRIMARY KEY (Users_correo,Sugerencias_id)
);

-- Table: Sugerencias
CREATE TABLE Sugerencias (
    id int  NOT NULL,
    mensaje varchar(200)  NOT NULL,
    palabras_clave varchar(50)  NOT NULL,
    Users_correo varchar(200)  NOT NULL,
    Tema_id int  NOT NULL,
    fecha_creacion date  NOT NULL,
    fecha_modificacion date  NULL,
    titulo varchar(20)  NOT NULL,
    estado varchar(30)  NOT NULL,
    CONSTRAINT Sugerencias_pk PRIMARY KEY (id)
);

-- Table: Tema
CREATE TABLE Tema (
    id int  NOT NULL,
    tipo varchar(20)  NOT NULL,
    CONSTRAINT Tema_pk PRIMARY KEY (id)
);

-- Table: Users
CREATE TABLE Users (
    correo varchar(200)  NOT NULL,
    nombre varchar(100)  NOT NULL,
    Users_type_id int  NOT NULL,
    CONSTRAINT Users_pk PRIMARY KEY (correo)
);

-- Table: Users_type
CREATE TABLE Users_type (
    id int  NOT NULL,
    type_name varchar(64)  NOT NULL,
    CONSTRAINT Users_type_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Likes_Sugerencias (table: Likes)
ALTER TABLE Likes ADD CONSTRAINT Likes_Sugerencias
    FOREIGN KEY (Sugerencias_id)
    REFERENCES Sugerencias (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Likes_Users (table: Likes)
ALTER TABLE Likes ADD CONSTRAINT Likes_Users
    FOREIGN KEY (Users_correo)
    REFERENCES Users (correo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Sugerencias_Tema (table: Sugerencias)
ALTER TABLE Sugerencias ADD CONSTRAINT Sugerencias_Tema
    FOREIGN KEY (Tema_id)
    REFERENCES Tema (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Sugerencias_Users (table: Sugerencias)
ALTER TABLE Sugerencias ADD CONSTRAINT Sugerencias_Users
    FOREIGN KEY (Users_correo)
    REFERENCES Users (correo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Users_Users_type (table: Users)
ALTER TABLE Users ADD CONSTRAINT Users_Users_type
    FOREIGN KEY (Users_type_id)
    REFERENCES Users_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.



insert into users_type (id,type_name) values (1,'ADMINISTRADOR');
insert into users_type  (id,type_name) values (2,'PERSONAL_PMO');
insert into users_type  (id,type_name) values (3,'PROPONENTE');
insert into users_type (id,type_name) values  (4,'DE_CONSULTA');

select * from users_type;

insert into tema values (1,'tema1');
insert into tema values (2,'tema2');

select * from tema;

insert into users values ('sebastian.goenaga@mail.escuelaing.edu.co','Sebastian Goenaga',1);
insert into users values ('daniel.vela@mail.escuelaing.edu.co','Daniel Vela',2);
insert into users values ('javier.vargas-l@mail.escuelaing.edu.co','Javier Vargas',3);
insert into users values ('david.ramirez-mo@mail.escuelaing.edu.co','David Ramirez',4);

select * from users;

insert into sugerencias values(1,
'crear nueva sala para sistemas ya que las que existen tienen poco espacio','sistemas,sala','daniel.vela@mail.escuelaing.edu.co'
,1,TO_DATE('17/12/2015', 'DD/MM/YYYY'),null,'nueva sala sistemas','EN_ESPERA_DE_REVISION');
select * from sugerencias;
insert into likes values('javier.vargas-l@mail.escuelaing.edu.co',1);
select * from likes;


/*-- foreign keys
ALTER TABLE Likes
    DROP CONSTRAINT Likes_Sugerencias;

ALTER TABLE Likes
    DROP CONSTRAINT Likes_Users;

ALTER TABLE Sugerencias
    DROP CONSTRAINT Sugerencias_Tema;

ALTER TABLE Sugerencias
    DROP CONSTRAINT Sugerencias_Users;

ALTER TABLE Users
    DROP CONSTRAINT Users_Users_type;

-- tables
DROP TABLE Likes;

DROP TABLE Sugerencias;

DROP TABLE Tema;

DROP TABLE Users;

DROP TABLE Users_type;*/
