package com.movies.domain.repository;

import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;

import java.util.Optional;

public interface MovieRepository {


    public ListWithCount<Movie> getAll(int page, int size);
    public int count();
    public Optional<Movie> findById(long id);
    public void save(Movie movie);
    public void delete(long id);
}
