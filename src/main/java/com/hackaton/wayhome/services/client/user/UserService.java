package com.hackaton.wayhome.services.client.user;

import com.hackaton.wayhome.dtos.client.user.res.UserResDto;
import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.mappers.UserMapper;
import com.hackaton.wayhome.models.client.User;
import com.hackaton.wayhome.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResDto> getAll() {
        List<UserResDto> res = new ArrayList<>();
        var users = userRepository.findAll();
        users.forEach(User -> {
            res.add(new UserMapper().mapUserToRes(User));
        });
        return res;
    }

    @Override
    public UserResDto getById(Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()) throw new NotFoundException("User Not Found", "U-404");
        var res = new UserMapper().mapUserToRes(user.get());
        return res;
    }

}
