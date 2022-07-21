package com.hackaton.wayhome.services.housing;

import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.Housing;
import com.hackaton.wayhome.repositories.IHousingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingService implements IHousingService {

    IHousingRepository housingRepository;

    public HousingService(IHousingRepository housingRepository){
        this.housingRepository = housingRepository;
    }

    @Override
    public List<Housing> getAll() {
        return housingRepository.findAll();
    }

    @Override
    public Housing getById(Long id) {
        var housing = housingRepository.findById(id);
        if(housing.isEmpty()) throw  new NotFoundException("Housing Not Found", "H-404");
        return housing.get();
    }

    @Override
    public List<Housing> findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(String search) {
        return housingRepository.findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(search);
    }
}
