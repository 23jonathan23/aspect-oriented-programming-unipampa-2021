package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sales.online.games.salesonlinegames.Domain.Core.Card;
import com.sales.online.games.salesonlinegames.Domain.Core.Game;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.PaymentMethod;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    @NotNull
    public List<Long> gameIds;

    @NotNull
    public Card card;

    @NotNull
    public PaymentMethod paymentMethod;

    @NotNull
    public int installment;

    @NotBlank
    public String coupon;

    @NotNull
    public long customerId;
}
