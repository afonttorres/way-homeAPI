package com.hackaton.wayhome.dtos.client.user.res;

import com.hackaton.wayhome.dtos.pet.PetResDto;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

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
    private List<PetResDto> pets;
    private java.util.Calendar createdDate;
}
