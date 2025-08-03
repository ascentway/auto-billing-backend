package com.Auto.Billing.System.controller;

import com.Auto.Billing.System.dto.TenantDto;
import com.Auto.Billing.System.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")

public class TenantController {

    @Autowired
    TenantService tenantService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTenantDetails(@RequestBody TenantDto tenantDto){
        System.out.println(tenantDto.toString());
        tenantService.saveTenant(tenantDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tenant Details Saved Successfully");
    }

    @GetMapping("/details")
    public ResponseEntity<List<TenantDto>> getAllTenants(){
        List<TenantDto> tenants = tenantService.getTenantDetails();
        return ResponseEntity.status(HttpStatus.OK).body(tenants);
    }

    @PutMapping("/update/{tid}")
    public TenantDto updateTenantDetails(@PathVariable int tid, @RequestBody TenantDto tenantDto){
        return tenantService.updateTenantDetails(tenantDto, tid);
    }
}
