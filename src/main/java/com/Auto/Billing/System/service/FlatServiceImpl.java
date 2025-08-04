package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.FlatDto;
import com.Auto.Billing.System.dto.TenantDto;
import com.Auto.Billing.System.entity.Building;
import com.Auto.Billing.System.entity.Flat;
import com.Auto.Billing.System.repository.BuildingRepository;
import com.Auto.Billing.System.repository.FlatRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.JavaInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlatServiceImpl implements FlatService{

    @Autowired
    private  FlatRepository flatRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ModelMapper modelMapper;

    public void addFlat(FlatDto flatDto) {
        Building building = buildingRepository.findById(flatDto.getBid());
        Flat flats = new Flat();
        flats.setFlatId(flatDto.getFlatId());
        flats.setFlatNo(flatDto.getFlatNo());
        flats.setFlatType(flatDto.getFlatType());
        flats.setMaxTenants(flatDto.getMaxTenants());
        flats.setFloor(flatDto.getFloor());
        flats.setOccupied(flatDto.isOccupied());
        flats.setBuilding(building);
        flatRepository.save(flats);
    }

    @Override
    public List<FlatDto> getAllFlats() {
        List<Flat> flats = new ArrayList<>();
        flats = flatRepository.findAll();
        List<FlatDto> flatDtoList = new ArrayList<>();
        flatDtoList = flats.stream().map(f -> modelMapper.map(f,FlatDto.class)).toList();
        return flatDtoList;
    }

    @Override
    public FlatDto getFlatById(int flatId) {
        Flat flat = flatRepository.findById(flatId);
        FlatDto flatDto = modelMapper.map(flat, FlatDto.class);
        return  flatDto;
    }

    @Override
    public void updateField(int flatId, FlatDto flatDto) {
        Flat flat = flatRepository.findById(flatId);
        if(!flat.getFlatType().equalsIgnoreCase(flatDto.getFlatType())){
            flat.setFlatType(flatDto.getFlatType());
        }
        flat.setFlatNo(flatDto.getFlatNo());
        flat.setOccupied(flatDto.isOccupied());
        flat.setFloor(flatDto.getFloor());
        flatRepository.save(flat);
    }

    @Override
    public void deleteFlat(int flatId) {
        Flat flat = flatRepository.findById(flatId);
        flatRepository.delete(flat);
    }

}
