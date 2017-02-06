package com.gop.lfg.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String name;
    private String description;
    private Integer minPlayers;
    private Integer maxPlayers;
}
