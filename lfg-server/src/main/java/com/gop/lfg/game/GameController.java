package com.gop.lfg.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class GameController {
    @Autowired
    private GameService gameService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/games", method = RequestMethod.POST)
    public GameDTO createGame(@RequestBody final Game gameCreationRequest) throws GameAlreadyExistsException {
        return gameService.create(gameCreationRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public List<GameDTO> findGames(@RequestParam(name = "name", defaultValue = "") final String name,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "10") int size) throws GameNotFoundException {
        return gameService.findGames(name, page, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/game/{gameId}", method = RequestMethod.GET)
    public GameDTO getGame(@PathVariable("gameId") final String id) throws GameNotFoundException {
        return gameService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/game/{gameId}", method = RequestMethod.PUT)
    public GameDTO updateGame(@PathVariable("gameId") final String id, @RequestBody final Game gameUpdateRequest) throws GameNotFoundException {
        return gameService.update(id, gameUpdateRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/game/{gameId}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable("gameId") final String id) throws GameNotFoundException {
        gameService.deleteById(id);
    }

}
