package com.movies.domain.usecase.admin.impl;

import com.movies.common.annotation.DomainTransactional;
import com.movies.common.annotation.DomainUseCase;
import com.movies.domain.exception.ResourceNotFoundException;
import com.movies.domain.service.MovieService;
import com.movies.domain.usecase.admin.MovieDeleteUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieDeleteUseCaseImpl implements MovieDeleteUseCase {

    private final MovieService movieService;

    @Override
    public void execute(long id){
        movieService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie " + id + " not found"));
        movieService.delete(id);}
}
