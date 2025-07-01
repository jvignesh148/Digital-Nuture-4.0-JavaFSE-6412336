package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;
    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void displayBooks() {
        System.out.println("Service: " + serviceName);
        bookRepository.getBooks().forEach(System.out::println);
    }
}
