package com.gop.lfg.player;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "players")
public class PlayerDTO {
    @Id
    private String id;
    private int version;

    @Indexed(unique = true)
    private String pseudo;

    private Set<String> ownedGames;
    private Set<String> favouriteGames;
}
