package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.TenantDto;

import java.util.List;

public interface TenantService {
    void saveTenant(TenantDto tenantDto);

    public List<TenantDto> getTenantDetails();

    public void updateTenantDetails(long tid, TenantDto tenantDto);

    public void deleteTenant(long tid);

    public TenantDto getTenantById(long tid);
}
