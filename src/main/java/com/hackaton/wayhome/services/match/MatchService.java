package com.hackaton.wayhome.services.match;

import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.Match;
import com.hackaton.wayhome.repositories.IMatchRepository;
import com.hackaton.wayhome.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements IMatchService {

    IMatchRepository matchRepository;
    IUserRepository userRepository;

    public MatchService(IMatchRepository matchRepository, IUserRepository userRepository){
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getUserMatches(Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()) throw new NotFoundException("User Not Found", "U-404");
        return matchRepository.findByUserId(id);
    }
}
