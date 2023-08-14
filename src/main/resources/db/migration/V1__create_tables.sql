CREATE TABLE Countries
(
    country_id UUID PRIMARY KEY,
    name       VARCHAR(64) NOT NULL,
    population int
) AS SELECT * FROM CSVREAD('../capgeminispring/src/main/resources/db/migration/countries_data.csv') ;

CREATE TABLE States
(
    state_id   UUID PRIMARY KEY,
    name       VARCHAR(64) NOT NULL,
    population int,
    country_id UUID        NOT NULL,
    CONSTRAINT states_countries_fk FOREIGN KEY (country_id) REFERENCES Countries (country_id)
) AS SELECT * FROM CSVREAD('../capgeminispring/src/main/resources/db/migration/states_data.csv');

CREATE TABLE Cities
(
    city_id    UUID PRIMARY KEY,
    country_id UUID        NOT NULL,
    state_id   UUID,
    name       VARCHAR(64) NOT NULL,
    population int,
    CONSTRAINT cities_countries_fk FOREIGN KEY (country_id) REFERENCES Countries (country_id),
    CONSTRAINT cities_states_fk FOREIGN KEY (state_id) REFERENCES States (state_id)
) AS SELECT * FROM CSVREAD('../capgeminispring/src/main/resources/db/migration/cities_data.csv');

CREATE TABLE Addresses
(
    address_id  UUID PRIMARY KEY,
    country_id  UUID         NOT NULL,
    city_id     UUID         NOT NULL,
    state_id    UUID,
    address     varchar(128) NOT NULL,
    postal_code varchar(16),
    CONSTRAINT addresses_countries_fk FOREIGN KEY (country_id) REFERENCES Countries (country_id),
    CONSTRAINT addresses_cities_fk FOREIGN KEY (city_id) REFERENCES Cities (city_id),
    CONSTRAINT addresses_states_fk FOREIGN KEY (state_id) REFERENCES States (state_id)
);

CREATE TABLE Customers
(
    customer_id UUID PRIMARY KEY,
    name        VARCHAR(64)              NOT NUll,
    surname     VARCHAR(64)              NOT NULL,
    email       VARCHAR(320)             NOT NULL UNIQUE,
    created     TIMESTAMP WITH TIME ZONE NOT NULL,
    updated     TIMESTAMP WITH TIME ZONE,
    address_id  UUID,
    CONSTRAINT customers_addresses_fk FOREIGN KEY (address_id) REFERENCES Addresses (address_id)
);
