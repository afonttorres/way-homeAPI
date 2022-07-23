package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.client.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
