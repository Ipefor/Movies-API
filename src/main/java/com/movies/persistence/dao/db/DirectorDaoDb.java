package com.movies.persistence.dao.db;

import com.movies.domain.model.Director;

import java.util.Optional;

public interface DirectorDaoDb extends GenericDaoDb<Director>{
    public Optional<Director> findById(long id);
}
