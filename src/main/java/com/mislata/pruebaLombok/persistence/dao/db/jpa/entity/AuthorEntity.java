package com.mislata.pruebaLombok.persistence.dao.db.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {

    @Id
    private Long id;
    private String name;
    private String nationality;
    @Column(name="biography_es")
    private String biographyEs;
    @Column(name="biography_en")
    private String biographyEn;
    @Column(name="birth_year")
    private int birthYear;
    @Column(name="death_year")
    private int deathYear;
}
