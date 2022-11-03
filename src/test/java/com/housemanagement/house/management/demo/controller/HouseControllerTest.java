package com.housemanagement.house.management.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.housemanagement.house.management.demo.HouseBuilderUtil;
import com.housemanagement.house.management.demo.dto.HouseDTO;
import com.housemanagement.house.management.demo.service.HouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HouseController.class)
class HouseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HouseService houseService;

    private HouseDTO house;

    @BeforeEach
    void setUp() {

        house = HouseBuilderUtil.getExisitingHouseDTO();
    }

    @Test
    void saveHouse() throws Exception {

        HouseDTO inputHouse=HouseBuilderUtil.getExisitingHouseDTO();

        Mockito.when(houseService.saveHouse(inputHouse))
                .thenReturn(house);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(inputHouse);
        mockMvc.perform(post("/houses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
        }

    @Test
    void fetchHouseById() throws Exception {
        Mockito.when(houseService.fetchHouseById(1L))
                    .thenReturn(house);

        mockMvc.perform(get("/houses/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.houseType").
                        value(house.getHouseType()));
    }

}