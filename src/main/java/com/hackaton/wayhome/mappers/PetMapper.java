package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.pet.PetResDto;
import com.hackaton.wayhome.models.pet.Pet;

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
}
