package com.Auto.Billing.System.controller;

import com.Auto.Billing.System.dto.RoleDto;
import com.Auto.Billing.System.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roles = roleService.getRoles();
        return ResponseEntity.status(HttpStatus.FOUND).body(roles);
    }
}
