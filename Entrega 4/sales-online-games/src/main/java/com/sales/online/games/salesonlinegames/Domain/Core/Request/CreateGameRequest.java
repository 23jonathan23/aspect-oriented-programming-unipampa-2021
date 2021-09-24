package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

import lombok.Data;

import java.util.List;

@Data
public class CreateGameRequest {
    @NotBlank
    public String name;

    @NotBlank
    public String description;

    @NotNull
    public GameGenre gameGenre;

    @NotNull
    public List<Platform> platforms;

    @NotBlank
    public String developer;

    @NotNull
    public long price;
}
