package com.hackaton.wayhome.services.match;

import com.hackaton.wayhome.dtos.match.MatchReqDto;
import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.housing.Housing;
import com.hackaton.wayhome.models.match.Match;
import com.hackaton.wayhome.models.client.Publisher;
import com.hackaton.wayhome.models.client.User;
import com.hackaton.wayhome.repositories.IHousingRepository;
import com.hackaton.wayhome.repositories.IMatchRepository;
import com.hackaton.wayhome.repositories.IUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MatchServiceTest {

    @Mock
    IMatchRepository matchRepository;
    @Mock
    IUserRepository userRepository;
    @Mock
    IHousingRepository housingRepository;

    @Test
    void getAllShouldReturnAllMatches() {
        int n = 4;
        var service = new MatchService(matchRepository, userRepository, housingRepository);
        var matches = this.createMatches(n);
        Mockito.when(matchRepository.findAll()).thenReturn(matches);
        var sut = service.getAll();
        assertThat(sut.size(), equalTo(n));
    }

    @Test
    void getUserMatchesShouldReturnUserMatchesByPamId() {
        int n = 5;
        var service = new MatchService(matchRepository, userRepository, housingRepository);
        var user = this.createUser(1L);
        var matches = this.createMatches(n);
        Mockito.when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        Mockito.when(matchRepository.findByUserId(any(Long.class))).thenReturn(matches);
        var sut = service.getUserMatches(1L);
        assertThat(sut, equalTo(matches));
    }

    @Test
    void getUserMatchesShouldntReturnMatchesIfUserDoesntExistAndThrowsException(){
        var service = new MatchService(matchRepository, userRepository, housingRepository);
        Exception ex = assertThrows(NotFoundException.class, ()->{
            service.getUserMatches(1L);
        });
        String msg = "User Not Found";
        var sut = ex.getMessage();
        assertTrue(sut.equals(msg));
    }

    @Test
    void createShouldPostAMatchAndReturnAMatchResDto() {
        var service = new MatchService(matchRepository, userRepository, housingRepository);
        var match = this.createMatch(1L);
        MatchReqDto req = new MatchReqDto(1L ,1L);
        Mockito.when(housingRepository.findById(any(Long.class))).thenReturn(Optional.of(match.getHousing()));
        Mockito.when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(match.getUser()));
        Mockito.when(housingRepository.save(any(Housing.class))).thenReturn(match.getHousing());
        Mockito.when(matchRepository.save(any(Match.class))).thenReturn(match);
        var sut = service.create(req);
        assertThat(sut.getPublisher(), equalTo(match.getPublisher()));
    }

    @Test
    void createShouldntCreateMatchIfHousingDoesntExist() {
        var service = new MatchService(matchRepository, userRepository, housingRepository);
        var req = new MatchReqDto(1L, 1L);
        Exception ex = assertThrows(NotFoundException.class, ()->{
            service.create(req);
        });
        String msg = "Housing Not Found";
        var sut = ex.getMessage();
        assertTrue(sut.equals(msg));
    }

    @Test
    void createShouldntCreateMatchIfUserDoesntExist() {
        var service = new MatchService(matchRepository, userRepository, housingRepository);
        var req = new MatchReqDto(1L, 1L);
        var housing = this.createHousing(1L);
        Mockito.when(housingRepository.findById(any(Long.class))).thenReturn(Optional.of(housing));
        Exception ex = assertThrows(NotFoundException.class, ()->{
            service.create(req);
        });
        String msg = "User Not Found";
        var sut = ex.getMessage();
        assertTrue(sut.equals(msg));
    }

    private Housing createHousing(Long id){
        var housing = new Housing();
        var seller = this.createPublisher(id);
        housing.setTitle("title");
        housing.setDescription("desc");
        housing.setCategory("cat");
        housing.setActive(true);
        housing.setImgUrl1("img");
        housing.setImgUrl2("img");
        housing.setImgUrl3("img");
        housing.setLocation("loc");
        housing.setRatio(4);
        housing.setPrice(400D);
        housing.setPublisher(seller);
        housing.setId(id);
        return housing;
    }

    private Publisher createPublisher(Long id){
        var seller = new Publisher();
        seller.setName("name");
        seller.setUsername("username");
        seller.setEmail("email");
        seller.setAvatar("avatar");
        seller.setCitty("loc");
        seller.setId(id);
        return seller;
    }

    private User createUser(Long id){
        var user = new User();
        user.setName("name");
        user.setUsername("user");
        user.setEmail("email");
        user.setCitty("loc");
        user.setAvatar("avatar");
        user.setId(id);
        return user;
    }

    private Match createMatch(Long id){
        var seller = this.createPublisher(id);
        var user = this.createUser(id);
        var housing = this.createHousing(id);
        var match = new Match();
        match.setPublisher(seller);
        match.setUser(user);
        match.setHousing(housing);
        match.setId(id);
        return match;
    }

    private List<Match> createMatches(int n){
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matches.add(this.createMatch(Long.valueOf(i)));
        }
        return matches;
    }
}