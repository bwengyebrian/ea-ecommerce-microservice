package edu.mum.stockservice.serviceImpl;

import edu.mum.stockservice.model.Vendor;
import edu.mum.stockservice.repository.VendorRepository;
import edu.mum.stockservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}
