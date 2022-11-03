package com.housemanagement.house.management.demo.service;

import com.housemanagement.house.management.demo.entity.Address;

public interface AddressService {

    Address findDistinctByStreetAndBuildingNo(String street, String buildingNo);

}
