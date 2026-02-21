package com.mislata.pruebaLombok.controller.admin.webModel.book;

import com.mislata.pruebaLombok.domain.model.Book;


public class BookMapper {

    public static BookCollection toBookCollection(Book book){
        if (book == null) {
            return null;
        }
        return new BookCollection(
                book.getIsbn(),
                book.getTitle()
        );
    }

}