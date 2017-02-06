package com.gop.lfg.game;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Value("${database.game.version}")
    private int version;

    @Autowired
    private GameRepository gameRepository;

    public GameDTO create(final Game game) {
        return gameRepository.save(
                GameDTO.builder()
                        .version(version)

                        .name(game.getName())
                        .description(game.getDescription())
                        .minPlayers(game.getMinPlayers())
                        .maxPlayers(game.getMaxPlayers())
                        .build());
    }

    public GameDTO findById(final String id) {
        return gameRepository.findOne(id);
    }

    public GameDTO findByName(final String name) {
        return gameRepository.findByName(name);
    }

    public GameDTO update(final String id, final Game game) throws GameNotFoundException {
        GameDTO gameDTO = gameRepository.findOne(id);
        if (gameDTO == null) {
            throw new GameNotFoundException();
        }

        if (Strings.isNullOrEmpty(game.getName()))
            gameDTO.setName(game.getName());

        if (Strings.isNullOrEmpty(game.getDescription()))
            gameDTO.setDescription(game.getDescription());

        if (game.getMinPlayers() != null)
            gameDTO.setMinPlayers(game.getMinPlayers());

        if (game.getMaxPlayers() != null)
            gameDTO.setMaxPlayers(game.getMaxPlayers());

        return gameRepository.save(gameDTO);
    }

    public void deleteById(final String id) {
        gameRepository.delete(id);
    }
}
