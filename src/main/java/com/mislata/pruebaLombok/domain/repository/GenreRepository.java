package com.mislata.pruebaLombok.domain.repository;

import com.mislata.pruebaLombok.domain.model.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> getByIsbnBook(String isbn);
    public List<Genre> getByIdBook(long idBook);
    public List<Genre> findAllById(Long[] ids);

}
