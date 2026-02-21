package com.mislata.pruebaLombok.domain.usecase.book.admin.impl;

import com.mislata.pruebaLombok.common.annotation.DomainTransactional;
import com.mislata.pruebaLombok.common.annotation.DomainUseCase;
import com.mislata.pruebaLombok.domain.exception.ResourceAlreadyExistsException;
import com.mislata.pruebaLombok.domain.exception.ResourceNotFoundException;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.service.*;
import com.mislata.pruebaLombok.domain.usecase.book.admin.BookInsertUseCase;
import lombok.RequiredArgsConstructor;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertUseCaseImpl implements BookInsertUseCase {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;

    @Override
    public void execute(Book book) {
        if(bookService.findByIsbn(book.getIsbn()).isPresent()) {
            throw new ResourceAlreadyExistsException("Book with ISBN " + book.getIsbn() + " already exists");
        }
        book.setPublisher(publisherService
                .findById(book.getPublisher().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher " + book.getPublisher().getName() + " not found")));
        book.setCategory(categoryService
                .findById(book.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category " + book.getCategory().getId() + " not found")));
        book.setAuthors(authorService
                .findAllById(book.getAuthors()));
        book.setGenres(genreService
                .findAllById(book.getGenres()));
        bookService.save(book);
    }
}
