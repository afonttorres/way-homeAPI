package com.hackaton.wayhome.dtos.client.user.res;

import com.hackaton.wayhome.dtos.pet.PetResDto;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
public class UserResDto {
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
    private List<PetResDto> pets;
    private java.util.Calendar createdDate;
}
