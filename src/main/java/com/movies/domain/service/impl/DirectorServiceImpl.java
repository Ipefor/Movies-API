package com.movies.domain.service.impl;

import com.movies.common.annotation.DomainService;
import com.movies.domain.model.Director;
import com.movies.domain.repository.DirectorRepository;
import com.movies.domain.service.DirectorService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public Optional<Director> findById(long id){return directorRepository.findById(id);}
}
