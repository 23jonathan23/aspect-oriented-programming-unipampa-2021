CREATE TABLE CustomerFavoriteGenre (
    CustomerFavoriteGenreId SERIAL PRIMARY KEY,
    CustomerId INTEGER NOT NULL REFERENCES Customer(CustomerId),
    GameGenreId INTEGER NOT NULL REFERENCES GameGenre(GameGenreId)
)