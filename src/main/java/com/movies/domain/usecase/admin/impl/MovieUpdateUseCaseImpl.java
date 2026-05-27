package com.movies.domain.usecase.admin.impl;

import com.movies.common.annotation.DomainTransactional;
import com.movies.common.annotation.DomainUseCase;
import com.movies.domain.exception.ResourceNotFoundException;
import com.movies.domain.model.Movie;
import com.movies.domain.service.ActorService;
import com.movies.domain.service.DirectorService;
import com.movies.domain.service.MovieService;
import com.movies.domain.usecase.admin.MovieUpdateUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieUpdateUseCaseImpl implements MovieUpdateUseCase {

    private final MovieService movieService;
    private final DirectorService directorService;
    private final ActorService actorService;

    @Override
    public void execute(Movie movie){
        if(movieService.findById(movie.getId()).isEmpty()) {
            throw new ResourceNotFoundException("Movie with id " + movie.getId() + " does not exist");
        }
        if(directorService.findById(movie.getDirector().getId()).isEmpty()){
            throw new ResourceNotFoundException("Director with id " + movie.getDirector().getId() + " was not found");
        }
        if(actorService.findAllById(movie.getActorList()).isEmpty()){
            throw new ResourceNotFoundException("Some actors were not found");
        }
        movieService.save(movie);
    }
}
