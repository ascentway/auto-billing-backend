package com.Auto.Billing.System.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TenantDto {
    private String name;
    private String email;
    private long mobileNo;
    private int roomNo;
    private int members;

    public TenantDto(String name, int members, long mobileNo, String email, int roomNo) {
        this.name = name;
        this.members = members;
        this.mobileNo = mobileNo;
        this.email = email;
        this.roomNo = roomNo;
    }

}
