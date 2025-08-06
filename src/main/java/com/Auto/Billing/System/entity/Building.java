package com.Auto.Billing.System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "buildings")
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


    @OneToOne(mappedBy = "buildings", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Caretaker> caretakers;
}
