package com.poins.api.dtos;

import com.poins.api.enums.Journey;

import java.util.Date;

public record EmployeeDTO(
        String firstName,
        String lastName,
        Date dateBirth,
        Journey journey) {}
