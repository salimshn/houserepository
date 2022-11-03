package com.housemanagement.house.management.demo;

import com.housemanagement.house.management.demo.dto.AddressDTO;
import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.dto.ShareHolderDTO;
import com.housemanagement.house.management.demo.entity.Address;
import com.housemanagement.house.management.demo.entity.House;
import com.housemanagement.house.management.demo.entity.ShareHolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public  class HouseBuilderUtil {
    public static House  getExisitingHouse(){
        Address address=Address.builder().addressId(2L).buildingNo("62").detail("adres ile ilgili detay").street("arpa").build();

        List<ShareHolder> holders=new ArrayList<>();
        ShareHolder shareHolder = ShareHolder.builder().shareHolderId(3L).email("asd@gmail.com").dateOfBirth(null)
                .name("John").surname("Black").dateOfBirth(LocalDate.of(1985,1,1)).build();
        holders.add(shareHolder);

        House house = House.builder().houseId(2L).houseType("Type 1").address(address).shareHolders(holders)
                .build();
        return house;
    }
    public static House  getNewHouse(){
        Address address=Address.builder().buildingNo("62").detail("adres ile ilgili detay").street("arpa").build();

        List<ShareHolder> holders=new ArrayList<>();
        ShareHolder shareHolder = ShareHolder.builder().email("asd@gmail.com").dateOfBirth(null)
                .name("John").surname("Black").dateOfBirth(LocalDate.of(1985,1,1)).build();
        holders.add(shareHolder);

        House house = House.builder().houseType("Type 1").address(address).shareHolders(holders)
                .build();
        return house;
    }

    public static HouseDTO getExisitingHouseDTO(){
        AddressDTO address=AddressDTO.builder().addressId(2L).buildingNo("62").detail("adres ile ilgili detay").street("arpa").build();

        List<ShareHolderDTO> holders=new ArrayList<>();
        ShareHolderDTO shareHolder = ShareHolderDTO.builder().shareHolderId(3L).email("asd@gmail.com").dateOfBirth(null)
                .name("John").surname("Black").dateOfBirth(LocalDate.of(1985,1,1)).build();
        holders.add(shareHolder);

        HouseDTO house = HouseDTO.builder().houseId(2L).houseType("Type 1").address(address).shareHolders(holders)
                .build();
        return house;
    }
    public static HouseDTO  getNewHouseDTO(){
        AddressDTO address=AddressDTO.builder().buildingNo("62").detail("adres ile ilgili detay").street("arpa").build();

        List<ShareHolderDTO> holders=new ArrayList<>();
        ShareHolderDTO shareHolder = ShareHolderDTO.builder().email("asd@gmail.com").dateOfBirth(null)
                .name("John").surname("Black").dateOfBirth(LocalDate.of(1985,1,1)).build();
        holders.add(shareHolder);

        HouseDTO house = HouseDTO.builder().houseType("Type 1").address(address).shareHolders(holders)
                .build();
        return house;
    }
}
