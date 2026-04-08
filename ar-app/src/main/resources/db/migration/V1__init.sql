CREATE TABLE IF NOT EXISTS ar_anchors (
    id VARCHAR(255) PRIMARY KEY,
    x DOUBLE NOT NULL,
    y DOUBLE NOT NULL,
    z DOUBLE NOT NULL,
    asset VARCHAR(255) NOT NULL
);

INSERT INTO ar_anchors (id, x, y, z, asset) VALUES ('1', 0.0, 1.2, -0.5, 'virtual_statue');
INSERT INTO ar_anchors (id, x, y, z, asset) VALUES ('2', 1.5, 0.0, 2.0, 'info_panel');
