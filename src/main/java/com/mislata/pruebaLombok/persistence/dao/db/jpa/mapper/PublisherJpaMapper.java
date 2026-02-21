package com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper;

import com.mislata.pruebaLombok.domain.model.Publisher;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.PublisherEntity;

public class PublisherJpaMapper {
    public static Publisher toPublisher(PublisherEntity publisherEntity){
        if (publisherEntity == null) {
            return null;
        }
        return new Publisher(
                publisherEntity.getId(),
                publisherEntity.getName(),
                publisherEntity.getSlug()
        );
    }

    public static PublisherEntity toPublisherEntity(Publisher publisher){
        if (publisher == null) {
            return null;
        }
        return new PublisherEntity(
                publisher.getId(),
                publisher.getName(),
                publisher.getSlug()
        );
    }
}
