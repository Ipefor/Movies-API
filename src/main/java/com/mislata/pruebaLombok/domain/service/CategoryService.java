package com.mislata.pruebaLombok.domain.service;

import com.mislata.pruebaLombok.domain.model.Category;

import java.util.Optional;

public interface CategoryService {

    public Optional<Category> findById(long id);
}