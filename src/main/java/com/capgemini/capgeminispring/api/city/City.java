package com.capgemini.capgeminispring.api.city;

import com.capgemini.capgeminispring.api.address.Address;
import com.capgemini.capgeminispring.api.country.Country;
import com.capgemini.capgeminispring.api.state.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID cityId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private Integer population;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    @JsonManagedReference
    @OneToMany(mappedBy = "city")
    private Set<Address> cityAddresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return Objects.equals(cityId, city.cityId);
    }

    @Override
    public int hashCode() {
        return cityId != null ? cityId.hashCode() : 0;
    }

    public UUID getCityId() {
        return cityId;
    }

    public void setCityId(UUID cityId) {
        this.cityId = cityId;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<Address> getCityAddresses() {
        return cityAddresses;
    }

    public void setCityAddresses(Set<Address> cityAddresses) {
        this.cityAddresses = cityAddresses;
    }
}
