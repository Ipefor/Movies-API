package com.movies.controller.user;


import com.movies.controller.common.PaginatedResponse;
import com.movies.controller.user.webModel.movie.MovieCollection;
import com.movies.controller.user.webModel.movie.MovieDetail;
import com.movies.controller.user.webModel.movie.MovieMapper;
import com.movies.domain.model.ListWithCount;
import com.movies.domain.model.Movie;
import com.movies.domain.usecase.MovieCountUseCase;
import com.movies.domain.usecase.MovieFindByIdUseCase;
import com.movies.domain.usecase.MovieGetAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieUserController.URL)
public class MovieUserController {

    public static final String URL = "/api/movies";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final MovieGetAllUseCase movieGetAllUseCase;
    private final MovieCountUseCase countUseCase;
    private final MovieFindByIdUseCase movieFindByIdUseCase;

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

}
