package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.BuildingDto;

import java.util.List;

public interface BuildingService {
    public void addBuilding(BuildingDto buildingDto);

    public List<BuildingDto> getAllBuildings();

    public BuildingDto getBuildingById(long bid);

    public void updateBuilding(long bid, BuildingDto buildingDto);

    public void deleteBuilding(long bid);
}
