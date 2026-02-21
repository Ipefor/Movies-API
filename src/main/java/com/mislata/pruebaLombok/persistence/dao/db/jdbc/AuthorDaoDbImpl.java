package com.mislata.pruebaLombok.persistence.dao.db.jdbc;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.persistence.dao.db.AuthorDaoDb;
import com.mislata.pruebaLombok.persistence.dao.db.jdbc.mapper.AuthorRowMapper;
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
public class AuthorDaoDbImpl implements AuthorDaoDb {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Author> getByIsbnBook(String isbn) {
        String sql = """
                SELECT authors.* FROM authors
                JOIN books_authors ON authors.id = books_authors.author_id
                JOIN books ON books_authors.book_id = books.id
                AND books.isbn = ?
           """;
        return jdbcTemplate.query(sql, new AuthorRowMapper(), isbn);
    }

    @Override
    public List<Author> getByIdBook(long idBook) {
        String sql = """
                SELECT authors.* FROM authors
                JOIN books_authors ON authors.id = books_authors.author_id
                AND books_authors.book_id = ?
           """;
        return jdbcTemplate.query(sql, new AuthorRowMapper(), idBook);
    }

    @Override
    public List<Author> findAllById(Long[] ids) {
        String sql = """
               SELECT authors.* FROM authors
               WHERE id IN (:ids)
           """;
        Map<String, List<Long>> params = Map.of("ids", Arrays.asList(ids));
        return namedParameterJdbcTemplate.query(sql, params, new AuthorRowMapper());
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public ListWithCount<Author> getAll(int page, int size) {
        return null;
    }


    @Override
    public Optional<Author> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long insert(Author author) {
        return 0;
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Author save(Author author) {
        return null;
    }
}
