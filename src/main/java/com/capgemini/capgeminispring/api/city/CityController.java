package com.capgemini.capgeminispring.api.city;

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
@RequestMapping("/cities")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/all")
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cities.add(city));
        return cities;
    }

    @GetMapping("/find/{id}")
    public Optional<City> findCityById(@PathVariable("id") UUID id) {
        return cityRepository.findById(id);
    }

}
