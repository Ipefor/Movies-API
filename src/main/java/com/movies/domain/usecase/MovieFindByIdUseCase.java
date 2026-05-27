package com.movies.domain.usecase;

import com.movies.domain.model.Movie;

public interface MovieFindByIdUseCase {

    public Movie execute(long id);
}
