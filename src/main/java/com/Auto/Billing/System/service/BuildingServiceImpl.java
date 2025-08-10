package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.BuildingDto;
import com.Auto.Billing.System.entity.Building;
import com.Auto.Billing.System.repository.BuildingRepository;
import com.Auto.Billing.System.repository.FlatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Service
public class BuildingServiceImpl implements BuildingService{

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addBuilding(BuildingDto buildingDto) {
        Building building = new Building();
        building.setBid(buildingDto.getBid());
        building.setBuildingName(buildingDto.getBuildingName());
        building.setTotalFlats(buildingDto.getTotalFlats());
        building.setAddress(buildingDto.getAddress());
        building.setCity(buildingDto.getCity());
        building.setPincode(buildingDto.getPincode());
        buildingRepository.save(building);

//// Calculate values dynamically
//        dto.setOccupiedFlats(flatRepository.countByBuildingAndStatus(building, "OCCUPIED"));
//        dto.setVacantFlats(flatRepository.countByBuildingAndStatus(building, "VACANT"));
//        dto.setMaintenanceFlats(flatRepository.countByBuildingAndStatus(building, "MAINTENANCE"));
//        dto.setBookedFlats(flatRepository.countByBuildingAndStatus(building, "BOOKED"));

    }

    @Override
    public List<BuildingDto> getAllBuildings() {
        List<Building> buildings = new ArrayList<>();
        buildings = buildingRepository.findAll();
        List<BuildingDto> buildingDtoList = new ArrayList<>();
        buildingDtoList = buildings.stream().map(b -> modelMapper.map(b,BuildingDto.class)).toList();
        return buildingDtoList;
    }

    @Override
    public BuildingDto getBuildingById(long bid) {
        Building building = buildingRepository.findById(bid);
        BuildingDto buildingDto = modelMapper.map(building, BuildingDto.class);
        return buildingDto;
    }

    @Override
    public void updateBuilding(long bid, BuildingDto buildingDto) {
        Building building = buildingRepository.findById(bid);
        building.setBuildingName(buildingDto.getBuildingName());
        building.setTotalFlats(buildingDto.getTotalFlats());
        buildingRepository.save(building);
    }

    @Override
    public void deleteBuilding(long bid) {
        Building building = buildingRepository.findById(bid);
        buildingRepository.delete(building);

    }
}
