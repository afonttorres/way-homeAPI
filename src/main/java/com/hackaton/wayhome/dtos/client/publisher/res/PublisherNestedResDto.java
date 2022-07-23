package com.hackaton.wayhome.dtos.client.publisher.res;

import com.hackaton.wayhome.models.pet.Pet;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

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
    private java.util.Calendar createdDate;
}
