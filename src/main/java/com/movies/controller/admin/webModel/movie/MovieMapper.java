package com.movies.controller.admin.webModel.movie;

import com.movies.controller.admin.webModel.actor.ActorMapper;
import com.movies.controller.admin.webModel.director.DirectorMapper;

import com.movies.domain.model.Movie;

public class MovieMapper {

    private static DirectorMapper directorMapper = new DirectorMapper();

    public static MovieCollection toMovieCollection(Movie movie){
        if (movie == null) {
            return null;
        }
        return new MovieCollection(
                movie.getTitleEn(),
                movie.getTitleEs(),
                movie.getYear()
        );
    }

    public static MovieDetail toMovieDetail(Movie movie){
        if (movie == null) {
            return null;
        }
        return new MovieDetail(
                movie.getTitleEn(),
                movie.getTitleEs(),
                movie.getYear(),
                directorMapper.toDirectorDetail(movie.getDirector()),
                movie.getActorList()
                        .stream()
                        .map(actor -> ActorMapper.toActorDetail(actor))
                        .toList()
        );
    }
}
