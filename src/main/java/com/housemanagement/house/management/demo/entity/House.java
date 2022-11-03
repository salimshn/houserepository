package com.housemanagement.house.management.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House {

    @Id
    @SequenceGenerator(
            name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "house_sequence"
    )
    private Long houseId;

    @Column(length=50, nullable=false)
    private String houseType;


    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "address_id",
            referencedColumnName = "addressId"
    )
    private Address address;

    @ManyToMany(
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "house_share_holder_map",
            joinColumns = @JoinColumn(
                    name = "house_id",
                    referencedColumnName = "houseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "share_holder_id",
                    referencedColumnName = "shareHolderId"
            )
    )
    private List<ShareHolder> shareHolders;

    public void addShareHolder(ShareHolder shareHolder){
        if(shareHolders == null) shareHolders = new ArrayList<>();
        shareHolders.add(shareHolder);
    }
}
