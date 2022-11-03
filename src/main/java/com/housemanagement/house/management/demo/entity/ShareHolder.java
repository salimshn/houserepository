package com.housemanagement.house.management.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShareHolder {

    @Id
    @SequenceGenerator(
            name = "share_holder_sequence",
            sequenceName = "share_holder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "share_holder_sequence"
    )
    private Long shareHolderId;

    @Column(length=100, nullable=false)
    private String name;

    @Column(length=100, nullable=false)
    private String surname;

    @Column(length=100, nullable=false)
    private String email;

    @Column(nullable=false)
    private LocalDate dateOfBirth;

}
