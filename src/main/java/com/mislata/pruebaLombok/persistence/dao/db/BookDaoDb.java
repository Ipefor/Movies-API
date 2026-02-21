package com.mislata.pruebaLombok.persistence.dao.db;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.Genre;

import java.util.List;
import java.util.Optional;

public interface BookDaoDb extends GenericDaoDb<Book> {

    Optional<Book> findByIsbn(String isbn);
    void deleteAuthors(long id);
    void insertAuthors(long id, List<Author> authors);
    void deleteGenres(long id);
    void insertGenres(long id, List<Genre> genres);
}
