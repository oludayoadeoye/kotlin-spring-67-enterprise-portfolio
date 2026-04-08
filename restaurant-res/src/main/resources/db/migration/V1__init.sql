CREATE TABLE IF NOT EXISTS reservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    table_number INT NOT NULL,
    date_time TIMESTAMP NOT NULL,
    guests INT NOT NULL
);
