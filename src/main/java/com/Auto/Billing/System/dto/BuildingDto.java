package com.Auto.Billing.System.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingDto {
    private Long bid;
    private String buildingName;
    private int totalFlats;
    private String address;
    private String city;
    private long pincode;

    private int occupiedFlats;
    private int vacantFlats;
    private int maintenanceFlats;
    private int bookedFlats;

    private List<CaretakerDto> caretakerDtos;
}
