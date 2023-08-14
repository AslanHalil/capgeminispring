package com.capgemini.capgeminispring.api.state;

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
@RequestMapping("/states")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @GetMapping("/all")
    @JsonManagedReference
    public List<State> getAllStates() {
        List<State> states = new ArrayList<>();
        stateRepository.findAll().forEach(state -> states.add(state));
        return states;
    }

    @GetMapping("/find/{id}")
    public Optional<State> findStateById(@PathVariable("id") UUID id) {
        return stateRepository.findById(id);
    }

}
