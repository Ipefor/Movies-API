package com.movies.persistence.dao.db.jpa.mapper;

import com.movies.domain.model.Movie;
import com.movies.persistence.dao.db.jpa.entity.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieJpaMapper {
    DirectorJpaMapper directorJpaMapper = new DirectorJpaMapper();
    ActorJpaMapper actorJpaMapper = new ActorJpaMapper();

    public Movie toMovieWithDetails(MovieEntity movieEntity) {
        if (movieEntity == null) {
            return null;
        }

        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setTitleEn(movieEntity.getTitleEn());
        movie.setTitleEs(movieEntity.getTitleEs());
        movie.setYear(movieEntity.getYear());

        if (movieEntity.getDirectorEntity() != null){
            movie.setDirector(directorJpaMapper.toDirector(movieEntity.getDirectorEntity()));
        }

        if (movieEntity.getActorEntityList() != null){
            movie.setActorList(movieEntity.getActorEntityList().stream()
                    .map(actorEntity -> actorJpaMapper.toActor(actorEntity))
                    .toList());
        }

        return movie;
    }

    public Movie toMovieAlone (MovieEntity movieEntity){
        if (movieEntity == null) {
            return null;
        }

        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setTitleEn(movieEntity.getTitleEn());
        movie.setTitleEs(movieEntity.getTitleEs());
        movie.setYear(movieEntity.getYear());
        return movie;
    }

    public MovieEntity toMovieEntity (Movie movie){
        if (movie == null){
            return null;
        }

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(movie.getId());
        movieEntity.setTitleEn(movie.getTitleEn());
        movieEntity.setTitleEs(movie.getTitleEs());
        movieEntity.setYear(movie.getYear());

        if (movie.getDirector()!= null) {
            movieEntity.setDirectorEntity(directorJpaMapper.toDirectorEntity(movie.getDirector()));
        }

        if (movie.getActorList() != null){
            movieEntity.setActorEntityList(movie.getActorList().stream()
                    .map(actor -> actorJpaMapper.toActorEntity(actor))
                    .toList());
        }

        return movieEntity;
    }

}
