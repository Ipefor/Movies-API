package com.movies.persistence.dao.db.jpa.repository;

import com.movies.persistence.dao.db.jpa.entity.MovieEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieJpaRepository extends JpaRepository<MovieEntity, Long> {
    @EntityGraph(attributePaths = {"directorEntity"})
    Optional<MovieEntity> findById(Long id);
}
