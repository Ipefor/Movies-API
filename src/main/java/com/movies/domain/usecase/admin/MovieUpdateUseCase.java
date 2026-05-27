package com.movies.domain.usecase.admin;

import com.movies.domain.model.Movie;

public interface MovieUpdateUseCase {

    public void execute(Movie movie);
}
