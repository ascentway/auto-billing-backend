package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.TenantDto;
import com.Auto.Billing.System.entity.Tenant;
import com.Auto.Billing.System.repository.TenantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveTenant(TenantDto tenantDto) {
        Tenant tenant=new Tenant();
        tenant.setName(tenantDto.getName());
        tenant.setEmail(tenantDto.getEmail());
        tenant.setMobileNo(tenantDto.getMobileNo());
        tenant.setAddress(tenantDto.getAddress());
        tenant.setPassword(tenantDto.getPassword());
        tenant.setGuardianName(tenantDto.getGuardianName());
        tenant.setGuardianMobileNo(tenantDto.getGuardianMobileNo());
        tenant.setRent(tenantDto.getRent());
        tenant.setMaintenanceCharge(tenantDto.getMaintenanceCharge());

        tenantRepository.save(tenant);
    }

    @Override
    public List<TenantDto> getTenantDetails() {
        List<Tenant> tenants = new ArrayList<>();
        tenants = tenantRepository.findAll();
        List<TenantDto> tenantList = new ArrayList<>();
        tenantList = tenants.stream().map(t -> modelMapper.map(t,TenantDto.class)).toList();
        return tenantList;
    }

    @Override
    public TenantDto updateTenantDetails(TenantDto tenantDto, int tid) {
        Tenant tenant = tenantRepository.findById(tid);

        return null;
    }
}
