CREATE TABLE IF NOT EXISTS pages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL UNIQUE,
    content TEXT NOT NULL
);

INSERT INTO pages (title, slug, content) VALUES ('Home', 'home', '<h1>Welcome</h1>');
INSERT INTO pages (title, slug, content) VALUES ('About', 'about', '<p>Portfolio CMS</p>');
