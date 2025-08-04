package com.Auto.Billing.System.dto;

import lombok.*;

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

}
