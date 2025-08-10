package com.Auto.Billing.System.entity;

import com.Auto.Billing.System.dto.OwnerDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "building")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    private String buildingName;
    private int totalFlats;
    private String address;
    private String city;
    private long pincode;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Flat> flats;

    @OneToOne(mappedBy = "building")
    private Caretaker caretaker;


}
