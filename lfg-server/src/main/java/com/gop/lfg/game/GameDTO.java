package com.gop.lfg.game;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "games")
public class GameDTO {
    @Id
    private String id;
    private int version;

    @Indexed(unique = true)
    private String name;
    private String description;

    private Integer minPlayers;
    private Integer maxPlayers;
}
