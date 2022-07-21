package com.hackaton.wayhome.services.match;

import com.hackaton.wayhome.models.Match;

import java.util.List;

public interface IMatchService {
    List<Match> getAll();

    List<Match> getUserMatches(Long id);
}
