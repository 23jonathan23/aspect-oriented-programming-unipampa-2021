package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IUserRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.User;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.UserEntity;

@Component
@Primary
public class UserRepository implements IUserRepository {

    private final SpringDataPostgresUserRepository repository;

    public UserRepository(final SpringDataPostgresUserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;
    
    public User insertUser(User user) {
        var userToInsert = modelMapper.map(user, UserEntity.class);

        userToInsert.customer.customerId = user.getCustomerId();
        
        UserEntity userEntity = repository.save(userToInsert);
        
        return modelMapper.map(userEntity, User.class);
    }

    public void deleteUser(User user) {
        repository.delete(modelMapper.map(user, UserEntity.class));
    }

    public Optional<User> findUserById(long userId) {
        Optional<UserEntity> userEntity = repository.findById(userId);
        
        if (userEntity.isPresent())
            return Optional.of(modelMapper.map(userEntity.get(), User.class));
        else
            return Optional.empty();
    }

    public List<User> getAll() {
        var users = repository.findAll();

        var response = new ArrayList<User>();

        for(var user : users)
            response.add(modelMapper.map(user, User.class));

        return response;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<UserEntity> userEntity = repository.findByUsername(username);
        
        if (userEntity.isPresent())
            return Optional.of(modelMapper.map(userEntity.get(), User.class));
        else
            return Optional.empty();
    }
}
