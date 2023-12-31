package com.capgemini.capgeminispring.api.country;

import com.capgemini.capgeminispring.api.address.Address;
import com.capgemini.capgeminispring.api.city.City;
import com.capgemini.capgeminispring.api.state.State;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID countryId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private Integer population;

    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    private Set<State> countryStates;

    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    private Set<City> countryCities;

    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    private Set<Address> countryAddresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return Objects.equals(countryId, country.countryId);
    }

    @Override
    public int hashCode() {
        return countryId != null ? countryId.hashCode() : 0;
    }

    public UUID getCountryId() {
        return countryId;
    }

    public void setCountryId(UUID countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Set<State> getCountryStates() {
        return countryStates;
    }

    public void setCountryStates(Set<State> countryStates) {
        this.countryStates = countryStates;
    }

    public Set<City> getCountryCities() {
        return countryCities;
    }

    public void setCountryCities(Set<City> countryCities) {
        this.countryCities = countryCities;
    }

    public Set<Address> getCountryAddresses() {
        return countryAddresses;
    }

    public void setCountryAddresses(Set<Address> countryAddresses) {
        this.countryAddresses = countryAddresses;
    }
}
