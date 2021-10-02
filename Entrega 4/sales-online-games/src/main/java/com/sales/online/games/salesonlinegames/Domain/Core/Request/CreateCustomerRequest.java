package com.sales.online.games.salesonlinegames.Domain.Core.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sales.online.games.salesonlinegames.Domain.Core.Address;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateCustomerRequest {
    @NotBlank
    public String name;

    @NotBlank
    public String email;

    @NotNull
    public LocalDate birthDate;

    @NotNull
    public List<Platform> platforms;

    @NotNull
    public List<GameGenre> favoriteGenres;

    @NotNull
    public Address address;
}