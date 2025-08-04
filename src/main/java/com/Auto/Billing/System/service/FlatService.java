package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.FlatDto;

import java.util.List;

public interface FlatService {

    public void addFlat(FlatDto flatDto);

    public List<FlatDto> getAllFlats();

    public FlatDto getFlatById(int flatId);

    public void updateField(int flatId, FlatDto flatDto);

    void deleteFlat(int flatId);
}
