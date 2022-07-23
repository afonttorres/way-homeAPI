package com.hackaton.wayhome.services.housing;

import com.hackaton.wayhome.models.housing.Housing;

import java.util.List;

public interface IHousingService {
    List<Housing> getAll();

    Housing getById(Long id);

}
