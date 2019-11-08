package edu.mum.accountservice.service;

import edu.mum.accountservice.model.Address;

import java.util.List;

public interface AddressService {

    Address saveAddress(Address address);
    Address getAddressById(long id);
    List<Address> getAddresss();
}
