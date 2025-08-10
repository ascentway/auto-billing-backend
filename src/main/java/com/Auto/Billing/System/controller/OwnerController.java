package com.Auto.Billing.System.controller;


import com.Auto.Billing.System.dto.OwnerDto;
import com.Auto.Billing.System.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/addOwner")
    public ResponseEntity<String> addOwner(@RequestBody OwnerDto ownerDto){
        System.out.println(ownerDto.toString());
        ownerService.addOwner(ownerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Owner added Successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<OwnerDto>> getAllOwners(){
        List<OwnerDto> ownerDtos = ownerService.getAllOwners();
        return ResponseEntity.status(HttpStatus.FOUND).body(ownerDtos);
    }

    @PutMapping("/edit/{oid}")
    public ResponseEntity<String> updateOwner(@PathVariable int oid, @RequestBody OwnerDto ownerDto){
        System.out.println(ownerDto.toString());
        ownerService.updateOwner(oid, ownerDto);
        return ResponseEntity.status(HttpStatus.OK).body("Details Updated Successfully");
    }

    @DeleteMapping("/delete/{oid}")
    public ResponseEntity<String> deleteOwner(@PathVariable int oid){
        ownerService.deleteOwner(oid);
        return ResponseEntity.status(HttpStatus.OK).body("Owner Removed Successfully");
    }
}
