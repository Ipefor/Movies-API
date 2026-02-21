package com.mislata.pruebaLombok.domain.usecase.book.impl;

import com.mislata.pruebaLombok.common.annotation.DomainTransactional;
import com.mislata.pruebaLombok.common.annotation.DomainUseCase;
import com.mislata.pruebaLombok.domain.service.BookService;
import com.mislata.pruebaLombok.domain.usecase.book.BookCountUseCase;
import lombok.RequiredArgsConstructor;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookCountUseCaseImpl implements BookCountUseCase {

    private final BookService bookService;

    @Override
    public int execute(){
        return bookService.count();
    }

}
