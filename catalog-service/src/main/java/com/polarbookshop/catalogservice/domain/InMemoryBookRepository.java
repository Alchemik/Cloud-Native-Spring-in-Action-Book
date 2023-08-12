package com.polarbookshop.catalogservice.domain;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private static final Map<String, Book> books = new ConcurrentHashMap<>();

    /**
     * @return
     */
    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    /**
     * @param isbn
     * @return
     */
    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) : Optional.empty();
    }

    /**
     * @param isbn
     * @return
     */
    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    /**
     * @param book
     * @return
     */
    @Override
    public Book save(Book book) {
         return books.put(book.isbn(), book);
    }

    /**
     * @param isbn
     */
    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
