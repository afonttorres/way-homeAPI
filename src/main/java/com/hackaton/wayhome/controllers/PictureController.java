package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.services.picture.IPictureService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PictureController {

    IPictureService pictureService;

    public PictureController(IPictureService pictureService){
        this.pictureService = pictureService;
    }
}
