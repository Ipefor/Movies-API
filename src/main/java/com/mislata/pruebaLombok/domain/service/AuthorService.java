package com.mislata.pruebaLombok.domain.service;

import com.mislata.pruebaLombok.domain.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getByIdBook(long idBook);

    public List<Author> findAllById(List<Author> authors);
}
