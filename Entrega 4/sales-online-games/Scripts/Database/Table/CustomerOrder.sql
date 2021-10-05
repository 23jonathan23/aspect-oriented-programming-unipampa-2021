CREATE TABLE CustomerOrder (
    CustomerOrderId SERIAL PRIMARY KEY,
    CardHolderName VARCHAR(40) NOT NULL,
    CardNumber VARCHAR(20) NOT NULL,
    Installment INTEGER NOT NULL,
    AmountInCents BIGINT NOT NULL,
    PaymentMethodId INTEGER NOT NULL REFERENCES PaymentMethod(PaymentMethodId),
    CustomerId INTEGER NOT NULL REFERENCES Customer(CustomerId),
    PurchaseDate DATE NOT NULL,
    OrderStatusId INTEGER NOT NULL REFERENCES OrderStatus(OrderStatusId),
    Coupon VARCHAR(10) NULL,
    CreatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)