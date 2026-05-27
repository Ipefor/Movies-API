package com.movies.persistence.dao.db.jpa;

import com.movies.domain.model.Actor;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.persistence.dao.db.MovieDaoDb;
import com.movies.persistence.dao.db.jpa.entity.MovieEntity;
import com.movies.persistence.dao.db.jpa.mapper.ActorJpaMapper;
import com.movies.persistence.dao.db.jpa.mapper.MovieJpaMapper;
import com.movies.persistence.dao.db.jpa.repository.MovieJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
@RequiredArgsConstructor
public class MovieDaoJpa implements MovieDaoDb {

    private final MovieJpaRepository movieJpaRepository;
    private final MovieJpaMapper movieJpaMapper;
    private final ActorJpaMapper actorJpaMapper;

    @Override
    public ListWithCount<Movie> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MovieEntity> moviePage= movieJpaRepository.findAll(pageable);
        return new ListWithCount<Movie>(
                moviePage.stream()
                        .map(movieEntity -> movieJpaMapper.toMovieAlone(movieEntity))
                        .toList(),
                moviePage.getTotalElements()
        );
    }

    @Override
    public List<Movie> getAll() {
        return movieJpaRepository
                .findAll()
                .stream()
                .map(movieEntity -> movieJpaMapper.toMovieAlone(movieEntity))
                .toList();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Optional<Movie> findById(long id) {
        return Optional.ofNullable(movieJpaRepository.findById(id))
                .map(movieEntity -> movieEntity.map(movieJpaMapper::toMovieWithDetails).orElse(null));
    }

    @Override
    public Movie save(Movie movie) {
        MovieEntity movieEntity = movieJpaMapper.toMovieEntity(movie);
        return movieJpaMapper.toMovieAlone(movieJpaRepository.save(movieEntity));
    }

    @Override
    public long insert(Movie movie) {
        return movieJpaRepository.save(movieJpaMapper.toMovieEntity(movie)).getId();
    }

    @Override
    public void update(Movie movie) {
        movieJpaRepository.save(movieJpaMapper.toMovieEntity(movie));
    }

    @Override
    public void deleteActors(long id) {
        movieJpaRepository.findById(id)
                .ifPresent(movieEntity -> movieEntity.getActorEntityList().clear());
    }

    @Override
    public void insertActors(long id, List<Actor> actors) {
        movieJpaRepository.findById(id)
                .ifPresent(movieEntity -> movieEntity.setActorEntityList(
                        actors.stream()
                                .map(actor -> actorJpaMapper.toActorEntity(actor))
                                .toList()
                ));
    }

    @Override
    public void delete(long id) {
        movieJpaRepository.deleteById(id);
    }
}
