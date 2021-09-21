package com.sales.online.games.salesonlinegames.Presentation.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class GameController {
    @GetMapping(value="/{name}")
    public String getMethodName(@PathVariable String name) {
        return "Olá " + name;
    }
}
