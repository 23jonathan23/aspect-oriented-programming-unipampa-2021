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
import com.sales.online.games.salesonlinegames.Infra.Repositories.Entities.CustomerEntity;

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
        CustomerEntity customerEntity = repository.save(modelMapper.map(customer, CustomerEntity.class));
        
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
        
        if (customerEntity.isPresent())
            return Optional.of(modelMapper.map(customerEntity.get(), Customer.class));
        else
            return Optional.empty();
    }

    public List<Customer> getAll() {
        var customers = repository.findAll();

        var response = new ArrayList<Customer>();

        for(var customer : customers)
            response.add(modelMapper.map(customer, Customer.class));

        return response;
    }
}
