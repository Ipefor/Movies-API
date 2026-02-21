package com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper;

import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.GenreEntity;

public class GenreJpaMapper {
    public static Genre toGenre(GenreEntity genreEntity){
        if (genreEntity == null) {
            return null;
        }
        return new Genre(
                genreEntity.getId(),
                genreEntity.getNameEs(),
                genreEntity.getNameEn(),
                genreEntity.getSlug()
        );
    }

    public static GenreEntity toGenreEntity(Genre genre){
        if (genre == null) {
            return null;
        }
        return new GenreEntity(
                genre.getId(),
                genre.getNameEs(),
                genre.getNameEn(),
                genre.getSlug()
        );
    }
}
