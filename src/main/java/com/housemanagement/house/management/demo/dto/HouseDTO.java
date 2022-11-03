package com.housemanagement.house.management.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseDTO {

    @Positive
    private Long houseId;

    @NotBlank(message = "{housetype.notfound}")
    @Length(max = 10,min =1)
    private String houseType;

    @NotNull(message = "{address.notfound}")
    @Valid
    private AddressDTO address;

    @NotEmpty(message = "{shareholder.notfound}")
    @Valid
    private List<ShareHolderDTO> shareHolders;

    public void addShareHolder(ShareHolderDTO shareHolder){
        if(shareHolders == null) shareHolders = new ArrayList<>();
        shareHolders.add(shareHolder);
    }

}
