package com.gop.lfg.security;

import com.gop.lfg.user.UserDTO;
import com.gop.lfg.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class UserAuthenticationService implements AuthenticationProvider {
    private final UserService userService;
    private final ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    public UserAuthenticationService(final UserService userService) {
        shaPasswordEncoder = new ShaPasswordEncoder();
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String login = (String) authentication.getPrincipal();
        final String password = (String) authentication.getCredentials();

        final UserDTO user = userService.findOneByLogin(login);
        if (user == null ||
                !shaPasswordEncoder.encodePassword(password, user.getSalt()).equals(user.getPassword())) {
            throw new AuthenticationFailedException("invalid password");
        }
        return new UsernamePasswordAuthenticationToken(user.getLogin(), null, null);
    }

    @Override
    public boolean supports(final Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
