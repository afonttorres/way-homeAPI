package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.dtos.client.publisher.res.PublisherResDto;
import com.hackaton.wayhome.services.client.publisher.IPublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PublisherController {

    IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    ResponseEntity<List<PublisherResDto>> getAll(){
        var publishers = publisherService.getAll();
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }

    @GetMapping("/publishers/{id}")
    ResponseEntity<PublisherResDto> getById(@PathVariable Long id){
        var publisher = publisherService.getById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
}
