package com.movies.controller.user.webModel.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movies.controller.user.webModel.actor.ActorDetail;
import com.movies.controller.user.webModel.director.DirectorDetail;

import java.util.List;

public record MovieDetail (

        String title,
        int year,
        @JsonProperty("director") DirectorDetail director,
        @JsonProperty("actorList") List<ActorDetail> actorList
){}
