package com.mislata.pruebaLombok.persistence.dao.db.jpa.entity;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.Category;
import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.domain.model.Publisher;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    private Long id;
    private String isbn;
    @Column(name="title_es")
    private String titleEs;
    @Column(name="title_en")
    private String titleEn;
    @Column(name="synopsis_es")
    private String synopsisEs;
    @Column(name="synopsis_en")
    private String synopsisEn;
    private BigDecimal price;
    private float discount;
    private String cover;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisherEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "books_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genresEntity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<AuthorEntity> authorsEntity;
}
