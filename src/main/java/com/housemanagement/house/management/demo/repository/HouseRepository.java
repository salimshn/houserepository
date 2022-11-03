package com.housemanagement.house.management.demo.repository;

import com.housemanagement.house.management.demo.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    House findByHouseType(String houseType);
}
