package com.Auto.Billing.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Caretaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int cid;
        private String name;
        private String email;
        private String address;
        private long mobileNo;
        private String password;
}
