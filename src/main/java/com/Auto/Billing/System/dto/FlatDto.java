package com.Auto.Billing.System.dto;

import com.Auto.Billing.System.entity.Tenant;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FlatDto {

    private int flatId;
    private String flatNo;
    private String flatType;
    private int maxTenants;
    private int floor;
    private boolean isOccupied;
    private int bid;
    private List<Tenant> tenants;

}
