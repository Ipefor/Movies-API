package com.movies.domain.usecase;

import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;

public interface MovieGetAllUseCase {

    public ListWithCount<Movie> execute(int page, int size);
}
