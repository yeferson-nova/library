package com.ynova.library.execption;

public class DuplicateLoanException extends RuntimeException {

    public DuplicateLoanException(String message) {
        super(message);
    }

}
