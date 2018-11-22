-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-21 04:03:28.493

-- tables
-- Table: comentario
CREATE TABLE comentario (
    id int  NOT NULL,
    sugerencias_id int  NOT NULL,
    fecha_creacion date  NOT NULL,
    fecha_modificacion date  NOT NULL,
    mensaje varchar(200)  NOT NULL,
    users_correo varchar(200)  NOT NULL,
    CONSTRAINT comentario_pk PRIMARY KEY (id)
);

-- Table: likes
CREATE TABLE likes (
    users_correo varchar(200)  NOT NULL,
    sugerencias_id int  NOT NULL,
    CONSTRAINT likes_pk PRIMARY KEY (users_correo,sugerencias_id)
);

-- Table: sugerencias
CREATE TABLE sugerencias (
    id int  NOT NULL,
    mensaje varchar(200)  NOT NULL,
    palabras_clave varchar(200)  NOT NULL,
    tema varchar(50)  NOT NULL,
    fecha_creacion date  NOT NULL,
    fecha_modificacion date  NOT NULL,
    titulo varchar(50)  NOT NULL,
    estado varchar(20)  NOT NULL,
    users_correo varchar(200)  NOT NULL,
    CONSTRAINT sugerencias_pk PRIMARY KEY (id)
);

-- Table: users
CREATE TABLE users (
    correo varchar(200)  NOT NULL,
    nombre varchar(100)  NOT NULL,
    user_type_id varchar(20)  NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (correo)
);

-- foreign keys
-- Reference: comentario_sugerencias (table: comentario)
ALTER TABLE comentario ADD CONSTRAINT comentario_sugerencias
    FOREIGN KEY (sugerencias_id)
    REFERENCES sugerencias (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: comentario_users (table: comentario)
ALTER TABLE comentario ADD CONSTRAINT comentario_users
    FOREIGN KEY (users_correo)
    REFERENCES users (correo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: likes_sugerencias (table: likes)
ALTER TABLE likes ADD CONSTRAINT likes_sugerencias
    FOREIGN KEY (sugerencias_id)
    REFERENCES sugerencias (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: likes_users (table: likes)
ALTER TABLE likes ADD CONSTRAINT likes_users
    FOREIGN KEY (users_correo)
    REFERENCES users (correo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: sugerencias_users (table: sugerencias)
ALTER TABLE sugerencias ADD CONSTRAINT sugerencias_users
    FOREIGN KEY (users_correo)
    REFERENCES users (correo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

