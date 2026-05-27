package com.movies.persistence.dao.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
public class MovieEntity {

    @Id
    private Long id;

    @Column(name = "title_es")
    private String titleEs;

    @Column(name = "title_en")
    private String titleEn;

    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directorId")
    private DirectorEntity directorEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "actorId")
    )
    private List<ActorEntity> actorEntityList;
}
