package com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper;

import com.mislata.pruebaLombok.domain.model.Category;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.CategoryEntity;

public class CategoryJpaMapper {
    public static Category toCategory(CategoryEntity categoryEntity){
        if (categoryEntity == null) {
            return null;
        }
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getNameEs(),
                categoryEntity.getNameEn(),
                categoryEntity.getSlug()
        );
    }

    public static CategoryEntity toCategoryEntity(Category category){
        if (category == null) {
            return null;
        }
        return new CategoryEntity(
                category.getId(),
                category.getNameEs(),
                category.getNameEn(),
                category.getSlug()
        );
    }
}
