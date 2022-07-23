package com.hackaton.wayhome.dtos.client.user.req;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserAuthReqDto {
    @NotNull
    String email;
    @NotNull
    String password;
}
