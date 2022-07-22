package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.MatchReqDto;
import com.hackaton.wayhome.models.Housing;
import com.hackaton.wayhome.models.Match;
import com.hackaton.wayhome.models.Seller;
import com.hackaton.wayhome.models.User;

public class MatchMapper {
    public Match mapToMatch(User u, Seller s, Housing h){
        var match = new Match();
        match.setUser(u);
        match.setSeller(s);
        match.setHousing(h);
       return match;
    }
}
