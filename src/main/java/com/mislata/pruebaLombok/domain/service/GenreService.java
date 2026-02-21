package com.mislata.pruebaLombok.domain.service;

import com.mislata.pruebaLombok.domain.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getByIdBook(long idBook);

    public List<Genre> findAllById(List<Genre> genres);
}
