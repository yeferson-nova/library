package com.ynova.library.execption;

public class BookNotFoundExeption extends RuntimeException {

    public BookNotFoundExeption(String message) {
        super(message);
    }

}
