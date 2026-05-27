package com.movies.domain.service;

import com.movies.domain.model.Actor;

import java.util.List;

public interface ActorService {

    public List<Actor> findAllById(List<Actor> actors);
}
