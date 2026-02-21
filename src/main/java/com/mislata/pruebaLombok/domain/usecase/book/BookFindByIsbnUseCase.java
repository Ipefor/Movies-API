package com.mislata.pruebaLombok.domain.usecase.book;

import com.mislata.pruebaLombok.domain.model.Book;

public interface BookFindByIsbnUseCase {
    Book execute(String isbn);
}
