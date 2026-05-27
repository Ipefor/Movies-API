package com.movies.persistence.repository.impl;

import com.movies.domain.model.Actor;
import com.movies.domain.repository.ActorRepository;
import com.movies.persistence.dao.db.ActorDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActorRepositoryImpl implements ActorRepository {

    private final ActorDaoDb actorDaoDb;

    @Override
    public List<Actor> findAllById(Long[] ids){
        return actorDaoDb.findAllById(ids);
    }
}
