package com.mislata.pruebaLombok.domain.service;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.domain.model.ListWithCount;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAll();

    ListWithCount<Book> getAll(int page, int size);

    long count();

    Optional<Book> findByIsbn(String isbn);

    public Optional<Book> findById(int id);

    //void insertAuthors(int idBook, List<Author> authors);
    //public void insertGenres(int idBook, List<Genre> genres);

    public void save(Book book);

    public void addAuthor(Book book, Author author);

    public void addGenre(Book book, Genre genre);

    //TODO: Revisar el controlador
}
