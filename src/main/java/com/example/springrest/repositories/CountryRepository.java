package com.example.springrest.repositories;

import com.example.springrest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    List<Country> getCountriesByNameStartingWith(String name);

    List<Country> getCountriesByCodeName(String codeName);

    List<Country> getCountriesByName(String name);
}
