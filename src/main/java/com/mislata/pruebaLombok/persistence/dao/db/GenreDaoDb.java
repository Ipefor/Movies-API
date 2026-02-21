package com.mislata.pruebaLombok.persistence.dao.db;

import com.mislata.pruebaLombok.domain.model.Genre;

import java.util.List;

public interface GenreDaoDb extends GenericDaoDb<Genre> {
    List<Genre> getByIdBook(long idBook);
    List<Genre> findAllById(Long[] ids);
    List<Genre> getByIsbnBook(String isbn);
}
