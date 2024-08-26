package com.cev.prueba_2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter // Crea de forma interna todos los Getters
@Setter // Crea de forma interna todos los Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String population;
    private int zipCode;
    private String province;
    private float entryPrice;
    @ManyToMany
    private List<Movie> movies;

}
