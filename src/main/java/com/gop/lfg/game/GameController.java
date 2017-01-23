package com.gop.lfg.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/games")
public class GameController {
    @Autowired
    private GameService gameService;

}
