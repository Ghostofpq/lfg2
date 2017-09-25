package com.gop.lfg.user;

import com.gop.lfg.game.Game;
import com.gop.lfg.game.GameAlreadyExistsException;
import com.gop.lfg.game.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userRepository;

    @Autowired
    public UserController(final UserService userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/users/create", method = RequestMethod.POST)
    public void createUser(@RequestBody final String encodedString) throws UserAlreadyExistsException {
        User user = new User();



        userRepository.create(user);
    }
}
