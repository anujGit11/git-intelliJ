package com.lcwd.user.service.exceptions;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String s) {
        super(s);
    }

    public DuplicateResourceException(){
        super("Duplicacy!!!");
    }
}
