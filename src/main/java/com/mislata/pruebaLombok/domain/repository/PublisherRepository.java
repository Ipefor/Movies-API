package com.mislata.pruebaLombok.domain.repository;

import com.mislata.pruebaLombok.domain.model.Publisher;

import java.util.Optional;

public interface PublisherRepository {
    Optional<Publisher> findById(Long id);
}
