package com.hackaton.wayhome.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchReqDto {
    Long userId;
    Long housingId;
}
