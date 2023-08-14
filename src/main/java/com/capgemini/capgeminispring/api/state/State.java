package com.capgemini.capgeminispring.api.state;

import com.capgemini.capgeminispring.api.address.Address;
import com.capgemini.capgeminispring.api.city.City;
import com.capgemini.capgeminispring.api.country.Country;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "states")
public class State {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID stateId;

    @Column(nullable = false, length = 64)
    private String name;

    @Column
    private Integer population;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "state")
    private Set<City> stateCities;

    @OneToMany(mappedBy = "state")
    private Set<Address> stateAddresses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return Objects.equals(stateId, state.stateId);
    }

    @Override
    public int hashCode() {
        return stateId != null ? stateId.hashCode() : 0;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
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

    public Set<City> getStateCities() {
        return stateCities;
    }

    public void setStateCities(Set<City> stateCities) {
        this.stateCities = stateCities;
    }

    public Set<Address> getStateAddresses() {
        return stateAddresses;
    }

    public void setStateAddresses(Set<Address> stateAddresses) {
        this.stateAddresses = stateAddresses;
    }
}
