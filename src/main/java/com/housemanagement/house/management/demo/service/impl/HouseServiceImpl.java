package com.housemanagement.house.management.demo.service.impl;

import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.dto.mapper.HouseMapper;
import com.housemanagement.house.management.demo.entity.Address;
import com.housemanagement.house.management.demo.entity.House;
import com.housemanagement.house.management.demo.error.house.HouseNotFoundException;
import com.housemanagement.house.management.demo.error.shareholder.AddressExistException;
import com.housemanagement.house.management.demo.repository.HouseRepository;
import com.housemanagement.house.management.demo.service.AddressService;
import com.housemanagement.house.management.demo.service.HouseService;
import com.housemanagement.house.management.demo.service.MessageResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    MessageSource messageSource ;

    @Autowired
    private AddressService addressService;

    @Override
    public HouseDTO saveHouse(@Valid HouseDTO houseDTO) throws AddressExistException {

        // Check the address already exist
        Address address=addressService
                .findDistinctByStreetAndBuildingNo(houseDTO.getAddress().getStreet(),houseDTO.getAddress().getBuildingNo());

        if(Objects.nonNull(address)){
            throw new AddressExistException(MessageResourceUtil.getMessage("address.exist",messageSource));
        }

        House house = HouseMapper.INSTANCE.map(houseDTO);
        return HouseMapper.INSTANCE.mapToDTO(houseRepository.save(house));
    }

    @Override
    public List<HouseDTO> fetchHouseList() {
        List<House> houseList=houseRepository.findAll();
        List<House> sortedHouseList =houseList.stream()
                .sorted(Comparator.comparingLong(House::getHouseId).reversed())
                .collect(Collectors.toList());
        return HouseMapper.INSTANCE.mapToDTOList(sortedHouseList);
    }

    @Override
    public HouseDTO fetchHouseById(Long houseId) throws HouseNotFoundException {

        House house= houseRepository.findById(houseId)
                .orElseThrow(() -> new HouseNotFoundException(MessageResourceUtil.getMessage("house.notfound",messageSource)));
        return HouseMapper.INSTANCE.mapToDTO(house);
    }

    @Override
    public void deleteHouseById(Long houseId) throws HouseNotFoundException {
        try {
            houseRepository.deleteById(houseId);
        }catch(EmptyResultDataAccessException e) {
            throw new HouseNotFoundException(MessageResourceUtil.getMessage("house.notfound",messageSource));
        }

    }

   /** @Override
    public House updateHouse(Long houseId, House house) {
        House depDB = houseRepository.findById(houseId).get();

        if(Objects.nonNull(house.getHouseType()) &&
                !"".equalsIgnoreCase(house.getHouseType())) {
            depDB.setHouseType(house.getHouseType());
        }

        return houseRepository.save(depDB);
    }*/
}
