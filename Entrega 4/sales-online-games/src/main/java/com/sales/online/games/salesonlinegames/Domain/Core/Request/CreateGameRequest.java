package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

import java.util.List;

public class CreateGameRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private GameGenre gameGenre;

    @NotBlank
    private List<Platform> platforms;

    @NotBlank
    private String developer;

    @NotBlank
    private long price;
}
