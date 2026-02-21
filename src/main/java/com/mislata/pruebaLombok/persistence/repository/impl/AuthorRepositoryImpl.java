package com.mislata.pruebaLombok.persistence.repository.impl;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.repository.AuthorRepository;
import com.mislata.pruebaLombok.persistence.dao.db.AuthorDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final AuthorDaoDb authorDaoDb;
    @Override
    public List<Author> getByIsbnBook(String isbn) {
        return authorDaoDb.getByIsbnBook(isbn);
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        return authorDaoDb.findAllById(ids);
    }

    @Override
    public List<Author> getByIdBook(long idBook) {
        return authorDaoDb.getByIdBook(idBook);
    }
}
