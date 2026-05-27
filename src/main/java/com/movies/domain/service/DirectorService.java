package com.movies.domain.service;

import com.movies.domain.model.Director;

import java.util.Optional;

public interface DirectorService {
    public Optional<Director> findById(long id);
}
