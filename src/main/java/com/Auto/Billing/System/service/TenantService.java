package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.TenantDto;

import java.util.List;

public interface TenantService {
    void saveTenant(TenantDto tenantDto);

    public List<TenantDto> getTenantDetails();

    public TenantDto updateTenantDetails(TenantDto tenantDto, int tid);

}
