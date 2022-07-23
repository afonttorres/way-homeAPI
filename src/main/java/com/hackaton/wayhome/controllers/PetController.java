package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.services.pet.IPetService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PetController {

    IPetService petService;

    public PetController(IPetService petService){
        this.petService = petService;
    }
}
