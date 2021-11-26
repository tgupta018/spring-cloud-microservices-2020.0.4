CREATE TABLE exchange_value (
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    currency_from VARCHAR(20) NOT NULL,
    currency_to VARCHAR(20) NOT NULL,
    conversion_multiple DECIMAL(20, 2),
    port INTEGER NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE currency_exchange (
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    currency_from VARCHAR(20) NOT NULL,
    currency_to VARCHAR(20) NOT NULL,
    conversion_multiple DECIMAL(20, 2),
    environment VARCHAR2(10) NULL,
    PRIMARY KEY (id)
);
