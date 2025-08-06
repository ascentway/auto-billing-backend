package com.Auto.Billing.System.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TenantSummaryDto {
    private long tid;
    private String name;
    private long mobileNo;
}
