CREATE TABLE IF NOT EXISTS patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    medical_history TEXT
);

CREATE TABLE IF NOT EXISTS appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    doctor_name VARCHAR(255) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);
