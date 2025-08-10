package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.OwnerDto;
import com.Auto.Billing.System.entity.Owner;
import com.Auto.Billing.System.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addOwner(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setName(ownerDto.getName());
        owner.setEmail(ownerDto.getEmail());
        owner.setPhoneNo(ownerDto.getPhoneNo());
        owner.setPassword(ownerDto.getPassword());
        owner.setBuildings(ownerDto.getBuildingList());
        ownerRepository.save(owner);
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<Owner> owners = new ArrayList<>();
        owners = ownerRepository.findAll();
        List <OwnerDto> ownerDtos = new ArrayList<>();
        ownerDtos = owners.stream().map(o -> modelMapper.map(o, OwnerDto.class)).toList();
        return ownerDtos;
    }

    @Override
    public void updateOwner(int oid, OwnerDto ownerDto) {
        System.out.println(ownerDto.toString());
        Owner owner = ownerRepository.findById(oid);
        if (ownerDto.getPhoneNo() != 0 ) {
            owner.setPhoneNo(ownerDto.getPhoneNo());
        }
        if (ownerDto.getEmail() != null && !ownerDto.getEmail().isEmpty()) {
            owner.setEmail(ownerDto.getEmail());
        }
        if (ownerDto.getPassword() != null && !ownerDto.getPassword().isEmpty()) {
            owner.setPassword(ownerDto.getPassword());
        }
        System.out.println(owner.toString());
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(int oid) {
        Owner owner = ownerRepository.findById(oid);
        ownerRepository.delete(owner);
    }
}
