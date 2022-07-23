package com.hackaton.wayhome.dtos.pet;

import com.hackaton.wayhome.models.pet.PetType;
import lombok.Data;

@Data
public class PetReqDto {
    String name;
    PetType type;
}
