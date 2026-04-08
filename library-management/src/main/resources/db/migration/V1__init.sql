CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) NOT NULL UNIQUE,
    available BOOLEAN DEFAULT TRUE
);

INSERT INTO books (title, isbn, available) VALUES ('Kotlin in Action', '978-1617293290', TRUE);
INSERT INTO books (title, isbn, available) VALUES ('Spring Boot in Action', '978-1617292545', TRUE);
