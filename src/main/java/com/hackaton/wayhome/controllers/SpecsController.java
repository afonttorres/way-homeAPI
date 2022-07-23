package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.dtos.spec.SpecResDto;
import com.hackaton.wayhome.services.spec.ISpecService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SpecsController {
    ISpecService specService;

    public SpecsController(ISpecService specService){
        this.specService = specService;
    }

    @GetMapping("/specs")
    List<SpecResDto> getAll(){
        return specService.getAll();
    }

    @GetMapping("/housings/{id}/specs")
    ResponseEntity<List<SpecResDto>> getHousingSpecs(@PathVariable Long id){
        var specs = specService.getByHousingId(id);
        return new ResponseEntity<>(specs, HttpStatus.OK);
    }
}
