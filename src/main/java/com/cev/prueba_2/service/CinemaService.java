package com.cev.prueba_2.service;

import com.cev.prueba_2.domain.Cinema;
import com.cev.prueba_2.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema createCinema (Cinema cinema){
        return this.cinemaRepository.save(cinema);
    } //Creamos un nuevo cine

    //Modificamos el contenido del cine desado
    public void save(Long id, Cinema cinema){
        Cinema savedCinema = cinemaRepository.getOne(id);
        savedCinema.setName(cinema.getName());
        savedCinema.setPopulation(cinema.getPopulation());
        savedCinema.setZipCode(cinema.getZipCode());
        savedCinema.setProvince(cinema.getProvince());
        savedCinema.setEntryPrice(cinema.getEntryPrice());
        savedCinema.setMovies(cinema.getMovies());
        cinemaRepository.save(savedCinema);
    }

    public void delete(Long id){
        cinemaRepository.delete(cinemaRepository.getOne(id));
    } //Eliminamos el Cine deseado
    public List<Cinema> findAll(){ return this.cinemaRepository.findAll();} // Encontramos todos los cines.

}
