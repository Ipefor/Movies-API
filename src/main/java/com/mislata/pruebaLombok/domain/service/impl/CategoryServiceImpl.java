package com.mislata.pruebaLombok.domain.service.impl;

import com.mislata.pruebaLombok.common.annotation.DomainService;
import com.mislata.pruebaLombok.domain.model.Category;
import com.mislata.pruebaLombok.domain.repository.CategoryRepository;
import com.mislata.pruebaLombok.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@DomainService
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

}


//TODO: REVISAR EL FALLO QUE HABÍA EN EL CASO 1