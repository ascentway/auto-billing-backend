package com.Auto.Billing.System.controller;

import com.Auto.Billing.System.dto.TenantDto;
import com.Auto.Billing.System.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant")
@RequiredArgsConstructor
public class TenantController {

    @Autowired
    private TenantService tenantService;

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

    @GetMapping("/details/{tid}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable long tid){
        TenantDto tenantDto = tenantService.getTenantById(tid);
        return ResponseEntity.status(HttpStatus.FOUND).body(tenantDto);
    }

    @PutMapping("/update/{tid}")
    public ResponseEntity<String> updateTenantDetails(@PathVariable long tid, @RequestBody TenantDto tenantDto){
        tenantService.updateTenantDetails(tid, tenantDto);
        return ResponseEntity.status(HttpStatus.OK).body("Details Updated Successfully");
    }

    @DeleteMapping("/delete/{tid}")
    public ResponseEntity<String> deleteTenant(@PathVariable int tid){
        tenantService.deleteTenant(tid);
        return ResponseEntity.status(HttpStatus.OK).body("Tenant Removed Successfully.");
    }
}
