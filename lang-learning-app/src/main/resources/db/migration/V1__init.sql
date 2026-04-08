CREATE TABLE IF NOT EXISTS vocabulary (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    word VARCHAR(255) NOT NULL,
    translation VARCHAR(255) NOT NULL,
    level VARCHAR(50) NOT NULL
);

INSERT INTO vocabulary (word, translation, level) VALUES ('Haus', 'House', 'A1');
INSERT INTO vocabulary (word, translation, level) VALUES ('Garten', 'Garden', 'A1');
