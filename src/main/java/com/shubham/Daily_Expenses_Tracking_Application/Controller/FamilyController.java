package com.shubham.Daily_Expenses_Tracking_Application.Controller;

import com.shubham.Daily_Expenses_Tracking_Application.Dto.FamilyDto;
import com.shubham.Daily_Expenses_Tracking_Application.Service.FamilyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/get")
    public ResponseEntity<List<FamilyDto>> getAllFamily() {
        return new ResponseEntity<>(familyService.getAllFamilyData(), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{familyId}")
    public ResponseEntity<FamilyDto> getFamilyById(@PathVariable Long familyId) {
        return new ResponseEntity<>(familyService.getFamilyDataById(familyId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createFamily(@RequestBody FamilyDto familyDto) {
        return new ResponseEntity<>(familyService.createFamilyData(familyDto), HttpStatus.OK);
    }

    @PutMapping("/put/{familyId}")
    public ResponseEntity<String> updateFamily(@PathVariable Long familyId, @RequestBody FamilyDto familyDto) {
        return new ResponseEntity<>(familyService.updateFamilyData(familyDto, familyId), HttpStatus.OK);
    }

    @PostMapping("/post/{familyId}/addUser/{userId}")
    public ResponseEntity<String> addUserToFamily(@PathVariable Long familyId, @PathVariable Long userId){
        return new ResponseEntity<>(familyService.addUserToFamily(familyId,userId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{familyId}")
    public ResponseEntity<String> deleteFamily(@PathVariable Long familyId){
        return new ResponseEntity<>(familyService.deleteFamilyData(familyId),HttpStatus.OK);
    }
}
