package com.movies.controller.admin;

import com.movies.controller.admin.webModel.movie.MovieCollection;
import com.movies.controller.admin.webModel.movie.MovieDetail;
import com.movies.controller.admin.webModel.movie.MovieMapper;
import com.movies.controller.common.PaginatedResponse;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.domain.usecase.MovieCountUseCase;
import com.movies.domain.usecase.MovieFindByIdUseCase;
import com.movies.domain.usecase.MovieGetAllUseCase;
import com.movies.domain.usecase.admin.MovieDeleteUseCase;
import com.movies.domain.usecase.admin.MovieInsertUseCase;
import com.movies.domain.usecase.admin.MovieUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieAdminController.URL)
public class MovieAdminController {

    public static final String URL = "/api/admin/movies";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final MovieGetAllUseCase movieGetAllUseCase;
    private final MovieCountUseCase countUseCase;
    private final MovieFindByIdUseCase movieFindByIdUseCase;
    private final MovieInsertUseCase movieInsertUseCase;
    private final MovieDeleteUseCase movieDeleteUseCase;
    private final MovieUpdateUseCase movieUpdateUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<MovieCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size)
    {
        int pageSize = (size!= null) ? size : Integer.parseInt(defaultPageSize);
        ListWithCount<Movie> movieList = movieGetAllUseCase.execute(page - 1, pageSize);
        PaginatedResponse<MovieCollection> response = new PaginatedResponse<>(
                movieList
                        .getList()
                        .stream()
                        .map(movie -> MovieMapper.toMovieCollection(movie))
                        .toList(),
                (int) movieList.getCount(), page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetail> findById(@PathVariable long id) {
        MovieDetail movieDetail = MovieMapper.toMovieDetail(movieFindByIdUseCase.execute(id));
        return new ResponseEntity<>(movieDetail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Movie movie) {
        movieInsertUseCase.execute(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Movie movie){
        movieUpdateUseCase.execute(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        movieDeleteUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


//@GetMapping
//public ResponseEntity<PaginatedResponse<MovieCollection>> getAll(
//        @RequestParam(defaultValue = "1") int page,
//        @RequestParam(required = false) Integer size)
//{
//    int pagesize = (size!= null) ? size : Integer.parseInt(defaultPageSize);
//    List<MovieCollection> movieCollections = movieGetAllUseCase
//            .execute(page-1, pagesize)
//            .stream()
//            .map(movie -> MovieMapper.toMovieCollection(movie))
//            .toList();
//
//    int total = countUseCase.execute();
//
//    PaginatedResponse<MovieCollection> response = new PaginatedResponse<>(movieCollections, total, page, pagesize, baseUrl + URL);
//    return new ResponseEntity<>(response, HttpStatus.OK);
//}