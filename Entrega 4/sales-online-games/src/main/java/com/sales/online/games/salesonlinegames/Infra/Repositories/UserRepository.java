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
        UserEntity userEntity = repository.save(modelMapper.map(user, UserEntity.class));
        
        return modelMapper.map(userEntity, User.class);
    }

    public User updateUser(long userId, User user) {
        var userEntity = modelMapper.map(user, UserEntity.class);

        userEntity.setUserId(userId);

        repository.save(userEntity);
        
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
}
