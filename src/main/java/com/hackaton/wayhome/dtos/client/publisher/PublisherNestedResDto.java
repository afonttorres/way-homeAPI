package com.hackaton.wayhome.dtos.client.publisher;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class PublisherNestedResDto {
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
