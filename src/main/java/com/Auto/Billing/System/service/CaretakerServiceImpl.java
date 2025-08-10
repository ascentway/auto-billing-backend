package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.CaretakerDto;
import com.Auto.Billing.System.entity.Building;
import com.Auto.Billing.System.entity.Caretaker;
import com.Auto.Billing.System.repository.BuildingRepository;
import com.Auto.Billing.System.repository.CaretakerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class CaretakerServiceImpl implements CaretakerService{

    @Autowired
    private CaretakerRepository caretakerRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCaretaker(CaretakerDto caretakerDto) {
        Caretaker caretaker = new Caretaker();
        caretaker.setCid(caretakerDto.getCid());
        caretaker.setName(caretakerDto.getName());
        caretaker.setEmail(caretakerDto.getEmail());
        caretaker.setPassword(caretakerDto.getPassword());
        caretaker.setAddress(caretakerDto.getAddress());
        caretaker.setMobileNo(caretakerDto.getMobileNo());
//        Optional<Building> building = buildingRepository.findById(caretakerDto.getBuildingSummaryDto().getId());
//        caretaker.setBuilding(building.getBuilding());
        caretakerRepository.save(caretaker);
    }

    @Override
    public List<CaretakerDto> getAllCaretakers() {
        List<Caretaker> caretakers =  new ArrayList<>();
        caretakers = caretakerRepository.findAll();
        List<CaretakerDto> caretakerDtoList = new ArrayList<>();
        caretakerDtoList = caretakers.stream().map(c -> modelMapper.map(c, CaretakerDto.class)).toList();
        return caretakerDtoList;
    }

    @Override
    public CaretakerDto getCaretakerById(long cid) {
        Caretaker caretaker = caretakerRepository.findById(cid);
        CaretakerDto caretakerDto = modelMapper.map(caretaker, CaretakerDto.class);
        return caretakerDto;
    }

    @Override
    public void updateCaretakerDetails(long cid, CaretakerDto caretakerDto) {
        Caretaker caretaker = caretakerRepository.findById(cid);
        if (caretakerDto.getMobileNo() != 0 ) {
            caretaker.setMobileNo(caretakerDto.getMobileNo());
        }
        if (caretakerDto.getEmail() != null && !caretakerDto.getEmail().isEmpty()) {
            caretaker.setEmail(caretakerDto.getEmail());
        }
        if (caretakerDto.getPassword() != null && !caretakerDto.getPassword().isEmpty()) {
            caretaker.setPassword(caretakerDto.getPassword());
        }
        caretakerRepository.save(caretaker);
    }

    @Override
    public void deleteCaretaker(long cid) {
        Caretaker caretaker = caretakerRepository.findById(cid);
        caretakerRepository.delete(caretaker);
    }


}
