package edu.mum.accountservice.serviceImpl;

import edu.mum.accountservice.model.Address;
import edu.mum.accountservice.repository.AddressRepository;
import edu.mum.accountservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> getAddresss() {
        return (List<Address>) addressRepository.findAll();
    }
}
