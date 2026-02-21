package com.mislata.pruebaLombok.domain.repository;

import com.mislata.pruebaLombok.domain.model.Category;

import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findById(Long id);
}
