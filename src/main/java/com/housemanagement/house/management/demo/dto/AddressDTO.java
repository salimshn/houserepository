package com.housemanagement.house.management.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    @Positive
    private Long addressId;

    @NotBlank(message = "{address.detail.notfound}")
    @Length(max = 1000,min =1)
    private String detail;
    @NotBlank(message = "{address.street.notfound}")
    private String street;
    @NotBlank(message = "{address.buildingno.notfound}")
    private String buildingNo;

}
