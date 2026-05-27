package com.movies.domain.service.impl;

import com.movies.common.annotation.DomainService;
import com.movies.domain.exception.ResourceNotFoundException;
import com.movies.domain.model.Actor;
import com.movies.domain.repository.ActorRepository;
import com.movies.domain.service.ActorService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    public List<Actor> findAllById(List<Actor> actors){
        List<Actor> foundActors =  actorRepository.findAllById(
                actors
                        .stream()
                        .map(actor -> actor.getId())
                        .toArray(Long[]::new)
        );
        if(foundActors.size() != actors.size()) {
            throw new ResourceNotFoundException("Some actors were not found");
        }
        return foundActors;
    }
}
