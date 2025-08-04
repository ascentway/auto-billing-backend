package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.RoleDto;
import com.Auto.Billing.System.entity.Role;
import com.Auto.Billing.System.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RoleDto> getRoles() {
        List<Role> roles = new ArrayList<>();
        roles = roleRepository.findAll();
        List<RoleDto> roleList = new ArrayList<>();
        roleList = roles.stream().map(r -> modelMapper.map(r,RoleDto.class)).toList();
        return roleList;
    }
}
