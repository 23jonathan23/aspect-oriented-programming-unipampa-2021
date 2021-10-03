package com.sales.online.games.salesonlinegames.Presentation.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import com.sales.online.games.salesonlinegames.Domain.Application.CustomerService;
import com.sales.online.games.salesonlinegames.Domain.Core.Customer;
import com.sales.online.games.salesonlinegames.Domain.Core.Request.CreateCustomerRequest;

@Controller
@RequestMapping("customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        var response = customerService.getAll();

        return new ResponseEntity<>(response ,HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable long customerId) {
        var response = customerService.findById(customerId);

        return response != null
            ? new ResponseEntity<>(response ,HttpStatus.OK)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody @Valid CreateCustomerRequest request) {
        var customer = new Customer();
        
        BeanUtils.copyProperties(request, customer);

        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable long customerId, @RequestBody Customer request) {
        var response = customerService.updateCustomer(customerId, request);

        return response != null
            ? new ResponseEntity<>(response ,HttpStatus.OK)
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");   
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable long customerId) {
        var response = customerService.deleteCustomer(customerId);

        return response.isPresent()
            ? ResponseEntity.status(HttpStatus.OK).body("")
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
    }
}
