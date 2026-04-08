CREATE TABLE IF NOT EXISTS flashcards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question TEXT NOT NULL,
    answer TEXT NOT NULL,
    category VARCHAR(100) NOT NULL
);

INSERT INTO flashcards (question, answer, category) VALUES ('What is Hexagonal Architecture?', 'Separation of concerns using ports and adapters.', 'Architecture');
