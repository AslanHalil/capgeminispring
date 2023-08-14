package com.capgemini.capgeminispring.api.country;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CountryRepository extends CrudRepository<Country, UUID> {
}
