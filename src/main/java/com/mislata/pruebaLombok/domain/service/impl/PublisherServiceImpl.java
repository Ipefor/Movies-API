package com.mislata.pruebaLombok.domain.service.impl;

import com.mislata.pruebaLombok.common.annotation.DomainService;
import com.mislata.pruebaLombok.domain.model.Publisher;
import com.mislata.pruebaLombok.domain.repository.PublisherRepository;
import com.mislata.pruebaLombok.domain.service.PublisherService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@DomainService
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    @Override
    public Optional<Publisher> findById(long id) {
        return publisherRepository.findById(id);
    }

}
