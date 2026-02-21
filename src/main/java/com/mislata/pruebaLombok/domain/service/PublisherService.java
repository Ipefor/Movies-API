package com.mislata.pruebaLombok.domain.service;

import com.mislata.pruebaLombok.domain.model.Publisher;

import java.util.Optional;

public interface PublisherService {

    public Optional<Publisher> findById(long id);
}
