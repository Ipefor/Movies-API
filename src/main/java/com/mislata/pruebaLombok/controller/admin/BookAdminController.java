package com.mislata.pruebaLombok.controller.admin;

import com.mislata.pruebaLombok.controller.common.PaginatedResponse;
import com.mislata.pruebaLombok.controller.admin.webModel.book.BookCollection;
import com.mislata.pruebaLombok.controller.admin.webModel.book.BookMapper;
import com.mislata.pruebaLombok.domain.model.Author;
import com.mislata.pruebaLombok.domain.model.Book;
import com.mislata.pruebaLombok.domain.model.Genre;
import com.mislata.pruebaLombok.domain.model.ListWithCount;
import com.mislata.pruebaLombok.domain.usecase.book.BookCountUseCase;
import com.mislata.pruebaLombok.domain.usecase.book.BookFindByIsbnUseCase;
import com.mislata.pruebaLombok.domain.usecase.book.BookGetAllUseCase;
import com.mislata.pruebaLombok.domain.usecase.book.admin.BookInsertAuthorsUseCase;
import com.mislata.pruebaLombok.domain.usecase.book.admin.BookInsertGenresUseCase;
import com.mislata.pruebaLombok.domain.usecase.book.admin.BookInsertUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookAdminController.URL)
public class BookAdminController {

    public static final String URL = "/api/admin/books";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final BookCountUseCase bookCountUseCase;
    private final BookGetAllUseCase bookGetAllUseCase;
    private final BookFindByIsbnUseCase bookFindByIsbnUseCase;
    private final BookInsertAuthorsUseCase bookInsertAuthorsUseCase;
    private final BookInsertGenresUseCase bookInsertGenresUseCase;
    private final BookInsertUseCase bookInsertUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {

        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);;
        ListWithCount<Book> bookList = bookGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(
                bookList
                        .getList()
                        .stream()
                        .map(book -> BookMapper.toBookCollection(book))
                        .toList(),
                (int) bookList.getCount(), page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable String isbn) {
        Book book = bookFindByIsbnUseCase.execute(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/{id}/authors")
    public ResponseEntity<Void> insertAuthors(@PathVariable Integer id, @RequestBody List<Author> authors) {
        bookInsertAuthorsUseCase.execute(id, authors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/genres")
    public ResponseEntity<Void> insertGenres(@PathVariable Integer id, @RequestBody List<Genre> genres) {
        bookInsertGenresUseCase.execute(id, genres);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Book book) {
        bookInsertUseCase.execute(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

//@GetMapping
//public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
//        @RequestParam(defaultValue = "1") int page,
//        @RequestParam(required = false) Integer size) {
//    int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
//    List<BookCollection> books = bookGetAllUseCase
//            .execute(page - 1, pageSize)
//            .stream()
//            .map(book -> BookMapper.toBookCollection(book))
//            .toList();
//
//    int total = bookCountUseCase.execute();
//
//    PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl + URL);
//    return new ResponseEntity<>(response, HttpStatus.OK);
//}