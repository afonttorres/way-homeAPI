package com.hackaton.wayhome.services.spec;

import com.hackaton.wayhome.dtos.SpecResDto;
import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.mappers.SpecMapper;
import com.hackaton.wayhome.models.Spec;
import com.hackaton.wayhome.repositories.IHousingRepository;
import com.hackaton.wayhome.repositories.ISpecRepository;
import com.hackaton.wayhome.services.housing.IHousingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecService implements ISpecService {

    ISpecRepository specRepository;
    IHousingRepository housingRepository;

    public SpecService(ISpecRepository specRepository, IHousingRepository housingRepository){
        this.specRepository = specRepository;
        this.housingRepository = housingRepository;
    }

    @Override
    public List<SpecResDto> getAll() {
        List<SpecResDto> specsRes = new ArrayList<>();
        var specs = specRepository.findAll();
        specs.forEach(Spec -> specsRes.add(new SpecMapper().MapToSpecResDto(Spec)));
        return specsRes;
    }

    @Override
    public List<SpecResDto> getByHousingId(Long id) {
        var housing = housingRepository.findById(id);
        if(housing.isEmpty()) throw new NotFoundException("Housing Not Found", "H-404");
        List<SpecResDto> specsRes = new ArrayList<>();
        var specs = specRepository.findByHousingId(id);
        specs.forEach(Spec -> specsRes.add(new SpecMapper().MapToSpecResDto(Spec)));
        return specsRes;
    }
}
