package com.gop.lfg.game;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "games")
public class GameDTO {
    @Id
    private String id;

    private String name;
    private String description;

    private Integer minPlayers;
    private Integer maxPlayers;
}
