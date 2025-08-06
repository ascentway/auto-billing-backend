package com.Auto.Billing.System.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingSummaryDto {
    private Long id;
    private String buildingName;
    private String address;
}
