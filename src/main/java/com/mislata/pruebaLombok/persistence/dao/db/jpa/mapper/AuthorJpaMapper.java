package com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.AuthorEntity;

public class AuthorJpaMapper {
    public static Author toAuthor(AuthorEntity authorEntity) {
        if (authorEntity == null) {
            return null;
        }

        return new Author(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getNationality(),
                authorEntity.getBiographyEs(),
                authorEntity.getBiographyEn(),
                authorEntity.getBirthYear(),
                authorEntity.getDeathYear()
        );
    }

    public static AuthorEntity toAuthorEntity(Author author) {
        if (author == null) {
            return null;
        }

        return new AuthorEntity(
                author.getId(),
                author.getName(),
                author.getNationality(),
                author.getBiographyEs(),
                author.getBiographyEn(),
                author.getBirthYear(),
                author.getDeathYear()
        );
    }
}
