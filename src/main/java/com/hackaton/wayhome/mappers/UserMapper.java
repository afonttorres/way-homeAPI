package com.hackaton.wayhome.mappers;

import com.hackaton.wayhome.dtos.client.user.res.UserNestedResDto;
import com.hackaton.wayhome.dtos.client.user.req.UserPostReqDto;
import com.hackaton.wayhome.dtos.client.user.req.UserPutReqDto;
import com.hackaton.wayhome.dtos.client.user.res.UserResDto;
import com.hackaton.wayhome.models.client.User;

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
        res.setCreatedDate(user.getCreatedDate());
        res.setPets(new PetMapper().mapMultiplePetsToRes(user.getPets()));
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
        res.setCreatedDate(user.getCreatedDate());
        res.setPets(new PetMapper().mapMultiplePetsToRes(user.getPets()));
        return res;
    }
}