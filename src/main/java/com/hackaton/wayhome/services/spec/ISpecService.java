package com.hackaton.wayhome.services.spec;

import com.hackaton.wayhome.dtos.spec.SpecResDto;

import java.util.List;

public interface ISpecService {
    List<SpecResDto> getAll();

    List<SpecResDto> getByHousingId(Long id);
}
