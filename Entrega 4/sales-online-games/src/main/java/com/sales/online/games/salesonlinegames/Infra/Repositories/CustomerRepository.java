package com.sales.online.games.salesonlinegames.Infra.Repositories;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.ICustomerRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Customer;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.GameGenre;
import com.sales.online.games.salesonlinegames.Domain.Core.Enuns.Platform;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.CustomerEntity;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.GameGenreEntity;
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.PlatformEntity;

@Component
@Primary
public class CustomerRepository implements ICustomerRepository {

    private final SpringDataPostgresCustomerRepository repository;

    public CustomerRepository(final SpringDataPostgresCustomerRepository repository) {
        this.repository = repository;
    }

    @Autowired
    ModelMapper modelMapper;
    
    public Customer insertCustomer(Customer customer) {
        var customerToInsert = modelMapper.map(customer, CustomerEntity.class);

        var favoriteGenresEntity = new ArrayList<GameGenreEntity>();

        for(var favoriteGenre : customer.getFavoriteGenres()) {
            var favoriteGenreEntity = new GameGenreEntity();
            favoriteGenreEntity.gamegenreid = favoriteGenre.value;
            
            favoriteGenresEntity.add(favoriteGenreEntity);
        }

        customerToInsert.favoriteGenres = favoriteGenresEntity;

        var platformsEntity = new ArrayList<PlatformEntity>();

        for(var platform : customer.getPlatforms()) {
            var platformEntity = new PlatformEntity();
            platformEntity.platformid = platform.value;
            
            platformsEntity.add(platformEntity);
        }

        customerToInsert.platforms = platformsEntity;

        CustomerEntity customerEntity = repository.save(customerToInsert);
        
        return modelMapper.map(customerEntity, Customer.class);
    }

    public Customer updateCustomer(long customerId, Customer customer) {
        var customerEntity = modelMapper.map(customer, CustomerEntity.class);

        customerEntity.setCustomerId(customerId);

        repository.save(customerEntity);
        
        return modelMapper.map(customerEntity, Customer.class);
    }

    public void deleteCustomer(Customer customer) {
        repository.delete(modelMapper.map(customer, CustomerEntity.class));
    }

    public Optional<Customer> findCustomerById(long customerId) {
        Optional<CustomerEntity> customerEntity = repository.findById(customerId);
        
        if (customerEntity.isPresent()) {
            var customer = modelMapper.map(customerEntity.get(), Customer.class);
            customer.setPlatforms(mapPlatformEntityToPlatformEnum(customerEntity.get().platforms));
            customer.setFavoriteGenres(mapGameGenreEntityToGameGenreEnum(customerEntity.get().favoriteGenres));
            
            return Optional.of(customer);
        }
        
        return Optional.empty();
    }

    public List<Customer> getAll() {
        var customersEntity = repository.findAll();

        var response = new ArrayList<Customer>();

        for(var customerEntity : customersEntity) {
            var platforms = mapPlatformEntityToPlatformEnum(customerEntity.platforms);
            var favoriteGenres = mapGameGenreEntityToGameGenreEnum(customerEntity.favoriteGenres);
            
            var customer = modelMapper.map(customerEntity, Customer.class);
            customer.setPlatforms(platforms);
            customer.setFavoriteGenres(favoriteGenres);

            response.add(customer);
        }

        return response;
    }

    private List<Platform> mapPlatformEntityToPlatformEnum(List<PlatformEntity> platformsEntity) {
        var platforms = new ArrayList<Platform>();

        for(var platformEntity : platformsEntity) 
            platforms.add(Platform.values()[platformEntity.platformid.intValue()]);
        
        return platforms;
    }

    private List<GameGenre> mapGameGenreEntityToGameGenreEnum(List<GameGenreEntity> favoriteGenresEntity) {
        var gameGenres = new ArrayList<GameGenre>();

        for(var favoriteGenreEntity : favoriteGenresEntity) 
            gameGenres.add(GameGenre.values()[favoriteGenreEntity.gamegenreid.intValue()]);
        
        return gameGenres;
    }
}
