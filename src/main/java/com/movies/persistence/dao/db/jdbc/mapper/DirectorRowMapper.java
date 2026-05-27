package com.movies.persistence.dao.db.jdbc.mapper;

import com.movies.domain.model.Director;
import com.movies.persistence.common.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRowMapper implements CustomRowMapper<Director> {

    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setId(rs.getLong("directors.id"));
        director.setName(rs.getString("directors.name"));
        return director;
    }
}

