package com.movies.controller.admin.webModel.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movies.controller.admin.webModel.actor.ActorDetail;
import com.movies.controller.admin.webModel.director.DirectorDetail;

import java.util.List;

public record MovieDetail(
        String titleEn,
        String titleEs,
        int year,
        @JsonProperty("director") DirectorDetail directorDetail,
        @JsonProperty("actorList") List<ActorDetail> actorDetail
) {
}
