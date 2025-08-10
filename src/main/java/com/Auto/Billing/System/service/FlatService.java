package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.FlatDto;

import java.util.List;

public interface FlatService {

    public void addFlat(FlatDto flatDto);

    public List<FlatDto> getAllFlats();

    public FlatDto getFlatById(int flatId);


    public void deleteFlat(int flatId);

    public void updateFlat(int flatId, FlatDto flatDto);
}
