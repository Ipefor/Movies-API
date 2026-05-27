package com.movies.persistence.dao.db.jdbc.mapper;

import com.movies.domain.model.Movie;
import com.movies.persistence.common.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements CustomRowMapper<Movie> {

    private final DirectorRowMapper directorRowMapper = new DirectorRowMapper();
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getLong("movies.id"));
        movie.setTitleEn(rs.getString("movies.title_en"));
        movie.setTitleEs(rs.getString("movies.title_es"));
        movie.setYear(rs.getInt("movies.year"));
        if(this.existsColumn(rs, "directors.id")){
            movie.setDirector(directorRowMapper.mapRow(rs, rowNum));
        }
        return movie;
    }
}
