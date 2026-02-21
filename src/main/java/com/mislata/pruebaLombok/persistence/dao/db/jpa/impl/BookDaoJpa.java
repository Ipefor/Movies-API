package com.mislata.pruebaLombok.persistence.dao.db.jpa.impl;

import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.persistence.dao.db.BookDaoDb;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.entity.BookEntity;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper.AuthorJpaMapper;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper.BookJpaMapper;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.mapper.GenreJpaMapper;
import com.mislata.pruebaLombok.persistence.dao.db.jpa.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
@RequiredArgsConstructor
public class BookDaoJpa implements BookDaoDb {
    private final BookJpaRepository bookJpaRepository;
    private final BookJpaMapper bookJpaMapper;
    private final AuthorJpaMapper authorJpaMapper;
    private final GenreJpaMapper genreJpaMapper;

    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(bookJpaRepository.findById(id))
                .map(bookEntity -> bookEntity.map(bookJpaMapper::toBookWithDetail).orElse(null));
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(bookJpaRepository.findByIsbn(isbn))
                .map(bookEntity -> bookEntity.map(bookJpaMapper::toBookWithDetail).orElse(null));
    }

    @Override
    public long insert(Book book) {
        return bookJpaRepository.save(bookJpaMapper.toBookEntity(book)).getId();
    }

    @Override
    public void update(Book book) {
        bookJpaRepository.save(bookJpaMapper.toBookEntity(book));
    }

    @Override
    public void delete(long id) {
        bookJpaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return bookJpaRepository.count();
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = bookJpaMapper.toBookEntity(book);
        return bookJpaMapper.toBook(bookJpaRepository.save(bookEntity));
    }

    @Override
    public List<Book> getAll() {
        return bookJpaRepository
                .findAll()
                .stream()
                .map(bookEntity -> bookJpaMapper.toBook(bookEntity))
                .toList();
        //TODO: PREGUNTAR A CESAR LO DEL BOOKJPAMAPPER
    }

    @Override
    public ListWithCount<Book> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BookEntity> bookPage= bookJpaRepository.findAll(pageable);
        return new ListWithCount<Book>(
                bookPage.stream()
                        .map(bookEntity -> bookJpaMapper.toBook(bookEntity))
                        .toList(),
                bookPage.getTotalElements()
        );
    }

    @Override
    public void deleteAuthors(long id) {
        bookJpaRepository.findById(id)
                .ifPresent(bookEntity -> bookEntity.getAuthorsEntity().clear());
    }

    @Override
    public void insertAuthors(long id, List<Author> authors) {
        bookJpaRepository.findById(id)
                .ifPresent(bookEntity -> bookEntity.setAuthorsEntity(
                        authors.stream()
                                .map(author -> authorJpaMapper.toAuthorEntity(author))
                                .toList()
                ));
    }

    @Override
    public void deleteGenres(long id) {
        bookJpaRepository.findById(id)
                .ifPresent(bookEntity -> bookEntity.getGenresEntity().clear());
    }

    @Override
    public void insertGenres(long id, List<Genre> genres) {
        bookJpaRepository.findById(id)
                .ifPresent(bookEntity -> bookEntity.setGenresEntity(
                        genres.stream()
                                .map(genre -> genreJpaMapper.toGenreEntity(genre))
                                .toList()
                ));
    }
}
