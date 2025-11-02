package com.shubham.Daily_Expenses_Tracking_Application.Service;

import com.shubham.Daily_Expenses_Tracking_Application.Dto.FamilyDto;
import com.shubham.Daily_Expenses_Tracking_Application.Entity.Family;
import com.shubham.Daily_Expenses_Tracking_Application.Entity.User;
import com.shubham.Daily_Expenses_Tracking_Application.Exception.FamilyNotFoundException;
import com.shubham.Daily_Expenses_Tracking_Application.Exception.UserNotFoundException;
import com.shubham.Daily_Expenses_Tracking_Application.Repository.FamilyRepo;
import com.shubham.Daily_Expenses_Tracking_Application.Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Getter
@Setter
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<FamilyDto> getAllFamilyData() {
        List<Family> familyList = familyRepo.findAll();
        return familyList.stream().map(family -> modelMapper.map(family, FamilyDto.class)).collect(Collectors.toList());
    }

    public FamilyDto getFamilyDataById(Long familyId) {
        Family family = familyRepo.findById(familyId).orElseThrow(() -> new FamilyNotFoundException("Family does not exist"));
        return modelMapper.map(family, FamilyDto.class);
    }

    public String createFamilyData(FamilyDto familyDto) {
        Family family = modelMapper.map(familyDto, Family.class);
        if (familyDto.getUsers() != null) {
            family.setTotalFamilyMembers((long) familyDto.getUsers().size());
        } else {
            family.setTotalFamilyMembers(0L);
        }
        familyRepo.save(family);
        return "Family created successfully";
    }

    public String updateFamilyData(FamilyDto familyDto, Long familyId) {
        Family family = familyRepo.findById(familyId).orElseThrow(() -> new FamilyNotFoundException("Family not found"));
        if (familyDto.getFamilyName() != null) {
            family.setFamilyName(familyDto.getFamilyName());
        }
        if (familyDto.getMonthlyBudget() != null) {
            family.setMonthlyBudget(familyDto.getMonthlyBudget());
        }
        return "Family data updated successfully";
    }

    public String addUserToFamily(Long familyId, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User does not exist"));
        Family family = familyRepo.findById(familyId).orElseThrow(() -> new FamilyNotFoundException("Family does not exist"));
        user.setFamily(family);
        family.getUsers().add(user);
        familyRepo.save(family);
        return "User added to family successfully";
    }

    public String deleteFamilyData(Long familyId) {
        Family family = familyRepo.findById(familyId).orElseThrow(() -> new FamilyNotFoundException("Family does not exist"));
        familyRepo.deleteById(familyId);
        return "Family deleted successfully";
    }
}
