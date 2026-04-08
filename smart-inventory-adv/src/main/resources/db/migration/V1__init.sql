CREATE TABLE IF NOT EXISTS stock_levels (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(100) NOT NULL UNIQUE,
    current_stock INT NOT NULL,
    min_threshold INT NOT NULL,
    needs_restock BOOLEAN DEFAULT FALSE,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO stock_levels (sku, current_stock, min_threshold, needs_restock) VALUES ('SKU-99', 5, 10, TRUE);
INSERT INTO stock_levels (sku, current_stock, min_threshold, needs_restock) VALUES ('SKU-101', 50, 20, FALSE);
