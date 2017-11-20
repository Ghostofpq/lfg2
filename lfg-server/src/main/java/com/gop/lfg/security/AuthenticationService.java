package com.gop.lfg.security;

import com.gop.lfg.user.UserDTO;
import com.gop.lfg.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {
    private UserService userService;
    private ShaPasswordEncoder shaPasswordEncoder;

    private static final String SECRET = "boblebricoleur";
    private static final long EXPIRATIONTIME = 3_600_000; // 1h

    @Autowired
    public AuthenticationService(UserService userService) {
        shaPasswordEncoder = new ShaPasswordEncoder();
        this.userService = userService;
    }

    public String authenticate(AuthenticationRequest request) throws AuthenticationFailedException {
        final UserDTO user = userService.findOneByLogin(request.getLogin());
        if (user == null ||
                !shaPasswordEncoder.encodePassword(request.getPassword(), user.getSalt()).equals(user.getPassword())) {
            throw new AuthenticationFailedException();
        }

        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
    }
}
