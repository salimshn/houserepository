package com.housemanagement.house.management.demo.service.impl;

import com.housemanagement.house.management.demo.entity.Address;
import com.housemanagement.house.management.demo.repository.AddressRepository;
import com.housemanagement.house.management.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    MessageSource messageSource ;

    @Override
    public Address findDistinctByStreetAndBuildingNo(String street, String buildingNo) {
        return addressRepository
                .findDistinctByStreetAndBuildingNo(street,buildingNo);
    }
}
