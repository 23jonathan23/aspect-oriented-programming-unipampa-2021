package com.sales.online.games.salesonlinegames.Presentation.Configuration;

import com.sales.online.games.salesonlinegames.Domain.Application.GameService;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Presentation.Startup;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Startup.class)
public class BeanConfiguration {

    @Bean
    GameService gameService(IGameRepository gameRepository) {
        return new GameService(gameRepository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
