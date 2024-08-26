package com.cev.prueba_2.repository;

import com.cev.prueba_2.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovie_Title(String title); //Selecciona las revieus de la pelicula con el título deseado.
}
