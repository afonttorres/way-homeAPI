package com.hackaton.wayhome.services.user;

import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.Housing;
import com.hackaton.wayhome.models.User;
import com.hackaton.wayhome.repositories.IUserRepository;
import com.hackaton.wayhome.services.housing.HousingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @Test
    void getAllShouldReturnAllUsers() {
        int n = 3;
        var service = new UserService(userRepository);
        var users = this.createUsers(n);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        var sut = service.getAll();
        assertThat(sut.size(), equalTo(n));
    }

    @Test
    void getByIdShouldReturnUserByPamId() {
        var service = new UserService(userRepository);
        var user = this.createUser(1L);
        Mockito.when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));
        var sut = service.getById(1L);
        assertThat(sut.getId(), equalTo(1L));
    }

    @Test
    void getByIdShouldntReturnHousingByPamIdIfHousingDoesntExistAndThrowsEx() {
        var service = new UserService(userRepository);
        Exception ex = assertThrows(NotFoundException.class, () -> {
            service.getById(1L);
        });
        String msg = "User Not Found";
        var sut = ex.getMessage();
        assertTrue(sut.equals(msg));
    }

    private User createUser(Long id){
        var user = new User();
        user.setName("name");
        user.setUsername("user");
        user.setEmail("email");
        user.setAnimal("animal");
        user.setLocation("loc");
        user.setAvatarUrl("avatar");
        user.setId(1L);
        return user;
    }

    private List<User> createUsers(int n){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            users.add(this.createUser(Long.valueOf(i)));
        }
        return users;
    }
}