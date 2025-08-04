package com.Auto.Billing.System.controller;

import com.Auto.Billing.System.dto.FlatDto;
import com.Auto.Billing.System.service.FlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flats")
@RequiredArgsConstructor
public class FlatController {
    private final FlatService flatService;

    @PostMapping("/add")
    public ResponseEntity<String> addFlat(@RequestBody FlatDto flatDto){
        System.out.println(flatDto.toString());
       flatService.addFlat(flatDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Flat Details Successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlatDto>> getAllFlats(){
        List<FlatDto> flatDtos = flatService.getAllFlats();
        return ResponseEntity.status(HttpStatus.FOUND).body(flatDtos);
    }

    @GetMapping("/{/flatId}")
    public ResponseEntity<FlatDto> getFlatById(@PathVariable int flatId){
        FlatDto flat = flatService.getFlatById(flatId);
        return ResponseEntity.status(HttpStatus.FOUND).body(flat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFlat(@PathVariable int flatId, @RequestBody FlatDto flatDto){
        flatService.updateField(flatId, flatDto);
        return ResponseEntity.status(HttpStatus.OK).body("Details Updated Successfully");
    }

    @DeleteMapping("/{id")
    public ResponseEntity<String> deleteFlat(@PathVariable int flatId){
        flatService.deleteFlat(flatId);
        return ResponseEntity.status(HttpStatus.OK).body("Flat Details Removed Successfully");

    }
}
