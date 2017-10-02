package com.gop.lfg.user;

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
    public void createUser(@RequestBody final User user) throws UserAlreadyExistsException {
        userRepository.create(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public void getUser(@RequestParam final String id) throws UserNotFoundException {
        userRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam final String id) throws UserNotFoundException {
        userRepository.deleteById(id);
    }
}
