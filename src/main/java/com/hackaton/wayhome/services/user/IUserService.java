package com.hackaton.wayhome.services.user;

import com.hackaton.wayhome.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    User getById(Long id);
}
