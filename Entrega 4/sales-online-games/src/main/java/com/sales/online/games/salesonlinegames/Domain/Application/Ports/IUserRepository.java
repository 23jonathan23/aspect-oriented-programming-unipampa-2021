package com.sales.online.games.salesonlinegames.Domain.Application.Ports;

import com.sales.online.games.salesonlinegames.Domain.Core.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    User insertUser(User user);

    void deleteUser(User user);

    Optional<User> findUserById(long userId);

    Optional<User> findUserByUsername(String username);

    List<User> getAll();
}
