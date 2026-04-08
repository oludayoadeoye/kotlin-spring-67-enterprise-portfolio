CREATE TABLE IF NOT EXISTS job_postings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    salary_range VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO job_postings (title, company, description, salary_range) VALUES ('Senior Kotlin Developer', 'TechCorp', 'Expert in Spring Boot 3', '$120k - $150k');
