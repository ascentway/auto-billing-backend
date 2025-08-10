package com.Auto.Billing.System.controller;


import com.Auto.Billing.System.dto.CaretakerDto;
import com.Auto.Billing.System.service.CaretakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caretaker")
public class CaretakerController {
    @Autowired
    private CaretakerService caretakerService;

    @PostMapping("/addCaretaker")
    public ResponseEntity<String> addCaretaker(@RequestBody CaretakerDto caretakerDto){
        System.out.println(caretakerDto.toString());
        caretakerService.addCaretaker(caretakerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Caretaker Details added Successfully");
    }

    @GetMapping("/allCaretaker")
    public ResponseEntity<List<CaretakerDto>> getAllCaretakers(){
        List<CaretakerDto> caretakerDtos= caretakerService.getAllCaretakers();
        return ResponseEntity.status(HttpStatus.FOUND).body(caretakerDtos);
    }

    @GetMapping("/details/{cid}")
    public ResponseEntity<CaretakerDto> getCaretakerById(@PathVariable long cid){
        CaretakerDto caretakerDto = caretakerService.getCaretakerById(cid);
        return ResponseEntity.status(HttpStatus.FOUND).body(caretakerDto);
    }

    @PutMapping("/edit/{cid}")
    public ResponseEntity<String> updateCaretakerDetails(@PathVariable long cid, @RequestBody CaretakerDto caretakerDto){
        caretakerService.updateCaretakerDetails(cid, caretakerDto);
        return ResponseEntity.status(HttpStatus.OK).body("Caretaker Details Updated Successfully");
    }

    @DeleteMapping("/delete/{cid}")
    public ResponseEntity<String> deleteCaretaker(@PathVariable long cid){
        caretakerService.deleteCaretaker(cid);
        return ResponseEntity.status(HttpStatus.OK).body("Caretaker Details Removed Successfully");
    }
}
