package com.mislata.pruebaLombok.controller.user.webModel.author;

import com.mislata.pruebaLombok.domain.model.Author;



public class AuthorMapper {

    public static AuthorCollection toAuthorCollection(Author author){
        if (author == null) {
            return null;
        }
        return new AuthorCollection(
                author.getId(),
                author.getName()
        );
    }
}
