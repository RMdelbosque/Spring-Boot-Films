package com.cev.prueba_2.repository;

import com.cev.prueba_2.domain.Cinema;
import com.cev.prueba_2.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String title); //Busca la pelicula con el título deseado
}
