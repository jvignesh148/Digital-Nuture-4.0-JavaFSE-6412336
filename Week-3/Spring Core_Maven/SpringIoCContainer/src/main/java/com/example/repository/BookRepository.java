package com.example.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public List<String> getBooks() {
        return Arrays.asList("Java Basics", "Spring in Action", "Effective Java");
    }
}
