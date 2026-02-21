package com.mislata.pruebaLombok.domain.repository;

import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.ListWithCount;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();

    public ListWithCount<Book> getAll(int page, int size);

    public long count();

    Optional<Book> findByIsbn(String isbn);

    public Optional<Book> findById(int id);

    public void save(Book book);

}
