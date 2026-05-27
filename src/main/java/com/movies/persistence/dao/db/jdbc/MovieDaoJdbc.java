package com.movies.persistence.dao.db.jdbc;

import com.movies.domain.model.Actor;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.persistence.dao.db.ActorDaoDb;
import com.movies.persistence.dao.db.MovieDaoDb;
import com.movies.persistence.dao.db.jdbc.mapper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieDaoJdbc implements MovieDaoDb {

    private final JdbcTemplate jdbcTemplate;
    private final ActorDaoDb actorDaoDb;

    @Override
    public ListWithCount<Movie> getAll(int page, int size) {
        String sql = """
                        SELECT * FROM movies
                        LIMIT ? OFFSET ?
                     """;
        List<Movie> movies = jdbcTemplate.query(sql, new MovieRowMapper(), size, page * size);
        int total = (int) this.count();
        return new ListWithCount<Movie>(movies, total);
    }

    @Override
    public List<Movie> getAll() {
        String sql = """
                        SELECT * FROM movies
                     """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public Optional<Movie> findById(long id) {
        String sql = """
                SELECT * FROM movies
                LEFT JOIN directors ON movies.directorId = directors.id
                WHERE movies.id = ?
           """;
        try {
            Movie movie = jdbcTemplate.queryForObject(sql, new MovieRowMapper(), id);
            movie.setActorList(actorDaoDb.getByIdMovie(id));
            return Optional.of(movie);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int count() {
        String sql = """
                SELECT COUNT(*) FROM movies
                     """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    @Override
    public Movie save(Movie movie) {
        insert(movie);
        this.deleteActors(movie.getId());
        this.insertActors(movie.getId(), movie.getActorList());
        return movie;
    }

    @Override
    public long insert(Movie movie) {
        String sql = """
                INSERT INTO movies(
                  id,
                  title_en,
                  title_es,
                  directorId,
                  year
                  )
                VALUES(?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                            title_en = VALUES(title_en),
                            title_es = VALUES(title_es),
                            directorId = VALUES(directorId),
                            year = VALUES(year)
                
            """;

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, movie.getId());
            ps.setString(2, movie.getTitleEn());
            ps.setString(3, movie.getTitleEs());
            ps.setLong(4, movie.getDirector().getId());
            ps.setInt(5, movie.getYear());
            return ps;
        });

        return movie.getId(); // Devuelve el id generado

    }

    @Override
    public void update(Movie movie) {
        String sql = """
                UPDATE movies
                SET title_en = ?,
                    title_es = ?,
                    directorId = ?,
                    year = ?
                WHERE id = ?
            """;
        jdbcTemplate.update(
                sql,
                movie.getId(),
                movie.getTitleEn(),
                movie.getTitleEs(),
                movie.getDirector().getId(),
                movie.getYear()
        );
    }

    @Override
    public void deleteActors(long id) {
        String sql = """
                DELETE FROM movie_actors
                WHERE movieId = ?
            """;
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insertActors(long movieId, List<Actor> actors) {
        String sql = """
            INSERT INTO movie_actors(movieId, actorId)
            VALUES (?, ?)
            ON DUPLICATE KEY UPDATE actorId = VALUES(actorId)
        """;
        actors.forEach(actor ->
                jdbcTemplate.update(sql, movieId, actor.getId())
        );
    }

    @Override
    public void delete(long id){
        String sql = """
            DELETE FROM movies
            WHERE id = ?
        """;
        jdbcTemplate.update(sql, id);
    }
}
