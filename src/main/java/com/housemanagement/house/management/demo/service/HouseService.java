package com.housemanagement.house.management.demo.service;


import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.error.house.HouseNotFoundException;
import com.housemanagement.house.management.demo.error.shareholder.AddressExistException;

import javax.validation.Valid;
import java.util.List;


public interface HouseService {

    HouseDTO saveHouse(@Valid HouseDTO house) throws AddressExistException;

    List<HouseDTO> fetchHouseList();

    HouseDTO fetchHouseById(Long houseId) throws HouseNotFoundException;

    void deleteHouseById(Long houseId) throws HouseNotFoundException;

   // House updateHouse(Long houseId, House house);

}
