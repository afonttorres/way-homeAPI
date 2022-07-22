package com.hackaton.wayhome.services.match;

import com.hackaton.wayhome.dtos.MatchReqDto;
import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.mappers.MatchMapper;
import com.hackaton.wayhome.models.Match;
import com.hackaton.wayhome.repositories.IHousingRepository;
import com.hackaton.wayhome.repositories.IMatchRepository;
import com.hackaton.wayhome.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService implements IMatchService {

    IMatchRepository matchRepository;
    IUserRepository userRepository;
    IHousingRepository housingRepository;

    public MatchService(IMatchRepository matchRepository, IUserRepository userRepository, IHousingRepository housingRepository){
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
        this.housingRepository = housingRepository;
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

    @Override
    public Match create(MatchReqDto req) {
        var housing = housingRepository.findById(req.getHousingId());
        var user = userRepository.findById(req.getUserId());
        if(housing.isEmpty()) throw new NotFoundException("Housing Not Found", "H-404");
        if(user.isEmpty()) throw new NotFoundException("User Not Found", "H-404");
        housing.get().setActive(false);
        housingRepository.save(housing.get());
        var match = new MatchMapper().mapToMatch(user.get(), housing.get().getPublisher(), housing.get());
        matchRepository.save(match);
        return match;
    }
}
