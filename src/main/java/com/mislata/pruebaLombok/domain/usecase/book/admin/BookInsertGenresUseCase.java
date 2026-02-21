package com.mislata.pruebaLombok.domain.usecase.book.admin;

import com.mislata.pruebaLombok.domain.model.Genre;

import java.util.List;

public interface BookInsertGenresUseCase {
    void execute(Integer id, List<Genre> genres);
}
