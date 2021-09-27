package com.sales.online.games.salesonlinegames.Domain.Application.Ports;

import com.sales.online.games.salesonlinegames.Domain.Core.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    User insertUser(User user);

    User updateUser(long id, User user);

    void deleteUser(User user);

    Optional<User> findUserById(long userId);

    List<User> getAll();
}
