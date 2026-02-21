package com.mislata.pruebaLombok.domain.usecase.book.impl;

import com.mislata.pruebaLombok.common.annotation.DomainTransactional;
import com.mislata.pruebaLombok.common.annotation.DomainUseCase;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.domain.service.BookService;
import com.mislata.pruebaLombok.domain.usecase.book.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookGetAllUseCaseImpl implements BookGetAllUseCase {

    private final BookService bookService;

    @Override
    public ListWithCount<Book> execute(int page, int pageSize){
        return bookService.getAll(page, pageSize);
    }
}
