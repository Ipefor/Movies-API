package com.mislata.pruebaLombok.persistence.repository.impl;

import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.domain.repository.BookRepository;
import com.mislata.pruebaLombok.persistence.dao.cache.BookDaoCache;
import com.mislata.pruebaLombok.persistence.dao.db.BookDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDaoDb bookDaoDb;
    private final BookDaoCache bookDaoCache;


    @Override
    public List<Book> findAll() {
        return bookDaoDb.getAll();
    }

    @Override
    public ListWithCount<Book> getAll(int page, int size) {
        return bookDaoDb.getAll(page,size);
    }

    @Override
    public long count() {
        return bookDaoDb.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookDaoCache.findByIsbn(isbn).or(
                () -> {
                    System.out.println("Retrieved from db: " + isbn);
                    Optional<Book> book = bookDaoDb.findByIsbn(isbn);
                    book.ifPresent(bookDaoCache::save);
                    return book;
                }
        );
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookDaoDb.findById(id);
    }

    @Override
    public void save(Book book) {
        bookDaoDb.save(book);
    }
}
