package com.mislata.pruebaLombok.persistence.dao.db.jpa.repository;

import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    @EntityGraph(attributePaths = {"publisherEntity", "categoryEntity"})
    Optional<BookEntity> findByIsbn(String isbn);
    @Override
    @EntityGraph(attributePaths = {"publisherEntity", "categoryEntity"})
    Optional<BookEntity> findById(Long id);

}
