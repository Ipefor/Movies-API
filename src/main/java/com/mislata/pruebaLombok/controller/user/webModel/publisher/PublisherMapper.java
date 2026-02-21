package com.mislata.pruebaLombok.controller.user.webModel.publisher;


import com.mislata.pruebaLombok.domain.model.Publisher;


public class PublisherMapper {
    public static PublisherCollection toPublisherCollection(Publisher publisher){
        if (publisher == null) {
            return null;
        }
        return new PublisherCollection(
                publisher.getId(),
                publisher.getName()

        );
    }
}