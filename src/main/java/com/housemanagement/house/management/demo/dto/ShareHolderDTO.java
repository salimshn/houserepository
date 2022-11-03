package com.housemanagement.house.management.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShareHolderDTO {

    @Positive
    private Long shareHolderId;

    @NotBlank(message = "{shareholder.name.notfound}")
    @Length(max = 50,min =1)
    private String name;

    @NotBlank(message = "{shareholder.surname.notfound}")
    @Length(max = 50,min =1)
    private String surname;

    @Email(message = "{shareholder.email.badformat}")
    private String email;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Past(message = "{shareholder.dateOfBirth.mustpast}")
    private LocalDate dateOfBirth;


}
