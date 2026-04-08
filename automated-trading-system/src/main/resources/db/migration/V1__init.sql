CREATE TABLE IF NOT EXISTS order_book_entries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    symbol VARCHAR(50) NOT NULL,
    side VARCHAR(10) NOT NULL, -- "BID", "ASK"
    price DOUBLE NOT NULL,
    quantity DOUBLE NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO order_book_entries (symbol, side, price, quantity) VALUES ('BTC_USD', 'BID', 65000.0, 0.5);
INSERT INTO order_book_entries (symbol, side, price, quantity) VALUES ('BTC_USD', 'ASK', 65100.0, 1.2);
