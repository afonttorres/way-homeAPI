package com.hackaton.wayhome.dtos.client.publisher.req;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PublisherAuthReqDto {
    @NotNull
    String email;
    @NotNull
    String password;
}
