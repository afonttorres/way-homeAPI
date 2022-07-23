package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.pet.PetReqDto;
import com.hackaton.wayhome.dtos.pet.PetResDto;
import com.hackaton.wayhome.models.pet.Pet;
import com.hackaton.wayhome.models.pet.PetType;

import java.util.ArrayList;
import java.util.List;

public class PetMapper {
    PetResDto mapPetToRes(Pet pet){
        var res = new PetResDto();
        res.setName(pet.getName());
        res.setType(pet.getType().toString());
        return res;
    }

    List<PetResDto> mapMultiplePetsToRes(List<Pet> pets){
        List<PetResDto> res = new ArrayList<>();
        pets.forEach(Pet -> res.add(this.mapPetToRes(Pet)));
        return res;
    }

    Pet mapReqToPet(PetReqDto req){
        var pet = new Pet();
        pet.setName(req.getName());
        pet.setType(req.getType());
        return pet;
    }
}
