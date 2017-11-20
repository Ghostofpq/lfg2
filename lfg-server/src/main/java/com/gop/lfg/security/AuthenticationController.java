package com.gop.lfg.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String createToken(final @RequestBody AuthenticationRequest authenticationRequest)
            throws AuthenticationFailedException {
        return authenticationService.authenticate(authenticationRequest);
    }

}
