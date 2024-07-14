package com.ynova.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ynova.library.execption.BookNotFoundExeption;
import com.ynova.library.execption.DuplicateBookException;
import com.ynova.library.execption.ErrorMessages;
import com.ynova.library.model.Book;
import com.ynova.library.service.IBookService;

public class BookServiceImpl implements IBookService {

    private final List<Book> books = new ArrayList<>();

    @Override
    public void registerBook(Book book) {
        boolean isDuplicateIsbn = books.stream()
                .anyMatch(existingBook -> existingBook.getIsbn().equals(book.getIsbn()));
        if (isDuplicateIsbn) {
            throw new DuplicateBookException(
                    ErrorMessages.DUPLICATE_BOOK.formatMessage(book.getTitle(), book.getIsbn()));
        }
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Optional<Book> findBookByISBN(String isbn) {

        Optional<Book> optionalBook = books.stream()
        .filter(book -> book.getIsbn().equals(isbn))
        .findFirst();

        if(optionalBook.isEmpty()){
            throw new BookNotFoundExeption(
                ErrorMessages.BOOK_NOT_FOUND.formatMessage(isbn)
            );
        }
        return optionalBook;
    }

}
