package com.cev.prueba_2.web;

import com.cev.prueba_2.domain.Cinema;
import com.cev.prueba_2.repository.CinemaRepository;
import com.cev.prueba_2.service.CinemaService;
import com.cev.prueba_2.service.CustomError.CustomError;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RequestMapping("cinema")
@RestController
public class CinemaController {

    private final CinemaService cinemaService;
    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaService cinemaService, CinemaRepository cinemaRepository) {
        this.cinemaService = cinemaService;
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping//Localizamos todos los cines
    public List<Cinema> findAll(){
        return this.cinemaService.findAll();
    }

    @GetMapping(path = "/title") //Localizamos los cines que proyectan una peli en concreto
    public List<Cinema> findByTitle(@RequestParam(required = false) String title){
        if(title != null){
            List<Cinema> totalCinemas = cinemaRepository.findByMovies_Title(title);
            totalCinemas.sort(Comparator.comparing(Cinema::getEntryPrice));
            return totalCinemas;
        }else throw new CustomError("Indicar el título es obligatorio para poder encontrar los cines que proyectan dicha pelicula.");
    }

    @GetMapping(path = "/title/zipCode") //Localizamos los cines que proyectan una peli en concreto y con un código postal en concreto
    public List<Cinema> findByZipCode(@RequestParam(required = false) String title, @RequestParam(required = false, name = "zipCode") Integer zipCode){
        if(title != null && zipCode != null){
            List<Cinema> totalCinemas = cinemaRepository.findByMovies_TitleContainingIgnoreCaseAndZipCodeEquals(title, zipCode);
            totalCinemas.sort(Comparator.comparing(Cinema::getEntryPrice));
            return totalCinemas;
        }else throw new CustomError("Todos los campos son obligatorios para poder encontrar los cines que proyectan dicha pelicula.");
    }

    @PostMapping // Dar de alta cines
    public Cinema createCinema(@RequestBody Cinema cinema){ return this.cinemaService.createCinema(cinema);}

    @GetMapping(path = "/{id}") // Buscar cine por id
    public Cinema searchCinema(@PathVariable Long id){

        return cinemaRepository.findByIdEquals(id);
    }

    @PutMapping(path = "/{id}") // Modificar un cine
    public Cinema modifyCinema(@PathVariable Long id, @RequestBody Cinema cinema){
        cinemaService.save(id,cinema);
        return cinema;
    }

    @DeleteMapping(path = "/{id}") //Eliminamos un cine
    String deleteCinema(@PathVariable Long id){
        cinemaService.delete(id);
        return ("Ok");
    }
}
