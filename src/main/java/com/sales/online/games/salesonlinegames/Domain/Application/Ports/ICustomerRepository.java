package com.sales.online.games.salesonlinegames.Domain.Application.Ports;

import com.sales.online.games.salesonlinegames.Domain.Core.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    Customer insertCustomer(Customer customer);

    Customer updateCustomer(long id, Customer customer);

    void deleteCustomer(Customer customer);

    Optional<Customer> findCustomerById(long customerId);

    List<Customer> getAll();
    
}
