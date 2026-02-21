package com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper;

import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookJpaMapper {

    private static CategoryJpaMapper categoryJpaMapper = new CategoryJpaMapper();
    private static PublisherJpaMapper publisherJpaMapper = new PublisherJpaMapper();
    private static AuthorJpaMapper authorJpaMapper = new AuthorJpaMapper();
    private static GenreJpaMapper genreJpaMapper = new GenreJpaMapper();

    public static Book toBook(BookEntity bookEntity){
        if (bookEntity == null) {
            return null;
        }

        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setIsbn((bookEntity.getIsbn()));
        book.setTitleEs(bookEntity.getTitleEs());
        book.setTitleEn(bookEntity.getTitleEn());
        book.setSynopsisEs(bookEntity.getSynopsisEs());
        book.setSynopsisEn(bookEntity.getSynopsisEn());
        book.setPrice(bookEntity.getPrice());
        book.setDiscount(bookEntity.getDiscount());
        book.setCover(bookEntity.getCover());

        return book;
    }

    public Book toBookWithDetail(BookEntity bookEntity){
        if (bookEntity == null) {
            return null;
        }

        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setIsbn((bookEntity.getIsbn()));
        book.setTitleEs(bookEntity.getTitleEs());
        book.setTitleEn(bookEntity.getTitleEn());
        book.setSynopsisEs(bookEntity.getSynopsisEs());
        book.setSynopsisEn(bookEntity.getSynopsisEn());
        book.setPrice(bookEntity.getPrice());
        book.setDiscount(bookEntity.getDiscount());
        book.setCover(bookEntity.getCover());

        if (bookEntity.getPublisherEntity() != null){
            book.setPublisher(publisherJpaMapper.toPublisher(bookEntity.getPublisherEntity()));
        }

        if (bookEntity.getCategoryEntity() != null){
            book.setCategory(categoryJpaMapper.toCategory(bookEntity.getCategoryEntity()));
        }

        if (bookEntity.getGenresEntity() != null){
            book.setGenres(bookEntity.getGenresEntity().stream()
                    .map(genreEntity -> genreJpaMapper.toGenre(genreEntity))
                    .toList());
        }

        if (bookEntity.getAuthorsEntity() != null){
            book.setAuthors(bookEntity.getAuthorsEntity().stream()
                    .map(authorEntity -> authorJpaMapper.toAuthor(authorEntity))
                    .toList());
        }


        return book;
    }


    public BookEntity toBookEntity (Book book){
        if (book == null){
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId(book.getId());
        bookEntity.setIsbn((book.getIsbn()));
        bookEntity.setTitleEs(book.getTitleEs());
        bookEntity.setTitleEn(book.getTitleEn());
        bookEntity.setSynopsisEs(book.getSynopsisEs());
        bookEntity.setSynopsisEn(book.getSynopsisEn());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setDiscount(book.getDiscount());
        bookEntity.setCover(book.getCover());

        if (book.getPublisher() != null){
            bookEntity.setPublisherEntity(publisherJpaMapper.toPublisherEntity(book.getPublisher()));
        }

        if (book.getCategory() != null){
            bookEntity.setCategoryEntity(categoryJpaMapper.toCategoryEntity(book.getCategory()));
        }

        if (book.getGenres() != null){
            bookEntity.setGenresEntity(book.getGenres().stream()
                    .map(genre -> genreJpaMapper.toGenreEntity(genre))
                    .toList());
        }

        if (book.getAuthors() != null){
            bookEntity.setAuthorsEntity(book.getAuthors().stream()
                    .map(author -> authorJpaMapper.toAuthorEntity(author))
                    .toList());
        }

        return bookEntity;
    }

}
