package com.movies.domain.repository;

import com.movies.domain.model.Director;

import java.util.Optional;

public interface DirectorRepository {

    public Optional<Director> findById(long id);
}
