package com.mislata.pruebaLombok.persistence.repository.impl;

import com.mislata.pruebaLombok.domain.model.Publisher;
import com.mislata.pruebaLombok.domain.repository.PublisherRepository;
import com.mislata.pruebaLombok.persistence.dao.db.PublisherDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryImpl implements PublisherRepository {

    private final PublisherDaoDb publisherDaoDb;

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherDaoDb.findById(id);
    }
}
