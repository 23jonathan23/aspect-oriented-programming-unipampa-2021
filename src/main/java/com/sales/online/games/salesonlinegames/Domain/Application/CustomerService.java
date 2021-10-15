package com.sales.online.games.salesonlinegames.Domain.Application;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import com.sales.online.games.salesonlinegames.Domain.Application.Ports.ICustomerRepository;
import com.sales.online.games.salesonlinegames.Domain.Core.Customer;

public class CustomerService {
    
    private final ICustomerRepository customerRepository;

    public CustomerService(final ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    public Customer findById(long customerId) {
        Optional<Customer> customer = customerRepository.findCustomerById(customerId);

        if(customer.isPresent())
            return customer.get();

        return null;
    }

    public Customer createCustomer(Customer customer) {

        return customerRepository.insertCustomer(customer);
    }

    public Customer updateCustomer(long customerId, Customer updatedCustomer) {
        Optional<Customer> customer = customerRepository.findCustomerById(customerId);
        
        if(customer.isPresent())
            return customerRepository.updateCustomer(customerId, updatedCustomer);
        
        return null;
    }

    public OptionalLong deleteCustomer(long customerId) {
        Optional<Customer> customer = customerRepository.findCustomerById(customerId);
        
        if(customer.isPresent()) {
            customerRepository.deleteCustomer(customer.get());
            return OptionalLong.of(customerId);
        }
        
        return OptionalLong.empty();
    }
}