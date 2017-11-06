package com.gop.lfg.user;

import com.gop.lfg.game.GameDTO;
import com.gop.lfg.game.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/users", method = RequestMethod.POST)
    public void createUser(@RequestBody final User user) throws UserAlreadyExistsException {
        userService.create(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/api/users", method = RequestMethod.GET)
    public List<UserDTO> findGames(@RequestParam(name = "name", defaultValue = "") final String login,
                                   @RequestParam(name = "page", defaultValue = "0") final int page,
                                   @RequestParam(name = "size", defaultValue = "10") final int size){
        return userService.find(login, page, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/api/users/{id}", method = RequestMethod.GET)
    public void getUser(@RequestParam final String id) throws UserNotFoundException {
        userService.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam final String id) throws UserNotFoundException {
        userService.deleteById(id);
    }
}
