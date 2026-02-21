package com.mislata.pruebaLombok.controller.user.webModel.genre;

import com.mislata.pruebaLombok.domain.model.Genre;

public class GenreMapper {
    public static GenreCollection toGenreCollection(Genre genre){
        if (genre == null) {
            return null;
        }

        return new GenreCollection(
                genre.getName()
        );
    }
}
