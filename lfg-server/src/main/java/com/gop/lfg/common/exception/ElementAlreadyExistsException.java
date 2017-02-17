package com.gop.lfg.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Element already exists")
public class ElementAlreadyExistsException extends Exception {
    private String element;

    public ElementAlreadyExistsException(final String element, final String message) {
        super(message);
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
