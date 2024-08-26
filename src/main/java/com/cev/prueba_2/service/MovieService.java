package com.cev.prueba_2.service;

import com.cev.prueba_2.domain.Cinema;
import com.cev.prueba_2.domain.Movie;
import com.cev.prueba_2.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie (Movie movie){
        return this.movieRepository.save(movie);
    } //Guardamos una nueva pelicula

    public List<Movie> finalAll(){ return this.movieRepository.findAll();} //Encontramos todas las peliculas

    //Buscamos una pelicula por su título.
    public List<Movie> findByTitleContaining(String title){
        return movieRepository.findByTitleContaining(title);
    }

    //Modificamos el contenido de la pelicula desada
    public void save(Long id, Movie movie){
        Movie savedMovie = movieRepository.getOne(id);
        savedMovie.setTitle(movie.getTitle());
        savedMovie.setPunctuation(movie.getPunctuation());
        savedMovie.setSynopsis(movie.getSynopsis());
        savedMovie.setDirector(movie.getDirector());
        savedMovie.setPremiereDate(movie.getPremiereDate());
        savedMovie.setReviews(movie.getReviews());
        movieRepository.save(savedMovie);
    }

    public void delete(Long id){
        movieRepository.delete(movieRepository.getOne(id));
    } //Eliminamos la pelicula deseada
}
