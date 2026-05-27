package com.movies.persistence.repository.impl;

import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.domain.repository.MovieRepository;
import com.movies.persistence.dao.db.MovieDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDaoDb movieDaoDb;

    @Override
    public ListWithCount<Movie> getAll(int page, int size) {
        return movieDaoDb.getAll(page,size);
    }

    @Override
    public int count(){
        return movieDaoDb.count();
    }

    @Override
    public Optional<Movie> findById(long id){ return movieDaoDb.findById(id);}

    @Override
    public void save(Movie movie) {movieDaoDb.save(movie);}

    @Override
    public void delete(long id){movieDaoDb.delete(id);}
}
