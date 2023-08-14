package com.capgemini.capgeminispring.api.address;

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
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/all")
    public List<Address> getAllAddresses() {
        List<Address> addressList = new ArrayList<>();
        addressRepository.findAll().forEach(addressList::add);
        return addressList;
    }

    @GetMapping("/find/{id}")
    public Optional<Address> findAddressById(@PathVariable("id") UUID id) {
        return addressRepository.findById(id);
    }


}
