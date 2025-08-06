package com.Auto.Billing.System.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaretakerDto {
    private long cid;
    private String name;
    private String email;
    private String address;
    private long mobileNo;
    private String password;
    private BuildingSummaryDto buildingSummaryDto;
}
