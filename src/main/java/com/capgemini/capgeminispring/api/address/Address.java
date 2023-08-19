package com.capgemini.capgeminispring.api.address;

import com.capgemini.capgeminispring.api.city.City;
import com.capgemini.capgeminispring.api.country.Country;
import com.capgemini.capgeminispring.api.state.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private UUID addressId;

    @Column(nullable = false, length = 128)
    private String address;

    @Column(length = 16)
    private String postalCode;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, insertable = true)
    private Country country;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, insertable = true)
    private City city;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "state_id", insertable = true)
    private State state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {
        return addressId != null ? addressId.hashCode() : 0;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
