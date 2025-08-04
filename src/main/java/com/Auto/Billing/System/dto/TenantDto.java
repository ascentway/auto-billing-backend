package com.Auto.Billing.System.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TenantDto {
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

}
