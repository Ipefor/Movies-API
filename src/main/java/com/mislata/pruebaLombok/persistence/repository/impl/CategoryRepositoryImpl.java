package com.mislata.pruebaLombok.persistence.repository.impl;

import com.mislata.pruebaLombok.domain.model.Category;
import com.mislata.pruebaLombok.domain.repository.CategoryRepository;
import com.mislata.pruebaLombok.persistence.dao.db.CategoryDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryDaoDb categoryDaoDb;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryDaoDb.findById(id);
    }
}
