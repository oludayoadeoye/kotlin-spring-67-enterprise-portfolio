CREATE TABLE IF NOT EXISTS site_projects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS skills (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    level VARCHAR(50) NOT NULL
);

INSERT INTO site_projects (title, description, url) VALUES ('Rust Portfolio', '67 backend projects in Rust', 'https://github.com/...');
INSERT INTO skills (name, level) VALUES ('Kotlin', 'Expert');
INSERT INTO skills (name, level) VALUES ('Java', 'Expert');
