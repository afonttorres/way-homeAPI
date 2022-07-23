package com.hackaton.wayhome.dtos.client.user;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class UserNestedResDto {
    Long id;
    @Nullable
    String avatar;
    String name;
    String surname;
    String username;
    String email;
    @Nullable
    Long phone;
}
