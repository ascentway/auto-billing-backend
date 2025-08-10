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
    public void updateTenantDetails(long tid, TenantDto tenantDto) {
        Tenant tenant = tenantRepository.findById(tid);
        if (tenantDto.getMobileNo() != 0) {
            tenant.setMobileNo(tenantDto.getMobileNo());
        }
        if (tenantDto.getEmail() != null && !tenantDto.getEmail().isEmpty()) {
            tenant.setEmail(tenantDto.getEmail());
        }
        if (tenantDto.getPassword() != null && !tenantDto.getPassword().isEmpty()) {
            tenant.setPassword(tenantDto.getPassword());
        }
        if (tenantDto.getPassword() != null && !tenantDto.getPassword().isEmpty()) {
            tenant.setPassword(tenantDto.getPassword());
        }
        if (tenantDto.getMaintenanceCharge() != 0) {
            tenant.setMaintenanceCharge(tenantDto.getMaintenanceCharge());
        }
        if (tenantDto.getRent() != 0) {
            tenant.setRent(tenantDto.getRent());
        }
        tenantRepository.save(tenant);
    }


    @Override
    public void deleteTenant(long tid) {
        Tenant tenant = tenantRepository.findById(tid);
        tenantRepository.delete(tenant);
    }

    @Override
    public TenantDto getTenantById(long tid) {
        Tenant tenant = tenantRepository.findById(tid);
        TenantDto tenantDto = modelMapper.map(tenant, TenantDto.class);
        return tenantDto;
    }
}
