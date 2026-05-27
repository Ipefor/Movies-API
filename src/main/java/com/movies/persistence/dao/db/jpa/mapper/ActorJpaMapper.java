package com.movies.persistence.dao.db.jpa.mapper;

import com.movies.domain.model.Actor;
import com.movies.persistence.dao.db.jpa.entity.ActorEntity;
import org.springframework.stereotype.Component;

@Component
public class ActorJpaMapper {

    public Actor toActor(ActorEntity actorEntity) {
        if (actorEntity == null) {
            return null;
        }

        Actor actor = new Actor();
        actor.setId(actorEntity.getId());
        actor.setName(actorEntity.getName());
        return actor;
    }

    public ActorEntity toActorEntity (Actor actor){
        if (actor == null) {
            return null;
        }

        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setId(actor.getId());
        actorEntity.setName(actor.getName());
        return actorEntity;
    }
}
