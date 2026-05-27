package com.movies.domain.usecase.impl;

import com.movies.common.annotation.DomainTransactional;
import com.movies.common.annotation.DomainUseCase;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.domain.service.MovieService;
import com.movies.domain.usecase.MovieGetAllUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieGetAllUseCaseImpl implements MovieGetAllUseCase {
    private final MovieService movieService;

    @Override
    public ListWithCount<Movie> execute(int page, int size){
            return movieService.getAll(page, size);
    }
}
