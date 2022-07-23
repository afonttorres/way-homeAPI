package com.hackaton.wayhome.dtos.client.user;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class UserPostReqDto {
    private String name;
    @Nullable
    private String surname;
    private String username;
    private String email;
    private String password;
}
