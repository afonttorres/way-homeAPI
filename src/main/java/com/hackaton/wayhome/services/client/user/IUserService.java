package com.hackaton.wayhome.services.client.user;

import com.hackaton.wayhome.dtos.client.user.res.UserResDto;
import com.hackaton.wayhome.models.client.User;

import java.util.List;

public interface IUserService {
    List<UserResDto> getAll();

    UserResDto getById(Long id);

}
