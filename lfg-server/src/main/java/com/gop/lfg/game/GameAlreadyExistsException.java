package com.gop.lfg.game;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Game already exists")
public class GameAlreadyExistsException extends Exception{
}
