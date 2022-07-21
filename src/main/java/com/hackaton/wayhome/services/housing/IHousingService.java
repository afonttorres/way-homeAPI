package com.hackaton.wayhome.services.housing;

import com.hackaton.wayhome.models.Housing;

import java.util.List;

public interface IHousingService {
    List<Housing> getAll();

    Housing getById(Long id);

    List<Housing> findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(String search);
}
