package com.movies.persistence.dao.db.jpa.mapper;

import com.movies.domain.model.Director;
import com.movies.persistence.dao.db.jpa.entity.DirectorEntity;
import org.springframework.stereotype.Component;


@Component
public class DirectorJpaMapper {

    public Director toDirector(DirectorEntity directorEntity) {
        if (directorEntity == null) {
            return null;
        }

        Director director = new Director();
        director.setId(directorEntity.getId());
        director.setName(directorEntity.getName());
        return director;
    }

    public DirectorEntity toDirectorEntity (Director director){
        if (director == null) {
            return null;
        }

        DirectorEntity directorEntity = new DirectorEntity();
        directorEntity.setId(director.getId());
        directorEntity.setName(director.getName());
        return directorEntity;
    }
}
