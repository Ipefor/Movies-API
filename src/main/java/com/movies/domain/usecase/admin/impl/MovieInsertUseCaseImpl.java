package com.movies.domain.usecase.admin.impl;

import com.movies.common.annotation.DomainTransactional;
import com.movies.common.annotation.DomainUseCase;
import com.movies.domain.exception.ResourceAlreadyExistsException;
import com.movies.domain.exception.ResourceNotFoundException;
import com.movies.domain.model.Movie;
import com.movies.domain.service.ActorService;
import com.movies.domain.service.DirectorService;
import com.movies.domain.service.MovieService;
import com.movies.domain.usecase.admin.MovieInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class MovieInsertUseCaseImpl implements MovieInsertUseCase {

    private final MovieService movieService;
    private final DirectorService directorService;
    private final ActorService actorService;

    @Override
    public void execute(Movie movie){
        if(movieService.findById(movie.getId()).isPresent()) {
            throw new ResourceAlreadyExistsException("Movie with id " + movie.getId() + " already exists");
        }

        movie.setDirector(directorService
                .findById(movie.getDirector().getId())
                .orElseThrow(()->
                        new ResourceNotFoundException("Director " + movie.getDirector().getName() + " not found")));
        movie.setActorList(actorService
                .findAllById(movie.getActorList()));
        movieService.save(movie);
    }
}
