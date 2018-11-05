-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-11-01 17:17:38.041

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
/*
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

*/