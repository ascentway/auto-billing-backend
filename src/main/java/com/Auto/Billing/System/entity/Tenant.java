package com.Auto.Billing.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private long mobileNo;
    private int roomNo;
    private int members;


}
