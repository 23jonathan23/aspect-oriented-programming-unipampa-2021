CREATE TABLE Address (
    AddressId SERIAL PRIMARY KEY,
    City VARCHAR(40) NOT NULL,
    FederativeUnit VARCHAR(2) NOT NULL,
    PublicPlace VARCHAR(100) NOT NULL,
    ZipCode VARCHAR(10) NOT NULL,
    CreatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)