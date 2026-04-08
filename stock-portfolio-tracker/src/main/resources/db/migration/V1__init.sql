CREATE TABLE IF NOT EXISTS stock_holdings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    symbol VARCHAR(50) NOT NULL,
    shares INT NOT NULL,
    avg_price DOUBLE NOT NULL,
    current_price DOUBLE NOT NULL
);

INSERT INTO stock_holdings (symbol, shares, avg_price, current_price) VALUES ('AAPL', 10, 150.0, 185.0);
INSERT INTO stock_holdings (symbol, shares, avg_price, current_price) VALUES ('TSLA', 5, 200.0, 175.0);
