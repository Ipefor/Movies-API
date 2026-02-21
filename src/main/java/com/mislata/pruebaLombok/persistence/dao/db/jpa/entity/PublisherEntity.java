package com.mislata.pruebaLombok.persistence.dao.db.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherEntity {

    @Id
    private Long id;
    private String name;
    private String slug;
}
