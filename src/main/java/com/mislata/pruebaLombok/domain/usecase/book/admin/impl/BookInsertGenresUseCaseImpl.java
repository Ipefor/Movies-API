package com.mislata.pruebaLombok.domain.usecase.book.admin.impl;

import com.mislata.pruebaLombok.common.annotation.DomainTransactional;
import com.mislata.pruebaLombok.common.annotation.DomainUseCase;
import com.mislata.pruebaLombok.domain.exception.ResourceNotFoundException;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.domain.service.BookService;
import com.mislata.pruebaLombok.domain.service.GenreService;
import com.mislata.pruebaLombok.domain.usecase.book.admin.BookInsertGenresUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertGenresUseCaseImpl implements BookInsertGenresUseCase {


    private final BookService bookService;
    private final GenreService genreService;

    @Override
    public void execute(Integer id, List<Genre> genres){
        Book book = bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
        genreService.findAllById(genres).forEach(genre -> bookService.addGenre(book, genre));
        bookService.save(book);
    }
}
