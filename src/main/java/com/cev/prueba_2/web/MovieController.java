package com.cev.prueba_2.web;

import com.cev.prueba_2.domain.Movie;
import com.cev.prueba_2.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("movie")
@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping//Localizamos todos los cines o por título
    List<Movie> getMovies(@RequestParam(required = false) String title){
        if(title != null){
            return movieService.findByTitleContaining(title);
        }else return movieService.finalAll();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){ return this.movieService.createMovie(movie);}

    @PutMapping(path = "/{id}") // Modificar una pelicula
    public Movie modifyCinema(@PathVariable Long id, @RequestBody Movie movie){
        movieService.save(id,movie);
        return movie;
    }

    @DeleteMapping(path = "/{id}") //Eliminamos una pelicula
    String deleteMovie(@PathVariable Long id){
        movieService.delete(id);
        return ("Ok");
    }
}
