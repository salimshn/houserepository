package com.housemanagement.house.management.demo.service;


import com.housemanagement.house.management.demo.HouseBuilderUtil;
import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.entity.House;
import com.housemanagement.house.management.demo.repository.HouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HouseServiceTest {

    @Autowired
    private HouseService houseService;

    @MockBean
    private HouseRepository houseRepository;

    @BeforeEach
    void setUp() {
        House house= HouseBuilderUtil.getExisitingHouse();
        Optional<House> optionalHouse =Optional.of(house);
        Mockito.when(houseRepository.findById(2L)).thenReturn(optionalHouse);

    }

    @Test
    @DisplayName("Get Data based on Validate House ID")
    public void whenValidHouseId_thenHouseShouldFound() throws Exception{
        Long houseId = 2L;
        HouseDTO found = houseService.fetchHouseById(houseId);
        assertEquals(houseId, found.getHouseId());
    }
}