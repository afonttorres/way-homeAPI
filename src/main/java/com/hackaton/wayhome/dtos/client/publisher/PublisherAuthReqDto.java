package com.hackaton.wayhome.dtos.client.publisher;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PublisherAuthReqDto {
    @NotNull
    String email;
    @NotNull
    String password;
}
