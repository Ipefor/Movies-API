package com.mislata.pruebaLombok.controller.user.webModel.book;

import com.mislata.pruebaLombok.controller.user.webModel.author.AuthorMapper;
import com.mislata.pruebaLombok.controller.user.webModel.genre.GenreMapper;
import com.mislata.pruebaLombok.controller.user.webModel.publisher.PublisherMapper;
import com.mislata.pruebaLombok.domain.model.Book;

public class BookMapper {

    private static PublisherMapper publisherMapper = new PublisherMapper();
    private static GenreMapper genreMapper = new GenreMapper();
    public static BookCollection toBookCollection(Book book){
        if (book == null) {
            return null;
        }
        return new BookCollection(
                book.getIsbn(),
                book.getTitle(),
                book.getPrice(),
                book.getDiscount(),
                book.getCover()
        );
    }

    public static BookDetail toBookDetail(Book book){
        if (book == null) {
            return null;
        }
        return new BookDetail(
                book.getIsbn(),
                book.getTitle(),
                book.getPrice(),
                book.getDiscount(),
                book.getSynopsis(),
                book.getCover(),
                book.getGenres()
                        .stream()
                        .map(genre -> GenreMapper.toGenreCollection(genre))
                        .toList(),
                book.getCategory(),
                publisherMapper.toPublisherCollection(book.getPublisher()),
                book.getAuthors()
                        .stream()
                        .map(author -> AuthorMapper.toAuthorCollection(author))
                        .toList()
        );
    }

}