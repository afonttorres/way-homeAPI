package com.hackaton.wayhome.dtos.client.publisher.req;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class PublisherPutReqDto {
    @Nullable
    private String avatar;
    private String name;
    @Nullable
    private String surname;
    private String username;
    @Nullable
    private Long phone;
    private String country;
    private String citty;
}
