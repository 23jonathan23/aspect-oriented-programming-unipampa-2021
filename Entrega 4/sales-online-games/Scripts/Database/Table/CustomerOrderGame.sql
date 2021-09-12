CREATE TABLE CustomerOrderGame (
    CustomerOrderGameId SERIAL PRIMARY KEY,
    CustomerOrderId INTEGER NOT NULL REFERENCES CustomerOrder(CustomerOrderId),
    GameId INTEGER NOT NULL REFERENCES Game(GameId)
)