package com.movies.persistence.dao.db.jdbc.mapper;

import com.movies.domain.model.Actor;
import com.movies.persistence.common.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorRowMapper implements CustomRowMapper<Actor> {

    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException{
        Actor actor = new Actor();
        actor.setId(rs.getLong("actors.id"));
        actor.setName(rs.getString("actors.name"));
        return actor;
    }
}
