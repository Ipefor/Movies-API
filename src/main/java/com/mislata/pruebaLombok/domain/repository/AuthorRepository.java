package com.mislata.pruebaLombok.domain.repository;
import com.mislata.pruebaLombok.domain.model.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> getByIsbnBook(String isbn);
    public List<Author> findAllById(Long[] ids);
    public List<Author> getByIdBook(long idBook);

}
