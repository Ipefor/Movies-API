package com.movies.persistence.repository.impl;

import com.movies.domain.model.Director;
import com.movies.domain.repository.DirectorRepository;
import com.movies.persistence.dao.db.DirectorDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DirectorRepositoryImpl implements DirectorRepository {

    private final DirectorDaoDb directorDaoDb;

    @Override
    public Optional<Director> findById(long id){return directorDaoDb.findById(id);}
}
