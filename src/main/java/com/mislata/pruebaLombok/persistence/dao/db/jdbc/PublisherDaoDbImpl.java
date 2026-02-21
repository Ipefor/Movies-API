package com.mislata.pruebaLombok.persistence.dao.db.jdbc;

import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.domain.model.Publisher;
import com.mislata.pruebaLombok.persistence.dao.db.PublisherDaoDb;
import com.mislata.pruebaLombok.persistence.dao.db.jdbc.mapper.PublisherRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PublisherDaoDbImpl implements PublisherDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Publisher> getAll() {
        return null;
    }

    @Override
    public ListWithCount<Publisher> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Publisher> findById(long id) {
        String sql = """
                SELECT * FROM publishers
                WHERE id = ?
                """;
        try
        {
            return Optional.of(jdbcTemplate.queryForObject(sql, new PublisherRowMapper(), id));
        }
        catch (Exception e)
        {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Publisher publisher) {
        return 0;
    }

    @Override
    public void update(Publisher publisher) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return null;
    }
}
