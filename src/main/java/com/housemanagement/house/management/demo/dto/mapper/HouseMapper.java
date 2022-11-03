package com.housemanagement.house.management.demo.dto.mapper;

import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.entity.House;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HouseMapper {

    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    House map(HouseDTO houseDTO);

    HouseDTO mapToDTO(House house);

    List<HouseDTO> mapToDTOList(List<House> houses);
}
