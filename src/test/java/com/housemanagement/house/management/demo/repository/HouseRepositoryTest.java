package com.housemanagement.house.management.demo.repository;

import com.housemanagement.house.management.demo.HouseBuilderUtil;
import com.housemanagement.house.management.demo.entity.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HouseRepositoryTest {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManager.persist(HouseBuilderUtil.getNewHouse());
    }

    @Test
    public void whenFindById_thenReturnHouse() {
        House house = houseRepository.findByHouseType("Type 1");
        assertEquals(house.getAddress().getBuildingNo(), "62");
    }
}