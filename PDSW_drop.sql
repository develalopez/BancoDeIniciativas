-- Created by Vertabelo (http://vertabelo.com)
<<<<<<< HEAD
-- Last modification date: 2018-11-21 04:03:28.493
=======
-- Last modification date: 2018-11-22 02:26:08.186
>>>>>>> Implementacion arreglo BaseDatos 1

-- foreign keys
ALTER TABLE comentario
    DROP CONSTRAINT comentario_sugerencias;

ALTER TABLE comentario
    DROP CONSTRAINT comentario_users;

ALTER TABLE likes
    DROP CONSTRAINT likes_sugerencias;

ALTER TABLE likes
    DROP CONSTRAINT likes_users;

ALTER TABLE sugerencias
    DROP CONSTRAINT sugerencias_users;

-- tables
DROP TABLE comentario;

DROP TABLE likes;

DROP TABLE sugerencias;

DROP TABLE users;

-- End of file.
