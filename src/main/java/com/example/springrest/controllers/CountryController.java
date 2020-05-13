package com.example.springrest.controllers;

import com.example.springrest.dto.CountryDto;
import com.example.springrest.mappers.CountryMapper;
import com.example.springrest.model.Country;
import com.example.springrest.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryMapper countryMapper;

    @RequestMapping("/country-starts-with")
    @ResponseBody
    public List<Country> getCountriesByNameStartingWith(@RequestParam String name) {
        return countryService.getCountriesByNameStartingWith(name);
    }

    @RequestMapping("/country-by-codename")
    @ResponseBody
    public List<CountryDto> getCountriesByCodeName(@RequestParam String codeName) {
        return countryMapper.countriesCollectionToDtoList(countryService.getCountriesByCodeName(codeName));
    }

    @RequestMapping("/country-by-name")
    @ResponseBody
    public List<CountryDto> getCountriesByName(@RequestParam String name) {
        return countryMapper.countriesCollectionToDtoList(countryService.getCountriesByName(name));
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void deleteById(@RequestParam int id) {
        countryService.deleteById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public CountryDto updateCountry(@RequestBody CountryDto countryDto) {
        Country countryToUpdate = countryMapper.dtoToCountry(countryDto);
        return countryMapper.countryToDto(countryService.update(countryToUpdate));
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CountryDto addCountry(@RequestBody CountryDto countryDto) {
        Country countryToCreate = countryMapper.dtoToCountry(countryDto);
        return countryMapper.countryToDto(countryService.create(countryToCreate));
    }

}
