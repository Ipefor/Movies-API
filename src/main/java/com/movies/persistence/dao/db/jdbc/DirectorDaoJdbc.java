package com.movies.persistence.dao.db.jdbc;

import com.movies.domain.model.Director;
import com.movies.domain.model.ListWithCount;
import com.movies.persistence.dao.db.DirectorDaoDb;
import com.movies.persistence.dao.db.jdbc.mapper.DirectorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DirectorDaoJdbc implements DirectorDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Director> getAll() {
        return null;
    }

    @Override
    public ListWithCount<Director> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Director> findById(long id) {
        String sql = """
                SELECT * FROM directors
                WHERE id = ?
                """;
        try
        {
            return Optional.of(jdbcTemplate.queryForObject(sql, new DirectorRowMapper(), id));
        }
        catch (Exception e)
        {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Director director) {
        return 0;
    }

    @Override
    public void update(Director director) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Director save(Director director) {
        return null;
    }
}
