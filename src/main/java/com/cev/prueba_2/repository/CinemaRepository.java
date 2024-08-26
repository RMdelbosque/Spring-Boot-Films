package com.cev.prueba_2.repository;

import com.cev.prueba_2.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    List<Cinema> findByMovies_Title(String title); //Busca en las listas de peliculas de cada cine.

    List<Cinema> findByMovies_TitleContainingIgnoreCaseAndZipCodeEquals(String title, Integer zipCode); // Busca en la lista de peliculas de cada cine con el código postal deseado

    Cinema findByIdEquals(Long id); //Localiza el cine por id


}
