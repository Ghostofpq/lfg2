package com.gop.lfg.event;


import com.gop.lfg.game.Game;
import com.gop.lfg.player.Player;

import java.time.LocalDateTime;
import java.util.Set;

public class Event {
    private String title;
    private String description;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Set<Game> games;
    private Set<Player> owners;
    private Set<Player> participants;
}
