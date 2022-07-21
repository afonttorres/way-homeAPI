package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.SpecResDto;
import com.hackaton.wayhome.models.Spec;

public class SpecMapper {

    public SpecResDto MapToSpecResDto(Spec spec){
        return new SpecResDto(spec.getSpec());
    }
}
