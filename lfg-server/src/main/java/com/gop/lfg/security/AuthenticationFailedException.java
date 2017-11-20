package com.gop.lfg.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "AuthenticationFailed")
public class AuthenticationFailedException extends Exception{
}
