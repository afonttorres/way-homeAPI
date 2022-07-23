package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.client.user.UserNestedResDto;
import com.hackaton.wayhome.dtos.client.user.UserPostReqDto;
import com.hackaton.wayhome.dtos.client.user.UserPutReqDto;
import com.hackaton.wayhome.dtos.client.user.UserResDto;
import com.hackaton.wayhome.models.client.User;
import org.springframework.lang.Nullable;

public class UserMapper {
    public User mapPostReqToUser(UserPostReqDto req){
        var user = new User();
        user.setName(req.getName());
        user.setSurname(req.getSurname());
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        return user;
    }

    public User mapPutReqToUser(UserPutReqDto req, User foundUser){
        var user = foundUser;
        user.setAvatar(req.getAvatar());
        user.setName(req.getName());
        user.setSurname(req.getSurname());
        user.setUsername(req.getUsername());
        user.setPhone(req.getPhone());
        user.setCountry(req.getCountry());
        user.setCitty(req.getCitty());
        return user;
    }

    public UserNestedResDto mapUserToNestedRes(User user){
        var res = new UserNestedResDto();
        res.setId(user.getId());
        res.setAvatar(user.getAvatar());
        res.setName(user.getName());
        res.setSurname(user.getSurname());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        res.setPhone(user.getPhone());
        return res;
    }

    public UserResDto mapUserToRes(User user){
        var res = new UserResDto();
        res.setId(user.getId());
        res.setAvatar(user.getAvatar());
        res.setName(user.getName());
        res.setSurname(user.getSurname());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        res.setPhone(user.getPhone());
        res.setCountry(user.getCountry());
        res.setCitty(user.getCitty());
        return res;
    }
}