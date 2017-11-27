package com.gop.lfg.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class TokenAuthenticationService {
    static private final long EXPIRATIONTIME = 864_000_000;
    static private final String SECRET = "ThisIsASecret";
    static private final String TOKEN_PREFIX = "Bearer";
    static private final String HEADER_STRING = "Authorization";

    static void addAuthentication(final HttpServletResponse res, final String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    static UsernamePasswordAuthenticationToken getAuthentication(final HttpServletRequest req) {
        final String token = req.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            final String userLogin = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (userLogin != null) {
                return new UsernamePasswordAuthenticationToken(userLogin, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
