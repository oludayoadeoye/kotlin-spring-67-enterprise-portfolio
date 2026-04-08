CREATE TABLE IF NOT EXISTS exchange_rates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    currency_pair VARCHAR(50) NOT NULL UNIQUE,
    rate DOUBLE NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO exchange_rates (currency_pair, rate) VALUES ('USD_EUR', 0.92);
INSERT INTO exchange_rates (currency_pair, rate) VALUES ('EUR_USD', 1.09);
INSERT INTO exchange_rates (currency_pair, rate) VALUES ('USD_GBP', 0.79);
