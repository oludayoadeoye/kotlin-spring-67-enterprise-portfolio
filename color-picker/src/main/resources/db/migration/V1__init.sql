CREATE TABLE IF NOT EXISTS colors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    hex VARCHAR(10) NOT NULL UNIQUE,
    r INT NOT NULL,
    g INT NOT NULL,
    b INT NOT NULL
);

INSERT INTO colors (name, hex, r, g, b) VALUES ('Red', '#FF0000', 255, 0, 0);
INSERT INTO colors (name, hex, r, g, b) VALUES ('Green', '#00FF00', 0, 255, 0);
INSERT INTO colors (name, hex, r, g, b) VALUES ('Blue', '#0000FF', 0, 0, 255);
