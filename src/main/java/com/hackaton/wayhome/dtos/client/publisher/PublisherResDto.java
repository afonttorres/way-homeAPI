package com.hackaton.wayhome.dtos.client.publisher;

import lombok.Data;
import org.springframework.lang.Nullable;


@Data
public class PublisherResDto {
    private Long id;
    @Nullable
    private String avatar;
    private String name;
    @Nullable
    private String surname;
    private String username;
    private String email;
    @Nullable
    private Long phone;
    private String country;
    private String citty;
}
