package com.example.springrest.services;

import com.example.springrest.exceptions.CountryNotFoundException;
import com.example.springrest.model.Country;
import com.example.springrest.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getCountriesByNameStartingWith(String name) {
        return countryRepository.getCountriesByNameStartingWith(name);
    }

    @Override
    public List<Country> getCountriesByCodeName(String codeName) {
        return countryRepository.getCountriesByCodeName(codeName.toUpperCase());
    }

    @Override
    public List<Country> getCountriesByName(String name) {
        return countryRepository.getCountriesByName(name);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country update(Country country) {
        Optional<Country> existing = countryRepository.findById(country.getId());
        if(existing.isPresent()) {
            return countryRepository.save(country);
        }
        throw new CountryNotFoundException("Given country doesn't exist");
    }

    @Override
    public Country create(Country country) {
        return countryRepository.saveAndFlush(country);
    }
}
