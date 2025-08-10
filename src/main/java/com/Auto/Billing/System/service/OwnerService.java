package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.OwnerDto;


import java.util.List;


public interface OwnerService{
    public void addOwner(OwnerDto ownerDto);

    public List<OwnerDto> getAllOwners();

    public void updateOwner(int oid, OwnerDto ownerDto);

    public void deleteOwner(int oid);
}
