CREATE TABLE GamePlatform (
    GamePlatformId SERIAL PRIMARY KEY,
    GameId INTEGER NOT NULL REFERENCES Game(GameId),
    PlatformId INTEGER NOT NULL REFERENCES Platform(PlatformId)
)