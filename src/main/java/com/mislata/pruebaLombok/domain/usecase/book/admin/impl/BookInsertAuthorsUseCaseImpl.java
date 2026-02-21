package com.mislata.pruebaLombok.domain.usecase.book.admin.impl;

import com.mislata.pruebaLombok.common.annotation.DomainTransactional;
import com.mislata.pruebaLombok.common.annotation.DomainUseCase;
import com.mislata.pruebaLombok.domain.exception.ResourceNotFoundException;
import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.service.AuthorService;
import com.mislata.pruebaLombok.domain.service.BookService;
import com.mislata.pruebaLombok.domain.usecase.book.admin.BookInsertAuthorsUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertAuthorsUseCaseImpl implements BookInsertAuthorsUseCase {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public void execute(Integer id, List<Author> authors){
        Book book = bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
        authorService.findAllById(authors).forEach(author -> bookService.addAuthor(book, author));
        bookService.save(book);
    }
}
