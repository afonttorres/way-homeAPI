package com.hackaton.wayhome.services.user;

import com.hackaton.wayhome.models.User;
import com.hackaton.wayhome.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
}
