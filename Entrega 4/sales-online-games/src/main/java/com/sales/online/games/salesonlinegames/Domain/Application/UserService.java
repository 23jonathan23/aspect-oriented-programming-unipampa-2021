package com.sales.online.games.salesonlinegames.Domain.Application;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IUserRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.User;

public class UserService {
    
    private final IUserRepository userRepository;

    public UserService(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User findById(long userId) {
        Optional<User> user = userRepository.findUserById(userId);

        if(user.isPresent())
            return user.get();

        return null;
    }

    public User createUser(User user) {

        return userRepository.insertUser(user);
    }

    public User updateUser(long userId, User updatedUser) {
        Optional<User> user = userRepository.findUserById(userId);
        
        if(user.isPresent())
            return userRepository.updateUser(userId, updatedUser);
        
        return null;
    }

    public OptionalLong deleteUser(long userId) {
        Optional<User> user = userRepository.findUserById(userId);
        
        if(user.isPresent()) {
            userRepository.deleteUser(user.get());
            return OptionalLong.of(userId);
        }
        
        return OptionalLong.empty();
    }
}