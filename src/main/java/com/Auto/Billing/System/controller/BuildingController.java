package com.Auto.Billing.System.controller;

import com.Auto.Billing.System.dto.BuildingDto;
import com.Auto.Billing.System.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/addBuilding")
    public ResponseEntity<String> addBuilding(@RequestBody BuildingDto buildingDto){
        System.out.println(buildingDto.toString());
        buildingService.addBuilding(buildingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Building Details Added Successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<BuildingDto>> getAllBuildings(){
        List<BuildingDto> buildingDtos = buildingService.getAllBuildings();
        return ResponseEntity.status(HttpStatus.FOUND).body(buildingDtos);
    }

    @GetMapping("/details/{bid}")
    public ResponseEntity<BuildingDto> getBuildingById(@PathVariable int bid) {
        BuildingDto buildingDto = buildingService.getBuildingById(bid);
        return ResponseEntity.status(HttpStatus.FOUND).body(buildingDto);
    }

    @PutMapping("/edit/{bid}")
    public ResponseEntity<String> updateBuilding(@PathVariable int bid, @RequestBody BuildingDto buildingDto){
        buildingService.updateBuilding(bid, buildingDto);
        return ResponseEntity.status(HttpStatus.OK).body("Details of the building updated successfully");
    }

    @DeleteMapping("/delete/{bid}")
    public ResponseEntity<String> deleteBuilding(@PathVariable int bid){
        buildingService.deleteBuilding(bid);
        return ResponseEntity.status(HttpStatus.OK).body("Building Details Removed Successfully");
    }
}
