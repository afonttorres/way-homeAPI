package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.spec.SpecResDto;
import com.hackaton.wayhome.models.spec.Spec;

public class SpecMapper {

    public SpecResDto MapToSpecResDto(Spec spec){
        return new SpecResDto(spec.getSpec().toString());
    }
}
