package com.movies.controller.user.webModel.actor;

import com.movies.domain.model.Actor;

public class ActorMapper {

    public static ActorDetail toActorDetail(Actor actor){
        if (actor == null) {
            return null;
        }
        return new ActorDetail(
                actor.getName()
        );
    }
}
