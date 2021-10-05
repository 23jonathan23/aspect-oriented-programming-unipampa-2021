CREATE TABLE CustomerFavoriteGenre (
    CustomerId INTEGER NOT NULL REFERENCES Customer(CustomerId),
    GameGenreId INTEGER NOT NULL REFERENCES GameGenre(GameGenreId),
	PRIMARY KEY(CustomerId, GameGenreId)
)