package com.movies.persistence.dao.db;

import com.movies.domain.model.Actor;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDaoDb extends GenericDaoDb<Movie>{

    public ListWithCount<Movie> getAll(int page, int size);
    public List<Movie> getAll();
    public int count();
    public Optional<Movie> findById(long id);
    public Movie save(Movie movie);
    public long insert(Movie movie);
    public void update(Movie movie);
    public void deleteActors(long id);
    public void insertActors(long id, List<Actor> actors);
    public void delete(long id);
}
