package com.capgemini.capgeminispring;

import com.capgemini.capgeminispring.api.address.Address;
import com.capgemini.capgeminispring.api.city.City;
import com.capgemini.capgeminispring.api.city.CityRepository;
import com.capgemini.capgeminispring.api.country.Country;
import com.capgemini.capgeminispring.api.customer.Customer;
import com.capgemini.capgeminispring.api.customer.CustomerRepository;
import com.capgemini.capgeminispring.api.state.State;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SampleDataLoader {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CityRepository cityRepository;

    @PostConstruct
    public void populateDatabase() {
        long count = customerRepository.count();
        if (count == 0) {
            createCustomers();
        }
    }

    private List<Customer> createCustomers() {
        String[] names = {"William", "Elizabeth", "James", "Mary", "John", "Sarah", "Michael", "Emily", "David", "Jessica"};
        String[] surnames = {"Smith", "Johnson", "Brown", "Davis", "Garcia", "Wilson", "Jones", "Jackson", "Anderson", "Harris"};
        String[] streetNames = {"Oak", "Maple", "Pine", "Cedar", "Elm", "Main", "High", "Park", "Washington", "Adams"};
        String[] cityIds = {"45576d7c-8d84-4422-9440-19ef80fa16f3",
                "91f360d5-811b-417c-a202-f5ba4b34b895",
                "144b05b6-ebf6-43a8-836d-0998c2c20a3c",
                "74716a04-d538-4441-84bf-7c41470778ca",
                "eb5e9505-8580-4857-9195-6bee0324ac0f"};

        Random random = new Random();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setName(names[i]);
            customer.setSurname(surnames[i]);
            customer.setEmail(customer.getName().toLowerCase() + "." + customer.getSurname().toLowerCase() + "@example.com");
            City city = findCity(cityIds[i / 2]);
            Address a = new Address();
            a.setCity(city);
            State s = new State();
            s.setStateId(city.getState().getStateId());
            a.setState(s);
            Country co = new Country();
            co.setCountryId(city.getCountry().getCountryId());
            a.setCountry(co);
            a.setAddress(streetNames[i] + " Street " + random.nextInt(100));
            customer.setAddress(a);
            customers.add(customerRepository.save(customer));
        }
        return customers;
    }

    private City findCity(String cityId) {
        return cityRepository.findById(UUID.fromString(cityId)).get();
    }


}
