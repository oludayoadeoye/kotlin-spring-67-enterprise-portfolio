CREATE TABLE IF NOT EXISTS questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(1024) NOT NULL,
    options TEXT NOT NULL, -- Stored as comma-separated or JSON
    correct_answer INT NOT NULL
);

INSERT INTO questions (text, options, correct_answer) VALUES ('What is Kotlin?', 'Language,Fruit,Planet', 0);
INSERT INTO questions (text, options, correct_answer) VALUES ('Spring Boot is based on?', 'Java,Python,Ruby', 0);
