package com.mislata.pruebaLombok.domain.service.impl;

import com.mislata.pruebaLombok.common.annotation.DomainService;
import com.mislata.pruebaLombok.domain.exception.ResourceNotFoundException;
import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.repository.AuthorRepository;
import com.mislata.pruebaLombok.domain.service.AuthorService;
import lombok.RequiredArgsConstructor;

import java.util.List;



@DomainService
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getByIdBook(long idBook) {
        return authorRepository.getByIdBook(idBook);
    }

    @Override
    public List<Author> findAllById(List<Author> authors) {
        List<Author> foundAuthors =  authorRepository.findAllById(
                authors
                        .stream()
                        .map(Author::getId)
                        .toArray(Long[]::new)
        );
        if(foundAuthors.size() != authors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }
        return foundAuthors;
    }
}
