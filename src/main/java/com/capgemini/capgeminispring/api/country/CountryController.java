package com.capgemini.capgeminispring.api.country;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/all")
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(country -> countries.add(country));
        return countries;
    }

    @GetMapping("/find/{id}")
    public Optional<Country> findCityById(@PathVariable("id") UUID id) {
        return countryRepository.findById(id);
    }


}
