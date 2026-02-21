package com.mislata.pruebaLombok.domain.service.impl;

import com.mislata.pruebaLombok.common.annotation.DomainService;
import com.mislata.pruebaLombok.domain.exception.ResourceNotFoundException;
import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.domain.repository.GenreRepository;
import com.mislata.pruebaLombok.domain.service.GenreService;
import lombok.RequiredArgsConstructor;

import java.util.List;


@DomainService
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> getByIdBook(long idBook) {
        return genreRepository.getByIdBook(idBook);
    }
    @Override
    public List<Genre> findAllById(List<Genre> genres) {
        List<Genre> foundGenres =  genreRepository.findAllById(
                genres
                        .stream()
                        .map(Genre::getId)
                        .toArray(Long[]::new)
        );
        if(foundGenres.size() != genres.size()) {
            throw new ResourceNotFoundException("Some genres were not found");
        }
        return foundGenres;
    }
}
