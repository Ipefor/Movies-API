package com.movies.persistence.dao.db.jdbc;

import com.movies.domain.model.Actor;
import com.movies.domain.model.ListWithCount;
import com.movies.persistence.dao.db.ActorDaoDb;
import com.movies.persistence.dao.db.jdbc.mapper.ActorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ActorDaoJdbc implements ActorDaoDb {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Actor> getByIdMovie(long idMovie) {
        String sql = """
                SELECT actors.* FROM actors
                JOIN movie_actors ON actors.id = movie_actors.actorId
                AND movie_actors.movieId = ?
           """;
        return jdbcTemplate.query(sql, new ActorRowMapper(), idMovie);
    }

    @Override
    public List<Actor> findAllById(Long[] ids) {
        String sql = """
               SELECT actors.* FROM actors
               WHERE id IN (:ids)
           """;
        Map<String, List<Long>> params = Map.of("ids", Arrays.asList(ids));
        return namedParameterJdbcTemplate.query(sql, params, new ActorRowMapper());
    }

    @Override
    public List<Actor> getAll() {
        return null;
    }

    @Override
    public ListWithCount<Actor> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Actor> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Actor actor) {
        return 0;
    }

    @Override
    public void update(Actor actor) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Actor save(Actor actor) {
        return null;
    }
}
