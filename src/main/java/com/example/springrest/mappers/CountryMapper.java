package com.example.springrest.mappers;

import com.example.springrest.dto.CountryDto;
import com.example.springrest.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CountryMapper {

    public Country dtoToCountry(CountryDto dto){
        Country country = new Country();
        country.setId(dto.getId());
        country.setCodeName(dto.getCodeName());
        country.setName(dto.getName());
        return country;
    }

    public CountryDto countryToDto(Country country){
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setCodeName(country.getCodeName());
        dto.setName(country.getName());
        return dto;
    }

    public List<Country> dtoCollectionToCountryList(Collection<CountryDto> dtos){
        List<Country> countries = new ArrayList<>(dtos.size());
        for (CountryDto dto: dtos) {
            countries.add(dtoToCountry(dto));
        }
        return countries;
    }

    public List<CountryDto> countriesCollectionToDtoList(Collection<Country> countries){
        List<CountryDto> dtos = new ArrayList<>(countries.size());
        for (Country country: countries) {
            dtos.add(countryToDto(country));
        }
        return dtos;
    }
}
