package com.mislata.pruebaLombok.domain.usecase.book.impl;

import com.mislata.pruebaLombok.common.annotation.DomainTransactional;
import com.mislata.pruebaLombok.common.annotation.DomainUseCase;
import com.mislata.pruebaLombok.domain.exception.ResourceNotFoundException;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.service.AuthorService;
import com.mislata.pruebaLombok.domain.service.BookService;
import com.mislata.pruebaLombok.domain.service.GenreService;
import com.mislata.pruebaLombok.domain.usecase.book.BookFindByIsbnUseCase;
import lombok.RequiredArgsConstructor;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookFindByIsbnUseCaseImpl implements BookFindByIsbnUseCase {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @Override
    public Book execute (String isbn){
        Book book = bookService.findByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book isbn " + isbn + " not found"));
        book.setAuthors(authorService.getByIdBook(book.getId()));
        book.setGenres(genreService.getByIdBook(book.getId()));
        return book;
    }
}
