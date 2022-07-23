package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMatchRepository extends JpaRepository<Match, Long> {

    @Query("select m from Match m where m.user.id = :id")
    List<Match> findByUserId(@Param("id") Long id);
}
