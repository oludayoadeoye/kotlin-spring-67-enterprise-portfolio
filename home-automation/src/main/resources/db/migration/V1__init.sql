CREATE TABLE IF NOT EXISTS devices (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    status VARCHAR(50) DEFAULT 'Off'
);

INSERT INTO devices (name, type, status) VALUES ('Living Room Light', 'Light', 'Off');
INSERT INTO devices (name, type, status) VALUES ('Kitchen AC', 'AC', 'Off');
