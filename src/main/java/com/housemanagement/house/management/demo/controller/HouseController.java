package com.housemanagement.house.management.demo.controller;

import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.error.house.HouseNotFoundException;
import com.housemanagement.house.management.demo.error.shareholder.AddressExistException;
import com.housemanagement.house.management.demo.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    //slf4j -springbootstarter
    private final Logger LOGGER = LoggerFactory.getLogger(HouseController.class);

   @GetMapping(value = "/houses")
    public List<HouseDTO> fetchHouseList() {
        LOGGER.info("Inside fetchHouseList of HouseController");
        return houseService.fetchHouseList();
    }

    @PostMapping("houses")
    public HouseDTO saveHouse(@Valid @RequestBody HouseDTO house) throws AddressExistException {
    LOGGER.info("Inside saveHouse of HouseController");
    return houseService.saveHouse(house);
    }

    @GetMapping("/houses/{id}")
    public HouseDTO fetchHouseById(@PathVariable("id") Long houseId) throws HouseNotFoundException {
        LOGGER.info("Inside fetchHouseById of HouseController");
        return houseService.fetchHouseById(houseId);
    }

    @DeleteMapping("/houses/{id}")
    public String deleteHouseById(@PathVariable("id") Long houseId) throws HouseNotFoundException{
        LOGGER.info("Inside fetchHouseList of HouseController");
        houseService.deleteHouseById(houseId);
        return "House deleted Successfully!!";
    }

    /**
    @PutMapping("/houses/{id}")
    public House updateHouse(@PathVariable("id") Long houseId, @RequestBody House house) {
        LOGGER.info("Inside updateHouse of HouseController");
        return houseService.updateHouse(houseId,house);
    }*/
}
