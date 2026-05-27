package com.movies.domain.usecase.impl;

import com.movies.common.annotation.DomainTransactional;
import com.movies.common.annotation.DomainUseCase;
import com.movies.domain.exception.ResourceNotFoundException;
import com.movies.domain.model.Movie;
import com.movies.domain.service.MovieService;
import com.movies.domain.usecase.MovieFindByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieFindByIdUseCaseImpl implements MovieFindByIdUseCase {

    private final MovieService movieService;

    @Override
    public Movie execute(long id){
        Movie movie = movieService.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Movie id " + id + " not found"));
        return movie;
    }
}
