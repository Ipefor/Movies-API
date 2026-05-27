package com.movies.domain.usecase.impl;

import com.movies.common.annotation.DomainTransactional;
import com.movies.common.annotation.DomainUseCase;
import com.movies.domain.service.MovieService;
import com.movies.domain.usecase.MovieCountUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieCountUseCaseImpl implements MovieCountUseCase {

    private final MovieService movieService;

    @Override
    public int execute(){
        return movieService.count();
    }
}
