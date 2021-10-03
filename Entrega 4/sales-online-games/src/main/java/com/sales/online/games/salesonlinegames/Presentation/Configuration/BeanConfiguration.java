package com.sales.online.games.salesonlinegames.Presentation.Configuration;

import com.sales.online.games.salesonlinegames.Domain.Application.AuthenticationService;
import com.sales.online.games.salesonlinegames.Domain.Application.CustomerService;
import com.sales.online.games.salesonlinegames.Domain.Application.GameService;
import com.sales.online.games.salesonlinegames.Domain.Application.OrderService;
import com.sales.online.games.salesonlinegames.Domain.Application.UserService;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.ICustomerRepository;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IOrderRepository;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IUserRepository;
import com.sales.online.games.salesonlinegames.Presentation.Startup;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackageClasses = Startup.class)
public class BeanConfiguration {

    @Bean
    GameService gameService(IGameRepository gameRepository) {
        return new GameService(gameRepository);
    }

    @Bean
    OrderService orderService(IOrderRepository orderRepository, IGameRepository gameRepository) {
        return new OrderService(orderRepository, gameRepository);
    }

    @Bean
    CustomerService customerService(ICustomerRepository customerRepository) {
        return new CustomerService(customerRepository);
    }

    @Bean
    UserService userService(IUserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    AuthenticationService authenticationService(IUserRepository userRepository) {
        return new AuthenticationService(userRepository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
