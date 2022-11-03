package com.housemanagement.house.management.demo.repository;

import com.housemanagement.house.management.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findDistinctByStreetAndBuildingNo(String street,String buildingNo);
}
