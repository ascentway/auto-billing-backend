package com.Auto.Billing.System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name ="tenant")
@Getter
@Setter

public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;
    private String name;
    private String email;
    private String password;
    private long mobileNo;
    private String address;
    private String guardianName;
    private long guardianMobileNo;
    private int rent;
    private int maintenanceCharge;
    @ManyToOne
    @JoinColumn(name = "flatId") // Foreign key column in the Item table
    private Flat flat;


}
