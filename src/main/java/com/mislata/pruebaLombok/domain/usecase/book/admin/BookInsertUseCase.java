package com.mislata.pruebaLombok.domain.usecase.book.admin;

import com.mislata.pruebaLombok.domain.model.Book;

public interface BookInsertUseCase {
    void execute(Book book);
}
