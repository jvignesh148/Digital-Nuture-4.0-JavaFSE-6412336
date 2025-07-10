package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public Country getCountryByCode(String code) {
        Optional<Country> optional = countryRepository.findById(code);
        return optional.orElse(null);
    }

    public List<Country> searchCountriesByName(String partialName) {
        return countryRepository.findByCoNameContainingIgnoreCase(partialName);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
