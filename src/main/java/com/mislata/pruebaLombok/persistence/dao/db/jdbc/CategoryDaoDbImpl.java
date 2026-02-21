package com.mislata.pruebaLombok.persistence.dao.db.jdbc;

import com.mislata.pruebaLombok.domain.model.Category;
import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.persistence.dao.db.CategoryDaoDb;
import com.mislata.pruebaLombok.persistence.dao.db.jdbc.mapper.CategoryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryDaoDbImpl implements CategoryDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public ListWithCount<Category> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Category> findById(long id) {
        String sql = """
                        SELECT * FROM categories
                        WHERE id = ?
                     """;
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql,new CategoryRowMapper(), id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public long insert(Category category) {
        return 0;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Category save(Category category) {
        return null;
    }
}
