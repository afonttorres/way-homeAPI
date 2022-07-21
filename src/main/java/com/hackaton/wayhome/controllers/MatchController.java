package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.models.Match;
import com.hackaton.wayhome.services.match.IMatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    IMatchService matchService;

    public MatchController(IMatchService matchService){
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    List<Match> getAll(){
        return matchService.getAll();
    }

    @GetMapping("/users/{id}/matches")
    ResponseEntity<List<Match>> getUserMatches(@PathVariable Long id){
        List<Match> matches = matchService.getUserMatches(id);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
}
