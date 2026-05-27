package com.movies.domain.service.impl;

import com.movies.common.annotation.DomainService;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.domain.repository.MovieRepository;
import com.movies.domain.service.MovieService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public ListWithCount<Movie> getAll(int page, int size){
        return movieRepository.getAll(page, size);
    }

    @Override
    public int count(){
        return movieRepository.count();
    }

    @Override
    public Optional<Movie> findById(long id){return movieRepository.findById(id);}

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void delete(long id){movieRepository.delete(id);}
}
