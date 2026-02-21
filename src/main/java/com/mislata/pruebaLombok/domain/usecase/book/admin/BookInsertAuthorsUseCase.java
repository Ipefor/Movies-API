package com.mislata.pruebaLombok.domain.usecase.book.admin;

import com.mislata.pruebaLombok.domain.model.Author;

import java.util.List;

public interface BookInsertAuthorsUseCase {
    void execute(Integer id, List<Author> authors);
}
