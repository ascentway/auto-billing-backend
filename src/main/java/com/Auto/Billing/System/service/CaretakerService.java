package com.Auto.Billing.System.service;

import com.Auto.Billing.System.dto.CaretakerDto;

import java.util.List;

public interface CaretakerService {
    public void addCaretaker(CaretakerDto caretakerDto);

    public List<CaretakerDto> getAllCaretakers();

    public CaretakerDto getCaretakerById(long cid);

    public void updateCaretakerDetails(long cid, CaretakerDto caretakerDto);

    public void deleteCaretaker(long cid);
}
