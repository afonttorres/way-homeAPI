package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.models.housing.Housing;
import com.hackaton.wayhome.models.match.Match;
import com.hackaton.wayhome.models.client.Publisher;
import com.hackaton.wayhome.models.client.User;

public class MatchMapper {
    public Match mapToMatch(User u, Publisher s, Housing h){
        var match = new Match();
        match.setUser(u);
        match.setPublisher(s);
        match.setHousing(h);
       return match;
    }
}
