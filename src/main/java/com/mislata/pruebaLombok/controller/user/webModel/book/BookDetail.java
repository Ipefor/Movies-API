package com.mislata.pruebaLombok.controller.user.webModel.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mislata.pruebaLombok.controller.user.webModel.author.AuthorCollection;
import com.mislata.pruebaLombok.controller.user.webModel.genre.GenreCollection;
import com.mislata.pruebaLombok.controller.user.webModel.publisher.PublisherCollection;
import com.mislata.pruebaLombok.domain.model.Category;
import com.mislata.pruebaLombok.domain.model.Genre;

import java.math.BigDecimal;
import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String synopsis,
        String cover,
        List<GenreCollection> genres,
        Category category,
        @JsonProperty("publisher") PublisherCollection publisherCollection,
        @JsonProperty("authors") List<AuthorCollection> authorsCollection
) {
}
