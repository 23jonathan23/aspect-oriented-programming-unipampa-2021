package com.sales.online.games.salesonlinegames.Presentation.Configuration;

import com.sales.online.games.salesonlinegames.Domain.Application.GameService;
import com.sales.online.games.salesonlinegames.Domain.Application.Ports.IGameRepository;
import com.sales.online.games.salesonlinegames.Infra.Repositories.GamePlatformRepository;
import com.sales.online.games.salesonlinegames.Presentation.Startup;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Startup.class)
public class BeanConfiguration {

    @Bean
    GameService gameService(IGameRepository gameRepository, GamePlatformRepository gamePlatformRepository) {
        return new GameService(gameRepository, gamePlatformRepository);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
