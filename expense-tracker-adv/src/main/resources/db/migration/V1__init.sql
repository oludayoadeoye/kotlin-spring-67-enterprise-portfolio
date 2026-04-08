CREATE TABLE IF NOT EXISTS request_logs (
    id VARCHAR(255) PRIMARY KEY,
    response_body TEXT,
    status_code INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS detailed_expenses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL,
    description TEXT,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS budgets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(100) NOT NULL UNIQUE,
    monthly_limit DOUBLE NOT NULL
);

INSERT INTO budgets (category, monthly_limit) VALUES ('Food', 500.0);
INSERT INTO budgets (category, monthly_limit) VALUES ('Rent', 1200.0);
