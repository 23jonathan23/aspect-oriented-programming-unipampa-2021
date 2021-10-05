CREATE TABLE CustomerPlatform (
    CustomerId INTEGER NOT NULL REFERENCES Customer (CustomerId),
    PlatformId INTEGER NOT NULL REFERENCES Platform(PlatformId),
	PRIMARY KEY(CustomerId, PlatformId)
)