CREATE TABLE MarketplaceUser (
    MarketplaceUserId SERIAL PRIMARY KEY,
    UserName VARCHAR(40) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    UserTypeId INTEGER NOT NULL REFERENCES UserType(UserTypeId),
    CustomerId INTEGER NULL REFERENCES Customer(CustomerId),
    CreatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT username_unique UNIQUE (username)
)