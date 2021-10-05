CREATE TABLE GamePlatform (
    GameId INTEGER NOT NULL REFERENCES Game(GameId),
    PlatformId INTEGER NOT NULL REFERENCES Platform(PlatformId),
	PRIMARY KEY(GameId, PlatformId)
)