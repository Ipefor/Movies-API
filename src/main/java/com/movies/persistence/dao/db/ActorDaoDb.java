package com.movies.persistence.dao.db;

import com.movies.domain.model.Actor;

import java.util.List;

public interface ActorDaoDb extends GenericDaoDb<Actor>{
    public List<Actor> getByIdMovie(long idMovie);
    public List<Actor> findAllById(Long[] ids);
}
