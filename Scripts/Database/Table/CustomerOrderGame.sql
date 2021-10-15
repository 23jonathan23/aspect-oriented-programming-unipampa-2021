CREATE TABLE CustomerOrderGame (
    CustomerOrderId INTEGER NOT NULL REFERENCES CustomerOrder(CustomerOrderId),
    GameId INTEGER NOT NULL REFERENCES Game(GameId),
	PRIMARY KEY(CustomerOrderId, GameId)
)