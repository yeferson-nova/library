package com.ynova.library.service;

import java.util.List;
import java.util.Optional;

import com.ynova.library.model.Book;

public interface IBookService {

    void registerBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> findBookByISBN(String isbn);


}
