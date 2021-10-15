package com.sales.online.games.salesonlinegames.Domain.Core.Report;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;

public class SalesQuantityPerGenre extends SalesQuantity {
    
    private GameGenre gameGenre;

    public SalesQuantityPerGenre(GameGenre gameGenre) {
        super();
        this.gameGenre = gameGenre;
        sales = 1;
    }

    public GameGenre getGameGenre() {
        return gameGenre;
    }
}
