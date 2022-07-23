package com.hackaton.wayhome.controllers;


import com.hackaton.wayhome.models.housing.Housing;
import com.hackaton.wayhome.services.housing.IHousingService;
import com.hackaton.wayhome.services.client.publisher.IPublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HousingController {

    IHousingService housingService;
    IPublisherService sellerService;

    public HousingController(
            IHousingService housingService,
            IPublisherService sellerService
    ){
        this.housingService=housingService;
        this.sellerService=sellerService;
    }

    @GetMapping("/housings")
    List<Housing> getAll(){
       return housingService.getAll();
    }

    @GetMapping("/housings/{id}")
    ResponseEntity<Housing> getById(@PathVariable Long id){
        var housing = housingService.getById(id);
        return new ResponseEntity<>(housing, HttpStatus.OK);
    }

//    @GetMapping(value="/housings", params="search")
//    List<Housing> getSearch(@RequestParam String search){
//        return housingService.findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(search);
//    }
}
