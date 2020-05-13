package com.example.springrest.services;

import com.example.springrest.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountriesByNameStartingWith(String name);

    List<Country> getCountriesByCodeName(String codeName);

    List<Country> getCountriesByName(String name);

    void deleteById(int id);

    Country update(Country country);

    Country create(Country country);

}
