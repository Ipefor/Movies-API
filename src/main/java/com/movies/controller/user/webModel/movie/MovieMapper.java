package com.movies.controller.user.webModel.movie;

import com.movies.controller.user.webModel.actor.ActorMapper;
import com.movies.controller.user.webModel.director.DirectorMapper;
import com.movies.domain.model.Movie;


public class MovieMapper {

    private static DirectorMapper directorMapper = new DirectorMapper();


    public static MovieCollection toMovieCollection(Movie movie){
        if (movie == null) {
            return null;
        }
        return new MovieCollection(
                movie.getTitle(),
                movie.getYear()
        );
    }

    public static MovieDetail toMovieDetail(Movie movie){
        if (movie == null) {
            return null;
        }
        return new MovieDetail(
                movie.getTitle(),
                movie.getYear(),
                directorMapper.toDirectorDetail(movie.getDirector()),
                movie.getActorList()
                        .stream()
                        .map(actor -> ActorMapper.toActorDetail(actor))
                        .toList()
        );
    }
}

/*    public static List<MovieCollection> toMovieCollectionList(List<Movie> movieList){
        List<MovieCollection> movieCollectionList = new ArrayList<>();
        for (Movie movie : movieList){
            movieCollectionList.add(toMovieCollection(movie));
        }
        return movieCollectionList;
    }*/