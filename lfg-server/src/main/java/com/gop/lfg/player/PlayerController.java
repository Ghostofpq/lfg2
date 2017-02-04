package com.gop.lfg.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
}
