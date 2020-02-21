DROP TABLE IF EXISTS exchange_rate;

CREATE TABLE exchange_rate (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  from_coin VARCHAR(250) NOT NULL,
  to_coin VARCHAR(250) NOT NULL,
  rate DECIMAL(4, 2) DEFAULT NULL
);

CREATE UNIQUE INDEX UQ_FROMTO_COLUMN ON exchange_rate
(
    from_coin, to_coin
);

INSERT INTO exchange_rate(from_coin, to_coin, rate) VALUES
('USD', 'PEN', 3.46),
('BRL', 'PEN', 1.77);
