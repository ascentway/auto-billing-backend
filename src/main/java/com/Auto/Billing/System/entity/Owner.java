package com.Auto.Billing.System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private String name;
    private String email;
    private long phoneNo;
    private String password;

    @OneToMany
    private List<Building> buildings = new ArrayList<>();

}
