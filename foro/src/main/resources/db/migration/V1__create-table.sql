-- Creación de la tabla 'topicos'
CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    autor VARCHAR(50) NOT NULL,
    status tinyint not null
);