package com.movies.controller.admin.webModel.director;

import com.movies.domain.model.Director;

public class DirectorMapper {


    public static DirectorDetail toDirectorDetail(Director director){
        if (director == null) {
            return null;
        }
        return new DirectorDetail(
                director.getName()
        );
    }
}
