package com.hackaton.wayhome.services.user;

import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.models.User;
import com.hackaton.wayhome.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()) throw new NotFoundException("User Not Found", "U-404");
        return user.get();
    }
}
