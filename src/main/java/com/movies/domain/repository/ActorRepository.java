package com.movies.domain.repository;

import com.movies.domain.model.Actor;

import java.util.List;

public interface ActorRepository {
    public List<Actor> findAllById(Long[] ids);
}
