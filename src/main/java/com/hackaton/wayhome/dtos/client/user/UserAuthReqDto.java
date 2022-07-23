package com.hackaton.wayhome.dtos.client.user;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserAuthReqDto {
    @NotNull
    String email;
    @NotNull
    String password;
}
