package com.ynova.library.execption;

public class DuplicateBookException extends RuntimeException {

    public   DuplicateBookException(String message) {
        super(message);
    }
}
