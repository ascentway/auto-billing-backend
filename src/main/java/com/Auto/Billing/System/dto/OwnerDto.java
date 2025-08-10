package com.Auto.Billing.System.dto;

import com.Auto.Billing.System.entity.Building;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerDto {
    private int oid;
    private String name;
    private String email;
    private long phoneNo;
    private String password;
    private List<Building> buildingList;
}
