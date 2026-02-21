package com.mislata.pruebaLombok.persistence.dao.cache;

import com.mislata.pruebaLombok.domain.model.Book;

import java.util.Optional;

public interface BookDaoCache extends GenericDaoCache<Book>{

    Optional<Book> findByIsbn(String isbn);
}
